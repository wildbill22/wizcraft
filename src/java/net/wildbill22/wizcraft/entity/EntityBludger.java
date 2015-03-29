package net.wildbill22.wizcraft.entity;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.items.ModItems;

public class EntityBludger extends EntityFlying {
	public static final String name = "bludger";

	public double waypointX;
	public double waypointY;
	public double waypointZ;
	private Entity target;
	private Entity attacker;
	private double attackerX;
	private double attackerY;
	private double attackerZ;
	private int ticksSinceHit;
	private double moveSpeed; // Added, for 1.7.10 port

	public EntityBludger(World world) {
		super(world);
		target = null;
		setSize(0.4F, 0.4F);
		isImmuneToFire = true;
		moveSpeed = 0.6F;
	}

	public EntityBludger(World world, EntityPlayer entityplayer) {
		super(world);
		target = null;
		setSize(0.4F, 0.4F);
		isImmuneToFire = true;
		moveSpeed = 0.6F;

		setLocationAndAngles(entityplayer.posX, entityplayer.posY
				+ (double) entityplayer.getEyeHeight(), entityplayer.posZ,
				entityplayer.rotationYaw, entityplayer.rotationPitch);
		posX -= MathHelper.cos((rotationYaw / 180F) * 3.141593F) * 0.5F;
		posY -= 0.10000000149011612D;
		posZ -= MathHelper.sin((rotationYaw / 180F) * 3.141593F) * 0.5F;
		setPosition(posX, posY, posZ);
	}
	
	public EntityBludger(World world, double i, double j, double k) {
        this(world);

        setPosition(i,j,k);
        
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
    }

	public boolean attackEntityFrom(DamageSource damagesource, int i) {
		attacker = damagesource.getEntity();
		if (attacker != null) {
			if (attacker instanceof EntityPlayer) {

				// check that hit with bat
				EntityPlayer playerAttacker = (EntityPlayer) attacker;

				ItemStack itemstack = playerAttacker.inventory.getCurrentItem();
				if (itemstack != null && itemstack.getItem() == ModItems.bat) {
					attackerX = attacker.posX;
					attackerY = attacker.posY;
					attackerZ = attacker.posZ;
					ticksSinceHit = 20;
					return true;
				}
			}
		}
		return true;
	}

	protected void entityInit() {
		super.entityInit();
	}

	// Use EntityLivingBase.damageEntity instead
//	public float getMaxHealth() {
//		return 0.0F;
//	}

    protected void damageEntity(DamageSource p_70665_1_, float p_70665_2_) {
    }

	public void onEntityUpdate() {
		if(worldObj.isRemote)
			return;
		if (ridingEntity != null && ridingEntity.isDead) {
			ridingEntity = null;
		}
		ticksExisted++;
		prevDistanceWalkedModified = distanceWalkedModified;
		prevPosX = posX;
		prevPosY = posY;
		prevPosZ = posZ;
		prevRotationPitch = rotationPitch;
		prevRotationYaw = rotationYaw;

		if (handleWaterMovement()) {
			if (!inWater) {
				float f = MathHelper.sqrt_double(motionX * motionX
						* 0.20000000298023224D + motionY * motionY + motionZ
						* motionZ * 0.20000000298023224D) * 0.2F;
				if (f > 1.0F) {
					f = 1.0F;
				}
				worldObj.playSoundAtEntity(this, "random.splash", f,
						1.0F + (rand.nextFloat() - rand.nextFloat()) * 0.4F);
				float f1 = MathHelper.floor_double(boundingBox.minY);
				for (int l = 0; (float) l < 1.0F + width * 20F; l++) {
					float f2 = (rand.nextFloat() * 2.0F - 1.0F) * width;
					float f4 = (rand.nextFloat() * 2.0F - 1.0F) * width;
					worldObj.spawnParticle("bubble", posX + (double) f2,
							f1 + 1.0F, posZ + (double) f4, motionX, motionY
									- (double) (rand.nextFloat() * 0.2F),
							motionZ);
				}

				for (int i1 = 0; (float) i1 < 1.0F + width * 20F; i1++) {
					float f3 = (rand.nextFloat() * 2.0F - 1.0F) * width;
					float f5 = (rand.nextFloat() * 2.0F - 1.0F) * width;
					worldObj.spawnParticle("splash", posX + (double) f3,
							f1 + 1.0F, posZ + (double) f5, motionX, motionY,
							motionZ);
				}

			}
			fallDistance = 0.0F;
			inWater = true;
			// fire = 0;
		} else {
			inWater = false;
		}
		if (worldObj.isRemote) {
			// fire = 0;
		} else
		/*
		 * if(fire > 0) { if(isImmuneToFire) { fire -= 4; if(fire < 0) { fire =
		 * 0; } } else { if(fire % 20 == 0) {
		 * attackEntityFrom(DamageSource.onFire, 1); } fire--; } }
		 */
		if (handleLavaMovement()) {
			setOnFireFromLava();
		}
		if (posY < -64D) {
			kill();
		}
		if (!worldObj.isRemote) {
			// setFlag(0, fire > 0);
			setFlag(2, ridingEntity != null);
		}

		updateEntityActionState();
	}

	protected void updateEntityActionState() {
		if(worldObj.isRemote)
			return;
		if(!worldObj.isRemote)
			target = (Entity) worldObj.playerEntities.get(0);

		if (ticksSinceHit == 20) {
			waypointX = posX - 50 * (attackerX - posX);
			waypointY = posY - 50 * (attackerY - target.height / 2 - posY);
			waypointZ = posZ - 50 * (attackerZ - posZ);
			ticksSinceHit--;
		}

		else if (ticksSinceHit > 0)
			ticksSinceHit--;

		else if (target != null && !target.isDead) {
			waypointX = target.posX;
			waypointY = target.posY - target.height / 2;
			waypointZ = target.posZ;
		}

		else {
			waypointX = posX;
			waypointY = posY;
			waypointZ = posZ;
		}

		double d = waypointX - posX;
		double d1 = waypointY - posY;
		double d2 = waypointZ - posZ;
		double d3 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);

		motionX = (d / d3) * moveSpeed;
		motionY = (d1 / d3) * moveSpeed;
		motionZ = (d2 / d3) * moveSpeed;

		// moveEntity(motionX,motionY,motionZ);
	}

	public Entity findClosestPlayer() {
		float d = 0F;
		@SuppressWarnings("rawtypes")
		List entities = worldObj.loadedEntityList;
		EntityLiving ent = null;
		target = null;
		for (int i = 0; i < entities.size(); i++) {
			if ((Entity) entities.get(i) != null) {
				if ((Entity) entities.get(i) instanceof EntityPlayer) {
					// && this.canEntityBeSeen((Entity) entities.get(i))) {
					ent = (EntityLiving) entities.get(i);
					float d1 = ent.getDistanceToEntity(this);
					if (d1 < d || target == null) {
						d = d1;
						target = ent;
					}
				}
			}
		}
		return target;
	}

	public boolean interact(EntityPlayer entityplayer) {
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if (itemstack != null && itemstack.getItem() == ModItems.bludgerGlove && !worldObj.isRemote) {
			// entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem,
			// new ItemStack(mod_QuidditchSMP.Bludger));
			if (entityplayer.inventory.addItemStackToInventory(new ItemStack(ModItems.bludger, 1))) {
				entityplayer.onItemPickup(this, 1);
				setDead();
				return true;
			} else
				return false;
		} else
			return false;

	}

	public void onCollideWithPlayer(EntityPlayer entityplayer) {
		// knock player
		double d = prevPosX - entityplayer.posX;
		double d1 = prevPosY - (entityplayer.posY - entityplayer.height / 2);
		double d2 = prevPosZ - entityplayer.posZ;
		double d3 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);

		if (entityplayer.ridingEntity != null
				&& entityplayer.ridingEntity instanceof EntityBroom) {
			entityplayer.ridingEntity.motionX = -2 * (d/d3);
			entityplayer.ridingEntity.motionY = -2 * (d1/d3);
			entityplayer.ridingEntity.motionZ = -2 * (d2/d3);
		}

		attackerX = entityplayer.posX;
		attackerY = entityplayer.posY - entityplayer.height / 2;// + (double)(entityplayer.getEyeHeight()/2);
		attackerZ = entityplayer.posZ;

		waypointX = posX - 50 * (attackerX - posX);
		waypointY = posY - 50 * (attackerY - posY);
		waypointZ = posZ - 50 * (attackerZ - posZ);

		ticksSinceHit = 10;

		// force drop quaffle
		// check random number, if within 25% force quaffle thrown
		int percent = worldObj.rand.nextInt(100);
		if (percent < 25) {
			//forceDropQuaffle(entityplayer);
		}
		// damage
	}
	
	public boolean isInRangeToRenderVec3D(Vec3 vec3d)
    {
        return true;
    }

    public boolean isInRangeToRenderDist(double d)
    {
        return true;
    }

	private boolean isCourseTraversable(double d, double d1, double d2,	double d3) {
		double d4 = (waypointX - posX) / d3;
		double d5 = (waypointY - posY) / d3;
		double d6 = (waypointZ - posZ) / d3;
		AxisAlignedBB axisalignedbb = boundingBox.copy();
		for (int i = 1; (double) i < d3; i++) {
			axisalignedbb.offset(d4, d5, d6);
			if (worldObj.getCollidingBoundingBoxes(this, axisalignedbb).size() > 0) {
				return false;
			}
		}

		return true;
	}
}
