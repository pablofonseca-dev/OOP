package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchingScenes implements GetStages{
    public SwitchingScenes(Stage stage) throws Exception{
        this.getStage(stage);
    }
    @Override
    public void getStage(Stage stage) throws Exception {
        Stage window;
        Scene scene1, scene2;

        window = stage;
        window.setTitle("Switching Scenes");

        //Layout One> Children are laid out in vertical column
        Label label1 = new Label("Welcome to the first scene!");
        JFXButton button1 = new JFXButton("Go to scene two!");

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(
                label1,
                button1
        );
        scene1 = new Scene(vBox1);

        //Layout Two> Children are laid out in a horizontal column
        Label label2 = new Label("Welcome to the second scene!");
        JFXButton button2 = new JFXButton("Go to scene one!");
        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(
                label2,
                button2
        );
        scene2 = new Scene(hBox1);



        button1.setOnAction(e -> {
            window.setScene(scene2);
        });
        button2.setOnAction(e -> {
            window.setScene(scene1);
        });

        window.setScene(scene1); //Default scene
    }
}
