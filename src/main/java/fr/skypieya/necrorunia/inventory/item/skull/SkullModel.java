package fr.skypieya.necrorunia.inventory.item.skull;

import fr.skypieya.necrorunia.inventory.item.skull.SkullEnum;
import org.bukkit.inventory.ItemStack;

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
