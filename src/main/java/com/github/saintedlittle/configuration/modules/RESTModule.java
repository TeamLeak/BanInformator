package com.github.saintedlittle.configuration.modules;

import com.github.saintedlittle.util.InstanceMemory;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
public class RESTModule {

    public final AtomicReference<String> REST_URL = new AtomicReference<>("");
    public final AtomicBoolean UseREST = new AtomicBoolean(false);

    public final AtomicInteger REST_PORT = new AtomicInteger(0);

    public void load() {
        UseREST.set(InstanceMemory.instance.get().getConfig().getBoolean("UseREST"));
        if (!UseREST.get())
            return;

        REST_URL.set(InstanceMemory.instance.get().getConfig().getString("REST_URL"));

        REST_PORT.set(InstanceMemory.instance.get().getConfig().getInt("REST_PORT"));

    }

}
