package sample;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.*;

public class Main extends Application{
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

        //Adding a new container
        GridPane grid_pane_layout = new GridPane();
        // We don't need this group object any more -> Group g = new Group();
        //Button leaf nodes
        Button first_button = new Button("First Button");
        Button second_button = new Button("Second Button");
        Button third_button = new Button("Third Button");
        Button fourth_button = new Button("Fourth Button");
        //We have to set constraint on the button.
        //setConstraints takes three arguments in its simplest
        //form. Node name, column index and row index.
        //Changing one object increases the width of the column in
        //which it is placed, unless we set a different constraint
        //on width of the column.
        GridPane.setConstraints(first_button, 1, 1);
        GridPane.setConstraints(second_button, 2, 1);
        GridPane.setConstraints(third_button, 1, 2);
        GridPane.setConstraints(fourth_button, 2, 2);
        //Label leaf nodes
        Label first_label = new Label("First Label");
        GridPane.setConstraints(first_label, 1, 3);
        //Add only one node -> g.getChildren().add(button);
        //To make grid lines visible use setGridLinesVisible Method
        grid_pane_layout.setGridLinesVisible(true);
        //To set some gap between cell, we can use setHGap method
        grid_pane_layout.setHgap(10); //Set Horizontal Grid Gap
        grid_pane_layout.setVgap(10); //Set Vertical Grid Gap

        BorderPane border_pane_layout = new BorderPane();
        border_pane_layout.setTop(new Button("Top"));
        border_pane_layout.setBottom(new Button("Bottom"));
        border_pane_layout.setLeft(new Button("Left"));
        border_pane_layout.setRight(new Button("Right"));
        int columnIndex = 1;
        int rowIndex = 4;
        int columnSpan = 2; //Occupy two columns
        int rowSpan = 1; //Occupy two rows
        GridPane.setConstraints(
                border_pane_layout,
                columnIndex,
                rowIndex,
                columnSpan,
                rowSpan);

        //Add N Nodes
        grid_pane_layout.getChildren().addAll(
                first_button,
                second_button,
                third_button,
                fourth_button,
                first_label,
                border_pane_layout
        );
        Scene scene = new Scene(grid_pane_layout, width, height);
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
