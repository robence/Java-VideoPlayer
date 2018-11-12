package com.robence.videoplayer;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

class MediaBar extends HBox {

    private Slider time = new Slider();
    private Slider vol = new Slider();

    private Button playButton = new Button("||");

    private MediaPlayer player;

    MediaBar() {
        setAlignment(Pos.CENTER);
        setPadding(new Insets(0, 10, 3, 10));

        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);

        HBox.setHgrow(time, Priority.ALWAYS);

        playButton.setPrefWidth(30);

        getChildren().add(playButton);
        getChildren().add(time);
        Label volume = new Label("Volume: ");
        getChildren().add(volume);
        getChildren().add(vol);


    }

    MediaBar(MediaPlayer play) {
        player = play;

        setAlignment(Pos.CENTER);
        setPadding(new Insets(0, 10, 3, 10));

        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);

        HBox.setHgrow(time, Priority.ALWAYS);

        playButton.setPrefWidth(30);

        getChildren().add(playButton);
        getChildren().add(time);
        Label volume = new Label("Volume: ");
        getChildren().add(volume);
        getChildren().add(vol);


        playButton.setOnAction(e -> {
            Status status = player.getStatus();

            if (status == Status.PLAYING) {
                if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
                    player.seek(player.getStartTime());
                    player.play();
                } else {
                    player.pause();
                    playButton.setText(">");
                }
            }

            if (status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED) {
                player.play();
                playButton.setText("||");
            }
        });

        player.currentTimeProperty().addListener(ov -> updateValues());

        time.valueProperty().addListener(ov -> {
            if (time.isPressed()) {
                player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
            }
        });

        vol.valueProperty().addListener(ov -> {
            if (vol.isPressed()) {
                player.setVolume(vol.getValue() / 100);
            }
        });
    }

    private void updateValues() {
        Platform.runLater(() -> {
            time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis() * 100);
        });
    }
}
