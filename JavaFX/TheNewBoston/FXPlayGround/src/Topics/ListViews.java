package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViews implements GetStages{

    JFXListView<String> listView;
    public ListViews(Stage stage) throws Exception{
        this.getStage(stage);
    }
    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();
        listView = new JFXListView<String>();
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //Multiple Elements
        JFXButton sendData = new JFXButton("Send Data");
        sendData.setOnAction(
                actionEvent -> {printMovies();}
        );
        root.getChildren().addAll(listView, sendData);




        //Don't modify this if you don't fucking know what to do :)
        //Always remember to add a root layout.
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
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

    private void printMovies(){
        String message;
        //All the list that you work with in JavaFX are of type
        //Observable List.
        message = "Submitted Data\n";
        ObservableList<String> movies;
        movies = listView.getSelectionModel().getSelectedItems(); //All the selected items.
        for(String e: movies){
            message += e + "\n";
        }
        System.out.println(message);
    }
}
