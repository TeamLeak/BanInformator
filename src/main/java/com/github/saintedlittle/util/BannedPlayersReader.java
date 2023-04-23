package com.github.saintedlittle.util;

import lombok.SneakyThrows;
import lombok.var;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.FileReader;

public final class BannedPlayersReader {

    @SneakyThrows
    public static String readBannedPlayers() {
        var file = Bukkit.getServer().getWorldContainer();

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
        }

        br.close();

        return sb.toString();
    }

}
