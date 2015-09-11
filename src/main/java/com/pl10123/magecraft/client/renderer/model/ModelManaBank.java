
package com.pl10123.magecraft.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelManaBank extends ModelBase
{
  //fields
    ModelRenderer StandRight;
    ModelRenderer StandLeft;
    ModelRenderer StandFront;
    ModelRenderer StandBack;
    ModelRenderer MainTank;
    ModelRenderer OutputCube;
    ModelRenderer ProtectorL;
    ModelRenderer ProtectorR;
    ModelRenderer ProtectorB;
    ModelRenderer ProtectorF;
    ModelRenderer TopRight;
    ModelRenderer TopBack;
    ModelRenderer TopFront;
    ModelRenderer TopLeft;
  
  public ModelManaBank()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      StandRight = new ModelRenderer(this, 0, 0);
      StandRight.addBox(0F, 0F, 0F, 6, 1, 2);
      StandRight.setRotationPoint(-7F, 23F, -1F);
      StandRight.setTextureSize(64, 32);
      StandRight.mirror = true;
      setRotation(StandRight, 0F, 0F, 0F);
      StandLeft = new ModelRenderer(this, 0, 0);
      StandLeft.addBox(-2F, 0F, 0F, 6, 1, 2);
      StandLeft.setRotationPoint(3F, 23F, -1F);
      StandLeft.setTextureSize(64, 32);
      StandLeft.mirror = true;
      setRotation(StandLeft, 0F, 0F, 0F);
      StandFront = new ModelRenderer(this, 0, 0);
      StandFront.addBox(-2F, 0F, 0F, 6, 1, 2);
      StandFront.setRotationPoint(-1F, 23F, -3F);
      StandFront.setTextureSize(64, 32);
      StandFront.mirror = true;
      setRotation(StandFront, 0F, 1.570796F, 0F);
      StandBack = new ModelRenderer(this, 0, 0);
      StandBack.addBox(0F, 0F, 0F, 6, 1, 2);
      StandBack.setRotationPoint(-1F, 23F, 7F);
      StandBack.setTextureSize(64, 32);
      StandBack.mirror = true;
      setRotation(StandBack, 0F, 1.570796F, 0F);
      MainTank = new ModelRenderer(this, 10, 7);
      MainTank.addBox(0F, 0F, 0F, 12, 13, 12);
      MainTank.setRotationPoint(-6F, 10F, -6F);
      MainTank.setTextureSize(64, 32);
      MainTank.mirror = true;
      setRotation(MainTank, 0F, 0F, 0F);
      OutputCube = new ModelRenderer(this, 0, 0);
      OutputCube.addBox(0F, 0F, 0F, 2, 1, 2);
      OutputCube.setRotationPoint(-1F, 23F, -1F);
      OutputCube.setTextureSize(64, 32);
      OutputCube.mirror = true;
      setRotation(OutputCube, 0F, 0F, 0F);
      ProtectorL = new ModelRenderer(this, 0, 0);
      ProtectorL.addBox(0F, 0F, 0F, 1, 14, 2);
      ProtectorL.setRotationPoint(6F, 9F, -1F);
      ProtectorL.setTextureSize(64, 32);
      ProtectorL.mirror = true;
      setRotation(ProtectorL, 0F, 0F, 0F);
      ProtectorR = new ModelRenderer(this, 0, 0);
      ProtectorR.addBox(0F, 0F, 0F, 1, 14, 2);
      ProtectorR.setRotationPoint(-7F, 9F, -1F);
      ProtectorR.setTextureSize(64, 32);
      ProtectorR.mirror = true;
      setRotation(ProtectorR, 0F, 0F, 0F);
      ProtectorB = new ModelRenderer(this, 0, 0);
      ProtectorB.addBox(0F, 0F, 0F, 1, 14, 2);
      ProtectorB.setRotationPoint(1F, 9F, 6F);
      ProtectorB.setTextureSize(64, 32);
      ProtectorB.mirror = true;
      setRotation(ProtectorB, 0F, -1.570796F, 0F);
      ProtectorF = new ModelRenderer(this, 0, 0);
      ProtectorF.addBox(0F, 0F, 0F, 1, 14, 2);
      ProtectorF.setRotationPoint(-1F, 9F, -6F);
      ProtectorF.setTextureSize(64, 32);
      ProtectorF.mirror = true;
      setRotation(ProtectorF, 0F, 1.570796F, 0F);
      TopRight = new ModelRenderer(this, 0, 0);
      TopRight.addBox(0F, 0F, 0F, 5, 1, 2);
      TopRight.setRotationPoint(-6F, 9F, -1F);
      TopRight.setTextureSize(64, 32);
      TopRight.mirror = true;
      setRotation(TopRight, 0F, 0F, 0F);
      TopBack = new ModelRenderer(this, 0, 0);
      TopBack.addBox(0F, 0F, 0F, 5, 1, 2);
      TopBack.setRotationPoint(-1F, 9F, 6F);
      TopBack.setTextureSize(64, 32);
      TopBack.mirror = true;
      setRotation(TopBack, 0F, 1.570796F, 0F);
      TopFront = new ModelRenderer(this, 0, 0);
      TopFront.addBox(0F, 0F, 0F, 5, 1, 2);
      TopFront.setRotationPoint(-1F, 9F, -1F);
      TopFront.setTextureSize(64, 32);
      TopFront.mirror = true;
      setRotation(TopFront, 0F, 1.570796F, 0F);
      TopLeft = new ModelRenderer(this, 0, 0);
      TopLeft.addBox(0F, 0F, 0F, 5, 1, 2);
      TopLeft.setRotationPoint(1F, 9F, -1F);
      TopLeft.setTextureSize(64, 32);
      TopLeft.mirror = true;
      setRotation(TopLeft, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    StandRight.render(f5);
    StandLeft.render(f5);
    StandFront.render(f5);
    StandBack.render(f5);
    MainTank.render(f5);
    OutputCube.render(f5);
    ProtectorL.render(f5);
    ProtectorR.render(f5);
    ProtectorB.render(f5);
    ProtectorF.render(f5);
    TopRight.render(f5);
    TopBack.render(f5);
    TopFront.render(f5);
    TopLeft.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
