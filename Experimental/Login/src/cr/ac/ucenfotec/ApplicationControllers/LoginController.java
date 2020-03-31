package cr.ac.ucenfotec.ApplicationControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import cr.ac.ucenfotec.Notification;
import cr.ac.ucenfotec.NotificationFactory;
import cr.ac.ucenfotec.TL.UserController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {

    @FXML
    private JFXTextArea correoElectronico;

    @FXML
    private JFXTextArea claveSeguridad;

    @FXML
    private JFXButton ingresar;

    @FXML
    void registrarse(MouseEvent event) {
        super.changeSceneToSignUp(ingresar);
    }

    @FXML


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserController userController = new UserController();
        ingresar.setOnAction(actionEvent ->{
            Notification errorNotificationInstance =
                    NotificationFactory.getNotificationFactory(NotificationFactory.ERROR_NOTIFICATION);
            Notification informationNotificationInstance =
                    NotificationFactory.getNotificationFactory(NotificationFactory.INFORMATION_NOTIFICATION);
            boolean informationSucceed = validateInformation();
            if(informationSucceed){
                //Check if there is already an admin
                if(userController.validateAdministratorExistence()){
                    //Validate administrator credentials
                    if(userController.validateAdministratorCredentials(this.correoElectronico.getText().trim(),
                            this.claveSeguridad.getText().trim())){
                        System.out.println("Los datos son correctos");
                        assert informationNotificationInstance != null;
                        informationNotificationInstance.setContentText("Inicio de sesión exitoso");
                        informationNotificationInstance.showAndWait();
                    }else{
                        assert errorNotificationInstance != null;
                        errorNotificationInstance.setContentText("El correo electónico o la contraseña no son válidos");
                        errorNotificationInstance.showAndWait();
                    }
                }else{
                    //Notifies that there is not an admin in the database.
                    assert errorNotificationInstance != null;
                    errorNotificationInstance.setContentText("No se pudo realizar la operación, no hay un administrador registrado");
                    errorNotificationInstance.showAndWait();
                    //Then
                    changeSceneToSignUp(ingresar);
                }
            }
        });

    }

    public boolean validateInformation(){
        Notification notification =
                NotificationFactory.getNotificationFactory(NotificationFactory.WARNING_NOTIFICATION);
        //Validate password
       if(validatePasswordInput(this.claveSeguridad.getText(), notification)){
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


}
