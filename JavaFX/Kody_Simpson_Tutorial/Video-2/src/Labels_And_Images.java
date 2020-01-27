import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Labels_And_Images extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Root Node
        VBox parentNode = new VBox();
        Image image = new Image("https://cdn.bitdegree.org/learn/pexels-photo-920220.jpeg?4d5e638c");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        Label label = new Label("Hello Mishi");
        label.setMinWidth(400);
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Color.web("Blue"));
        label.setFont(new Font("Consolas", 24));
        parentNode.getChildren().addAll(label, imageView);
        Scene primaryScene = new Scene(parentNode);
        stage.setTitle("Episode 5 - Images and Labels");
        stage.setWidth(400);
        stage.setHeight(400);
        stage.setScene(primaryScene);
        stage.show();
    }
}
