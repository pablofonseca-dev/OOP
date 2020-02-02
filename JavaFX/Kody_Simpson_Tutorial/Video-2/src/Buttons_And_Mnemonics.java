// JFoenix Lib Imports
import com.jfoenix.controls.JFXButton;


// Java FX Libs Imports
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Buttons_And_Mnemonics extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setMinWidth(400);
        root.setMinHeight(500);

        JFXButton button_1 = new JFXButton();
        button_1.setStyle("-fx-font-size: 45px");
        button_1.setText("Republicans are really cool");
        //text wrapping -> for when the button text is too long.
        button_1.setWrapText(true);
        JFXButton button_2 = new JFXButton("Click Me!");
        //button sizing
        button_2.setMinSize(50, 50); //set the minimum size the button can be.
        button_2.setPrefSize(100, 100); //set the preferred size a button can be.
        button_2.setMaxSize(150, 150); //set the max size tht button can be.
        button_2.setStyle("-fx-background-color: #000");
        button_2.setStyle("-fx-text-fill: #000");
        root.getChildren().addAll(button_1, button_2);

        //Mnemonic - shortcut for buttons
        button_2.setMnemonicParsing(true); //Buttton can be selected and pressed with ALT R

        //We will test to see if it worked with an event
        //and lambda expression.
        button_2.setOnAction(e -> {
            System.out.println("Button tapped");
        });

        Scene scene = new Scene(root);

        stage.setTitle("Buttons and Mnemonics");
        stage.setHeight(500);
        stage.setWidth(400);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
