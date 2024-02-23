package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.models.CustomEntityModel;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class CustomEntityUtil {
    public CustomEntityModel Default(){
        new CustomEntityModel(EntityType.ZOMBIE)
                .set_armor(50f)
                .set_attack(.5f)
                ;
    }
}
