package net.wildbill22.wizcraft.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.wizcraft.client.model.ModelBludger;
import net.wildbill22.wizcraft.entity.EntityBludger;
import net.wildbill22.wizcraft.lib.Reference;

import org.lwjgl.opengl.GL11;

public class RenderBludger extends Render {
	public static final ResourceLocation bludgerTexture = new ResourceLocation(Reference.MODID + ":textures/models/BludgerSkin.png");
    protected ModelBase modelBludger;

    public RenderBludger() {
    	shadowSize = 0.2F;
    	modelBludger = new ModelBludger();
    }

    public void renderNew(EntityBludger entitybludger, double d, double d1, double d2,
            float f, float f1)
    {
    	GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        
        float yaw = entitybludger.rotationYaw;
        float pitch = entitybludger.rotationPitch;
        
        GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(pitch, 0.0F, 0.0F, 1.0F);
        
//        loadTexture("/QuidditchImages/BludgerSkin.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        modelBludger.render(entitybludger, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

	@Override
    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        renderNew((EntityBludger)entity, d, d1, d2, f, f1);
    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return bludgerTexture;
	}
}
