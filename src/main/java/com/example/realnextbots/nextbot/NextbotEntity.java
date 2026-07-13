package com.example.realnextbots.nextbot;

import com.example.realnextbots.RealNextbots;
import com.example.realnextbots.nextbot.goal.NextbotAttackGoal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class NextbotEntity extends PathfinderMob {
    private final String NEXTBOT_ID;

    private int soundTimer = 0;

    public NextbotEntity(EntityType<? extends PathfinderMob> entityType, Level level, String nextbotId) {
        super(entityType, level);
        this.NEXTBOT_ID = nextbotId;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9999.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.FOLLOW_RANGE, 128.0D)
                .add(Attributes.ATTACK_DAMAGE, Double.MAX_VALUE); // Required for attack reach
    }


    public @NotNull ResourceLocation getTextureLocation() {
        return ResourceLocation.fromNamespaceAndPath(RealNextbots.MODID, "textures/entity/" + this.NEXTBOT_ID + ".png");
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.goalSelector.addGoal(1, new NextbotAttackGoal(this, 1.0D, false));
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

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            if (this.soundTimer <= 0) {
                this.playSound(ModSounds.NEXTBOT_SANYA.get(), 1.0F, 1.0F);

                this.soundTimer = 270;
            } else {
                this.soundTimer--;
            }

        }
    }
}
