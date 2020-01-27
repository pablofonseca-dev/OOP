import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Css_Styles extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox parentNode = new VBox();
        parentNode.setMinWidth(400);
        parentNode.setMinHeight(500);
        Label label = new Label("This is a label leaf node");

        parentNode.getChildren().add(label);

        Scene scene = new Scene(parentNode);
        scene.getStylesheets().add("./Stylesheets/CSS.css");
        stage.setTitle("CSS Styles Stage");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
