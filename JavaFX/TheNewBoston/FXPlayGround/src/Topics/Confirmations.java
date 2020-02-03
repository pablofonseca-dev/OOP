package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Confirmations implements GetStages{
    public Confirmations(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        JFXButton showNotification = new JFXButton();
        JFXButton closeStage = new JFXButton();
        showNotification.setText("Pop-Up!");
        closeStage.setText("Close");

        showNotification.setOnAction(actionEvent -> {
            boolean confirmationValue = ConfirmationBox.display("Question Bro", "Are you a cool guy?");
            AlertBox.display("Answer", String.valueOf(confirmationValue));
            System.out.println(confirmationValue);
        });
        closeStage.setOnAction(actionEvent -> {ApplicationStopStage.finishLifeCycle(stage);});
        root.getChildren().addAll(
                showNotification,
                closeStage
        );
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }


}
