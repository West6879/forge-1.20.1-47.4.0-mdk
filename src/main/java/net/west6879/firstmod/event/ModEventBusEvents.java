package net.west6879.firstmod.event;


import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.west6879.firstmod.FirstMod;
import net.west6879.firstmod.entity.ModEntities;
import net.west6879.firstmod.entity.custom.RhinoEntity;

@Mod.EventBusSubscriber(modid = FirstMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }

}
