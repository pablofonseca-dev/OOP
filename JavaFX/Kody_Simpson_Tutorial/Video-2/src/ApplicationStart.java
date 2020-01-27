import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationStart extends Application {

    /*
    Before the application starts the init method is going to run
    whatever code is inside.
    This might be useful for loading pictures or loading assets and resources.
     */

    /*
        A Stage is basically a window.
        Only one scene can be displayed at a time on a stage.

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

        Stage secondStage = new Stage();
        secondStage.setTitle("Second Window");

        secondStage.setWidth(400);
        secondStage.setHeight(300);

        secondStage.setX(200);
        secondStage.setY(500);

        //Modality
        /*
        * Represent how you want the stages to interact with each other
        *
        * Modality.APPLICATION_MODAL what this will do is that other windows
        * cannot be used until this one is closed.
        *
        * Modality.NONE is the default value where you can interact with any window
        *
        * Modality.WINDOW_MODAL means that you cannot mess with the window
        * that owns this window until this windows closed. We need to give an owner
        * for the child window.
        * */
        Stage newWindow = new Stage();
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.initOwner(secondStage);
        //Init Style
        /*
        * Useful to initialize styles
        * StageStyle.DECORATED is the regular window, so we can change how the window
        * appears.
        * StageStyle.TRANSPARENT basically gonna make it invisible.
        * StageStyle.UTILITY useful in case you ever want to have like a simple
        * tool pop-up or like a Settings menu. That's basically what I would use it.
        * StageStyle.UNDECORATED is invisible because it's only going to show
        * constants of the window it's only going to show the constants of the window
        * it's not going to show the frame of the window. An undecorated window it's going
        * to be a regular window but with only the contents not the frame.
        * StageStyle.UNIFIED removes the border between the decoration area and the main content
        * area
        * */
        newWindow.initStyle(StageStyle.UNIFIED);
        secondStage.show();
        newWindow.show();
    }

    @Override
    public void stop() throws Exception{
        System.out.println("After");
    }
}


