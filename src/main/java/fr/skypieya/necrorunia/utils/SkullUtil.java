package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.Enum.SkullEnum;
import fr.skypieya.necrorunia.models.SkullModel;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SkullUtil {
    private final HashMap<EntityType, SkullEnum> _entitySkull = new HashMap<>();

    public SkullUtil() {
        _entitySkull.put(EntityType.ZOMBIE, SkullEnum.ZOMBIE);
        _entitySkull.put(EntityType.CREEPER, SkullEnum.CREEPER);
        _entitySkull.put(EntityType.SKELETON, SkullEnum.SKELETON);

    }

    public ItemStack GetHead(EntityType entityType){

        if(!_entitySkull.containsKey(entityType)){return new ItemStack(Material.PLAYER_HEAD);}

        return new SkullModel().createMobHead(_entitySkull.get(entityType));
    }

    public HashMap<EntityType, SkullEnum> GetEntitySkull(){
        return _entitySkull;
    }
}
