package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox{

    public static void display(String title, String message){
        Stage windowAlert = new Stage();
        windowAlert.setWidth(300);;
        windowAlert.setHeight(100);
        windowAlert.initModality(Modality.APPLICATION_MODAL);
        windowAlert.initStyle(StageStyle.UTILITY);
        windowAlert.setAlwaysOnTop(true);
        windowAlert.setTitle(title);
        windowAlert.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        JFXButton closeButton = new JFXButton("Close");
        closeButton.setOnAction(actionEvent -> {
            windowAlert.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene sceneAlert = new Scene(layout);

        windowAlert.setScene(sceneAlert);

        windowAlert.showAndWait();
    }
}
