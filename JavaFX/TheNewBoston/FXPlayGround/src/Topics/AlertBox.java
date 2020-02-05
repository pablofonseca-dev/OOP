package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AlertBox{

    public static void display(String title, String message){
        Stage windowAlert = new Stage();
        windowAlert.setWidth(400);;
        windowAlert.setHeight(400);
        windowAlert.initModality(Modality.APPLICATION_MODAL);
        windowAlert.initStyle(StageStyle.UTILITY);
        windowAlert.setAlwaysOnTop(true);
        windowAlert.setTitle(title);
        windowAlert.setMinWidth(250);
        Label label = new Label();
        label.setText(message);
        label.setTextFill(Color.web("#FFFFFF"));
        JFXButton closeButton = new JFXButton("Close");
        closeButton.setTextFill(Color.WHITE);
        closeButton.setOnAction(actionEvent -> {
            windowAlert.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, closeButton);

        layout.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        layout.setAlignment(Pos.CENTER);

        Scene sceneAlert = new Scene(layout);

        windowAlert.setScene(sceneAlert);

        windowAlert.showAndWait();
    }
}
