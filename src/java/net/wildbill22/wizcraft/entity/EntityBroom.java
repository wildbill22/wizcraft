package net.wildbill22.wizcraft.entity;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.items.ModItems;
import net.wildbill22.wizcraft.lib.KeyBindings;

public class EntityBroom extends Entity {
	public static final String name = "broom";

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double velocityX;
    private double velocityY;
    private double velocityZ;

    public EntityBroom(World world) {
        super(world);
        preventEntitySpawning = true;
        setSize(1.3F, 0.6F);
        yOffset = height / 2.0F;
    }
    
    public EntityBroom(World world,Entity entity) {
        this(world,entity.posX,entity.posY,entity.posZ);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void entityInit() {
        dataWatcher.addObject(17, new Integer(0));
        dataWatcher.addObject(18, new Integer(1));
        dataWatcher.addObject(19, new Integer(0));
    }

    public AxisAlignedBB getCollisionBox(Entity entity) {
        return entity.boundingBox;
    }

    public AxisAlignedBB getBoundingBox() {
        return boundingBox;
    }

    public boolean canBePushed() {
        return true;
    }

    public EntityBroom(World world, double d, double d1, double d2) {
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
    }

    public double getMountedYOffset()
    {
        return 0;
    }

    public boolean attackEntityFrom(DamageSource damagesource, int i) {
        if(worldObj.isRemote || isDead)
        {
            return true;
        }
        func_41017_d(-func_41016_i());
        func_41019_c(10);
        func_41015_b(func_41020_g() + i * 10);
        setBeenAttacked();
        if(func_41020_g() > 40)
        {
            if(riddenByEntity != null)
            {
                riddenByEntity.mountEntity(this);
            }
            dropItem(ModItems.broom, 1);
//            dropItemWithOffset(ModItems.broom, 1, 0.0F);

            setDead();
        }
        return true;
    }

    public void performHurtAnimation() {
        func_41017_d(-func_41016_i());
        func_41019_c(10);
        func_41015_b(func_41020_g() * 11);
    }

    public boolean canBeCollidedWith() {
        return !isDead;
    }

    public void setPositionAndRotation2(double d, double d1, double d2, float f, float f1, int i) {
        boatX = d;
        boatY = d1;
        boatZ = d2;
        boatYaw = f;
        boatPitch = f1;
        boatPosRotationIncrements = i + 4;
        motionX = velocityX;
        motionY = velocityY;
        motionZ = velocityZ;
    }

    public void setVelocity(double d, double d1, double d2) {
        velocityX = motionX = d;
        velocityY = motionY = d1;
        velocityZ = motionZ = d2;
    }

    public void onUpdate() {
        super.onUpdate();
        if(func_41018_h() > 0)
        {
            func_41019_c(func_41018_h() - 1);
        }
        if(func_41020_g() > 0)
        {
            func_41015_b(func_41020_g() - 1);
        }
        prevPosX = posX;
        prevPosY = posY;
        prevPosZ = posZ;
        int i = 5;
        double d = 0.0D;

        double d1 = Math.sqrt(motionX * motionX + motionZ * motionZ);
        
        if(worldObj.isRemote)
        {
            if(boatPosRotationIncrements > 0)
            {
                double d4 = posX + (boatX - posX) / (double)boatPosRotationIncrements;
                double d10 = posY + (boatY - posY) / (double)boatPosRotationIncrements;
                double d13 = posZ + (boatZ - posZ) / (double)boatPosRotationIncrements;
                double d17;
                for(d17 = boatYaw - (double)rotationYaw; d17 < -180D; d17 += 360D) { }
                for(; d17 >= 180D; d17 -= 360D) { }
                //rotationYaw += d17 / (double)boatPosRotationIncrements;
                //rotationPitch += (boatPitch - (double)rotationPitch) / (double)boatPosRotationIncrements;
                boatPosRotationIncrements--;
                setPosition(d4, d10, d13);
                //setRotation(rotationYaw, rotationPitch);
            } else
            {
                double d5 = posX + motionX;
                double d11 = posY + motionY;
                double d14 = posZ + motionZ;
                setPosition(d5, d11, d14);
                /*if(onGround)
                {
                    motionX *= 0.5D;
                    motionY *= 0.5D;
                    motionZ *= 0.5D;
                }*/
                motionX *= 0.99000000953674316D;
                motionY *= 0.94999998807907104D;
                motionZ *= 0.99000000953674316D;
            }
            return;
        }
        /*if(d < 1.0D)
        {
            double d6 = d * 2D - 1.0D;
            motionY += 0.039999999105930328D * d6;
        } else
        {
            if(motionY < 0.0D)
            {
                motionY /= 2D;
            }
            motionY += 0.0070000002160668373D;
        }*/
        if(riddenByEntity != null)
        {
        	double riderX = riddenByEntity.motionX;
			double riderZ = riddenByEntity.motionZ;
			
			double acc = 0.05;
			
			float maxX = (float)riderX*29.0F;
			float maxZ = (float)riderZ*29.0F;
			
            //motionX += maxX * 0.060000000000000001D;
            //motionZ += maxZ * 0.060000000000000001D;
            
            //keep within max speeds
            if(motionX > maxX){
    			motionX -= acc;
    			if(motionX < maxX)
    				motionX = maxX;
            }
            if(motionX < maxX){
    			motionX += acc;
    			if(motionX > maxX)
    				motionX = maxX;
            }
            if(maxX == 0 && motionX > 0){
            	motionX -= acc;
            	if(motionX < 0)
            		motionX = 0;
            }
            if(maxX == 0 && motionX < 0){
            	motionX += acc;
            	if(motionX > 0)
            		motionX = 0;
            }
            
            if(motionZ > maxZ){
    			motionZ -= acc;
    			if(motionZ < maxZ)
    				motionZ = maxZ;
            }
            if(motionZ < maxZ){
    			motionZ += acc;
    			if(motionZ > maxZ)
    				motionZ = maxZ;
            }
            if(maxZ == 0 && motionZ > 0){
            	motionZ -= acc;
            	if(motionZ < 0)
            		motionZ = 0;
            }
            if(maxZ == 0 && motionZ < 0){
            	motionZ += acc;
            	if(motionZ > 0)
            		motionZ = 0;
            }
    		//if(Math.abs(motionZ) > Math.abs(maxZ) && motionZ/motionZ == maxZ/maxZ)
    		//	motionZ = maxZ;
            
    		//move up/down
    		EntityPlayer rider = (EntityPlayer)riddenByEntity;
    		
    		boolean broomUp = KeyBindings.broomDown.isPressed();
    		boolean broomDown = KeyBindings.broomUp.isPressed();
    		
    		if(broomUp && motionY <= 0.5){
    			motionY += acc;
    		}
    		if(broomDown && motionY >= -0.5){
    			motionY -= acc;
    		}
    		
    		//move up if hitting wall
    		if(isCollidedHorizontally && !broomDown && !broomUp)
            {
                motionY += acc;
            }
            
            if(motionY > 0.5)
            	motionY -= acc;
            if(motionY < -0.5)
            	motionY += acc;
            
            //slow down if not holding same movement keys
            /*if(motionX > 0 && riderX <= 0){
				motionX -= acc;
				if(motionX < 0)
					motionX = 0;
			}
			if(motionX < 0 && riderX >= 0){
				motionX += acc;
				if(motionX > 0)
					motionX = 0;
			}
			if(motionZ > 0 && riderZ <= 0){
				motionZ -= acc;
				if(motionZ < 0)
					motionZ = 0;
			}
			if(motionZ < 0 && riderZ >= 0){
				motionZ += acc;
				if(motionZ > 0)
					motionZ = 0;
			}*/
			
			//decrease y speed
			if(motionY > 0 && !broomUp && !broomDown && !isCollidedHorizontally){
				motionY -= acc;
				if(motionY < 0)
					motionY = 0;
			}
			if(motionY < 0 && !broomUp && !broomDown && !isCollidedHorizontally){
				motionY += acc;
				if(motionY > 0)
					motionY = 0;
			}
        }
        
        else if(!onGround){
        	motionY -= 0.1;
        	if(motionY < -0.5D)
            	motionY = -0.5D;
        }
        
        else
        {
        	//slow down
            if(motionX > 0){
				motionX -= 0.1;
				if(motionX < 0)
					motionX = 0;
			}
			if(motionX < 0){
				motionX += 0.1;
				if(motionX > 0)
					motionX = 0;
			}
			if(motionZ > 0){
				motionZ -= 0.1;
				if(motionZ < 0)
					motionZ = 0;
			}
			if(motionZ < 0){
				motionZ += 0.1;
				if(motionZ > 0)
					motionZ = 0;
			}
        }
        
        moveEntity(motionX, motionY, motionZ);
        
        /*rotationPitch = 0.0F;
        double d12 = rotationYaw;
        double d15 = prevPosX - posX;
        double d18 = prevPosZ - posZ;
        if(d15 * d15 + d18 * d18 > 0.001D)
        {
            d12 = (float)((Math.atan2(d18, d15) * 180D) / 3.1415926535897931D);
        }
        double d20;
        for(d20 = d12 - (double)rotationYaw; d20 >= 180D; d20 -= 360D) { }
        for(; d20 < -180D; d20 += 360D) { }
        if(d20 > 20D)
        {
            d20 = 20D;
        }
        if(d20 < -20D)
        {
            d20 = -20D;
        }
        rotationYaw += d20;
        setRotation(rotationYaw, rotationPitch);*/
        List list = worldObj.getEntitiesWithinAABBExcludingEntity(this, boundingBox.expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));
        if(list != null && list.size() > 0 && !worldObj.isRemote)
        {
            for(int j1 = 0; j1 < list.size(); j1++)
            {
                Entity entity = (Entity)list.get(j1);
                if(entity != riddenByEntity && entity.canBePushed() && (entity instanceof EntityBroom))
                {
                    entity.applyEntityCollision(this);
                }
            }

        }
        /*for(int k1 = 0; k1 < 4; k1++)
        {
            int l1 = MathHelper.floor_double(posX + ((double)(k1 % 2) - 0.5D) * 0.80000000000000004D);
            int i2 = MathHelper.floor_double(posY);
            int j2 = MathHelper.floor_double(posZ + ((double)(k1 / 2) - 0.5D) * 0.80000000000000004D);
            if(worldObj.getBlockId(l1, i2, j2) == Block.snow.blockID)
            {
                worldObj.setBlockWithNotify(l1, i2, j2, 0);
            }
        }*/

        if(riddenByEntity != null && riddenByEntity.isDead)
        {
            riddenByEntity = null;
        }
    }

    public void updateRiderPosition()
    {
        if(riddenByEntity == null)
        {
            return;
        } else
        {
            double d = Math.cos(((double)rotationYaw * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
            double d1 = Math.sin(((double)rotationYaw * 3.1415926535897931D) / 180D) * 0.40000000000000002D;
            riddenByEntity.setPosition(posX, posY + getMountedYOffset() + riddenByEntity.getYOffset(), posZ);
            //riddenByEntity.setPosition(posX,posY+1.0,posZ);
            return;
        }
    }

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
    }

    protected void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        if(riddenByEntity != null && (riddenByEntity instanceof EntityPlayer) && riddenByEntity != entityplayer)
        {
            return true;
        }
        if(!worldObj.isRemote)
        {
        	if(riddenByEntity != null)
        		rotationYaw = (-1)*entityplayer.rotationYaw;
            entityplayer.mountEntity(this);
        }
        return true;
    }

    public void func_41015_b(int i)
    {
        dataWatcher.updateObject(19, Integer.valueOf(i));
    }

    public int func_41020_g()
    {
        return dataWatcher.getWatchableObjectInt(19);
    }

    public void func_41019_c(int i)
    {
        dataWatcher.updateObject(17, Integer.valueOf(i));
    }

    public int func_41018_h()
    {
        return dataWatcher.getWatchableObjectInt(17);
    }

    public void func_41017_d(int i)
    {
        dataWatcher.updateObject(18, Integer.valueOf(i));
    }

    public int func_41016_i()
    {
        return dataWatcher.getWatchableObjectInt(18);
    }
}
