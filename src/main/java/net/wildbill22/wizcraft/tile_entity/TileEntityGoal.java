package net.wildbill22.wizcraft.tile_entity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.wildbill22.wizcraft.blocks.BlockGoal;

public class TileEntityGoal extends TileEntity{
	
	public TileEntityGoal() {
        goalTime = 0;
        neighborHasQuaffle = false;
        hasQuaffle = false;
        justLostQuaffle = false;
    }
	
	public TileEntityGoal(TileEntityGoal other){
	}
	
	public void readFromNBT(NBTTagCompound nbttagcompound) {
        //super.readFromNBT(nbttagcompound);
		super.readFromNBT(nbttagcompound);
        goalTime = nbttagcompound.getShort("GoalTime");
        neighborHasQuaffle = nbttagcompound.getBoolean("neighborHasQuaffle");
        hasQuaffle = nbttagcompound.getBoolean("hasQuaffle");
        justLostQuaffle = nbttagcompound.getBoolean("justLostQuaffle");
        maxGoalTime = nbttagcompound.getShort("MaxGoalTime");
        neighborX = nbttagcompound.getShort("NeighborX");
        neighborY = nbttagcompound.getShort("NeighborY");
        neighborZ = nbttagcompound.getShort("NeighborZ");
    }
	
	public void writeToNBT(NBTTagCompound nbttagcompound) {
        //super.writeToNBT(nbttagcompound);
		super.writeToNBT(nbttagcompound);
        nbttagcompound.setShort("GoalTime", (short)goalTime);
        nbttagcompound.setBoolean("neighborHasQuaffle", neighborHasQuaffle);
        nbttagcompound.setBoolean("hasQuaffle", hasQuaffle);
        nbttagcompound.setBoolean("justLostQuaffle", justLostQuaffle);
        nbttagcompound.setShort("MaxGoalTime", (short)maxGoalTime);
        nbttagcompound.setShort("NeighborX", (short)neighborX);
        nbttagcompound.setShort("NeighborY", (short)neighborY);
        nbttagcompound.setShort("NeighborZ", (short)neighborZ);
    }
	
	public void updateEntity()
    {
		if(!worldObj.isRemote){
			BlockGoal.updateGoalBlockState(!hasQuaffle && !neighborHasQuaffle,(hasQuaffle || neighborHasQuaffle), worldObj, xCoord, yCoord, zCoord);
			
			if(!hasQuaffle && !neighborHasQuaffle && goalTime > 0)
				goalTime--;
			
			if(verifyQuaffle){
				hasQuaffle = false;
			}
			
			//if hasquaffle, set verify to true, if verify still true on next update set hasquaffle false
			if(hasQuaffle){
				verifyQuaffle = true;
				goalTime = maxGoalTime;
			}
			//if(neighborHasQuaffle)
			//	neighborHasQuaffle=false;
		}
    }
	
	public void setNeighborHasQuaffle(boolean b){
		neighborHasQuaffle = b;
		if(b){
			//goalTime = maxGoalTime;
			//countDown = false;
		}	
		//else if(!hasQuaffle)
		//	countDown = true;
	}
	
	public void setHasQuaffle(boolean b){
		//scored = b;
		hasQuaffle = (b);
		if(b){
			verifyQuaffle = false;
			goalTime = maxGoalTime;
		//	countDown = false;
		}
		//else if(!neighborHasQuaffle)
		//	countDown = true;
	}
	
	public void setGoalTime(int i){
		goalTime = i;
	}
	
	public void setNeighborPosition(int i, int j, int k){
		neighborX = i;
		neighborY = j;
		neighborZ = k;
	}
	
	public void openChest()
    {
    }

    public void closeChest()
    {
    }

    public boolean hasQuaffle;
    public boolean justLostQuaffle;
    public boolean verifyQuaffle;
    public boolean neighborHasQuaffle;
    public int neighborX;
    public int neighborY;
    public int neighborZ;
	public int goalTime;
	public int maxGoalTime=50;
}
