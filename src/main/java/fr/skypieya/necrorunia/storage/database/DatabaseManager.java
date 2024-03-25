package fr.skypieya.necrorunia.storage.database;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class DatabaseManager {

    private final String _dataName = "Data.";
    public HashMap<UUID, DatabaseModel> DatabaseModels = new HashMap<>();
    private static DatabaseManager INSTANCE;

    public DatabaseManager(){
        INSTANCE = this;
    }

    //region Database Fonctions
    public void Save(DatabaseModel databaseModel) {
        File f = databaseModel.GetFile();
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.createSection("Data");
        config.set(_dataName + databaseModel.GetKey(), databaseModel.GetValue());
        try {
            config.save(f);
        } catch (IOException e) {throw new RuntimeException(e);}
    }

    public DatabaseModel Get(String path, String name, String key){
        DatabaseModel databaseModel =  new DatabaseModel(getFile(path.split("/"),name),key,null);
        databaseModel.Load();
        load(databaseModel);
        return databaseModel;
    }

    public UUID Load(String path, String name, String key, String value){
        DatabaseModel databaseModel =  new DatabaseModel(getFile(path.split("/"),name),key, value);
        return load(databaseModel);
    }

    private UUID load(DatabaseModel databaseModel){
        UUID uuid = UUID.randomUUID();
        if(!DatabaseModels.containsValue(databaseModel)){
            while(DatabaseModels.containsKey(uuid)){
                uuid = UUID.randomUUID();
            }
            DatabaseModels.put(uuid,databaseModel);
        }
        return uuid;
    }
    //endregion

    public DatabaseModel GetDatabaseModel(UUID uuid){
        return DatabaseModels.get(uuid);
    }

    public UUID GetUUIDFromDatabaseModel(DatabaseModel databaseModel){
        for(UUID uuid : DatabaseModels.keySet()){
            if(DatabaseModels.get(uuid).equals(databaseModel)){
                return uuid;
            }
        }
        return load(databaseModel);
    }

    //region Config
    private File getFile(String[] paths, String name){
        StringBuilder filePath = new StringBuilder(NecroRunia.getPlugin().getDataFolder().getPath() + File.separator);
        for(String path : paths){
            if(!path.equalsIgnoreCase("")){
                filePath.append(path).append(File.separator);
            }
        }
        return new File(filePath.toString(), name + ".yml");
    }
    //endregion

    public String GetDataName(){return _dataName;}
    public static DatabaseManager getINSTANCE(){return INSTANCE;}
}
