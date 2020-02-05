package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtractInputs implements GetStages{

    public ExtractInputs(Stage stage) throws Exception{
        this.getStage(stage);
    }
    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();

        TextField textField = new TextField();
        textField.setPromptText("Input your data here :)");
        JFXButton sendData = new JFXButton("Send!");
        sendData.setOnAction(actionEvent -> {
            //System.out.println(textField.getText());
            boolean result = isInt(textField);
            if(result){
                AlertBox.display("Alert Box", "The value is an integer number");
            }else{
                AlertBox.display("Alert Box", "The value is just text, not a number");
            }
        });
        root.getChildren().addAll(textField, sendData);


        //Don't modify this if you don't fucking know what to do :)
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

    public boolean isInt(TextField textField){
        boolean isInteger = false;
        try{
            int numberValue = Integer.parseInt(textField.getText());
            isInteger = true;
        }catch(NumberFormatException exception){}
        return isInteger;
    }

}
