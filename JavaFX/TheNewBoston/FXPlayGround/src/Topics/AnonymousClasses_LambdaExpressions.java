package Topics;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AnonymousClasses_LambdaExpressions implements GetStages {

    JFXButton button;
    JFXButton button2;

    @Override
    public void getStage(Stage stage) throws Exception {
        stage.setTitle("Anonymous Classes and Lambda Expressions");
        button = new JFXButton();
        button2 = new JFXButton();

        StackPane root = new StackPane();
        button.setText("Click Me");
        button2.setText("Click Me!");
        //This is an inner anonymous class
        //even anonymous class are boring, so Oracle introduced lambda expressions since Java V 8.
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("I'm an anonymous inner class");
            }
        });

        //This is a modern lambda expression
        button2.setOnAction(e -> button2.setText("Clicked"));

        root.getChildren().addAll(button, button2);

        Scene scene = new Scene(root);

        stage.setScene(scene);

    }
}
