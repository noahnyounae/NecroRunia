package fr.skypieya.necrorunia.models;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

public class CustomEntityModel {

    //region Variables
    private EntityType _entityType;
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
    private boolean _isUnkillable;
    private ItemStack _skull;
    private ItemStack _first_hand_itemStack;
    private ItemStack _second_hand_itemStack;
    private EntityEquipment _entityEquipement;
    //endregion

    //region Build
    public CustomEntityModel(EntityType entityType){
        this._entityType = entityType;
        this._livingEntity = Spawn(
                Bukkit.getWorlds().get(0),
                new Location(Bukkit.getWorlds().get(0), 0,0,0))
                .get_livingEntity();
        this._livingEntity.setInvulnerable(true);
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
        this._entityEquipement = this._livingEntity.getEquipment();
        this._livingEntity.setInvulnerable(false);
        this._livingEntity.damage(Double.MAX_VALUE);
    }
    //endregion

    //region Getter

    public boolean is_isUnkillable() {
        return _isUnkillable;
    }

    public LivingEntity get_livingEntity() {
        return _livingEntity;
    }

    public double get_maxhealth() {
        return _maxhealth;
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

    public ItemStack GetSecondHand(){
        return this._second_hand_itemStack;
    }

    public ItemStack GetFirstHand(){
        return this._first_hand_itemStack;
    }

    //endregion

    //region Setter

    public void set_isUnkillable(boolean _isUnkillable) {
        this._isUnkillable = _isUnkillable;
    }

    public CustomEntityModel set_livingEntity(LivingEntity _livingEntity) {
        this._livingEntity = _livingEntity;
        update();
        return this;
    }

    public CustomEntityModel set_maxhealth(double _maxhealth) {
        this._maxhealth = _maxhealth;
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

    public CustomEntityModel set_skull(ItemStack _skull) {
        this._skull = _skull;
        update();
        return this;
    }

    //endregion

    //region Update
    private void update(){
        if(_livingEntity == null) return;
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
        setFirstHand(this._first_hand_itemStack);
        setSecondHand(this._second_hand_itemStack);
    }

    private double getAttribute(Attribute attribute){
        return this._livingEntity.getAttribute(attribute).getBaseValue();
    }

    private void setAttribute(Attribute attribute, double value){
        this._livingEntity.getAttribute(attribute).setBaseValue(value);
    }

    //endregion

    //region Inventory
    public CustomEntityModel SetFirstHand(ItemStack itemStack){
        this._first_hand_itemStack = itemStack;
        update();
        return this;
    }

    public CustomEntityModel SetSecondHand(ItemStack itemStack){
        this._second_hand_itemStack = itemStack;
        update();
        return this;
    }

    private void setFirstHand(ItemStack itemStack){
        if(itemStack == null) return;
        this._livingEntity.getEquipment().setItemInMainHand(itemStack);
    }

    private void setSecondHand(ItemStack itemStack){
        if(itemStack == null) return;
        this._livingEntity.getEquipment().setItemInOffHand(itemStack);
    }

    private void set_entityEquipement(EntityEquipment entityEquipement){
        this._entityEquipement = entityEquipement;
        update();
    }
    //endregion

    //region Spawn
    public CustomEntityModel Spawn(World world, Location location){
        this._livingEntity = (LivingEntity) world.spawnEntity(location, this._entityType);
        update();
        return this;
    }
    //endregion
}
