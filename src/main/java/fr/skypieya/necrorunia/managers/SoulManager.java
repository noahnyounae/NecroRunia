package fr.skypieya.necrorunia.managers;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.models.PlayerModel;
import fr.skypieya.necrorunia.models.SoulModel;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.List;

public class SoulManager {
    private final float _soulDelayDeltaSec = 0.25f;
    public final SoulListener soulListener = new SoulListener();
    public final List<SoulModel> souls = new ArrayList<>();
    public SoulManager(){
        for(World world: Bukkit.getWorlds()){
            for(Entity entity: world.getEntities()){
                if(entity instanceof LivingEntity){
                    LivingEntity livingEntity = (LivingEntity) entity;
                    if(livingEntity.isGlowing() && livingEntity.isInvisible() && !livingEntity.hasAI()){
                        livingEntity.remove();
                    }
                }
            }
        }
    }

    public void onDisable(){
        for(SoulModel soulModel: souls){
            LivingEntity livingEntity = soulModel.GetLivingEntity();
            if(livingEntity != null){
                livingEntity.remove();
            }
        }
    }

    public int GetSoulDelaySec(PlayerModel playerModel){
        return Math.round(_soulDelayDeltaSec * playerModel.GetRandSoulLuck());
    }
}

class SoulListener implements Listener {
    @EventHandler
    public void onEntityDied(EntityDeathEvent e){
        LivingEntity dead = e.getEntity();
        if(dead.getLastDamageCause() != null) {
            if (dead.getLastDamageCause().getDamageSource().getCausingEntity() instanceof Player) {
                Player player = (Player) dead.getLastDamageCause().getDamageSource().getCausingEntity();
                SoulManager soulManager = NecroRunia.getPlugin().GetSoulManager();
                soulManager.souls.add(new SoulModel(dead,
                        soulManager.GetSoulDelaySec(NecroRunia.getPlugin().GetPlayerManager().GetPlayerModel(player))));
            }
        }
    }
}
