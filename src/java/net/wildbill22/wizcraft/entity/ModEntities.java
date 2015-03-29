package net.wildbill22.wizcraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.wildbill22.wizcraft.WizcraftMod;
import net.wildbill22.wizcraft.lib.Reference;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * @author WILLIAM
 *
 */
public class ModEntities {
	private static int modEntityID = 0;
	
	public static void preInit() {
		// Overworld eggs
//		registerEntityEgg(EntityCreeperDragon.class, 0xd8bb9d, 0xa63c1a);
		
		// Overworld mod entities 
		EntityRegistry.registerModEntity(EntityBludger.class, Reference.MODID + EntityBludger.name, 
				++modEntityID, WizcraftMod.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntityBroom.class, Reference.MODID + EntityBroom.name, 
				++modEntityID, WizcraftMod.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntityQuaffle.class, Reference.MODID + EntityQuaffle.name, 
				++modEntityID, WizcraftMod.instance, 80, 1, true);
		EntityRegistry.registerModEntity(EntitySnitch.class, Reference.MODID + EntitySnitch.name, 
				++modEntityID, WizcraftMod.instance, 80, 1, true);

		// Projectiles
//		EntityRegistry.registerModEntity(EntitySpear.class, ItemSpear.name, ++modEntityID, Core.instance, 64, 10, true);
		
		addMobSpawns();
	}

	private static void addMobSpawns() {
		//Overworld
		/**
		 * Weighted Probability info:
		 * 
		 * CREATURE (day): Cows (8), Pigs (10), Chickens (10), Sheep (12)
		 * MONSTER (night): All 100 except Endermen (10), and Witches (5)
		 * AMBIENT (ambient creatures): Bats (10)
		 * WATER (water, duh): Squids (10)
		 * 
		 * Make sure these balance out; if not balanced, it could cause excess spawning/not spawning
		 * at all, plus crashes.
		 */
//		EntityRegistry.addSpawn(EntityCreeperDragon.class, BALANCE.MOBPROP.DRAGON_SPAWN_PROB, 1, 2, EnumCreatureType.creature, 
//				BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, 
//				BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, 
//				BiomeGenBase.roofedForest, BiomeGenBase.desert);
	}
	
    static int startEntityId = 300;
    
    @SuppressWarnings("unchecked")
    public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) {
    	int id = getUniqueEntityId();
    	EntityList.IDtoClassMapping.put(id, entity);
    	EntityList.entityEggs.put(id, new EntityList.EntityEggInfo(id, primaryColor, secondaryColor));
    }
        
    public static int getUniqueEntityId() {
    	do {
    		startEntityId++;
    	}
    	while (EntityList.getStringFromID(startEntityId) != null);

    	return startEntityId;
    }
}
