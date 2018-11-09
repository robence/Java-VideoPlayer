package com.robence.videoplayer;

import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class DefaultScene extends Scene {

    private static final int DEFAULT_PLAYER_WIDTH = 720;
    private static final int PLAYER_HEIGHT = 535;
    private static final Color DEFAULT_COLOR = Color.BLACK;

    private javafx.scene.Scene scene;

    public DefaultScene(Player player) {
        super(player, DEFAULT_PLAYER_WIDTH, PLAYER_HEIGHT, DEFAULT_COLOR);
    }

    public DefaultScene(Player player, int defaultPlayerWidth, int playerHeight, Color defaultColor) {
        super(player, DEFAULT_PLAYER_WIDTH, PLAYER_HEIGHT, DEFAULT_COLOR);
    }
}
