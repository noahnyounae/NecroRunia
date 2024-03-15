package fr.skypieya.necrorunia.models;

import fr.skypieya.necrorunia.NecroRunia;
import org.bukkit.entity.Player;

import java.util.Random;

public class PlayerModel {
    private final Player _player;
    private int _soulPercentLuck = 100;
    public PlayerModel(Player player){
        this._player = player;
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

    public void SetSoulLuck(int soulLuck) {
        soulLuck = Math.max(0,soulLuck);
        this._soulPercentLuck = soulLuck;
    }
}
