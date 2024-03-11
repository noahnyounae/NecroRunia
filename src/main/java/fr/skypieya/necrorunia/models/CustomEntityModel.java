package fr.skypieya.necrorunia.models;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CustomEntityModel {
    //region Variables
    private LivingEntity _livingEntity;
    private double _maxHealth;
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

    //endregion

    //region Build
    public CustomEntityModel(LivingEntity livingEntity){
        this._livingEntity = livingEntity;
        this._maxHealth = getAttribute(Attribute.GENERIC_MAX_HEALTH);
        this._health = this._maxHealth;
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

    //endregion

    //region Getter
    public LivingEntity get_livingEntity() {
        return _livingEntity;
    }

    public double get_maxHealth() {
        return _maxHealth;
    }

    public double get_health() {
        return _health;
    }

    public double get_attack() {
        return _attack;
    }

    public double get_armor() {
        return _armor;
    }

    public double get_attack_knockback() {
        return _attack_knockback;
    }

    public double get_attack_speed() {
        return _attack_speed;
    }

    public double get_follow_range() {
        return _follow_range;
    }

    public double get_luck() {
        return _luck;
    }

    public double get_knockback_resistance() {
        return _knockback_resistance;
    }

    public double get_mouvement_speed() {
        return _mouvement_speed;
    }

    public double get_flying_speed() {
        return _flying_speed;
    }

    public ItemStack get_skull() {
        return _skull;
    }
    //endregion

    //region Setter

    public CustomEntityModel set_skull(ItemStack _skull) {
        this._skull = _skull;
        return this;
    }

    public CustomEntityModel set_livingEntity(LivingEntity _livingEntity) {
        this._livingEntity = _livingEntity;
        update();
        return this;
    }

    public CustomEntityModel set_maxHealth(double _maxHealth) {
        this._maxHealth = _maxHealth;
        update();
        return this;
    }

    public CustomEntityModel set_health(double _health) {
        this._health = _health;
        update();
        return this;
    }

    public CustomEntityModel set_attack(double _attack) {
        this._attack = _attack;
        update();
        return this;
    }

    public CustomEntityModel set_armor(double _armor) {
        this._armor = _armor;
        update();
        return this;
    }

    public CustomEntityModel set_attack_knockback(double _attack_knockback) {
        this._attack_knockback = _attack_knockback;
        update();
        return this;
    }

    public CustomEntityModel set_attack_speed(double _attack_speed) {
        this._attack_speed = _attack_speed;
        update();
        return this;
    }

    public CustomEntityModel set_follow_range(double _follow_range) {
        this._follow_range = _follow_range;
        update();
        return this;
    }

    public CustomEntityModel set_luck(double _luck) {
        this._luck = _luck;
        update();
        return this;
    }

    public CustomEntityModel set_knockback_resistance(double _knockback_resistance) {
        this._knockback_resistance = _knockback_resistance;
        update();
        return this;
    }

    public CustomEntityModel set_mouvement_speed(double _mouvement_speed) {
        this._mouvement_speed = _mouvement_speed;
        update();
        return this;
    }

    public CustomEntityModel set_flying_speed(double _flying_speed) {
        this._flying_speed = _flying_speed;
        update();
        return this;
    }

    //endregion

    //region Update
    private void update(){

        setAttribute(Attribute.GENERIC_MAX_HEALTH, this._maxHealth);
        setAttribute(Attribute.GENERIC_ATTACK_DAMAGE,this._attack);
        setAttribute(Attribute.GENERIC_ARMOR, this._armor);
        setAttribute(Attribute.GENERIC_ATTACK_KNOCKBACK, this._attack_knockback);
        setAttribute(Attribute.GENERIC_ATTACK_SPEED, this._attack_speed);
        setAttribute(Attribute.GENERIC_FOLLOW_RANGE, this._follow_range);
        setAttribute(Attribute.GENERIC_LUCK, this._luck);
        setAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, this._knockback_resistance);
        setAttribute(Attribute.GENERIC_MOVEMENT_SPEED, this._mouvement_speed);
        setAttribute(Attribute.GENERIC_FLYING_SPEED, this._flying_speed);
    }

    private double getAttribute(Attribute attribute){
        return Objects.requireNonNull(this._livingEntity.getAttribute(attribute)).getBaseValue();
    }

    private void setAttribute(Attribute attribute, double value){
        Objects.requireNonNull(this._livingEntity.getAttribute(attribute)).setBaseValue(value);
    }
    //endregion
}
