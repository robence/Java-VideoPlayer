package com.robence.videoplayer;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {

    private Player player;
    private FileChooser fileChooser;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(final Stage primaryStage) {

        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        file.getItems().add(open);
        menu.getMenus().add(file);

        fileChooser = new FileChooser();

        open.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                player.player.pause();
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    try {
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player, 720, 535, Color.BLACK);
                        primaryStage.setScene(scene);
                    } catch (MalformedURLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }
        });

        player = new Player("file:///C:/trailer.mp4");
        player.setTop(menu);
        Scene scene = new Scene(player, 720, 535, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
