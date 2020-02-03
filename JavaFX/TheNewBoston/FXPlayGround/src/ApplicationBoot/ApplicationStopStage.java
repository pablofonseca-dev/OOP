package ApplicationBoot;

import Topics.ConfirmationBox;
import javafx.application.Platform;
import javafx.stage.Stage;

public class ApplicationStopStage {
    public static void finishLifeCycle(Stage primaryStage) {
        boolean confirmationValue = ConfirmationBox.display("Confirmation Box", "Are you sure to close the program?");
        if (confirmationValue) {
            System.out.println("Application Ended");
            Platform.exit();
        }
    }
}
