package fr.skypieya.necrorunia;

import fr.skypieya.necrorunia.inventory.MenuUtil;
import fr.skypieya.necrorunia.inventory.PlayerSkullMenuUtil;
import fr.skypieya.necrorunia.inventory.item.ItemEnum;
import fr.skypieya.necrorunia.inventory.item.ItemUtil;
import fr.skypieya.necrorunia.inventory.item.skull.SkullEnum;
import fr.skypieya.necrorunia.random.RandomUtil;
import fr.skypieya.necrorunia.storage.database.DatabaseManager;
import fr.skypieya.necrorunia.entity.player.PlayerManager;
import fr.skypieya.necrorunia.inventory.item.skull.SkullManager;
import fr.skypieya.necrorunia.entity.soul.SoulManager;
import fr.skypieya.necrorunia.inventory.item.ItemStackModel;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

///////////////////////////////////////////////////////////////////////////////////////
//Faire en sorte que le "NecroStaff" (ou autre) ait un stack size modulaire (avec les events)
//Ajouter les "menus d'âmes" (menu joueur liste necro...) persistant (json ?)

public final class NecroRunia extends JavaPlugin {

    private MenuUtil _menuUtil;
    private ItemUtil _itemUtil;
    private PlayerSkullMenuUtil _playerSkullMenuUtil;
    private RandomUtil _randomUtil;
    private static NecroRunia INSTANCE;

    @Override
    public void onEnable() {
        assignment();
        listeners();

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "==========================");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[NecroRunia] Load Complete");
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "==========================");
    }

    private void assignment(){
        INSTANCE = this;
        _menuUtil = new MenuUtil();
        _itemUtil = new ItemUtil();
        _playerSkullMenuUtil = new PlayerSkullMenuUtil();
        _randomUtil = new RandomUtil();
        new SoulManager();
        new PlayerManager();
        new DatabaseManager();
        new SkullManager();
    }

    private void listeners(){
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new TempListeners(), this);
        pluginManager.registerEvents(PlayerManager.getINSTANCE().playerManagerListener , this);
        pluginManager.registerEvents(SoulManager.getINSTANCE().soulListener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //region Get
    public MenuUtil GetMenuUtil(){
        return _menuUtil;
    }
    public ItemUtil GetItemUtil(){return  _itemUtil;}
    public PlayerSkullMenuUtil GetPlayerSkullMenuUtil(){return _playerSkullMenuUtil;}
    public RandomUtil GetRandUtil(){return _randomUtil;}
    public static NecroRunia getPlugin() {
        return INSTANCE;
    }
    //endregion
}

class TempListeners implements Listener {

    public TempListeners(){}

    @EventHandler
    public void OnPlayerInteract(PlayerInteractAtEntityEvent e){
        if(new ItemStackModel(e.getPlayer().getInventory().getItemInMainHand()).GetUUID().equals(ItemEnum.NecroStaff.Get_UUID())){
            ItemStack head = SkullManager.getINSTANCE().GetHead(e.getRightClicked().getType()).GetSkull();
            if(head != SkullEnum.Default.Get_ItemStack()){
                Location location = e.getRightClicked().getLocation();
                Objects.requireNonNull(location.getWorld()).dropItem(location, head);
                e.getRightClicked().remove();
            }
        }
    }
    @EventHandler
    public void OnPlayerCrouch(PlayerToggleSneakEvent e){
        e.getPlayer().getInventory().addItem(NecroRunia.getPlugin().GetItemUtil().Get(ItemEnum.NecroStaff));
        e.getPlayer().getInventory().addItem(new ItemStackModel(new ItemStack(Material.DIAMOND_SWORD))
                .AddEnchant(Enchantment.DAMAGE_ALL, 1000)
                .GetItemStack());
    }
}
