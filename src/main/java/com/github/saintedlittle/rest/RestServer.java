package com.github.saintedlittle.rest;

import com.github.saintedlittle.configuration.Configuration;
import com.github.saintedlittle.util.JsonMemory;
import io.javalin.Javalin;

public final class RestServer {

    private final int REST_PORT = Configuration.restModule.get().REST_PORT.get();

    public void start() {
        Javalin app = Javalin.create().start(REST_PORT);

        app.get("/banlist", ctx -> ctx.json(JsonMemory.bannedPlayers.get()));
        app.get("/", ctx -> ctx.result("Yes, this is the API homepage for the banlist."));

        System.out.printf("[BanInformator] REST started on %d!", REST_PORT);
    }

}
