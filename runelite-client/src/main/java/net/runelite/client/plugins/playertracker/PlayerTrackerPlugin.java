package net.runelite.client.plugins.playertracker;

import com.google.gson.JsonObject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.OverlayManager;



import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@PluginDescriptor(
        name = "SluttyStudios",
        description = "Tracks players",
        enabledByDefault = false
)
public class PlayerTrackerPlugin extends Plugin {

    @Inject
    Client client;
    @Inject
    OverlayManager overlayManager;
    @Inject
    PlayerTrackerOverlay ptOverlay;

    @Provides PlayerTrackerConfig playerTrackerConfig(ConfigManager configManager) {
        return configManager.getConfig(PlayerTrackerConfig.class);
    }

//    Socket s;
//    int counter;
//    PrintWriter out;
//    int player_num;

    @Override
    protected void startUp() throws Exception  {
        overlayManager.add(ptOverlay);
//        counter = 0;
//        player_num = 0;
//        s = new Socket("127.0.0.1", 6969);
//        System.out.println("Starting up Player Tracker by Slutty Studios (tm)");
//        System.out.println("Sending data: ");
//        System.out.println("World: " + client.getWorld());
//        JsonObject json = new JsonObject();
//        json.addProperty("id", "RL");
//        json.addProperty("message", "world");
//        json.addProperty("data", client.getWorld());
//        out = new PrintWriter(s.getOutputStream(), true);
//        out.println(json.toString());
    }

    @Override
    protected void shutDown() {
        overlayManager.remove(ptOverlay);
    }

//    @Subscribe
//    protected void onGameStateChanged(GameStateChanged gameStateChanged) throws Exception {
//        if(gameStateChanged.getGameState() == GameState.LOGGED_IN) {
//            JsonObject json = new JsonObject();
//            json.addProperty("id", "RL");
//            json.addProperty("message", "world");
//            json.addProperty("data", client.getWorld());
//            out = new PrintWriter(s.getOutputStream(), true);
//            out.println(json.toString());
//        }
//    }

//    @Subscribe
//    protected void onGameTick(GameTick tick) {
//        JsonObject json = new JsonObject();
//        json.addProperty("id", "RL");
//        json.addProperty("message", "player_list");
//        counter++;
//        List<Player> player_list = client.getPlayers();
//        for(Player p: player_list) {
//            JsonObject temp_json = new JsonObject();
//            temp_json.addProperty("user_name", p.getName());
//            temp_json.addProperty("combat_level", p.getCombatLevel());
//            String num = String.valueOf(player_num);
//            json.add(num, temp_json);
//            player_num++;
//        }
//        json.addProperty("player_num", player_num);
//        if(counter == 20) {
//            counter = 0;
//        }
//        out.println(json.toString());
//        player_num = 0;
//    }
}
