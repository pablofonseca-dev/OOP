package cr.ac.ucenfotec;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class EmailSenderController implements Initializable {

    //FXML Properties - Nodes
    @FXML
    private TextField fromField;

    @FXML
    private TextField toField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField bombsField;
    @FXML
    private JFXButton sendButton;


    @FXML
    public void sendEmailEvent(ActionEvent actionEvent) throws Exception {
        String fromDestinationValue = this.fromField.getText();
        String toDestinationValue = this.toField.getText();
        String passwordValue = this.passwordField.getText();

        int bombsAmount = Integer.parseInt(this.bombsField.getText());
        this.toField.getText();
        if(!(fromDestinationValue.equalsIgnoreCase("") && toDestinationValue.equalsIgnoreCase("") && passwordValue.equalsIgnoreCase(""))){
            try {
                System.out.println("<[TRYING TO ATTACK]>");
                Runnable emailThread = new EmailThread(fromDestinationValue, passwordValue, toDestinationValue,
                        bombsAmount);
                Thread thread = new Thread(emailThread);
                thread.start();
                System.out.println("<<<New Background Thread Initialized>>>");
                Runnable threadLife = new ThreadsAlive(thread, sendButton);
                Thread existenceAnalyzer = new Thread(threadLife);
                existenceAnalyzer.start();
                thread.join();
                existenceAnalyzer.join();
                AttackFinishedNotificationFX notificationFX = new AttackFinishedNotificationFX();
            } catch(Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("All fields must be filled");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initializing Controllers...");
    }
    //FXML Event Handlers


}