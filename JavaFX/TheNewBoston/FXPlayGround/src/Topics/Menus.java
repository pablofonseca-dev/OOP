package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

        /*

        Check Menu Items, with it you could pretty much toggle a checkbox on and off. It's really good for options
        if you want to set or show line numbers to on or for turn line numbers off. Or auto-save to on or off
        So it's pretty much just like a checkbox but in a drop-down menu. So I'm gonna make another menu called a help
        menu
        * */
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(actionEvent -> {
            //Do you have a check mark or not?
            if(showLines.isSelected()){
                System.out.println("Program will now display line numbers");
            }else{
                System.out.println("Hiding line numbers");
            }
        });

        //You can also check the item by default
        CheckMenuItem autoSave = new CheckMenuItem("Auto Save");
        autoSave.setSelected(true);

        //Difficulty RadioMenuItems
        //With this you can only select one item at a time.
        Menu difficultyMenu = new Menu("Difficulty");
        //YOU DON'T NEED TO ADD A TOGGLE GROUP TO THE MENU, this could produce a Stack Overflow Error.
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        //Main Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(
                fileMenu,
                editMenu,
                helpMenu,
                difficultyMenu
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
