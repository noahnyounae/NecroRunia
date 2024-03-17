package fr.skypieya.necrorunia.models;

import org.bukkit.inventory.InventoryHolder;

import java.io.IOException;
import java.util.UUID;

public class PlayerSoulMenuModel extends MenuModel {

    private final UUID _uuid;
    private final String _dataPath = "PlayerSkullMenu";

    public PlayerSoulMenuModel(int size, InventoryHolder holder, String title, UUID uuid) {
        super(size, holder, title);
        this._uuid = uuid;
    }

    public PlayerSoulMenuModel(String inventory64, UUID uuid) {
        super(9, null, "");
        this._uuid = uuid;
        try {
            this._inventory = fromBase64(inventory64);
        } catch (IOException e) {throw new RuntimeException(e);}
    }
}
