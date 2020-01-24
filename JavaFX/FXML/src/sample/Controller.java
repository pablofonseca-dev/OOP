package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    /**
     * Initialize method
     */
    /*
        If we want to reference elements from FXML, we need
        to use FXML annotation and create a variable
        of same type and the name must be same as
        the value in fx: id attribute of the corresponding element.
        We can access the element inside the controller using the reference
        as usual. Let us search some value in initialize method. As I mentioned
        earlier, initialize method runs after the FXML is loaded.
     */
    @FXML
    public TextField textField;

    public void initialize(){
        textField.setText("This is set through controller");
    }
}
