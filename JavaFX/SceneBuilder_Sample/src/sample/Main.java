package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
    public static void main(String... args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        If we want to access the
//        the text field in our Application class, we need to get a reference to the controller
//        object, for that, we need to create an FXMLLoader object using the constructor taking
//        the FXML URL object. And then using non-static load method without any attributes to load
//        the FXML. Once loaded, we can get a reference to the controller using getController method.
//        Once we have the controller, we can refer to text field like any other public field of class.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));


        // getResource method will create an URL object for the items
        // that are included in class path. You can also keep
        // this FXML separately and give its full path to load.
        Controller controller = loader.getController();
        //Set command line arguments to read
        Integer width = 0;
        Integer height = 0;
        try {
            width = Integer.parseInt(getParameters().getNamed().get("width"));
            height = Integer.parseInt(getParameters().getNamed().get("height"));
            System.out.println("List returned by getUnnamed method \n" + getParameters().getUnnamed());
            System.out.println("List returned by getRaw method \n" + getParameters().getRaw());
        } catch (NumberFormatException number_format_exception) {
            System.out.println("The values of height and width are Null, so they are no going to be assigned");
        }
        //Adding a new container
        GridPane grid_pane_layout = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene;
        if(width > 0 && height > 0) {
            scene = new Scene(grid_pane_layout, width, height);
            System.out.println("Configured custom width and height values : --width=" + width + " --height=" + height);
        }else {
            //By default
            scene = new Scene(grid_pane_layout, 600, 400);
            System.out.println("Added default width and height values : --width=600 --height=400");
        }
        primaryStage.setScene(scene);
        primaryStage.setTitle("Do-It!");
        //To make our application float on top of all other applications we can use
        //the method setAlwaysOnTop
        primaryStage.setAlwaysOnTop(false);
        //setResizable prevents from changing the width and height
        primaryStage.setResizable(true);
        primaryStage.show();
        //End
    }
}
