import Topics.AnonymousClasses_LambdaExpressions;
import Topics.SwitchingScenes;
import javafx.application.Application;
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


        SwitchingScenes switchingScenes = new SwitchingScenes(primaryStage);
        primaryStage.show();


    }
}
