package com.robence.videoplayer;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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

        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("File");
        MenuItem menuItem = new MenuItem("Open");

        menu.getItems().add(menuItem);
        menuBar.getMenus().add(menu);

        fileChooser = new FileChooser();

        menuItem.setOnAction(e -> {
            player.player.pause();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    player = new Player(file.toURI().toURL().toExternalForm());
                    Scene scene = new DefaultScene(player);
                    primaryStage.setScene(scene);
                } catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        player = new Player("file:///C:/trailer.mp4");
        player.setTop(menuBar);
        Scene scene = new DefaultScene(player);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
