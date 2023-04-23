package com.github.saintedlittle.commands;

import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import static com.github.saintedlittle.json.Converter.toJsonString;
import static com.github.saintedlittle.util.JsonMemory.bannedPlayers;
import static java.lang.String.format;

public final class InformationCommand implements CommandExecutor {

    @SneakyThrows
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length > 1)
            sender.sendMessage(createMessage(UUID.fromString(args[0])));
        else {
            sender.sendMessage(toJsonString(bannedPlayers.get()));
        }
        return true;
    }

    private static String createMessage(UUID uuid) {
        AtomicReference<String> result = new AtomicReference<>(ChatColor.RED + "" + ChatColor.BOLD + "NOT FOUND!");
        bannedPlayers.get().forEach(e -> {
            if (e.getUuid().equals(uuid)) {
                result.set(format("USERNAME: %s; UUID: %s; REASON: %s; CREATED: %s; EXPIRES: %s",
                        e.getSource(), e.getUuid(), e.getReason(), e.getCreated(), e.getExpires()
                ));
            }
        });

        return result.get();
    }
}
