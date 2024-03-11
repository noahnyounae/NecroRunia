package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.Enum.ItemStackEnum;
import fr.skypieya.necrorunia.models.ItemStackModel;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ItemUtil {

    public ItemUtil(){}

    public ItemStack Get(ItemStackEnum itemStackEnum){
        return (itemStackEnum == ItemStackEnum.NecroStaff) ? itemNecroStaff(itemStackEnum)
        //: (itemStackEnum == ItemStackEnum.NecroStaff) ? itemNecroStaff()
        : Default();
    }

    private ItemStack Default(){
        return new ItemStackModel(new ItemStack(Material.STICK))
                .AddEnchant()
                .SetDisplayName("Default Item Stack")
                .SetLore(Arrays.asList("Default Item Stack",""))
                .SetUUID(ItemStackEnum.Default.Get_UUID())
                .eraser()
                .GetItemStack();
    }

    private ItemStack itemNecroStaff(ItemStackEnum itemStackEnum){
        return new ItemStackModel(new ItemStack(Material.STICK))
                .AddEnchant()
                .SetDisplayName("NecroStaff")
                .SetLore(Arrays.asList("","Un baton de nécromancien qui permet de rappeler une âme à lui",
                        "[Click droit sur la cible]"))
                .SetUUID(itemStackEnum.Get_UUID())
                .eraser()
                .GetItemStack();
    }
}