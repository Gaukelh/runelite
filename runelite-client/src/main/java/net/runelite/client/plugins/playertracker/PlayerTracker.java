package net.runelite.client.plugins.playertracker;

import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.events.GameTick;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.SkullIcon;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@PluginDescriptor(
        name = "SluttyStudios",
        description = "Tracks players"
)
public class PlayerTracker extends Plugin {

    @Inject Client client;
    List<Player> old_list;

    @Override
    protected void startUp() throws Exception  {
        old_list = Arrays.asList(client.getCachedPlayers());
        System.out.println(old_list);
//        for(Player p: old_list) {
//            System.out.println("CB: " + p.getCombatLevel() + "Name: " + p.getName());
//        }
    }

    @Subscribe
    protected void onGameTick(GameTick tick) {
        List<Player> new_list = Arrays.asList(client.getCachedPlayers());
        for(Player p: old_list) {
            if(!new_list.contains(p)){
                old_list.remove(p);
            }
        }
        for(Player p: new_list) {
            if(!old_list.contains(p)) {
                old_list.add(p);
                System.out.println("CB: " + p.getCombatLevel() + "Name: " + p.getName());
            }
        }
    }

}
