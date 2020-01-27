import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Scene Graph is a theoretical hierarchy

public class Scenes extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //A layout manager is usually the top level tag in the root.
        //Root Pane
        VBox root = new VBox();

        //Leaf Nodes
        Label labelOne = new Label("Hello, I'm a node");
        Label labelTwo = new Label("Hello, I'm a node too :)");
        root.getChildren().addAll(labelOne, labelTwo);

        //Scenes and it's layouts are branch nodes.
        //Controls are leaf nodes like label.
        //Scenes.
        Scene sceneOne = new Scene(root);
        sceneOne.setCursor(Cursor.CROSSHAIR);

        stage.setTitle("Scenes Stage");
        stage.setWidth(400);
        stage.setHeight(500);
        stage.setScene(sceneOne);
        stage.show();

    }
}
