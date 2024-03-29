package fr.skypieya.necrorunia.inventory;

import fr.skypieya.necrorunia.entity.soul.PlayerSoulMenuModel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerSkullMenuUtil {
    public HashMap<UUID, PlayerSoulMenuModel> PlayerSkullMenuModels= new HashMap<>();

    public PlayerSkullMenuUtil(){}


}
class PlayerSkullMenuUtilListener implements Listener{
    private final PlayerSkullMenuUtil _playerSkullMenuUtil;

    public PlayerSkullMenuUtilListener(PlayerSkullMenuUtil playerSkullMenuUtil){
        this._playerSkullMenuUtil = playerSkullMenuUtil;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        UUID uuid = e.getPlayer().getUniqueId();
        if(!_playerSkullMenuUtil.PlayerSkullMenuModels.containsKey(uuid)){
            _playerSkullMenuUtil.PlayerSkullMenuModels.put(uuid,
                    new PlayerSoulMenuModel(54, e.getPlayer(), e.getPlayer().getName() + "'s Menu", uuid));
        }

    }
}
