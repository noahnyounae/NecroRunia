package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.Enum.SkullEnum;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.HashMap;

public class SkullModel {
    private final ItemStack _itemStack;
    public SkullModel(SkullEnum skullEnum){
        ItemStack itemStack = skullEnum.Get_ItemStack();
        _itemStack = (itemStack == null)
            ? SkullEnum.Default.Get_ItemStack()
                : itemStack;
    }

    public ItemStack GetSkull(){return _itemStack;}
    public ItemStack GetItemStack(){return _itemStack;}
}
