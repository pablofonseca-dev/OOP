package cr.ac.ucenfotec;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Notification extends Alert {
    private String notificationMessage;

    public static final int EMPTY_FIELD = 1;
    public static final int REGEX_FAILED = 2;

    public Notification(AlertType alertType) {
        super(alertType);
    }

    public void generateMessage(int messageType){
        switch (messageType){
            case EMPTY_FIELD:
                this.notificationMessage = "Este campo no puede estar vacío";
                break;
            case REGEX_FAILED:
                this.notificationMessage = "El valor ingresado es inválido segun las normas";
                break;
        }
        setContentText(notificationMessage);
    }

}
