package com.dyrho.kitpvp.main;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Initializer {

    public Initializer() {
    }

    public void registerAll() {

    }

    private void registerListeners() {

    }

    private void registerCommands() {

    }

    private void registerListener(Listener listener) {
        KitPvP.getKitpvpPlugin().getServer().getPluginManager().registerEvents(listener, KitPvP.getKitpvpPlugin());
    }

    private void registerCommand(String command, CommandExecutor commandExecutor) {
        KitPvP.getKitpvpPlugin().getCommand(command).setExecutor(commandExecutor);
    }
}
