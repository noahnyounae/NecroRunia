package fr.skypieya.necrorunia.inventory.item.skull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum SkullEnum {
    ZOMBIE(new ItemStack(Material.ZOMBIE_HEAD)),
    CREEPER(new ItemStack(Material.CREEPER_HEAD)),
    SKELETON(new ItemStack(Material.SKELETON_SKULL)),
    Default(new ItemStack(Material.PLAYER_HEAD))
    ;

    private final ItemStack _itemStack;

    SkullEnum(ItemStack itemStack) {
        this._itemStack = itemStack;
    }

    public ItemStack Get_ItemStack(){
        return _itemStack;
    }
}
