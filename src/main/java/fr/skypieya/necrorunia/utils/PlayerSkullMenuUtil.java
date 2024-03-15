package fr.skypieya.necrorunia.utils;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.models.PlayerSkullMenuModel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class PlayerSkullMenuUtil {
    public HashMap<UUID, PlayerSkullMenuModel> PlayerSkullMenuModels= new HashMap<>();

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
                    new PlayerSkullMenuModel(54, e.getPlayer(), e.getPlayer().getName() + "'s Menu", uuid));
        }

    }
}
