package net.wildbill22.wizcraft.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.wildbill22.wizcraft.client.model.ModelBroom;
import net.wildbill22.wizcraft.entity.EntityBroom;
import net.wildbill22.wizcraft.lib.Reference;

import org.lwjgl.opengl.GL11;

public class RenderBroom extends Render {
	public static final ResourceLocation broomTexture = new ResourceLocation(Reference.MODID + ":textures/models/BroomSkin.png");
    protected ModelBase modelBroom;

    public RenderBroom() {
   		shadowSize = 0.2F;
   		modelBroom = new ModelBroom();
    }

   public void renderBroom(EntityBroom entitybroom, double d, double d1, double d2,
           float f, float f1)
   {
	   GL11.glPushMatrix();
       GL11.glTranslatef((float)d, (float)d1+1.0F, (float)d2);
       //float yaw = 0F;
       //float pitch = 0F;
       //if(entitybroom.riddenByEntity != null)
    	//   yaw = (-1)*entitybroom.riddenByEntity.rotationYaw;
       //else
    	//   yaw = entitybroom.rotationYaw;
       
       //pitch = (float)entitybroom.motionY*(-50F);
       
      // GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
      // GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
       
//       this.loadTexture("/QuidditchImages/BroomSkin.png");
       GL11.glScalef(-1F, -1F, 1.0F);
       modelBroom.render(entitybroom, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
       GL11.glPopMatrix();
   }

   	@Override
    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
    {
   	   renderBroom((EntityBroom)entity, d, d1, d2, f, f1);
    }
       
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return broomTexture;
	}
}