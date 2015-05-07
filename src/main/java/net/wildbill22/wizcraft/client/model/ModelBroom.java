package net.wildbill22.wizcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBroom extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
  
  public ModelBroom()
  {
	  textureWidth = 64;
	  textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 1, 1, 24);
      Shape1.setRotationPoint(-1F, 14F, -5F);
      //Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 3, 3, 3);
      Shape2.setRotationPoint(-2F, 13F, -8F);
      //Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 32, 0);
      Shape3.addBox(0F, 0F, 0F, 5, 5, 11);
      Shape3.setRotationPoint(-3F, 12F, -19F);
      //Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    //super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z) {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
}


/*package net.minecraft.src;

public class ModelBroom extends ModelBase
{
      //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
      
      public ModelBroom()
      {
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 1, 1, 24);
        Shape1.setRotationPoint(-1F, 14F, -5F);
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 3, 3, 3);
        Shape2.setRotationPoint(-2F, 13F, -8F);
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 32, 0);
        Shape3.addBox(0F, 0F, 0F, 5, 5, 11);
        Shape3.setRotationPoint(-3F, 12F, -19F);
        setRotation(Shape3, 0F, 0F, 0F);
      }

      public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
      {
        //super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
      }

      public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
      {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
      }
      
      private void setRotation(ModelRenderer model, float x, float y, float z)
      {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
      }
}*/
