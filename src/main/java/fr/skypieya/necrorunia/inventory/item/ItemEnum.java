package fr.skypieya.necrorunia.inventory.item;

import java.util.UUID;

public enum ItemEnum {
    NecroStaff(UUID.fromString("f261049e-1bae-4d69-b505-eb285c5ec202")),
    Default(UUID.fromString("ab86962a-c3ab-436d-8598-05b8269b4d30")),
    ;

    private final UUID _uuid;

    ItemEnum(UUID uuid) {
        this._uuid = uuid;
    }

    public UUID Get_UUID(){
        return _uuid;
    }
}
