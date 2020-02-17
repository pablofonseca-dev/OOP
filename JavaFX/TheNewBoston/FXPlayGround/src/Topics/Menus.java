package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Menus implements GetStages{
    public Menus(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        //File Menu
        Menu fileMenu = new Menu("File");

        //Menu Items
        fileMenu.getItems().add(new MenuItem("New..."));
        fileMenu.getItems().add(new MenuItem("Open..."));
        fileMenu.getItems().add(new MenuItem("Save..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Exit"));

        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        MenuItem copy = new MenuItem("Copy");
        copy.setDisable(true);
        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("Pasting some crap"));
        editMenu.getItems().addAll(copy, paste);


        //Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                fileMenu,
                editMenu
        );

        root.setTop(menuBar);
        //Don't modify this if you don't fucking know what to do :)
        //Always remember to add a root layout.
        JFXButton closeStage = new JFXButton();
        closeStage.setText("Close");
        closeStage.setOnAction(actionEvent -> {
            ApplicationStopStage.finishLifeCycle(stage);});
        root.getChildren().addAll(closeStage);
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }
}
