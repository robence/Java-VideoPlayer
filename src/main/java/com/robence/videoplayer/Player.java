package com.robence.videoplayer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

    private MediaPlayer player;

    public Player() {
        player();
    }

    public Player(String file) {
        Media media = new Media(file);
        player = new MediaPlayer(media);
        player();

        player.play();

    }

    private void player() {

        MediaView view = player != null
                ? new MediaView(player)
                : new MediaView();

        Pane pane = new Pane();
        pane.getChildren().add(view);
        setCenter(pane);

        MediaBar bar = player != null
                ? new MediaBar(player)
                : new MediaBar();

        setBottom(bar);
        setStyle("-fx-background-color: #bfc2c7");

    }

}
