package fr.skypieya.necrorunia.entity.player;

import fr.skypieya.necrorunia.NecroRunia;
import fr.skypieya.necrorunia.entity.soul.PlayerSoulMenuModel;
import fr.skypieya.necrorunia.entity.soul.SoulModel;
import fr.skypieya.necrorunia.storage.database.DatabaseManager;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerModel extends CraftPlayer {
    private final Player _player;
    private int _soulPercentLuck = 100;
    private PlayerSoulMenuModel _playerSoulMenuModel;
    public PlayerModel(Player player){
        super((CraftServer)NecroRunia.getPlugin().getServer(),(EntityPlayer) player);
        this._player = player;
        UUID uuid = player.getUniqueId();
        _playerSoulMenuModel = new PlayerSoulMenuModel(DatabaseManager.getINSTANCE()
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
