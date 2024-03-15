package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.utils.DatabaseUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DatabaseModel {

    public DatabaseModel(){}

    //region ARRU
    //Database : Add, Remove, Read, Update
    public DatabaseModel Add(String path, String name, String key, String value){
        YamlConfiguration config = getConfig(path, name);
        config.set(key, value);
        return this;
    }

    public DatabaseModel Remove(String path, String name,String key){
        YamlConfiguration config = getConfig(path, name);
        config.set(key, null);
        return this;
    }

    public Object Read(String path, String name,String key){
        YamlConfiguration config = getConfig(path, name);
        return config.get(key);
    }

    public DatabaseModel Update(String path, String name,String key, String value){
        YamlConfiguration config = getConfig(path, name);
        config.set(key, value);
        return this;
    }
    //endregion

    //region Config
    private YamlConfiguration getConfig(String path, String name){
        int i = 0;
        String filePath = "";
        String[] files = (NecroRunia.getPlugin().getDataFolder().getName() + "/" + path).split("/");
        boolean created = true;

        while(i < files.length - 1){

            File file = new File(filePath + files[i]);
            if(!file.exists()){
                created = file.mkdir();
            }

            if(!created){throw new NullPointerException();}

            filePath = file.getPath() + file.getName() + "/";
            i+=1;
        }

        File file = new File(filePath, name + ".yml");
        if(!file.exists()){
            try {
                created = file.createNewFile();
            }catch (IOException e){
                Bukkit.getServer().getLogger().severe(
                        ChatColor.RED + "Could not create " + filePath + file.getName() +".yml!");
            }
            if(!created){Bukkit.getServer().getLogger().severe(
                    ChatColor.RED + "Could not create " + filePath + file.getName() +".yml!");}
        }

        return YamlConfiguration.loadConfiguration(file);
    }
    //endregion
}
