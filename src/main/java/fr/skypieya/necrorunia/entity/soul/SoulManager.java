package fr.skypieya.necrorunia.entity.soul;

import fr.skypieya.necrorunia.entity.player.PlayerModel;
import fr.skypieya.necrorunia.entity.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.ArrayList;
import java.util.List;

public final class SoulManager {
    private final float _soulDelayDeltaSec = 0.25f;
    private static SoulManager INSTANCE;
    public final SoulListener soulListener = new SoulListener();
    public final List<SoulModel> souls = new ArrayList<>();
    public SoulManager(){
        INSTANCE = this;
        for(World world: Bukkit.getWorlds()){
            for(Entity entity: world.getEntities()){
                if(entity instanceof LivingEntity){
                    LivingEntity livingEntity = (LivingEntity) entity;
                    if(livingEntity.getCustomName() != null){
                        if(livingEntity.getCustomName().equalsIgnoreCase(ChatColor.RED + "Soul")) {
                            livingEntity.remove();
                        }
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

    public SoulModel GetSoulModelFromLivingEntity(LivingEntity livingEntity){
        for(SoulModel soulModel : souls){
            if(soulModel.GetLivingEntity().equals(livingEntity)){
                return soulModel;
            }
        }
        return null;
    }
    public static SoulManager getINSTANCE(){return INSTANCE;}
}

class SoulListener implements Listener {
    @EventHandler
    public void onEntityDied(EntityDeathEvent e){
        LivingEntity dead = e.getEntity();
        if(dead.getLastDamageCause() != null) {
            if (dead.getLastDamageCause().getDamageSource().getCausingEntity() instanceof Player) {
                Player player = (Player) dead.getLastDamageCause().getDamageSource().getCausingEntity();
                SoulManager soulManager = SoulManager.getINSTANCE();
                soulManager.souls.add(new SoulModel(dead,
                        soulManager.GetSoulDelaySec(PlayerManager.getINSTANCE().GetPlayerModel(player))));
            }
        }
    }

    @EventHandler
    public  void onPlayerAtInteractEntity(PlayerInteractAtEntityEvent e){
        if(e.getRightClicked() instanceof LivingEntity){
            LivingEntity livingEntity = (LivingEntity) e.getRightClicked();
            SoulModel soulModel = SoulManager.getINSTANCE().GetSoulModelFromLivingEntity(livingEntity);
            if(soulModel != null){
                PlayerManager.getINSTANCE().GetPlayerModel(e.getPlayer())
                        .PlayerInteractWithSoul(soulModel);
            }

        }
    }
}
