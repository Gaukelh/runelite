package net.runelite.client.plugins.playertracker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.List;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.OverlayUtil;

public class PlayerTrackerOverlay extends Overlay {

    private final Client client;
    private final PlayerTrackerConfig config;
    private PlayerTrackerPlugin playerTrackerPlugin;

    @Inject
    private PlayerTrackerOverlay(Client client, PlayerTrackerConfig config, PlayerTrackerPlugin playerTrackerPlugin) {
        this.client = client;
        this.config = config;
        this.playerTrackerPlugin = playerTrackerPlugin;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(OverlayPriority.HIGHEST);
    }

    @Override
    public Dimension render(Graphics2D graphics) {
        if(config.highlightAttackTile()) {
            List<Player> players = client.getPlayers();
            Player local = client.getLocalPlayer();
            for(Player p: players) {
                if(p != local) {
                    if(p.getName() != "Ferticus" && p.getName() != "kiwi hybrid" && p.getName() != "GravityLbstr" && p.getName() != "BlooMcgee") {
                        if(81 >= p.getCombatLevel() && p.getCombatLevel() >= 20) {
                            OverlayUtil.renderActorOverlay(graphics, p, "", config.highlightAttackColor());
                        }
                    }
                }
            }
        }
        if(config.highlightDangerTile()) {
            List<Player> players = client.getPlayers();
            Player local = client.getLocalPlayer();
            for(Player p: players) {
                if(p != local) {
                    if (p.getName() != "Ferticus" && p.getName() != "kiwi hybrid" && p.getName() != "GravityLbstr" && p.getName()!= "BlooMcgee") {
                        if (91 > p.getCombatLevel() && p.getCombatLevel() > 81) {
                            OverlayUtil.renderActorOverlay(graphics, p, "", config.highlightDangerColor());
                        }
                    }
                }
            }
        }
        return null;
    }

//    private void renderPlayers(Graphics2D graphics) {
//
//    }
//
//    private void renderTile(final Graphics2D graphics, final LocalPoint dest, final Color color) {
//        if(dest == null) {
//            return;
//        }
//        final Polygon poly = Perspective.getCanvasTilePoly(client, dest);
//        if(poly == null) {
//            return;
//        }
//        OverlayUtil.renderPolygon(graphics, poly, color);
//    }
}
