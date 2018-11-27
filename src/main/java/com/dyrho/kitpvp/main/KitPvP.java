package com.dyrho.kitpvp.main;

import com.dyrho.core.main.Core;
import org.bukkit.plugin.java.JavaPlugin;

public class KitPvP extends JavaPlugin {

    private static KitPvP kitpvpPlugin;
    public static KitPvP getKitpvpPlugin() {return kitpvpPlugin;}

    private static Initializer initializer;
    public static Initializer getInitializer() {return initializer;}

    @Override
    public void onEnable() {
        //announce that kitpvp is starting up
        Core.getKitpvpLogger().info("KitPvP plugin is starting up...");

        //create variable
        kitpvpPlugin = this;

        //initialize
        initializer = new Initializer();
        initializer.registerAll();

        //setting up language manager to load kitpvp language
        Core.getLanguageManager().loadDifferentServer("kitpvp");
    }

    @Override
    public void onDisable() {
    }
}
