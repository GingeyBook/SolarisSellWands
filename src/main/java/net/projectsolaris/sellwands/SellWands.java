package net.projectsolaris.sellwands;


import org.bukkit.plugin.java.JavaPlugin;

public final class SellWands extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Enabling SolarisSellWands by GingeyBook...");
        this.getCommand("hoe").setExecutor(new giveHoe());

    }

    @Override
    public void onDisable() {
    }
}
