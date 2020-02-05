package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxes implements GetStages{

    //Constructor
    public CheckBoxes(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {

        //Check Boxes
        JFXCheckBox checkBox1 = new JFXCheckBox("Bacon");
        JFXCheckBox checkBox2 = new JFXCheckBox("Tuna");
        JFXCheckBox checkBox3 = new JFXCheckBox("Cheese");
        checkBox3.setSelected(true);

        //Buttons
        JFXButton button1 = new JFXButton("Order Now!");
        button1.setOnAction(actionEvent ->
        {
            handleOptions(checkBox1, checkBox2, checkBox3);
        });

        //Layout
        VBox root = new VBox();
        root.setPadding(new Insets(40, 20, 40, 20));

        //Add elements
        root.getChildren().addAll(
                checkBox1,
                checkBox2,
                checkBox3,
                button1
        );

        //Don't modify this if you don't fucking know what to do :)
        //root.setAlignment(Pos.CENTER);
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
    //Handle checkbox options
    private void handleOptions(JFXCheckBox... args){
        StringBuilder elementsSelected = new StringBuilder();
        for (JFXCheckBox arg : args) {
            if (arg.isSelected()) {
                elementsSelected.append(arg.getText()).append("\n");
            }
        }
        AlertBox.display("Alert Box", "Elements selected: \n" + elementsSelected);
    }
}
