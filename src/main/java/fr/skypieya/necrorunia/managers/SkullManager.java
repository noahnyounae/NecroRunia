package fr.skypieya.necrorunia.managers;

import fr.skypieya.necrorunia.Enum.SkullEnum;
import fr.skypieya.necrorunia.models.SkullModel;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SkullManager {

    private final HashMap<EntityType, SkullEnum> _entitySkulls = new HashMap<>();

    public SkullManager() {
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
}
