package cr.ac.ucenfotec;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;

public class AttackFinishedNotificationFX{
    public AttackFinishedNotificationFX() throws Exception{
        Stage attackNotificationStage = new Stage();
        attackNotificationStage.setWidth(354);
        attackNotificationStage.setHeight(255);
        attackNotificationStage.initStyle(StageStyle.TRANSPARENT);
        Parent fxmlStage =  FXMLLoader.load(getClass().getResource("AttackFinishedNotification.fxml"));
        Scene scene = new Scene(fxmlStage);
        attackNotificationStage.setScene(scene);
        attackNotificationStage.show();
    }
}
