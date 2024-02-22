package fr.skypieya.necrorunia.models;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.HashMap;

public class SkullModel {

    public HashMap<EntityType, String> MHFs = new HashMap<>();

    public SkullModel(){

    }

    private ItemStack createMobHead(EntityType entityType){
        ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = ((SkullMeta)itemStack.getItemMeta());
        ;
        PlayerProfile playerProfile = Bukkit.createPlayerProfile(MobHeadEnum(entityType));
        playerProfile.setTextures();
        skullMeta.setOwnerProfile(playerProfile);
    }

}