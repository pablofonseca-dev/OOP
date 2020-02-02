package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Confirmations implements GetStages{
    public Confirmations(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        StackPane root = new StackPane();

        JFXButton showNotification = new JFXButton();
        showNotification.setText("Pop-Up!");
        showNotification.setOnAction(actionEvent -> {
            boolean confirmationValue = ConfirmationBox.display("Question Bro", "Are you a cool guy?");
            AlertBox.display("Answer", String.valueOf(confirmationValue));
            System.out.println(confirmationValue);
        });
        root.getChildren().addAll(showNotification);
        Scene scene = new Scene(root);
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }
}
