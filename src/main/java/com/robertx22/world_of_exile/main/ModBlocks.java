package com.robertx22.world_of_exile.main;

import com.robertx22.world_of_exile.blocks.RandomBlock;
import com.robertx22.world_of_exile.blocks.delay.DelayedBlock;
import com.robertx22.world_of_exile.blocks.delay.DelayedBlockEntity;
import com.robertx22.world_of_exile.blocks.final_treasure.FinalTreasureBlock;
import com.robertx22.world_of_exile.blocks.locked_treasure.LockedTreasureBlock;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.function.Supplier;

public class ModBlocks {

    public static ModBlocks INSTANCE;

    public DelayedBlock DELAY_BLOCK = of("delay", new DelayedBlock());
    public RandomBlock RANDOM_BLOCK = of("random_block", new RandomBlock());
    public FinalTreasureBlock FINAL_TREASURE_BLOCK = of("final_treasure", new FinalTreasureBlock());
    public LockedTreasureBlock LOCKED_TREASURE_BLOCK = of("locked_treasure", new LockedTreasureBlock());

    <T extends Block> T of(String id, T c) {
        Registry.register(Registry.BLOCK, WOE.id(id), c);
        return c;
    }

    public BlockEntityType<DelayedBlockEntity> DELAY_ENTITY = of(DELAY_BLOCK, DelayedBlockEntity::new);

    private <T extends BlockEntity> BlockEntityType<T> of(Block block, Supplier<BlockEntity> en) {
        BlockEntityType<T> type = (BlockEntityType<T>) BlockEntityType.Builder.create(en, block)
            .build(null);
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, Registry.BLOCK.getId(block)
            .toString(), type);
    }

    public ModBlocks() {

    }

}