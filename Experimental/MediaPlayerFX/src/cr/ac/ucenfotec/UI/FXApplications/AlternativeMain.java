package cr.ac.ucenfotec.UI.FXApplications;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AlternativeMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private double xOffset = .0;
    private double yOffset = .0;
    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try{
            root = FXMLLoader.load(getClass().getResource("../FXML/MediaPlayerFXML.fxml"));
            //This events are designed to enable reposition in "X" and "Y" axis.
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    xOffset = mouseEvent.getSceneX();
                    yOffset = mouseEvent.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    primaryStage.setX(mouseEvent.getScreenX() - xOffset);
                    primaryStage.setY(mouseEvent.getScreenY() - yOffset);
                }
            });
            System.out.println("FXML Found");
            Scene scene = new Scene(root);
            //Set full-screen in the media player stage when double-click the scene.
            scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent clicksAmount) {
                    if(clicksAmount.getClickCount() == 2){
                        primaryStage.setFullScreen(true);
                    }
                    if(clicksAmount.getClickCount() == 3){
                        primaryStage.setFullScreen(false);
                    }
                }
            });
            primaryStage.setScene(scene);
            System.out.println("Displaying the primary stage");
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            primaryStage.show();
        }catch(IOException ioException){
            ioException.printStackTrace();
            System.out.println("FXML Not Found in Alternative Main");
        }catch(Exception otherException){
            otherException.printStackTrace();
        }
    }
}
