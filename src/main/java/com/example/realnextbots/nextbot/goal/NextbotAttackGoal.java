package com.example.realnextbots.nextbot.goal;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class NextbotAttackGoal extends MeleeAttackGoal {

    public NextbotAttackGoal(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.mob.getTarget() != null && this.mob.tickCount % 5 == 0) {
            this.mob.getNavigation().moveTo(this.mob.getTarget(), 1.0D);
        }
    }
}
