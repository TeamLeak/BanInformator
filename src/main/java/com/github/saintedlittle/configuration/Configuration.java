package com.github.saintedlittle.configuration;

import com.github.saintedlittle.configuration.modules.INFORMATIONModule;
import com.github.saintedlittle.configuration.modules.RESTModule;
import com.github.saintedlittle.configuration.modules.SHARINGModule;

import java.util.concurrent.atomic.AtomicReference;

public final class Configuration {
    private static boolean isFirstRun = true;

    public static final AtomicReference<INFORMATIONModule> information = new AtomicReference<>(new INFORMATIONModule());
    public static final AtomicReference<RESTModule> restModule = new AtomicReference<>(new RESTModule());
    public static final AtomicReference<SHARINGModule> sharingModule = new AtomicReference<>(new SHARINGModule());

    public static void reload() {
        information.get().load();
        restModule.get().load();
        sharingModule.get().load();

        if (isFirstRun) {
            System.out.println("[BanInformator] configuration has been loaded!");
            isFirstRun = false;
        }

        System.out.println("[BanInformator] configuration has been reloaded!");

    }

}
