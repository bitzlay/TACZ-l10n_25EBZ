package com.tacz.guns.client.handler;


import com.tacz.guns.GunMod;
import com.tacz.guns.client.ExplosiveRadialMenu;
import com.tacz.guns.client.RadialKeybindings;
import com.tacz.guns.util.ExplosiveRadialMenuItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {
    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event){
        Minecraft minecraft = Minecraft.getInstance();


                 if(RadialKeybindings.INSTANCE.guiKey.consumeClick() && minecraft.player != null){
                     ItemStack itemStack = minecraft.player.getItemInHand(InteractionHand.MAIN_HAND);
                    if(itemStack.getItem() instanceof ModernKineticGunItem){
                        Minecraft.getInstance().setScreen(new ExplosiveRadialMenu(ExplosiveRadialMenuItem.MAIN_MENU));
                    }
        }
    }}
       /* else if(Keybindings.INSTANCE.guiKey.consumeClick() && minecraft.player != null){
            ItemStack itemStack = minecraft.player.getItemInHand(InteractionHand.MAIN_HAND);
            if(itemStack.getItem() instanceof ModernKineticGunItem){
                Minecraft.getInstance().setScreen(new RadialReloadMenu(RadialMenuItem.MAIN_MENU));
    }
}}}*/
