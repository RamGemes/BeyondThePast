package net.ramgames.btp.blocks.custom;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.ramgames.btp.BeyondThePast;
import net.ramgames.btp.blocks.ModBlocks;

public class BuddingBlock extends Block {

    private final Block[] clusterStages;
    public BuddingBlock(Settings settings, Block... clusterStages) {
        super(settings);
        this.clusterStages = clusterStages;
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if(random.nextInt(5) != 0) return;
        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        for(int i = clusterStages.length-2; i >= 0; i--) if(blockState.getBlock().equals(clusterStages[i])) if(blockState.get(Properties.FACING).equals(direction)) world.setBlockState(blockPos, clusterStages[i+1].getDefaultState().with(AmethystClusterBlock.FACING, direction));
        if(blockState.getBlock().equals(Blocks.AIR)) world.setBlockState(blockPos, clusterStages[0].getDefaultState().with(AmethystClusterBlock.FACING, direction));
        if(blockState.getBlock().equals(Blocks.WATER)) world.setBlockState(blockPos, clusterStages[0].getDefaultState().with(AmethystClusterBlock.FACING, direction).with(Properties.WATERLOGGED, true));
        super.randomTick(state, world, pos, random);
    }
}
