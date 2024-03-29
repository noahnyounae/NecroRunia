package fr.skypieya.necrorunia.entity.soul;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.entity.CustomEntityModel;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class SoulModel {
    private final LivingEntity _livingEntity;
    private final CustomEntityModel _customEntityModel;
    private final int _receivePercentLuck = 100;

    public SoulModel(LivingEntity livingEntity, int delay){
        this._livingEntity = livingEntity;
        this._customEntityModel = new CustomEntityModel(livingEntity);
        livingEntityToSoul(delay);
        new SoulRunnable(_livingEntity).runTaskLater(NecroRunia.getPlugin(),delay * 20L);
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
        _livingEntity.setCustomName(ChatColor.RED + "Soul");
        _livingEntity.setCustomNameVisible(false);
    }

    public LivingEntity GetLivingEntity() {
        return _livingEntity;
    }
    public CustomEntityModel GetCustomEntityModel() {return _customEntityModel;}
    public int GetReceivePercentLuck() {return _receivePercentLuck;}
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