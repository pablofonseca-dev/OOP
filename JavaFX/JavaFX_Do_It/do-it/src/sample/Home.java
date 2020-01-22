package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.*;

public class Home extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{

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

        Group g = new Group();
        //Button leaf nodes
        Button first_button = new Button("First Button");
        Button second_button = new Button("Second Button");
        second_button.setLayoutY(50);
        //Label leaf nodes
        Label first_label = new Label("First Label");
        first_label.setLayoutY(100);
        //Add only one node -> g.getChildren().add(button);
        //Add N Nodes
        g.getChildren().addAll(
                first_button,
                second_button,
                first_label
        );
        Scene scene = new Scene(g, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Do-It!");
        //To make our application float on top of all other applications we can use
        //the method setAlwaysOnTop
        primaryStage.setAlwaysOnTop(true);
        //setResizable prevents from changing the width and height
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] commandLine_args){
        Application.launch(commandLine_args);
    }
}
