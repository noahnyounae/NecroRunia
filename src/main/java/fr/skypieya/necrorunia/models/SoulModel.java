package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class SoulModel {
    private final LivingEntity _livingEntity;

    public SoulModel(LivingEntity livingEntity, int delay){
        this._livingEntity = livingEntity;
        livingEntityToSoul(delay);
        new SoulRunnable(_livingEntity).runTaskLater(NecroRunia.getPlugin(),delay * 20L);
        Bukkit.broadcastMessage(delay + "");
    }

    private void livingEntityToSoul(int delay){
        _livingEntity.setHealth(_livingEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
        _livingEntity.setAI(false);
        _livingEntity.setGlowing(true);
        _livingEntity.setInvisible(true);
        _livingEntity.setCollidable(false);
        _livingEntity.setCanPickupItems(false);
        _livingEntity.addPotionEffect(new PotionEffect(
                PotionEffectType.FIRE_RESISTANCE,delay,100,true,true));
    }

    public LivingEntity GetLivingEntity() {
        return _livingEntity;
    }
}
class SoulRunnable extends BukkitRunnable{
    private final LivingEntity _livingEntity;
    public SoulRunnable(LivingEntity livingEntity){
        _livingEntity = livingEntity;
    }

    @Override
    public void run() {
        if(_livingEntity != null){
            _livingEntity.remove();
        }
    }
}