package fr.skypieya.necrorunia.inventory.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public final class ItemUtil {
    private static ItemUtil INSTANCE;
    public ItemUtil(){}

    public ItemStack Get(ItemEnum itemStackEnum){
        return (itemStackEnum == ItemEnum.NecroStaff) ? itemNecroStaff(itemStackEnum)
        //: (itemStackEnum == ItemStackEnum.NecroStaff) ? itemNecroStaff()
        : Default();
    }

    private ItemStack Default(){
        return new ItemStackModel(new ItemStack(Material.STICK))
                .AddEnchant()
                .SetDisplayName("Default Item Stack")
                .SetLore(Arrays.asList("Default Item Stack",""))
                .SetUUID(ItemEnum.Default.Get_UUID())
                .eraser()
                .GetItemStack();
    }

    private ItemStack itemNecroStaff(ItemEnum itemStackEnum){
        return new ItemStackModel(new ItemStack(Material.STICK))
                .AddEnchant()
                .SetDisplayName("NecroStaff")
                .SetLore(Arrays.asList("","Un baton de nécromancien qui permet de rappeler une âme à lui",
                        "[Click droit sur la cible]"))
                .SetUUID(itemStackEnum.Get_UUID())
                .eraser()
                .GetItemStack();
    }
    public static ItemUtil getINSTANCE(){return INSTANCE;}
}