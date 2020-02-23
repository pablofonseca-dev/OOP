package cr.ac.ucenfotec.BL;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaBar extends HBox { //Extends horizontal box
    //Introducing Media Sliders
    private JFXSlider time = new JFXSlider(); //Slider for time.
    private JFXSlider volume = new JFXSlider(); //Slider for volume.
    private JFXButton PlayButton = new JFXButton("||"); //For pausing the player.
    private Label volumeLabel = new Label("Volume: ");

    private MediaPlayer player;
    //Constructor
    public MediaBar(MediaPlayer mediaPlayer){
        //Taking media player obj.
        this.player = mediaPlayer;

         //Because MediaBar extends from HBox can be configured as one.
        //HBox Configurations.
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 10, 10, 10));

        //Setting the preference for volume var.
        volume.setPrefWidth(70);
        volume.setMinWidth(30);
        volume.setValue(100);

        HBox.setHgrow(time, Priority.ALWAYS);

        PlayButton.setPrefWidth(30);

        //Adding the components to the bottom.
        getChildren().addAll(
                PlayButton,
                time,
                volume,
                volumeLabel
        );

        //Adding Functionality to play the media player.


        //Providing functionality to the play button.
        PlayButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Status mediaPlayerStatus = player.getStatus();
                if(mediaPlayerStatus == Status.PLAYING){
                    //If the status is Video Playing
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                       //If the player is at the end of the video
                        player.seek(player.getStartTime()); //Restart the video.
                        player.play();
                    }else{
                        //Pausing the player
                        player.pause();
                        PlayButton.setText(">");
                    }
                } // If the video is stopped, halted or paused.
                if(mediaPlayerStatus == Status.HALTED || mediaPlayerStatus == Status.STOPPED || mediaPlayerStatus == Status.PAUSED){
                    player.play(); //Start the video
                    PlayButton.setText("||");
                }
            }
        });

        //Providing functionality to time slider.
        player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(time.isPressed()){ //It would set the time as specified by user by pressing.
                    player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
                }
            }
        });

        //Providing functionality to volume slider.
        volume.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(volume.isPressed()){
                    player.setVolume(volume.getValue() / 100); //It would set the volume as specified the user by
                    // pressing.
                }
            }
        });
    }

    protected void updateValues(){
        Platform.runLater(new Runnable(){
            public void run(){
                //Updating to the new time value
                //This will move the slider while running your video
                //There is a possible error here.
                time.setValue(player.getTotalDuration().toMillis() * 100);
            }
        });
    }

}
