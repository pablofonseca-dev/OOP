package cr.ac.ucenfotec.UI.FXApplications;

import cr.ac.ucenfotec.BL.Player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.MalformedURLException;


public class Main extends Application {
    Player player;
    FileChooser fileChooser;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Setting up the stages
        MenuItem open = new MenuItem("Open");
        Menu file = new Menu("File");
        MenuBar menu = new MenuBar();

        //Connecting the above three
        file.getItems().add(open);
        menu.getMenus().add(file);

        //Adding functionality to switch to different videos
        fileChooser = new FileChooser();
        open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Pausing the video while switching
                File file = fileChooser.showOpenDialog(primaryStage);

                //Choosing the file to play
                if(file != null){
                    try{
                        player = new Player(file.toURI().toURL().toExternalForm());
                        Scene scene = new Scene(player, Color.BLACK);
                        primaryStage.setScene(scene);
                    }catch(MalformedURLException urlException){
                        System.out.println("Malformed URL Exception");
                        urlException.printStackTrace();
                    }
                }
            }
        });
        //Here you can choose any video
        player = new Player(getClass().getResource("cybertruck.mp4").toExternalForm());

        player.setTop(menu);
        //Setting the menu to the Scene
        Scene scene = new Scene(player, 720, 535, Color.BLACK);

        //Height and Width of the Video Player
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
