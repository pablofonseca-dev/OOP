package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxes implements GetStages{
    //Constructor
    public ChoiceBoxes(Stage stage) throws Exception{
        this.getStage(stage);
    }
    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();
        JFXButton button = new JFXButton("Click Me!");

        //A choice box is a dropdown list
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();

        //Adding elements to the observable list
        choiceBox.getItems().addAll(
                "Avocado",
                "Tomato",
                "Pineapple",
                "Apple",
                "Lemon"
        );

        //Listen for selection changes: v> list item, oldValue: for example from lemon and newValue: for example to
        // Pineapple. Change the value from lemon to pineapple.
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableList, oldValue, newValue) -> {
            sendFruit(choiceBox);
        });
        button.setOnAction(actionEvent -> {
            sendFruit(choiceBox);
        });
        //Add Default value, must be something that already exist in the list.
        choiceBox.setValue("Avocado");

        //Add nodes to layout
        root.getChildren().addAll(
                choiceBox,
                button
        );


        //Don't modify this if you don't fucking know what to do :)
        //Always remember to add a root layout.
        root.setAlignment(Pos.CENTER);
        JFXButton closeStage = new JFXButton();
        closeStage.setText("Close");
        closeStage.setOnAction(actionEvent -> {
            ApplicationStopStage.finishLifeCycle(stage);});
        root.getChildren().add(closeStage);
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }

    public static void sendFruit(ChoiceBox<String> args){
        String fruitSelected = args.getValue();
        AlertBox.display("Alert Box", "Fruits selected: " + fruitSelected);
    }
}
