package com.tacz.guns.util;

import com.tacz.guns.init.ModItems;
import com.tacz.guns.util.ExplosiveRadialMenuItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.ArrayList;
import java.util.Objects;

public class ExplosiveRadialMenuItem {

    private final String name;
    private final Item item;
    private final ArrayList<ExplosiveRadialMenuItem> nestedMenuItems;

    public ExplosiveRadialMenuItem(String name, Item item){
        this(name, item, null);
    }

    public ExplosiveRadialMenuItem(String name, Item item, ArrayList<ExplosiveRadialMenuItem> nestedMenuItems){
        this.name = name;
        this.item = item;
        this.nestedMenuItems = nestedMenuItems;
    }

    @Override
    public String toString() {
        return name;
    }

    public Component getComponent(){
        return Component.translatable("gui.tacz.explosive_ammo." + name);
    }

    public ItemStack getItemToRender(){
        return new ItemStack(Objects.requireNonNullElse(this.item, Items.COBBLESTONE));
    }

    public boolean hasNestedMenu(){
        return nestedMenuItems != null && nestedMenuItems.size() > 0;
    }

    public ArrayList<ExplosiveRadialMenuItem> getNestedMenuItems(){
        return nestedMenuItems != null? nestedMenuItems : new ArrayList<ExplosiveRadialMenuItem>();
    }

    public static ExplosiveRadialMenuItem getExplosiveRadialMenuItemByName(ArrayList<ExplosiveRadialMenuItem> menu, String name){
        for(ExplosiveRadialMenuItem explosiveRadialMenuItem : menu){
            if(explosiveRadialMenuItem.name.equals(name)){
                return explosiveRadialMenuItem;
            }
        }
        return null;
    }


    public static final ExplosiveRadialMenuItem EXPLOSIVE_AMMO_RADIAL = new ExplosiveRadialMenuItem("explosive_ammo_radial", ModItems.MODERN_KINETIC_GUN.get());

    public static final ExplosiveRadialMenuItem NORMAL_AMMO_RADIAL = new ExplosiveRadialMenuItem("normal_ammo_radial", ModItems.MODERN_KINETIC_GUN.get());




    public static final ArrayList<ExplosiveRadialMenuItem> MAIN_MENU = new ArrayList<>(){
        {
           add(NORMAL_AMMO_RADIAL);
            add(EXPLOSIVE_AMMO_RADIAL);
//            add(HATCH);
//            add(DOOR);
//            add(DOOR_FRAME);
//            add(WINDOW_FRAME);
//            add(WINDOW);
        }
    };

    public static final ArrayList<ExplosiveRadialMenuItem> ALL_ITEMS = new ArrayList<>(){
        {
            add(NORMAL_AMMO_RADIAL);
            add(EXPLOSIVE_AMMO_RADIAL);

        }
    };
}
