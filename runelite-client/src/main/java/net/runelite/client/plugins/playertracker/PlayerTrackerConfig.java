package net.runelite.client.plugins.playertracker;

import java.awt.Color;
import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("playertracker")
public interface PlayerTrackerConfig extends Config {

    @Alpha
    @ConfigItem(
            keyName = "highlightAttackColor",
            name = "Attack Color",
            description = "Color to highlight tiles players can attack"
    )
    default Color highlightAttackColor() {
        return Color.BLUE;
    }

    @ConfigItem(
            keyName = "highlightAttackTile",
            name = "Highlight Attack Color",
            description = "Highlights the tile players can attack"
    )
    default boolean highlightAttackTile() {
        return true;
    }

    @Alpha
    @ConfigItem(
            keyName = "highlightDangerColor",
            name = "Danger Color",
            description = "Color to highlight dangerous player tiles"
    )
    default Color highlightDangerColor() {
        return Color.RED;
    }

    @ConfigItem(
            keyName = "highlightDangerTile",
            name = "Highlight Danger Color",
            description = "Highlights the tile dangerous to the player"
    )
    default boolean highlightDangerTile() {
        return true;
    }
}
