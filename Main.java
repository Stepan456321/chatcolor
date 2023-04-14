package com.example.colorchat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getLogger().info("Плагин ColorChat был запущен!");
        saveDefaultConfig();
        config = getConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Плагин ColorChat был остановлен!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatcolor")) {
            if (args.length == 1) {
                String color = args[0].toUpperCase();
                if (ChatColor.valueOf(color) != null) {
                    config.set("chat-color", color);
                    saveConfig();
                    sender.sendMessage(ChatColor.GREEN + "Цвет чата был изменён на " + color);
                } else {
                    sender.sendMessage(ChatColor.RED + "Неверный цвет!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Использование: /chatcolor [цвет]");
            }
            return true;
        } else if (cmd.getName().equalsIgnoreCase("reload") && sender.hasPermission("colorchat.reload")) {
            reloadConfig();
            config = getConfig();
            sender.sendMessage(ChatColor.GREEN + "Конфиг перезагружен !");
            return true;
        }
        return false;
    }

    public String getChatColor() {
        return config.getString("chat-color", "WHITE");
    }
}
```
