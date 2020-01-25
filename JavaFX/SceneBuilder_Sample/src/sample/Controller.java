package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<?> taskTable;

    @FXML
    private TextField taskDescription;

    @FXML
    private Button addButton;

    @FXML
    private Spinner<Integer> progressSpinner;

    @FXML
    private CheckBox completedCheckBox;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<String> priorities; //This combo box accepts a list of string

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        progressSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0)
        );
        priorities.getItems().addAll("High", "Medium", "Low");

    }
}