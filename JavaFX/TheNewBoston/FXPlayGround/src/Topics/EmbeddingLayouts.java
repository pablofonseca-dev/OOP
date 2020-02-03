package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbeddingLayouts implements GetStages{
    public EmbeddingLayouts(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        HBox topMenu = new HBox();
        JFXButton buttonA = new JFXButton("File");
        JFXButton buttonB = new JFXButton("Edit");
        JFXButton buttonC = new JFXButton("View");
        topMenu.getChildren().addAll(
                buttonA,
                buttonB,
                buttonC
        );

        VBox leftMenu = new VBox();
        JFXButton buttonD = new JFXButton("D");
        JFXButton buttonE = new JFXButton("E");
        JFXButton buttonF = new JFXButton("F");
        leftMenu.getChildren().addAll(
                buttonD,
                buttonE,
                buttonF
        );

        BorderPane root = new BorderPane();
        root.setTop(topMenu);
        root.setLeft(leftMenu);

        //Don't modify this if you don't fucking know what to do :)
        JFXButton closeStage = new JFXButton();
        closeStage.setText("Close");

        closeStage.setOnAction(actionEvent -> {ApplicationStopStage.finishLifeCycle(stage);});
        root.setCenter(closeStage);

        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }


}