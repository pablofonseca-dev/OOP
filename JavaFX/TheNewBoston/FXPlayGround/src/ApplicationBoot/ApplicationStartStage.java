package ApplicationBoot;

import Topics.*;
import javafx.application.Application;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ApplicationStartStage extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Set command line arguments to read
        Integer width = 0;
        Integer height = 0;
        boolean definedCustomValues;
        try {
            width = Integer.parseInt(getParameters().getNamed().get("width"));
            height = Integer.parseInt(getParameters().getNamed().get("height"));
            System.out.println("Custom Height: " + height);
            System.out.println("Custom Width: " + width);
            definedCustomValues = true;
        } catch (NumberFormatException ignored){
            definedCustomValues = false;
        }

        if(definedCustomValues){
            primaryStage.setHeight(height);
            primaryStage.setWidth(width);
        }else{
            primaryStage.setHeight(700);
            primaryStage.setWidth(900);
        }
        //Confirmations confirmations = new Confirmations(primaryStage);
        //EmbeddingLayouts embeddingLayouts = new EmbeddingLayouts(primaryStage);
        //GridPanes gridPanes = new GridPanes(primaryStage);
        //ExtractInputs  extractInputs = new ExtractInputs(primaryStage);
        //CheckBoxes checkBoxes = new CheckBoxes(primaryStage);
        ChoiceBoxes choiceBoxes = new ChoiceBoxes(primaryStage);
        primaryStage.show();


    }
}
