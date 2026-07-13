package com.example.realnextbots.nextbot;

import com.example.realnextbots.RealNextbots;
import com.example.realnextbots.nextbot.goal.TouchKillGoal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class NextbotEntity extends PathfinderMob {
    private final String NEXTBOT_ID;

    public NextbotEntity(EntityType<? extends PathfinderMob> entityType, Level level, String nextbotId) {
        super(entityType, level);
        this.NEXTBOT_ID = nextbotId;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9999.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.32D)
                .add(Attributes.FOLLOW_RANGE, 128.0D);
    }


    public @NotNull ResourceLocation getTextureLocation() {
        return ResourceLocation.fromNamespaceAndPath(RealNextbots.MODID, "textures/entity/" + this.NEXTBOT_ID + ".png");
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TouchKillGoal(this));
    }

    @Override
    public boolean isPersistenceRequired() {
        return true;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double distance) {
        return true;
    }

    @Override
    public boolean canBeLeashed() {
        return false;
    }
}
