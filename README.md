# ConfigSystem

A configuration system for Minecraft java plugins to make custom configuration files.

## Table of Contents

- [Introduction](#introduction)
- [Installation](#installation)
- [Usage](#usage)
    - [Configuration](#configuration)
        - [Code Examples](#code-examples)
- [Contribution](#contribution)
- [License](#license)
- [Thankyou](#thankyoudonations)

## Introduction

Welcome to the ConfigSystem Wiki! This project provides a configuration system for Minecraft Java plugins, allowing developers to create custom configuration files with ease. The system is designed to be flexible and user-friendly, making it simple to manage configuration settings for your Minecraft plugins.

## Installation

To use the ConfigSystem in your Minecraft plugin, you will need to include its files in your plugin. Follow the steps below to get started:
1. Firstly download the latest version of the codes from [here](https://github.com/ItzLoghotXD/ConfigSystem/releases/latest).
2. Then extract the `.zip` file.
3. And make a package `config` then:
   * make three files `ConfigType.java`, `ConfigHandler.java`, and `ConfigManager.java`
4. Then copy the content of the extracted file(s) and put the content in the respected file(s) and replace the [MainClassName] placeholder in `ConfigManager.java`, as shown in this video.<br>
![file_video](https://raw.githubusercontent.com/ItzLoghotXD/ConfigSystem/main/assets/file_video.mkv)

## Usage

The ConfigSystem is designed to be easy to use. Below are examples of how to create, read, and write configuration files. Your specific use-case might not yet be covered by in this readme file, so make sure to explore the [WIKI](https://github.com/ItzLoghotXD/ConfigSystem/wiki) and [Javadoc](https://itzloghotxd.github.io/ConfigSystem/javadoc), or ask your IDE for suggestions!

### Configuration

To create a basic configuration file, follow these steps:
1. Import the `configManager.java` class to the `main` class.
2. Then make a `singleton instance` of the `main` class and `ConfigMandger.java` class.
3. And then make a getter for the instance.

#### Code Examples

Code Example:

```java
// Example main class
package me.itzloghotxd.configsystem;

import junit.framework.TestListener;
import me.itzloghotxd.configsystem.config.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ConfigSystem extends JavaPlugin {

    // Declare a static instance of the class
    private static ConfigSystem plugin;
    // Declare an instance of the ConfigManager class
    private ConfigManager configManager;

    public void onEnable() {
        // Initialize the instance in onEnable
        plugin = this;
        configManager = new ConfigManager();

        // Register the event listener
        getServer().getPluginManager().registerEvents(new Test(), this);

    }

    public void onDisable() {
    }

    public void onReload() {
        // Example reload function
        configManager.reloadFiles();
    }

    // Provide a public method to access the instance
    public static ConfigSystem getPlugin() {
        return plugin;
    }

    // Provide a public method to access the instance
    public ConfigManager getConfigManager() {
        return configManager;
    }
}
```
All done now u can use this system to get data from your custom configuration file.

An example class which uses this system.<br>
Code Example:
```java
package me.itzloghotxd.configsystem;

import me.itzloghotxd.configsystem.config.ConfigType;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class test implements Listener {
    public void onPlayerJoin(PlayerJoinEvent event) {
        // By this we can use FileConfiguration's methods.
        FileConfiguration config = ConfigSystem.getPlugin().getConfigManager().getConfig(ConfigType.SETTINGS);
        Player player = event.getPlayer();
        // getting string from path "join-message" from config.yml
        String message = ChatColor.translateAlternateColorCodes('&', config.getString("join-message", "Hello Player!"));

        player.sendMessage(message);
    }
}
```

Example `config.yml` file
```yaml
# you will need to install placeholder api to replace %player% variable
join-message: "&aHello %player%!, Welcome to my Server"
```

## Contribution

We welcome contributions from the community! If you'd like to contribute to the ConfigSystem project, please follow the guidelines below:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Make your changes and commit them with a clear message.
4. Push your changes to your fork.
5. Create a pull request with a description of your changes.

Please ensure that your code follows the project's coding standards and includes appropriate tests.

## License

The ConfigSystem project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

# Thankyou/Donations

Thank you for using `GameMenu`! If you have any questions or need support, please open an issue on the [GitHub repository](https://github.com/ItzLoghotXD/GameMenu/issues).

I work on this Project with the little amount of free time that I have. Please feel free to donate via Crypto any amount you desire to show your support, and help me stay motivated to keep this project going. Thank You!<br>
* Bitcoin (BTC) Address: bc1qgarxwpp4rn3y5h8hwmhc6a5cpwzqqu3p5pun07
* Litecoin (LTC) Address: LaHYbGK3ysnGQyC8PNmrFkZu3xvDfFQg14
* Ethereum (ETH) Address: 0xE842deFED402339F77637e95cD09d7b3820630ac
* Solana (SOL) Address: HcXwLbebt7mvjc69we8jnQtBGSAcB9U5rnbAMQeRAdSD
* Dogecoin (DOGE) Address: DKgToq8vnBHTgik3iQnm3r3r4mnqvXy4Um

