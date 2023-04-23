package com.github.saintedlittle.util;

import com.github.saintedlittle.json.Converter;
import com.github.saintedlittle.json.model.BannedPlayers;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class JsonMemory {

    public static final AtomicReference<List<BannedPlayers>> bannedPlayers = new AtomicReference<>();

    @SneakyThrows
    public static void loadBannedPlayers() {
        bannedPlayers.set(Converter.loadBannedPlayers());
    }

    @SneakyThrows
    public static void updateBannedPlayers() {
        Converter.loadBannedPlayers().stream().filter(player -> !bannedPlayers.get().contains(player)).forEach(player -> bannedPlayers.get().add(player));

    }
}
