package fr.skypieya.necrorunia.entity;

import fr.skypieya.necrorunia.NecroRunia;
import net.minecraft.world.entity.EntityLiving;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;

public class CustomEntityModel extends CraftLivingEntity {
    public CustomEntityModel(LivingEntity entity) {
        super((CraftServer) NecroRunia.getPlugin().getServer(),(EntityLiving) entity);
    }

}
