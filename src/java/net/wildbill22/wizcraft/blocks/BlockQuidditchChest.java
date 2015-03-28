package net.wildbill22.wizcraft.blocks;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockQuidditchChest extends ModBlocks {
	public static final String name = "quidditchChest";

	protected BlockQuidditchChest() {
		super(name, name, Material.wood);
		setHardness(1.0F);
		setResistance(3.0F);
    }
		
	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
    }
	
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (world.isRemote) {
            return true;
        }
		int l = world.getBlockMetadata(i, j, k);
//		int[][][] pitchSetup = new int[153][51][37];
		
		Block cobblestone = Blocks.cobblestone;
		Block grass = Blocks.grass;
		Block sand = Blocks.sand;
		Block fence = Blocks.fence;
		Block plank = Blocks.planks;
//		Block wool = Blocks.wool;
		Block net = ModBlocks.blockGoal;
		
		Block[] blocks = new Block[412794];
		
		//if(l == 1){
			int currentBlock = 0;
			String outputPitch = "";
			for(int x = -76; x <= 76; x++){
				for(int z = -35; z <= 35; z++){
					for(int y = -2; y <= 35; y++){
						blocks[currentBlock] = world.getBlock(i+x,j+y,k+z);
						//System.out.println(world.getBlockId(i+x,j+y,k+z));
						//outputPitch += " " + world.getBlockId(i+x,j+y,k+z);
						currentBlock ++;
					}
				}
			}
			world.setBlockMetadataWithNotify(i, j, k, 0, 3);
			System.out.println("****");
			/*for(int c=0;c<blocks.length;c++){
				outputPitch += " " + blocks[c];
				System.out.println(blocks[c]);
			}*/
			
			String temp = Arrays.toString(blocks);//.replace(", ", "");
			temp = temp.substring(1, temp.length()-1);
			
			System.out.println(temp);
			
			/*Writer output = null;
			File file = new File("pitchfile.txt");
			try {
				output = new BufferedWriter(new FileWriter(file));
				output.write(outputPitch);
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		//}
		if(l == 0){
			world.setBlockMetadataWithNotify(i, j, k, 1, 3);
			//cobblestone base
			fillWithBlocks(world, i-76, i+76, j-2, j-2, k-35, k+35, cobblestone);
			
			//initial grass pass
			fillWithBlocks(world, i-76, i+76, j-1, j-1, k-35, k+35, grass);
			
			//wool outlines
			//fillWithBlocks(world, i-76, i+76, j-1, j-1, k-25, k+25, wool);
			
			//sand pits
			fillWithBlocks(world, i-76+9, i-76+11, j-1, j-1, k-25+14, k-25+14, sand);
			fillWithBlocks(world, i-76+8, i-76+12, j-1, j-1, k-25+15, k-25+15, sand);
			fillWithBlocks(world, i-76+7, i-76+13, j-1, j-1, k-25+16, k-25+16, sand);
			fillWithBlocks(world, i-76+6, i-76+14, j-1, j-1, k-25+17, k-25+17, sand);
			fillWithBlocks(world, i-76+5, i-76+15, j-1, j-1, k-25+18, k-25+18, sand);
			fillWithBlocks(world, i-76+4, i-76+16, j-1, j-1, k-25+19, k-25+19, sand);
			fillWithBlocks(world, i-76+3, i-76+17, j-1, j-1, k-25+20, k-25+20, sand);
			fillWithBlocks(world, i-76+2, i-76+18, j-1, j-1, k-25+21, k-25+22, sand);
			fillWithBlocks(world, i-76+1, i-76+19, j-1, j-1, k-25+23, k-25+26, sand);
			fillWithBlocks(world, i-76+2, i-76+18, j-1, j-1, k-25+27, k-25+28, sand);
			fillWithBlocks(world, i-76+3, i-76+17, j-1, j-1, k-25+29, k-25+29, sand);
			fillWithBlocks(world, i-76+4, i-76+16, j-1, j-1, k-25+30, k-25+30, sand);
			fillWithBlocks(world, i-76+5, i-76+15, j-1, j-1, k-25+31, k-25+31, sand);
			fillWithBlocks(world, i-76+6, i-76+14, j-1, j-1, k-25+32, k-25+32, sand);
			fillWithBlocks(world, i-76+7, i-76+13, j-1, j-1, k-25+33, k-25+33, sand);
			fillWithBlocks(world, i-76+8, i-76+12, j-1, j-1, k-25+34, k-25+34, sand);
			fillWithBlocks(world, i-76+9, i-76+11, j-1, j-1, k-25+35, k-25+35, sand);
			
			fillWithBlocks(world, i-76+141, i-76+143, j-1, j-1, k-25+14, k-25+14, sand);
			fillWithBlocks(world, i-76+140, i-76+144, j-1, j-1, k-25+15, k-25+15, sand);
			fillWithBlocks(world, i-76+139, i-76+145, j-1, j-1, k-25+16, k-25+16, sand);
			fillWithBlocks(world, i-76+138, i-76+146, j-1, j-1, k-25+17, k-25+17, sand);
			fillWithBlocks(world, i-76+137, i-76+147, j-1, j-1, k-25+18, k-25+18, sand);
			fillWithBlocks(world, i-76+136, i-76+148, j-1, j-1, k-25+19, k-25+19, sand);
			fillWithBlocks(world, i-76+135, i-76+149, j-1, j-1, k-25+20, k-25+20, sand);
			fillWithBlocks(world, i-76+134, i-76+150, j-1, j-1, k-25+21, k-25+22, sand);
			fillWithBlocks(world, i-76+133, i-76+151, j-1, j-1, k-25+23, k-25+26, sand);
			fillWithBlocks(world, i-76+134, i-76+150, j-1, j-1, k-25+27, k-25+28, sand);
			fillWithBlocks(world, i-76+135, i-76+149, j-1, j-1, k-25+29, k-25+29, sand);
			fillWithBlocks(world, i-76+136, i-76+148, j-1, j-1, k-25+30, k-25+30, sand);
			fillWithBlocks(world, i-76+137, i-76+147, j-1, j-1, k-25+31, k-25+31, sand);
			fillWithBlocks(world, i-76+138, i-76+146, j-1, j-1, k-25+32, k-25+32, sand);
			fillWithBlocks(world, i-76+139, i-76+145, j-1, j-1, k-25+33, k-25+33, sand);
			fillWithBlocks(world, i-76+140, i-76+144, j-1, j-1, k-25+34, k-25+34, sand);
			fillWithBlocks(world, i-76+141, i-76+143, j-1, j-1, k-25+35, k-25+35, sand);

			//fence posts
			fillWithBlocks(world, i-76+10, i-76+10, j, j+25, k-25+19, k-25+19, fence);
			fillWithBlocks(world, i-76+10, i-76+10, j, j+30, k-25+25, k-25+25, fence);
			fillWithBlocks(world, i-76+10, i-76+10, j, j+25, k-25+31, k-25+31, fence);
			
			fillWithBlocks(world, i-76+142, i-76+142, j, j+25, k-25+19, k-25+19, fence);
			fillWithBlocks(world, i-76+142, i-76+142, j, j+30, k-25+25, k-25+25, fence);
			fillWithBlocks(world, i-76+142, i-76+142, j, j+25, k-25+31, k-25+31, fence);
			
			//plank goals
			fillWithBlocks(world, i-76+10, i-76+10, j+25, j+25, k-25+18, k-25+20, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+29, j+29, k-25+18, k-25+20, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+17, k-25+17, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+21, k-25+21, plank);
			
			fillWithBlocks(world, i-76+10, i-76+10, j+30, j+30, k-25+24, k-25+26, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+34, j+34, k-25+24, k-25+26, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+31, j+33, k-25+23, k-25+23, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+31, j+33, k-25+27, k-25+27, plank);
			
			fillWithBlocks(world, i-76+10, i-76+10, j+25, j+25, k-25+30, k-25+32, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+29, j+29, k-25+30, k-25+32, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+29, k-25+29, plank);
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+33, k-25+33, plank);
			
			
			fillWithBlocks(world, i-76+142, i-76+142, j+25, j+25, k-25+18, k-25+20, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+29, j+29, k-25+18, k-25+20, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+17, k-25+17, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+21, k-25+21, plank);
			
			fillWithBlocks(world, i-76+142, i-76+142, j+30, j+30, k-25+24, k-25+26, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+34, j+34, k-25+24, k-25+26, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+31, j+33, k-25+23, k-25+23, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+31, j+33, k-25+27, k-25+27, plank);
			
			fillWithBlocks(world, i-76+142, i-76+142, j+25, j+25, k-25+30, k-25+32, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+29, j+29, k-25+30, k-25+32, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+29, k-25+29, plank);
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+33, k-25+33, plank);
			
			//nets
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+18, k-25+20, net);
			fillWithBlocks(world, i-76+10, i-76+10, j+31, j+33, k-25+24, k-25+26, net);
			fillWithBlocks(world, i-76+10, i-76+10, j+26, j+28, k-25+30, k-25+32, net);
			
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+18, k-25+20, net);
			fillWithBlocks(world, i-76+142, i-76+142, j+31, j+33, k-25+24, k-25+26, net);
			fillWithBlocks(world, i-76+142, i-76+142, j+26, j+28, k-25+30, k-25+32, net);
			
		}
        return true;
    }
	
	public void fillWithBlocks(World world,int i1, int i2, int j1, int j2, int k1, int k2, Block material){
		for(int i = i1; i <= i2; i++){
			for(int j = j1; j <= j2; j++){
				for(int k = k1; k <= k2; k++){
					world.setBlock(i, j, k, material);
				}
			}
		}
	}
	
	public void onBlockRemoval(World world, int i, int j, int k)
    {
		dropBlockAsItem(world, i, j, k, 1, 1);
    }
	
	/*public int idDropped(int i, Random random){
		return blockID;
	}*/

}
