package fr.skypieya.necrorunia.models;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

public class CustomEntityModel {
    private LivingEntity _livingEntity;
    private double _maxhealth;
    private double _health;
    private double _attack;
    private double  _armor;
    private double _attack_knockback;
    private double _attack_speed;
    private double _follow_range;
    private double _luck;
    private double _knockback_resistance;
    private double _mouvement_speed;
    private double _flying_speed;
    private ItemStack _skull;
    public CustomEntityModel(LivingEntity livingEntity){
        this._livingEntity = livingEntity;
        this._maxhealth = getAttribute(Attribute.GENERIC_MAX_HEALTH);
        this._health = this._maxhealth;
        this._attack = getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        this._armor = getAttribute(Attribute.GENERIC_ARMOR);
        this._attack_knockback = getAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK);
        this._attack_speed = getAttribute(Attribute.GENERIC_ATTACK_SPEED);
        this._follow_range = getAttribute(Attribute.GENERIC_FOLLOW_RANGE);
        this._luck = getAttribute(Attribute.GENERIC_LUCK);
        this._knockback_resistance = getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE);
        this._mouvement_speed = getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        this._flying_speed = getAttribute(Attribute.GENERIC_FLYING_SPEED);
    }

    private void update(){

        setAttribute(Attribute.GENERIC_MAX_HEALTH, this._maxhealth);
        setAttribute(Attribute.GENERIC_ATTACK_DAMAGE,this._attack);
        setAttribute(Attribute.GENERIC_ARMOR, this._armor);
        setAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, this._attack_knockback);
        setAttribute(Attribute.GENERIC_ATTACK_SPEED, this._attack_speed);
        setAttribute(Attribute.GENERIC_FOLLOW_RANGE, this._attack_speed);
        setAttribute(Attribute.GENERIC_LUCK, this._luck);
        setAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, this._knockback_resistance);
        setAttribute(Attribute.GENERIC_MOVEMENT_SPEED, this._mouvement_speed);
        setAttribute(Attribute.GENERIC_FLYING_SPEED, this._flying_speed);
    }

    private double getAttribute(Attribute attribute){
        return this._livingEntity.getAttribute(attribute).getBaseValue();
    }

    private void setAttribute(Attribute attribute, double value){
        this._livingEntity.getAttribute(attribute).setBaseValue(value);
    }
}
