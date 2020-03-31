package cr.ac.ucenfotec;


import javafx.scene.control.Alert;

public abstract class NotificationFactory {

    public static final int ERROR_NOTIFICATION = 1;
    public static final int WARNING_NOTIFICATION = 2;
    public static final int INFORMATION_NOTIFICATION = 3;
    public static Notification getNotificationFactory(int notificationType){
        switch(notificationType){
            case ERROR_NOTIFICATION:
                return new Notification(Alert.AlertType.ERROR);
            case WARNING_NOTIFICATION:
                return new Notification(Alert.AlertType.WARNING);
            case INFORMATION_NOTIFICATION:
                return new Notification(Alert.AlertType.INFORMATION);
            default:
                return null;
        }
    }





}
