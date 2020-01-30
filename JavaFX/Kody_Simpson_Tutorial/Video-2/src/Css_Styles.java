import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Css_Styles extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setMinWidth(400);
        root.setMinHeight(500);
        Label label = new Label("This is a label leaf node");

        root.getChildren().add(label);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("./Stylesheets/CSS.css");
        stage.setTitle("CSS Styles Stage");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
