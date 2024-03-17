package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DatabaseModel {
    private final File _file;
    private final String _key;
    private String _value;
    public DatabaseModel(File file, String key, String value){
        this._file = file;
        this._key = key;
        this._value = value;
    }



    public File GetFile() {
        return _file;
    }
    public String GetKey() {
        return _key;
    }
    public String GetValue() {
        return _value;
    }
    public DatabaseModel SetValue(String value){
        if(!this._value.equalsIgnoreCase(value)){
            this._value = value;
            this.update();
        }
        return this;
    }

    public DatabaseModel Update(){
        this.update();
        return this;
    }

    public DatabaseModel Save(){
        this.update();
        return this;
    }

    public DatabaseModel Load(){
        YamlConfiguration config = YamlConfiguration.loadConfiguration(this._file);
        this._value = (String) config.get(NecroRunia.getPlugin().GetDatabaseManager().GetDataName() +  this._key);
        return this;
    }

    private void update(){
        YamlConfiguration config = YamlConfiguration.loadConfiguration(this._file);
        config.createSection("Data");
        config.set(NecroRunia.getPlugin().GetDatabaseManager().GetDataName() +  this._key,
                this._value);
        try {
            config.save(this._file);
        } catch (IOException e) {throw new RuntimeException(e);}
    }

}
