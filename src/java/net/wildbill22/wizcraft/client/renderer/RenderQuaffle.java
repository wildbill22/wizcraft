package net.wildbill22.wizcraft.client.renderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.wizcraft.client.model.ModelQuaffle;
import net.wildbill22.wizcraft.entity.EntityQuaffle;
import net.wildbill22.wizcraft.lib.Reference;

import org.lwjgl.opengl.GL11;

public class RenderQuaffle extends Render {
	public static final ResourceLocation quaffleTexture = new ResourceLocation(Reference.MODID + ":textures/models/QuaffleSkin.png");
    protected ModelBase modelQuaffle;

    public RenderQuaffle() {
    	shadowSize = 0.2F;
    	modelQuaffle = new ModelQuaffle();
    }

    public void renderNew(EntityQuaffle entityquaffle, double d, double d1, double d2, float f, float f1) {
    	float yaw =(float) (entityquaffle.rotationYaw * (-180) / 3.1415927410125732D);

    	GL11.glPushMatrix();
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
        GL11.glRotatef((-1)*yaw, 0.0F, 1.0F, 0.0F);
//        loadTexture("/QuidditchImages/QuaffleSkin.png");
        GL11.glScalef(-1F, -1F, 1.0F);
        modelQuaffle.render(entityquaffle, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        renderNew((EntityQuaffle)entity, d, d1, d2, f, f1);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return quaffleTexture;
	}
}