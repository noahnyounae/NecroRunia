package fr.skypieya.necrorunia.models;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CustomEntityModel {
    private final EntityType _entityType;
    private final double _max_health;
    private final double _attack;
    private final double  _armor;
    private final double _attack_knockback;
    private final double _attack_speed;
    private final double _follow_range;
    private final double _luck;
    private final double _knockback_resistance;
    private final double _mouvement_speed;
    private final double _flying_speed;
    private ItemStack _skull;
    public CustomEntityModel(LivingEntity livingEntity){
        this._entityType           = livingEntity.getType();
        this._max_health            = getAttribute(Attribute.GENERIC_MAX_HEALTH          , livingEntity);
        this._attack               = getAttribute(Attribute.GENERIC_ATTACK_DAMAGE       , livingEntity);
        this._armor                = getAttribute(Attribute.GENERIC_ARMOR               , livingEntity);
        this._attack_knockback     = getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK    , livingEntity);
        this._attack_speed         = getAttribute(Attribute.GENERIC_ATTACK_SPEED        , livingEntity);
        this._follow_range         = getAttribute(Attribute.GENERIC_FOLLOW_RANGE        , livingEntity);
        this._luck                 = getAttribute(Attribute.GENERIC_LUCK                , livingEntity);
        this._knockback_resistance = getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, livingEntity);
        this._mouvement_speed      = getAttribute(Attribute.GENERIC_MOVEMENT_SPEED      , livingEntity);
        this._flying_speed         = getAttribute(Attribute.GENERIC_FLYING_SPEED        , livingEntity);
    }

    private void spawn(Location location){
        LivingEntity livingEntity = (LivingEntity) Objects.requireNonNull(location.getWorld())
                .spawnEntity(location, this._entityType);
        setAttribute(Attribute.GENERIC_MAX_HEALTH          , this._max_health          , livingEntity);
        setAttribute(Attribute.GENERIC_ATTACK_DAMAGE       ,this._attack               , livingEntity);
        setAttribute(Attribute.GENERIC_ARMOR               , this._armor               , livingEntity);
        setAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK    , this._attack_knockback    , livingEntity);
        setAttribute(Attribute.GENERIC_ATTACK_SPEED        , this._attack_speed        , livingEntity);
        setAttribute(Attribute.GENERIC_FOLLOW_RANGE        , this._attack_speed        , livingEntity);
        setAttribute(Attribute.GENERIC_LUCK                , this._luck                , livingEntity);
        setAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, this._knockback_resistance, livingEntity);
        setAttribute(Attribute.GENERIC_MOVEMENT_SPEED      , this._mouvement_speed     , livingEntity);
        setAttribute(Attribute.GENERIC_FLYING_SPEED        , this._flying_speed        , livingEntity);
        setAttribute(Attribute.GENERIC_FOLLOW_RANGE        , this._follow_range        , livingEntity);
        livingEntity.setHealth(this._max_health);
    }

    private double getAttribute(Attribute attribute,LivingEntity livingEntity){
        return Objects.requireNonNull(livingEntity.getAttribute(attribute)).getBaseValue();
    }

    private void setAttribute(Attribute attribute, double value, LivingEntity livingEntity){
        Objects.requireNonNull(livingEntity.getAttribute(attribute)).setBaseValue(value);
    }
}
