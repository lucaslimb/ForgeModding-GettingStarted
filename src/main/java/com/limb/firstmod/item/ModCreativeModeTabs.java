package com.limb.firstmod.item;

import com.limb.firstmod.FirstMod;
import com.limb.firstmod.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

        public static final RegistryObject<CreativeModeTab> LUQUITA_ITEMS_TAB = CREATIVE_MODE_TABS.register("luquita_items_tab",
                () -> CreativeModeTab.builder()
                        .icon(() -> new ItemStack(ModItems.LUQUITA.get()))
                        .title(Component.translatable("creativetab.firstmod.luquita_items"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept((ModItems.LUQUITA.get()));
                            output.accept((ModItems.RAW_LUQUITA.get()));
                        })
                        .build());

        public static final RegistryObject<CreativeModeTab> LUQUITA_BLOCKS_TAB = CREATIVE_MODE_TABS.register("luquita_blocks_tab",
                () -> CreativeModeTab.builder()
                        .withTabsBefore(LUQUITA_ITEMS_TAB.getId())
                        .icon(() -> new ItemStack(ModBlock.LUQUITA_BLOCK.get()))
                        .title(Component.translatable("creativetab.firstmod.luquita_blocks"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept((ModBlock.LUQUITA_BLOCK.get()));
                            output.accept((ModBlock.RAW_LUQUITA_BLOCK.get()));
                            output.accept((ModBlock.LUQUITA_ORE.get()));
                            output.accept((ModBlock.LUQUITA_DEEPSLATE_ORE.get()));

                        })
                        .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
