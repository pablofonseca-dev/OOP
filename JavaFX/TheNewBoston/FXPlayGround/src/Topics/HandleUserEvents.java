package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HandleUserEvents implements EventHandler<ActionEvent>, GetStages {

    JFXButton button;
    JFXButton button2;

    @Override
    public void getStage(Stage stage) throws Exception{
        stage.setTitle("The New Boston: Handle User Events");
        button = new JFXButton();
        StackPane root = new StackPane();
        button.setText("Click Me");

        button.setOnAction(this::handle);
        button2.setOnAction(this::handle);

        root.getChildren().addAll(
                button,
                button2
        );

        Scene scene = new Scene(root);

        stage.setScene(scene);
    }
    @Override
    public void handle(ActionEvent event){
        if(event.getSource() == button){
            System.out.println("Button one mashed!");
        }
        if(event.getSource() == button2){
            System.out.println("Button two mashed!");
        }

    }

}