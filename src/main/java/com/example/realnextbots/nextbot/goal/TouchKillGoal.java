package com.example.realnextbots.nextbot.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class TouchKillGoal extends Goal {
    private final Mob mob;

    public TouchKillGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        LivingEntity target = this.mob.getTarget();

        if (target == null || !target.isAlive()) {
            return false;
        }

        return this.mob.getBoundingBox().inflate(0.1D).intersects(target.getBoundingBox());
    }

    @Override
    public void start() {
        LivingEntity target = this.mob.getTarget();

        if (target != null) {
            target.hurt(this.mob.damageSources().mobAttack(this.mob), Float.MAX_VALUE);
        }
    }
}
