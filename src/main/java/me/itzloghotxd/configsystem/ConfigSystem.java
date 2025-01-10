package me.itzloghotxd.configsystem;

import me.itzloghotxd.configsystem.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigSystem extends JavaPlugin {

    private static ConfigSystem plugin;
    private ConfigManager configManager;

    public void onEnable() {
        plugin = this;
        configManager = new ConfigManager();
        configManager.loadFiles(this);
        getServer().getPluginManager().registerEvents(new test(), this);
    }

    public void onDisable() {
    }

    public void onReload() {
        configManager.reloadFiles();
    }

    public static ConfigSystem getPlugin() {
        return plugin;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
