package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DatabaseUtil {

    //region Build
    public DatabaseUtil(){
        boolean created = true;
        if (!NecroRunia.getPlugin().getDataFolder().exists()) {
            created = NecroRunia.getPlugin().getDataFolder().mkdir();
        }
        if(!created){throw new NullPointerException();}
    }
    //endregion

}
