package fr.skypieya.necrorunia.models;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ItemStackModel {


    //region Variables
    private final ItemStack _itemStack;
    //endregion

    //region Build
    public ItemStackModel(ItemStack itemStack){
        _itemStack = itemStack;
    }
    //endregion

    //region modules

    public ItemStackModel AddEnchant(){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addEnchant(Enchantment.ARROW_DAMAGE,1, true);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel AddEnchant(Enchantment enchantment, int power){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addEnchant(enchantment,power, true);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel AddEnchant(Enchantment enchantment, int power, boolean hide){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addEnchant(enchantment,power,hide);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel SetDisplayName(String displayName){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(displayName);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel SetUnbreakable(boolean unbreakable){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setUnbreakable(unbreakable);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel SetLore(List<String> stringList){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setLore(stringList);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel AddItemFlags(ItemFlag... itemFlags){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.addItemFlags(itemFlags);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackModel SetUUID(UUID uuid){
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        List<String> lore = itemMeta.getLore();
        assert lore != null;
        lore.add(uuid.toString());
        itemMeta.setLore(lore);
        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    //endregion

    //region Get
    public ItemStack GetItemStack(){
        return _itemStack;
    }

    public UUID GetUUID() {
        ItemMeta itemMeta = _itemStack.getItemMeta();
        assert itemMeta != null;
        List<String> lore = itemMeta.getLore();
        assert lore != null;
        return UUID.fromString(lore.get(lore.size() - 1));
    }
    //endregion

    //region Eraser
    public ItemStackModel eraser(){
        ItemMeta itemMeta = _itemStack.getItemMeta();

        assert itemMeta != null;
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_DYE);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ARMOR_TRIM);

        _itemStack.setItemMeta(itemMeta);
        return this;
    }

    //endregion
}
