package cr.ac.ucenfotec.UI.FXControllers;
import com.jfoenix.controls.JFXSlider;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MediaPlayerFXController implements Initializable {

    //Custom Variables
    private static int pausePlaySwitchCounter = 0;
    //FXML Attributes
    @FXML
    private ImageView playPauseImage;
    @FXML
    private JFXSlider volumeSlider;

    @FXML
    private MediaView mediaView;

    //******//
    @FXML
    private JFXSlider progressBar;
    //Objs instance needed to be implemented in the mediaView
    private MediaPlayer mediaPlayer;
    private Media media;
    //******//

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Initializing the Controller of the Media Player FXML");

        //Custom Path of one video
        String path = new File("src/Video/cybertruck_demo_2.mp4").getPath();
        File file = new File(path);
        //Convert from relative Path to an absolute path depending of each computer file system.
        String fileConversion = file.toURI().toString();
        System.out.println("Path>>> " + path);
        System.out.println("File>>> " + file);
        System.out.println("Relative Path Conversion in this Machine>>>" + fileConversion);
        media = new Media(fileConversion);

        //Set Media Player to Media View
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);

        DoubleProperty width = mediaView.fitWidthProperty();
        DoubleProperty height = mediaView.fitHeightProperty();

        //Resize the video
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));


        //Volume Slider Functionality
        volumeSlider.setValue(mediaPlayer.getVolume() * 100);
        volumeSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(volumeSlider.getValue() / 100);
                System.out.println("Volume>>> " + volumeSlider.getValue());
            }
        });

        //Set mouse dragging to video progress bar
        progressBar.setValue(0); //Default value

        //Set automatic movement to progressBar slider
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration oldValue,
                                Duration newValue) {
                progressBar.setValue(newValue.toSeconds());
            }
        });

        //Set mouse events to progressBar slider
        progressBar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mediaPlayer.seek(Duration.seconds(progressBar.getValue()));
            }
        });

        //Change image from the play and pause image
        playPauseImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                /*
                        String path = new File("src/Video/star_wars.mp4").getPath();
                        File file = new File(path);
                        //Convert from relative Path to an absolute path depending of each computer file system.
                        String fileConversion = file.toURI().toString();
                */
                String imagePath;
                if(pausePlaySwitchCounter == 0){
                    //Change Image Path
                    imagePath = new File("src/cr/ac/ucenfotec/UI/Media/Icons/pause_icon.png").getPath();
                    pausePlaySwitchCounter = 1;
                    mediaPlayer.play();
                }else{
                    //Change Image Path
                    imagePath = new File("src/cr/ac/ucenfotec/UI/Media/Icons/play_icon.png").getPath();
                    pausePlaySwitchCounter = 0;
                    mediaPlayer.pause();
                }
                File imageFile = new File(imagePath);
                String imageFileConversion = imageFile.toURI().toString();
                Image image = new Image(imageFileConversion);
                playPauseImage.setImage(image);
            }
        });
    }

    public void fast(ActionEvent event){
        mediaPlayer.setRate(2.0);
    }

    public void normal(ActionEvent event){
        mediaPlayer.setRate(1.0);
    }

    public void slow(ActionEvent event){
        mediaPlayer.setRate(.5);
    }

    public void reload(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }

    public void start(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.stop();
    }

    public void last(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getTotalDuration());
        mediaPlayer.stop();
    }

}
