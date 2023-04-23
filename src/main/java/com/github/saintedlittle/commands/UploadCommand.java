package com.github.saintedlittle.commands;

import com.github.saintedlittle.configuration.Configuration;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.github.saintedlittle.json.Converter.toJsonString;
import static com.github.saintedlittle.util.JsonMemory.bannedPlayers;

public final class UploadCommand implements CommandExecutor {

    @SneakyThrows
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        URL url = new URL(Configuration.restModule.get().REST_URL.get());

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        // Send the JSON payload to the server
        OutputStream os = con.getOutputStream();
        os.write(toJsonString(bannedPlayers.get()).getBytes());
        os.flush();
        os.close();

        // Check the response code
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Handle success response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            sender.sendMessage("SUCCESS! ANSWER: " + response);
            return true;
        } else {
            // Handle error response
            sender.sendMessage("ERROR! RESPONCE CODE: " + responseCode);
            return false;
        }

    }
}
