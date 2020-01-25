import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ApplicationStart extends Application {

    /*
    Before the application starts the init method is going to run
    whatever code is inside.
    This might be useful for loading pictures or loading assets and resources.
     */
    @Override
    public void init() throws Exception{
        System.out.println("Before");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
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
        //Adding a new layout
        GridPane grid_pane_layout = new GridPane();

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

    @Override
    public void stop() throws Exception{
        System.out.println("After");
    }
}


