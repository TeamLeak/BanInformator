package com.github.saintedlittle.listeners;

import com.github.saintedlittle.util.JsonMemory;
import lombok.var;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class BanListener implements Listener {

    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerBan(PlayerQuitEvent event) {
        var player = event.getPlayer();

        if (player.isBanned()) {
            executor.submit(JsonMemory::updateBannedPlayers);
        }
    }

    public static void shutdown() {
        executor.shutdown();
    }

}
