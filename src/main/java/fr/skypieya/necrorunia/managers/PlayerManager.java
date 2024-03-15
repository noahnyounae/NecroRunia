package fr.skypieya.necrorunia.managers;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.models.PlayerModel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


import java.util.HashMap;

public class PlayerManager {
    private final HashMap<Player, PlayerModel> _players = new HashMap<Player, PlayerModel>();
    public PlayerManagerListener playerManagerListener = new PlayerManagerListener();

    public PlayerManager(){
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
}

class PlayerManagerListener implements Listener {
    @EventHandler
    public void onPlayerLogin(PlayerJoinEvent e){
        NecroRunia.getPlugin().GetPlayerManager().AddPlayerModel(e.getPlayer());
    }
}
