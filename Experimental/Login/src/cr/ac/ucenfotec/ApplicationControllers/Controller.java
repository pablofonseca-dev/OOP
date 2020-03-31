package cr.ac.ucenfotec.ApplicationControllers;

import cr.ac.ucenfotec.Notification;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    public static Pattern pattern;
    public static Matcher matcher;
    //Minimum eight characters, at least one letter and one number.
    public static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    //Validate common input
    public static final String COMMON_INPUT_PATTERN = "[A-Za-z]{1,100}";
    //Validate email address
    public static final String EMAIL_ADDRESS_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\" +
            ".[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";


    public void changeSceneToLogin(Node anyNode){
        //Change scene to login
        try {
            Stage currentStage = (Stage) anyNode.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("../ApplicationViews/login.fxml"));
            BorderPane rootNode = (BorderPane) parent;
            Scene scene = new Scene(rootNode);
            currentStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Hay un problema, no se pudo cambiar la escena");
            e.printStackTrace();
        }
    }

    public void changeSceneToSignUp(Node anyNode){
        //Change scene to sign up
        try {
            Stage currentStage = (Stage) anyNode.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource("../ApplicationViews/signup.fxml"));
            BorderPane rootNode = (BorderPane) parent;
            Scene scene = new Scene(rootNode);
            currentStage.setScene(scene);
        } catch (IOException e) {
            System.out.println("Hay un problema, no se pudo cambiar la escena");
            e.printStackTrace();
        }
    }

    //Returns true if there is an error in the a common input
    public boolean validateCommonInput(String inputContent, Notification notification){
        //Initialize Common Input REGEX
        pattern = Pattern.compile(COMMON_INPUT_PATTERN);
        matcher = pattern.matcher(inputContent.trim());
        //If the user name is empty
        if(inputContent.isEmpty() || inputContent.isBlank()){
            notification.generateMessage(Notification.EMPTY_FIELD);
            return true;
        }
        //If the user name doesn't pass the name regular expression.
        if(!matcher.matches()){
            notification.generateMessage(Notification.REGEX_FAILED);
            return true;
        }
        return false;
    }

    //Returns true if there is an error in the email input
    public boolean validateEmailInput(String emailContent, Notification notification){
        //Initialize Email Input REGEX
        pattern = Pattern.compile(EMAIL_ADDRESS_PATTERN);
        matcher = pattern.matcher(emailContent.trim());
        //If the email is empty
        if(emailContent.isEmpty() || emailContent.isBlank()){
            notification.generateMessage(Notification.EMPTY_FIELD);
            return true;
        }
        //If the email doesn't pass the email standard regular expression.
        if(!matcher.matches()){
            notification.generateMessage(Notification.REGEX_FAILED);
            return true;
        }
        return false;
    }
    //Returns true if there is an error in a password input
    public boolean validatePasswordInput(String passwordContent, Notification notification){
        //Initialize Password REGEX
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(passwordContent.trim());
        //If the password is empty
        if(passwordContent.isBlank() || passwordContent.isEmpty()){
            notification.generateMessage(Notification.EMPTY_FIELD);
            return true;
        }
        //If the password doesn't pass the password regular expression.
        if(!matcher.matches()){
            notification.generateMessage(Notification.REGEX_FAILED);
            return true;
        }
        return false;
    }
}
