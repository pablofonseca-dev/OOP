package cr.ac.ucenfotec.ApplicationControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;


public class SignUpController implements Initializable{

        @FXML
        private JFXTextArea user_nickname;

        @FXML
        private JFXTextArea user_email;

        @FXML
        private JFXTextArea user_password;

        @FXML
        private JFXButton signup_button;

        @FXML
        private Label signin_button;

        @FXML
        void createAccount(MouseEvent event) {

        }

        @FXML
        void login(MouseEvent event) {

        }
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }

    }
