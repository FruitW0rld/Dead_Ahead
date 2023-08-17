package net.fruitworld.deadahead.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


public class WitchEntity extends Monster implements IAnimatable {
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);
    public WitchEntity(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    public static AttributeSupplier setAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 25)
                .add(Attributes.ATTACK_DAMAGE, 7)
                .add(Attributes.ATTACK_SPEED, 0.6)
                .add(Attributes.MOVEMENT_SPEED, 0.40)
                .add(Attributes.FOLLOW_RANGE, 40).build();

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("witch.run", ILoopType.EDefaultLoopTypes.LOOP));
        }


        event.getController().setAnimation(new AnimationBuilder().addAnimation("witch.idle", ILoopType.EDefaultLoopTypes.LOOP));
        return PlayState.CONTINUE;
    }
    private PlayState attackPredicate(AnimationEvent<WitchEntity> event) {
        if(this.swinging && event.getController().getAnimationState().equals(AnimationState.Stopped)) {
            event.getController().markNeedsReload();
            event.getController().setAnimation(new AnimationBuilder().addAnimation("witch.attack", ILoopType.EDefaultLoopTypes.PLAY_ONCE));
            this.swinging = false;

        }


        return PlayState.CONTINUE;

    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 5, this::predicate));
        data.addAnimationController(new AnimationController<>(this, "attackController", 5, this::attackPredicate));
    }


    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState blockIn) {
        this.playSound(SoundEvents.ZOMBIE_STEP, 0.15f, 1.0f);
    }

    protected SoundEvent getAmbientSound() {return SoundEvents.ZOMBIE_AMBIENT;}

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {return SoundEvents.ZOMBIE_HURT;}

    protected SoundEvent getDeathSound() {return SoundEvents.ZOMBIE_DEATH;}

    protected float getSoundVolume() {return 0.2f;}


}
