package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.inventory.InventoryHolder;

import java.io.IOException;
import java.util.UUID;

public class PlayerSkullMenuModel extends MenuModel {

    private final UUID _uuid;
    private final String _dataPath = "PlayerSkullMenu";

    public PlayerSkullMenuModel(int size, InventoryHolder holder, String title, UUID uuid) {
        super(size, holder, title);
        this._uuid = uuid;
    }

    public PlayerSkullMenuModel Load() throws IOException {
        Object object = new DatabaseModel().Read("",_dataPath,_uuid.toString());
        if(object == null){
            new DatabaseModel().Add("",_dataPath,_uuid.toString(), toBase64(this._inventory));
            object = new DatabaseModel().Read("",_dataPath,_uuid.toString());
        }
        this._inventory = fromBase64((String) object);
        return this;
    }
}
