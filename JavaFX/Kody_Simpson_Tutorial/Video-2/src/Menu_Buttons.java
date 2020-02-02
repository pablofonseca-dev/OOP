// JFoenix Lib Imports
import com.jfoenix.controls.JFXButton;


// Java FX Libs Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Menu_Buttons extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setMinWidth(400);
        root.setMinHeight(500);

        //Menu Buttons
        //First, create the menu options
        MenuItem item1 = new MenuItem("Taco");
        MenuItem item2 = new MenuItem("Burrito");
        MenuItem item3 = new MenuItem("Cheese Enchilada");
        MenuItem item4 = new MenuItem("Chips & Salsa");

        //Now, create the main button to hold these options
        MenuButton menuButton = new MenuButton();
        menuButton.setMinSize(200, 100);
        menuButton.getItems().addAll(
                item1,
                item2,
                item3,
                item4
        );
        menuButton.setText("Favorite Mexican Food");

        Label food = new Label("No Food Selected");
        food.setStyle("-fx-font-size: 16px;");

        root.getChildren().addAll(menuButton, food);
        Scene scene = new Scene(root);

        //Add events for when an option is selected
        item1.setOnAction(e -> {
            food.setText("Food: Taco");
        });
        item2.setOnAction(e -> {
            food.setText("Food: Burrito");
        });
        item3.setOnAction(e -> {
            food.setText("Food: Cheese Enchilada");
        });
        item4.setOnAction(e -> {
            food.setText("Food: Cheeps & Salsa");
        });

        stage.setTitle("Menu Buttons");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}