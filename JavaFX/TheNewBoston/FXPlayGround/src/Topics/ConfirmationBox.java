package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConfirmationBox{
    static boolean confirmationValue;
    public static boolean display(String title, String message) {
        Stage windowConfirmation = new Stage();
        windowConfirmation.setWidth(300);
        windowConfirmation.setHeight(100);
        windowConfirmation.initModality(Modality.APPLICATION_MODAL);
        windowConfirmation.initStyle(StageStyle.UTILITY);
        windowConfirmation.setAlwaysOnTop(true);
        windowConfirmation.setTitle(title);
        windowConfirmation.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        JFXButton yesButton = new JFXButton("Yes");
        JFXButton noButton = new JFXButton("No");

        yesButton.setOnAction(actionEvent -> {
            confirmationValue =  true;
            windowConfirmation.close();
        });

        noButton.setOnAction(actionEvent -> {
            confirmationValue = false;
            windowConfirmation.close();
        });

        VBox layout = new VBox();

        HBox buttonLayout = new HBox(yesButton, noButton);

        buttonLayout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                label,
                buttonLayout
        );

        layout.setAlignment(Pos.CENTER);

        Scene sceneAlert = new Scene(layout);

        windowConfirmation.setScene(sceneAlert);

        windowConfirmation.showAndWait();
        
        return confirmationValue;
    }
}
