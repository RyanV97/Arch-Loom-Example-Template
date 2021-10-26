package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ExampleMod.MODID)
public class ExampleMod {

    //Change this MODID variable to whatever you like to uniquely identify your mod.
    //Make sure you also change this in your mods.toml file to match, otherwise your mod will not load.
    public static final String MODID = "examplemod";
    public static final Logger LOGGER = LogManager.getLogger();

    public ExampleMod() {

        // This is our mod's event bus, used for things like registry or lifecycle events
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();
        MOD_BUS.addListener(this::commonSetup);
        MOD_BUS.addListener(this::clientSetup);

        // Most other events are fired on Forge's bus.
        // Whichever class/instance of an object we pass into this register method
        // will be registered to the event bus and receive events, as shown in the kaboom example below.
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
        LOGGER.info("Look, I found a {}!", Items.DIAMOND.getRegistryName());
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("This is client setup, which is like common setup, but for the client!");
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    //An Example of receiving an event.
    //Whichever event is used as the argument for this method, is which event it will be "subscribed" to.
    @SubscribeEvent
    public void kaboom(ExplosionEvent.Detonate event) {
        LOGGER.info("Kaboom! Something just blew up in {}!", event.getWorld());
    }
}
