package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class GridPanes implements GetStages{
    public GridPanes(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {

        GridPane root = new GridPane();

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setVgap(8);
        root.setHgap(10);

        //Name Label
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Paul");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passwordLabel = new Label("Password: ");

        //setConstraints 1. Node 2. Column  3. Row
        GridPane.setConstraints(passwordLabel, 0, 1);

        //Password Input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);

        //Login Button
        JFXButton loginButton = new JFXButton();
        loginButton.setText("Login");
        GridPane.setConstraints(loginButton, 0, 3);

        root.getChildren().addAll(
                nameLabel,
                nameInput,
                passwordLabel,
                passwordInput,
                loginButton
        );
        //Don't modify this if you don't fucking know what to do :)
        JFXButton closeStage = new JFXButton();
        closeStage.setText("Close");

        closeStage.setOnAction(actionEvent -> {ApplicationStopStage.finishLifeCycle(stage);});
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }


}