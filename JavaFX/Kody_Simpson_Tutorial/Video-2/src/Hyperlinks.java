import javafx.application.Application;
import javafx.css.Stylesheet;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class Hyperlinks extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Episode 6 - Hyperlinks");
        stage.setWidth(400);
        stage.setHeight(500);

        VBox parentNode = new VBox();


        Image image = new Image("https://cdn.bitdegree.org/learn/pexels-photo-920220.jpeg?4d5e638c");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(100);
        Hyperlink hyperlink = new Hyperlink("Click Me!", imageView);
        Label label = new Label("Link not touched");

        hyperlink.setOnAction(e -> {
            label.setText("Link Touched");
        });

        parentNode.getChildren().addAll(hyperlink, label);
        Scene scene = new Scene(parentNode);
        scene.getStylesheets().add("./Stylesheets/CSS.css");
        stage.setScene(scene);
        stage.show();

    }
}
