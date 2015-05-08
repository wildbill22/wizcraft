package net.wildbill22.wizcraft.client.renderer;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.wizcraft.client.model.ModelSnitch;
import net.wildbill22.wizcraft.entity.EntitySnitch;
import net.wildbill22.wizcraft.lib.Reference;

import org.lwjgl.opengl.GL11;

public class RenderSnitch extends Render {
	public static final ResourceLocation snitchTexture = new ResourceLocation(Reference.MODID + ":textures/models/goldenSnitch.png");
	protected ModelSnitch modelSnitch;
	
	public RenderSnitch() {
		shadowSize = 0.2F;
		modelSnitch = new ModelSnitch();
	}

	public void renderNew(EntitySnitch entitysnitch, double d, double d1,
			double d2, float f, float f1) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		
		float yaw = entitysnitch.rotationYaw;
	    float pitch = entitysnitch.rotationPitch;
	        
	    GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
	    GL11.glRotatef(pitch, 0.0F, 0.0F, 1.0F);
		
//		loadTexture("/QuidditchImages/SnitchSkin.png");
		GL11.glScalef(-1F, -1F, 1.0F);
		modelSnitch.flap(entitysnitch.wingFlap);
		modelSnitch.render(entitysnitch, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void doRender(Entity entity, double d, double d1, double d2,
			float f, float f1) {
		renderNew((EntitySnitch) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return snitchTexture;
	}
}
