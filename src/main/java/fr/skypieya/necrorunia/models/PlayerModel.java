package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.managers.DatabaseManager;
import org.bukkit.entity.Player;

import java.util.Random;
import java.util.UUID;

public class PlayerModel {
    private final Player _player;
    private int _soulPercentLuck = 100;
    private PlayerSoulMenuModel _playerSoulMenuModel;
    public PlayerModel(Player player){
        this._player = player;
        UUID uuid = player.getUniqueId();
        _playerSoulMenuModel = new PlayerSoulMenuModel(NecroRunia.getPlugin().GetDatabaseManager()
                .Get("PlayerSkullMenu",
                    uuid.toString(), "Inventory").GetValue(),player.getUniqueId());
    }
    public Player GetPlayer() {
        return _player;
    }
    public int GetSoulLuck() {
        return _soulPercentLuck;
    }

    public int GetRandSoulLuck(){
        return NecroRunia.getPlugin().GetRandUtil().GetRandom().nextInt(0,_soulPercentLuck);
    }

    public PlayerModel PlayerInteractWithSoul(SoulModel soulModel){
        if(receiveSoul(soulModel)){
            //todo
        }
        return this;
    }

    private boolean receiveSoul(SoulModel soulModel){
        return GetRandSoulLuck() <= soulModel.GetReceivePercentLuck();
    }

    public void SetSoulLuck(int soulLuck) {
        soulLuck = Math.max(0,soulLuck);
        this._soulPercentLuck = soulLuck;
    }
}
