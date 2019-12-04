package net.runelite.client.plugins.playertracker;

import java.awt.*;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PlayerTrackerOverlay extends Overlay {

    private final Client client;
    private final PlayerTrackerConfig config;
    private PlayerTrackerPlugin playerTrackerPlugin;
    private static final Font FONT = FontManager.getRunescapeFont().deriveFont(Font.BOLD, 16);

    @Inject
    private PlayerTrackerOverlay(Client client, PlayerTrackerConfig config, PlayerTrackerPlugin playerTrackerPlugin) {
        this.client = client;
        this.config = config;
        this.playerTrackerPlugin = playerTrackerPlugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ALWAYS_ON_TOP);
        setPriority(OverlayPriority.HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        graphics.setFont(FONT);
        List<Player> players = client.getPlayers();
        Player local = client.getLocalPlayer();
        for(Player p: players) {
            if(p != local) {
                if(!p.getName().equalsIgnoreCase("Ferticus") && !p.getName().equalsIgnoreCase("kiwi hybrid") && !p.getName().equalsIgnoreCase("gravitylbstr") && !p.getName().equalsIgnoreCase("bloomcgee") && !p.getName().equalsIgnoreCase("doctor moans")) {
                    if(config.highlightAttackTile()) {
                        if(config.yellowLowerBound() > p.getCombatLevel() && p.getCombatLevel() >= config.greenLowerBound()) {
                            OverlayUtil.renderActorOverlay(graphics, p, p.getCombatLevel() + "   " + p.getName(), config.highlightAttackColor());
                        }
                    }
                    if(config.highlightMediumTile()) {
                        if (config.yellowUpperBound() >= p.getCombatLevel() && p.getCombatLevel() >= config.yellowLowerBound()) {
                            OverlayUtil.renderActorOverlay(graphics, p, p.getCombatLevel() + "   " + p.getName(), config.highlightMediumColor());
                        }
                    }
                    if(config.highlightDangerTile()) {
                        if (config.redUpperBound() >= p.getCombatLevel() && p.getCombatLevel() > config.yellowUpperBound()) {
                            OverlayUtil.renderActorOverlay(graphics, p, p.getCombatLevel() + "   " + p.getName(), config.highlightDangerColor());
                        }
                    }
                }
            }
        }
        return null;
    }
}
