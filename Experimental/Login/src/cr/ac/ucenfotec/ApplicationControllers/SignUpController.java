package cr.ac.ucenfotec.ApplicationControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import cr.ac.ucenfotec.Notification;
import cr.ac.ucenfotec.NotificationFactory;
import cr.ac.ucenfotec.TL.UserController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpController extends Controller implements Initializable {

        @FXML
        private JFXTextArea nombreUsuario;

        @FXML
        private JFXTextArea claveSeguridad;

        @FXML
        private JFXButton registrarse;

        @FXML
        private Label iniciarSesion;

        @FXML
        private JFXTextArea correoElectronico;
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                UserController userController = new UserController();
                registrarse.setOnAction(actionEvent -> {
                        Notification errorNotificationInstance =
                                NotificationFactory.getNotificationFactory(NotificationFactory.ERROR_NOTIFICATION);
                        Notification informationNotificationInstance =
                                NotificationFactory.getNotificationFactory(NotificationFactory.INFORMATION_NOTIFICATION);
                        boolean informationSucceed = validateInformation();
                        if(informationSucceed){
                                //Check if there is already an admin
                                if(userController.validateAdministratorExistence()){
                                        assert errorNotificationInstance != null;
                                        errorNotificationInstance.setContentText("Ya se encuentra registrado un administrador\n" +
                                                "Proceda a iniciar su sesión");
                                        errorNotificationInstance.showAndWait();
                                }else{
                                        //Send the information to the database
                                        userController.logAdministrator(nombreUsuario.getText(), claveSeguridad.getText(),
                                                correoElectronico.getText());
                                        assert informationNotificationInstance != null;
                                        informationNotificationInstance.setContentText("El administrador se registró correctamente\n" +
                                                "Proceda a iniciar sesión");
                                        informationNotificationInstance.showAndWait();
                                        //Then
                                        changeSceneToLogin(iniciarSesion);
                                }
                        }
                });
        }

        @Override
        public void changeSceneToLogin(Node anyNode) {
                super.changeSceneToLogin(anyNode);
        }

        public boolean validateInformation(){
                Notification notification =
                        NotificationFactory.getNotificationFactory(NotificationFactory.WARNING_NOTIFICATION);
                //Validate name
                if(validateCommonInput(this.nombreUsuario.getText(), notification)){
                        assert notification != null;
                        notification.setTitle("ERROR EN EL NOMBRE");
                        notification.showAndWait();
                        return false;
                }
                //Validate password
                else if(validatePasswordInput(this.claveSeguridad.getText(), notification)){
                        assert notification != null;
                        notification.setTitle("ERROR EN LA CLAVE");
                        notification.showAndWait();
                        return false;
                }
                //Validate email
                else if(validateEmailInput(this.correoElectronico.getText(), notification)){
                        assert notification != null;
                        notification.setTitle("ERROR EN EL CORREO ELECTRÓNICO");
                        notification.showAndWait();
                        return false;
                }
                else{
                        return true;
                }
        }


        public void changeSceneToLogin(MouseEvent mouseEvent) {
                changeSceneToLogin(registrarse);
        }
}
