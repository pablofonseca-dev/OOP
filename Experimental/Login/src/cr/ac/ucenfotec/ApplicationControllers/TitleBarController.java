package cr.ac.ucenfotec.ApplicationControllers;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TitleBarController implements Initializable {
    @FXML
    private ImageView minimize;
    @FXML
    private ImageView fullScreen;
    @FXML
    private ImageView exit;

    private Stage thisStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Event Handlers
        minimize.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                thisStage = (Stage) minimize.getScene().getWindow();
                System.out.println("Minimized");
                thisStage.setIconified(true);
            }
        });

        fullScreen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount() == 1) {
                    thisStage = (Stage) minimize.getScene().getWindow();
                    System.out.println("Full Screen Setup");
                    thisStage.setFullScreen(true);
                }else if(mouseEvent.getClickCount() == 2){
                    System.out.println("Exiting from full screen");
                    thisStage.setFullScreen(false);
                }
            }
        });

        exit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                thisStage = (Stage) minimize.getScene().getWindow();
                System.out.println("Good Bye");
                Platform.exit();
            }
        });

    }
}
