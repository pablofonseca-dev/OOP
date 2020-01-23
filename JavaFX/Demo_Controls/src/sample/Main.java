package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Set command line arguments to read
        Integer width = 0;
        Integer height = 0;
        try {
            width = Integer.parseInt(getParameters().getNamed().get("width"));
            height = Integer.parseInt(getParameters().getNamed().get("height"));
        } catch (NumberFormatException number_format_exception) {
            System.out.println("The values of height and width are Null");
            number_format_exception.printStackTrace();
        }
        System.out.println("List returned by getUnnamed method \n" + getParameters().getUnnamed());
        System.out.println("List returned by getRaw method \n" + getParameters().getRaw());
        //End

        GridPane grid = new GridPane();

        //Grid Settings
        grid.setMinHeight(400);
        grid.setMinWidth(600);
        grid.setHgap(20);
        grid.setVgap(5);
        grid.setGridLinesVisible(false);

        TableView table = new TableView();
        table.setMinHeight(350);
        table.setMinWidth(550);

        TableColumn column1 = new TableColumn("Priority");
        TableColumn column2 = new TableColumn("Description");
        TableColumn column3 = new TableColumn("Progress");
        table.getColumns().addAll(
                column1,
                column2,
                column3
        );

        GridPane.setConstraints(table, 1, 1, 3, 1);

        TextField taskName = new TextField();
        taskName.setPromptText("Enter Task Name");
        taskName.setText("Default Text");
        taskName.setMinWidth(300);
        GridPane.setConstraints(taskName, 2, 2);

        ComboBox priority = new ComboBox();
        priority.getItems().addAll("High", "Low", "Medium");
        priority.setPromptText("Enter Priority");

        GridPane.setConstraints(priority, 1, 2);

        Button addButton = new Button("Add");
        addButton.setMinWidth(100);
        GridPane.setConstraints(addButton, 3, 2);

        Button cancelButton = new Button("Cancel");
        cancelButton.setMinWidth(100);
        GridPane.setConstraints(cancelButton, 3, 3);

        HBox progressArea = new HBox();
        progressArea.getChildren().addAll(
                new Label("Progress Area"),
                new Spinner<Integer>(0, 100, 0),
                new CheckBox("Completed")
        );
        progressArea.setAlignment(Pos.CENTER_RIGHT);
        progressArea.setSpacing(10);

        GridPane.setConstraints(progressArea, 1, 3, 2, 1);

        grid.getChildren().addAll(
                table,
                taskName,
                priority,
                addButton,
                cancelButton,
                progressArea
        );
        Scene scene = new Scene(grid, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Demo Controls");
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] commandLine_args){
        Application.launch(commandLine_args); //Launch command line arguments.
    }
}
