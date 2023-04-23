package com.github.saintedlittle.configuration.modules;

import com.github.saintedlittle.util.InstanceMemory;

import java.util.concurrent.atomic.AtomicBoolean;

public class SHARINGModule {

    private final AtomicBoolean ReturnOnGetInformationCommand = new AtomicBoolean(false);
    private final AtomicBoolean UseUploadCommand = new AtomicBoolean(false);

    public void load() {
        ReturnOnGetInformationCommand.set(InstanceMemory.instance.get().getConfig().getBoolean("ReturnOnGetInformationCommand"));
        UseUploadCommand.set(InstanceMemory.instance.get().getConfig().getBoolean("UseUploadCommand"));

    }

}
