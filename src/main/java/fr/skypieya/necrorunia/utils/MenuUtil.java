package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.models.ItemStackModel;
import fr.skypieya.necrorunia.models.MenuModel;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class MenuUtil {
    public void Default(Player player){
        new MenuModel(18, null, "This is a Default Menu")
                .Add(new ItemStack(Material.DIRT))
                .Set(new ItemStack(Material.IRON_BLOCK), 12)
                .Set(new ItemStackModel(new ItemStack(Material.IRON_AXE))
                            .AddEnchant()
                            .SetLore(Arrays.asList("Cecil est un test", "XD"))
                            .GetItemStack()
                        , 17)
                .open(player);
    }

}
