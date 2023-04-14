package com.example.colorchat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatColorListener implements Listener {
    private Main plugin;

    public ChatColorListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String color = plugin.getChatColor();
        ChatColor chatColor = ChatColor.valueOf(color);
        event.setMessage(chatColor + event.getMessage());
    }
}
