package fr.skypieya.necrorunia.entity.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


import java.util.HashMap;

public final class PlayerManager {
    private final HashMap<Player, PlayerModel> _players = new HashMap<Player, PlayerModel>();
    private static PlayerManager INSTANCE;
    public PlayerManagerListener playerManagerListener = new PlayerManagerListener();

    public PlayerManager(){
        this.INSTANCE = this;
        for(Player player : Bukkit.getOnlinePlayers()){
            AddPlayerModel(player);
        }
    }

    public PlayerModel GetPlayerModel(Player player){
        return _players.get(player);
    }

    public void AddPlayerModel(Player player){
        _players.put(player, new PlayerModel(player));
    }

    public static PlayerManager getINSTANCE(){return INSTANCE;}
}

class PlayerManagerListener implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent e){
        PlayerManager.getINSTANCE().AddPlayerModel(e.getPlayer());
    }
}
