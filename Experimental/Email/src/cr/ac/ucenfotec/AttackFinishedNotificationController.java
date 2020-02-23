package cr.ac.ucenfotec;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class AttackFinishedNotificationController {
    //FXML Properties - Nodes
    @FXML
    private ImageView exitButton;

    public void closeNotificationStage(){
        Stage thisStage = (Stage) exitButton.getScene().getWindow();
        thisStage.close();
    }
}

