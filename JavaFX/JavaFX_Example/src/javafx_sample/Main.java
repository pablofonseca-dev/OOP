package javafx_sample;

import javafx.application.Application;
import javafx.stage.Stage;

//Scene and group classes are ways to organize our elements on a stage
//Java FX API (Application Programming Interface)
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Main extends Application{
    public static void main(String[] arguments){
        Application.launch(arguments);
    }

    @Override
    public void start(Stage stage){
        //Set command line arguments to read
        Integer width = 0;
        Integer height = 0;
        try {
            width = Integer.parseInt(getParameters().getNamed().get("width"));
            height = Integer.parseInt(getParameters().getNamed().get("height"));
        }catch(NumberFormatException number_format_exception){
            System.out.println("The values of height and width are Null");
            number_format_exception.printStackTrace();
        }
        System.out.println("List returned by getUnnamed method \n" + getParameters().getUnnamed());
        System.out.println("List returned by getRaw method \n" + getParameters().getRaw());
        //End
        stage.setTitle("Hello JavaFX");
        //to add a label we need to create a group object whose constructor takes an
        //area of UI Controls or nodes in JavaFX Terminology.

        Label label = new Label("Hello Label");
        Button button = new Button("Hello Button");

        Group group = new Group(label, button);
        //Group group = new Group(new Label("Hello Label")); It is the same.
        //Now we can't add the group directly to the stage. We have to enclose it in a scene.
        //Scene constructor takes three parameters: A container, width, and a height.
        //Group is a container.
        Scene scene = new Scene(group, width, height);
        stage.setScene(scene);
        stage.show();
    }
}

