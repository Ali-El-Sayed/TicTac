/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Screens;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ui.components.GameButton;

public class videoPopUp {

    public static void openVideoPopUp() {
        Stage videoStage = new Stage();
        videoStage.initModality(Modality.APPLICATION_MODAL);
        videoStage.setTitle("Video Dialog");

        Media media = new Media(new File("C:/Users/LEGION/Desktop/winnerVideo.mp4").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        Button playAgain = new GameButton("Test", GameButton.Mode.NORMAL, () -> {
            System.out.println("hi");
        });
        playAgain.setPrefSize(250, 100);
        Button Back = new GameButton(GameButton.Mode.BACK, () -> {
            System.out.println("hi");
        });
        Back.setPrefSize(250, 100);
        HBox hBox = new HBox();
        HBox.setMargin(playAgain, new Insets(25.0, 40.0, 20.0, 20.0));
        HBox.setMargin(Back, new Insets(25.0, 0.0, 0.0, 0.0));
        hBox.getChildren().add(playAgain);
        hBox.getChildren().add(Back);

        BorderPane dialogRoot = new BorderPane();
        dialogRoot.setCenter(mediaView);
        BorderPane.setAlignment(mediaView, Pos.TOP_CENTER);

        dialogRoot.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_LEFT);

        dialogRoot.setBackground(new Background(new BackgroundImage(new Image("/assets/background.png"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        Scene dialogScene = new Scene(dialogRoot, 1200, 858);

        videoStage.setScene(dialogScene);
        videoStage.setResizable(false);
        videoStage.setOnCloseRequest(event -> {
            mediaPlayer.stop();
        });
        mediaPlayer.play();
        videoStage.showAndWait();
    }
}
