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
            description = "Color to highlight tiles players can attack",
            position = 1
    )
    default Color highlightAttackColor() {
        return Color.GREEN;
    }

    @ConfigItem(
            keyName = "highlightAttackTile",
            name = "Highlight Attack Color",
            description = "Highlights the tile players can attack"
    )
    default boolean highlightAttackTile() {
        return true;
    }

    @ConfigItem(
            keyName = "greenLowerBound",
            name = "Lower Bound Green Attack",
            description = "Lower bound of the attack highlight green (inclusive)",
            position = 4
    )
    default int greenLowerBound() { return 20; }

    @Alpha
    @ConfigItem(
            keyName = "highlightDangerColor",
            name = "Danger Color",
            description = "Color to highlight dangerous player tiles",
            position = 3
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

    @ConfigItem(
            keyName = "redUpperBound",
            name = "Upper Bound Red Attack",
            description = "Upper bound of the attack highlight red (inclusive)",
            position = 7
    )
    default int redUpperBound() { return 90; }

    @Alpha
    @ConfigItem(
            keyName = "highlightMediumColor",
            name = "Medium Color",
            description = "Color to highlight medium player tiles",
            position = 2
    )
    default Color highlightMediumColor() {
        return Color.YELLOW;
    }

    @ConfigItem(
            keyName = "highlightDangerTile",
            name = "Highlight Medium Color",
            description = "Highlights the tile medium to the player"
    )
    default boolean highlightMediumTile() {
        return true;
    }

    @ConfigItem(
            keyName = "yellowLowerBound",
            name = "Lower Bound Yellow Attack",
            description = "Lower bound of the attack highlight yellow (inclusive)",
            position = 5
    )
    default int yellowLowerBound() { return 45; }

    @ConfigItem(
            keyName = "yellowUpperBound",
            name = "Upper Bound Yellow Attack",
            description = "Upper bound of the attack highlight yellow (inclusive)",
            position = 6
    )
    default int yellowUpperBound() { return 85; }
}
