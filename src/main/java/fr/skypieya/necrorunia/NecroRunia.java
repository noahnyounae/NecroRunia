package fr.skypieya.necrorunia;

import fr.skypieya.necrorunia.utils.MenuUtil;
import org.bukkit.plugin.java.JavaPlugin;


public final class NecroRunia extends JavaPlugin {

    private MenuUtil _menuUtil;
    private static NecroRunia INSTANCE;

    @Override
    public void onEnable() {
        assignment();

    }

    private void assignment(){
        INSTANCE = this;
        _menuUtil = new MenuUtil();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    //region Get
    public MenuUtil GetMenuUtil(){
        return _menuUtil;
    }

    public static NecroRunia getPlugin() {
        return INSTANCE;
    }
    //endregion
}
