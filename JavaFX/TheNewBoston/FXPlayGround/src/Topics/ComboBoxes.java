package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxes implements GetStages{
    JFXComboBox<String> comboBox;

    public ComboBoxes(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();

        comboBox = new JFXComboBox<String>();
        comboBox.getItems().addAll(
                "Good Will Hunting",
                "St. Vincent",
                "BlackHat"
        );
        comboBox.setValue("What's your favorite movie?");
        JFXButton sendData = new JFXButton("Send Data");
        sendData.setOnAction(actionEvent -> {
            printMovie();
        });
        comboBox.setEditable(true);
        root.getChildren().addAll(
                comboBox,
                sendData
        );
        //Don't modify this if you don't fucking know what to do :)
        //Always remember to add a root layout.
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
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

    //Print out a movie
    private void printMovie(){
        System.out.println(comboBox.getValue());
        boolean validation = false;
        for(int i = 0; i < comboBox.getItems().size(); i++){

            if(comboBox.getItems().get(i).equalsIgnoreCase(comboBox.getValue())){
                validation = true;
                break;
            }else{
                validation = false;
            }
        }
        if(!validation){
            comboBox.getItems().add(comboBox.getValue());
        }
    }

}
