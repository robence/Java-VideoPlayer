package com.robence.videoplayer;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {

    MediaPlayer player;

    public Player() {
        //Media media = new Media(file);
        //player = new MediaPlayer(media);
        MediaView view = new MediaView();
        Pane pane = new Pane();

        pane.getChildren().add(view);

        setCenter(pane);

        MediaBar bar = new MediaBar();

        setBottom(bar);

        setStyle("-fx-background-color: #bfc2c7");
    }

    public Player(String file) {
        Media media = new Media(file);
        player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        Pane pane = new Pane();

        pane.getChildren().add(view);

        setCenter(pane);

        MediaBar bar = new MediaBar(player);

        setBottom(bar);

        setStyle("-fx-background-color: #bfc2c7");

        player.play();

    }

}
