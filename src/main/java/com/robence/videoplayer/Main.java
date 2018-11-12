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
        MenuItem openFile = new MenuItem("Open");

        menu.getItems().add(openFile);
        menuBar.getMenus().add(menu);

        fileChooser = new FileChooser();

        addOpenFIleEventListener(primaryStage, menuBar, openFile);

        player = new Player();
        setStage(primaryStage, menuBar);
        primaryStage.show();
    }

    private void addOpenFIleEventListener(Stage primaryStage, MenuBar menuBar, MenuItem openFile) {
        openFile.setOnAction(e -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    player = new Player(file.toURI().toURL().toExternalForm());
                    setStage(primaryStage, menuBar);
                } catch (MalformedURLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }

    private void setStage(Stage primaryStage, MenuBar menuBar) {
        player.setTop(menuBar);
        Scene scene = new DefaultScene(player);
        primaryStage.setScene(scene);
    }


}
