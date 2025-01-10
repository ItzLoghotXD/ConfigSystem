package me.itzloghotxd.configsystem;

import me.itzloghotxd.configsystem.config.ConfigType;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class test implements Listener {
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = ConfigSystem.getPlugin().getConfigManager().getConfig(ConfigType.SETTINGS);
        Player player = event.getPlayer();
        String message = ChatColor.translateAlternateColorCodes('&', config.getString("join-message", "Hello Player!"));

        player.sendMessage(message);
    }
}
