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
    public SkullModel(){}

    public ItemStack createMobHead(SkullEnum skullEnum){
        ItemStack itemStack = skullEnum.Get_ItemStack();
        if(itemStack != null){
            return itemStack;
        }
        return new ItemStack(Material.PLAYER_HEAD);
    }
}
