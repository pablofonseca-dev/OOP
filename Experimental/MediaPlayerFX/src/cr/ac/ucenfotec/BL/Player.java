package cr.ac.ucenfotec.BL;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;



public class Player extends BorderPane {
    //Order to divide the media player into regions
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Pane mediaPlayerPane;
    MediaBar mediaBar;

    public Player(String file){

        media = new Media(file);
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        mediaPlayerPane = new Pane();
        mediaPlayerPane.getChildren().addAll(mediaView);

        //Because Player extends from BorderPane can be configured as one.
        //BorderPane Configurations
        setCenter(mediaPlayerPane);
        mediaBar = new MediaBar(mediaPlayer);
        setBottom(mediaBar);
        setStyle("-fx-background-color: #BFC2C7");
        mediaPlayer.play();



    }
}