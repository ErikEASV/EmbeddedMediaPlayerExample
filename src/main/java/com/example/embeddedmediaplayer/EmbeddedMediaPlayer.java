package com.example.embeddedmediaplayer;

/* Rettet EK dec. 2023
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class EmbeddedMediaPlayer extends Application {

    private static String media_url;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Embedded Media Player");
        Group root = new Group();
        Scene scene = new Scene(root, 540, 241);

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Åben lydfil...");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null)
            media_url = selectedFile.toURI().toString();
        else
            media_url =
            "https://samplelib.com/lib/preview/mp3/sample-15s.mp3";
        //   "https://samplelib.com/lib/preview/mp3/sample-6s.mp3";
        //    "https://media.istockphoto.com/id/1249558755/video/corcovado-national-park-costa-rica.mp4?s=mp4-640x640-is&k=20&c=SeqFrvNEiF0K4DSsKEFPeYDP6cOYLJzYtvFuBvALLBU=";

        // create media player
        Media media = new Media (media_url);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        MediaControl mediaControl = new MediaControl(mediaPlayer);

        scene.setRoot(mediaControl);

        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
