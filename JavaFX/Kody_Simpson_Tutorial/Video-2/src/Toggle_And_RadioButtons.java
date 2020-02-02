import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Toggle_And_RadioButtons extends Application {
    public void start(Stage stage){
        VBox root = new VBox();
        root.setMinHeight(500);
        root.setMinWidth(700);
        Scene scene = new Scene(root);

        JFXToggleButton toggleButton = new JFXToggleButton();
        JFXToggleButton toggleButton1 = new JFXToggleButton();
        JFXToggleButton toggleButton2 = new JFXToggleButton();
        toggleButton.setText("Blue");
        toggleButton1.setText("Pink");
        toggleButton2.setText("Orange");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleButton.setToggleGroup(toggleGroup);
        toggleButton1.setToggleGroup(toggleGroup);
        toggleButton2.setToggleGroup(toggleGroup);

        //RadioButton extends ToggleButton, so it can be added to a toggle group.
        JFXRadioButton radioButton = new JFXRadioButton();
        JFXRadioButton radioButton1 = new JFXRadioButton();
        JFXRadioButton radioButton2 = new JFXRadioButton();
        radioButton.setText("Brown");
        radioButton1.setText("Purple");
        radioButton2.setText("Red");

        ToggleGroup toggleGroup1 = new ToggleGroup();
        radioButton.setToggleGroup(toggleGroup1);
        radioButton1.setToggleGroup(toggleGroup1);
        radioButton2.setToggleGroup(toggleGroup1);
        root.getChildren().addAll(
                toggleButton,
                toggleButton1,
                toggleButton2,
                radioButton,
                radioButton1,
                radioButton2

        );
        stage.setTitle("Menu Buttons");
        stage.setHeight(500);
        stage.setWidth(700);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }
}
