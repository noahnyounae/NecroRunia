package fr.skypieya.necrorunia;

import fr.skypieya.necrorunia.Enum.ItemStackEnum;
import fr.skypieya.necrorunia.Enum.SkullEnum;
import fr.skypieya.necrorunia.managers.DatabaseManager;
import fr.skypieya.necrorunia.managers.PlayerManager;
import fr.skypieya.necrorunia.managers.SkullManager;
import fr.skypieya.necrorunia.managers.SoulManager;
import fr.skypieya.necrorunia.models.ItemStackModel;
import fr.skypieya.necrorunia.utils.*;
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
import java.util.UUID;


///////////////////////////////////////////////////////////////////////////////////////
//Faire en sorte que le "NecroStaff" (ou autre) ait un stack size modulaire (avec les events)
//Ajouter les "menus d'âmes" (menu joueur liste necro...) persistant (json ?)

public final class NecroRunia extends JavaPlugin {

    private MenuUtil _menuUtil;
    private ItemUtil _itemUtil;
    private PlayerSkullMenuUtil _playerSkullMenuUtil;
    private RandomUtil _randomUtil;
    private SoulManager _soulManager;
    private PlayerManager _playerManager;
    private DatabaseManager _databaseManager;
    private SkullManager _skullManager;
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
        _soulManager = new SoulManager();
        _playerManager = new PlayerManager();
        _databaseManager = new DatabaseManager();
        _skullManager = new SkullManager();
    }

    private void listeners(){
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new TempListeners(), this);
        pluginManager.registerEvents(_playerManager.playerManagerListener , this);
        pluginManager.registerEvents(_soulManager.soulListener, this);
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
    public SkullManager GetSkullManager(){return  _skullManager;}
    public PlayerSkullMenuUtil GetPlayerSkullMenuUtil(){return _playerSkullMenuUtil;}
    public RandomUtil GetRandUtil(){return _randomUtil;}
    public SoulManager GetSoulManager(){return _soulManager;}
    public PlayerManager GetPlayerManager(){return _playerManager;}
    public DatabaseManager GetDatabaseManager(){return _databaseManager;}
    public static NecroRunia getPlugin() {
        return INSTANCE;
    }
    //endregion
}

class TempListeners implements Listener {

    public TempListeners(){}

    @EventHandler
    public void OnPlayerInteract(PlayerInteractAtEntityEvent e){
        if(new ItemStackModel(e.getPlayer().getInventory().getItemInMainHand()).GetUUID().equals(ItemStackEnum.NecroStaff.Get_UUID())){
            ItemStack head = NecroRunia.getPlugin().GetSkullManager().GetHead(e.getRightClicked().getType()).GetSkull();
            if(head != SkullEnum.Default.Get_ItemStack()){
                Location location = e.getRightClicked().getLocation();
                Objects.requireNonNull(location.getWorld()).dropItem(location, head);
                e.getRightClicked().remove();
            }
        }
    }
    @EventHandler
    public void OnPlayerCrouch(PlayerToggleSneakEvent e){
        e.getPlayer().getInventory().addItem(NecroRunia.getPlugin().GetItemUtil().Get(ItemStackEnum.NecroStaff));
        e.getPlayer().getInventory().addItem(new ItemStackModel(new ItemStack(Material.DIAMOND_SWORD))
                .AddEnchant(Enchantment.DAMAGE_ALL, 1000)
                .GetItemStack());
    }
}
