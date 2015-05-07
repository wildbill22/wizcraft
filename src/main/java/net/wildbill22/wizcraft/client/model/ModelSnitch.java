package net.wildbill22.wizcraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSnitch extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer right_wing;
	ModelRenderer left_wing;

	public ModelSnitch() {
		Body = new ModelRenderer(this, 9, 1);
		Body.addBox(0F, 0F, 0F, 2, 2, 2);
		Body.setRotationPoint(0F, 0F, 0F);
		setRotation(Body, 0F, 0F, 0F);
		right_wing = new ModelRenderer(this, 0, 0);
		right_wing.addBox(0F, 0F, -4F, 0, 1, 4);
		right_wing.setRotationPoint(1F, 0F, 0F);
		setRotation(right_wing, 0F, 0F, 1F);
		//right_wing.IsMirrored = true;
		left_wing = new ModelRenderer(this, 18, 0);
		left_wing.addBox(0F, 0F, 0F, 0, 1, 4);
		left_wing.setRotationPoint(1F, 0F, 2F);
		setRotation(left_wing, 0F, 0F, 1F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		//super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		right_wing.render(f5);
		left_wing.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void flap(float f) {
		setRotation(left_wing, 0F, f, 1F);
		setRotation(right_wing, 0F, (-1)*f, 1F);
	}
}
