package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Alerts implements GetStages{
    public Alerts(Stage stage) throws Exception{
        this.getStage(stage);
    }
    @Override
    public void getStage(Stage stage) throws Exception {

        StackPane root = new StackPane();

        JFXButton showNotification = new JFXButton();
        showNotification.setText("Pop-Up!");
        showNotification.setOnAction(actionEvent -> {
            AlertBox.display("Alert Box", "You are a Cool Guy!");
        });
        root.getChildren().addAll(showNotification);
        Scene scene = new Scene(root);
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);

    }
}
