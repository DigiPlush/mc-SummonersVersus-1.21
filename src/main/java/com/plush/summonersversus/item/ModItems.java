package com.plush.summonersversus.item;

import com.plush.summonersversus.SummonersVersus;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SummonersVersus.MODID);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
