package com.github.saintedlittle.configuration.modules;

import com.github.saintedlittle.util.InstanceMemory;

import java.util.concurrent.atomic.AtomicBoolean;

public class INFORMATIONModule {

    private final AtomicBoolean UseBanListener = new AtomicBoolean(false);

    private final AtomicBoolean GetInfoFromBannedJson = new AtomicBoolean(false);

    public void load() {
        UseBanListener.set(InstanceMemory.instance.get().getConfig().getBoolean("UseBanListener"));
        GetInfoFromBannedJson.set(InstanceMemory.instance.get().getConfig().getBoolean("GetInfoFromBannedJson"));

    }
}
