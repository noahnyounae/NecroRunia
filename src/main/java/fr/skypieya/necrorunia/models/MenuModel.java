package fr.skypieya.necrorunia.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class MenuModel {

    //region Variables
    private final Inventory _inventory;

    //endregion

    //region Build
    public MenuModel(int size, InventoryHolder holder, String title){
        size = size - size % 9;
        size = Math.max(size, 9);
        size = Math.min(size, 53);

        title = title == null ? "Default" : title;

        this._inventory = Bukkit.createInventory(holder, size, title);
    }
    //endregion

    //region Add

    private void add(ItemStack itemStack){
        _inventory.addItem(itemStack);
    }
    public MenuModel Add(ItemStack itemStack){
        this.add(itemStack);
        return this;
    }

    public MenuModel Add(ItemStack[] itemStacks){
        for (ItemStack itemStack: itemStacks){
            this.add(itemStack);
        }
        return this;
    }

    private void set(ItemStack itemStack, int id){
        _inventory.setItem(id, itemStack);
    }

    public MenuModel Set(ItemStack itemStack, int id){
        this.set(itemStack, id);
        return this;
    }

    public MenuModel Set(HashMap<Integer, ItemStack> itemStacks){
        for (int id: itemStacks.keySet()){
            this.set(itemStacks.get(id), id);
        }
        return this;
    }

    //endregion

    //region Remove
    private void remove(ItemStack itemStack){
        _inventory.remove(itemStack);
    }
    private void remove(Material material){
        _inventory.remove(material);
    }
    private void remove(int id){_inventory.clear(id);}

    public MenuModel Remove(ItemStack itemStack){
        this.remove(itemStack);
        return this;
    }

    public MenuModel Remove(Material material){
        this.remove(material);
        return this;
    }

    public MenuModel Remove(ItemStack[] itemStacks){
        for(ItemStack itemStack: itemStacks){
            this.remove(itemStack);
        }
        return this;
    }

    public MenuModel Remove(Material[] materials){
        for(Material material: materials){
            this.remove(material);
        }
        return this;
    }

    public MenuModel Remove(int id){
        this.remove(id);
        return this;
    }

    public MenuModel Remove(int[] ids){
        for(int id: ids){
            this.remove(id);
        }
        return this;
    }

    //endregion

    //region Open
    public void open(Player player){
        player.openInventory(_inventory);
    }
    //endregion
}
