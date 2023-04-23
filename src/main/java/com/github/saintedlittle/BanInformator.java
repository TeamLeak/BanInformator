package com.github.saintedlittle;

import com.github.saintedlittle.commands.InformationCommand;
import com.github.saintedlittle.commands.ReloadCommand;
import com.github.saintedlittle.commands.UploadCommand;
import com.github.saintedlittle.configuration.Configuration;
import com.github.saintedlittle.listeners.BanListener;
import com.github.saintedlittle.rest.RestServer;
import com.github.saintedlittle.util.InstanceMemory;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BanInformator extends JavaPlugin {

    private final FileConfiguration config = getConfig();

    @Override
    public void onEnable() {

        if (!getConfig().getBoolean("Enabled"))
            onDisable();

        // Register instance.
        InstanceMemory.instance.set(this);

        // Initialize Configuration.
        loadConfiguration();

        // Register Listeners.
        getServer().getPluginManager().registerEvents(new BanListener(), this);

        // Register Commands.
        Objects.requireNonNull(getCommand("reload")).setExecutor(new ReloadCommand());
        Objects.requireNonNull(getCommand("upload")).setExecutor(new UploadCommand());
        Objects.requireNonNull(getCommand("getInformation")).setExecutor(new InformationCommand());

        // REST
        RestServer restServer = new RestServer();
        restServer.start();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }

    private void loadConfiguration() {
        config.options().copyDefaults(true);
        saveConfig();

        Configuration.reload();
    }
}
