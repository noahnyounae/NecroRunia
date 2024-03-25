package fr.skypieya.necrorunia.inventory.item.skull;

import org.bukkit.entity.EntityType;

import java.util.HashMap;

public final class SkullManager {

    private final HashMap<EntityType, SkullEnum> _entitySkulls = new HashMap<>();
    private static SkullManager INSTANCE;
    public SkullManager() {
        INSTANCE = this;
        _entitySkulls.put(EntityType.ZOMBIE, SkullEnum.ZOMBIE);
        _entitySkulls.put(EntityType.CREEPER, SkullEnum.CREEPER);
        _entitySkulls.put(EntityType.SKELETON, SkullEnum.SKELETON);
    }

    public SkullModel GetHead(EntityType entityType){
        if(!_entitySkulls.containsKey(entityType)){return new SkullModel(SkullEnum.Default);}
        return new SkullModel(_entitySkulls.get(entityType));
    }

    public HashMap<EntityType, SkullEnum> GetEntitySkulls(){
        return _entitySkulls;
    }

    public static SkullManager getINSTANCE() {return INSTANCE;}
}
