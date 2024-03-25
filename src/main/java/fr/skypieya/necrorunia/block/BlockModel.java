package fr.skypieya.necrorunia.block;

import net.minecraft.core.BlockPosition;
import net.minecraft.world.level.GeneratorAccess;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_20_R3.block.CraftBlock;

public class BlockModel extends CraftBlock {
    public BlockModel(World world, Location location) {
        super((GeneratorAccess) world,(BlockPosition) world.getBlockAt(location));
    }
}
