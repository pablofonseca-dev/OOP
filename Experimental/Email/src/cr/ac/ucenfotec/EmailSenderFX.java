package cr.ac.ucenfotec;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmailSenderFX extends Application {

    EmailSenderController controller = new EmailSenderController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("EmailSenderUI.fxml"));
        primaryStage.setTitle("Email Bomber Attacking Tool");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        printLogo();
        System.out.println("<<Setup the Attack>>");
    }

    public void printLogo(){
        String mainLogo = "\n" +
                "                              _\\|/_\n" +
                "                                .\n"+
                "                          `--+--'\n" +
                "                             |\n" +
                "                      ,-'########`,\n" +
                "                      |###########|\n" +
                "                   _.-'###########`-._\n" +
                "                ,-'###################`-.\n" +
                "              ,'#########################`,         .___          \\|/ .__         .\n" +
                "             |#############################|        [__ ._ _  __  .|  [__) _ ._ _ |_  _ ._.\n" +
                "            |###############################|       [___[ | )[__|_||  [__)(_)[ | )[_)(/,[\n" +
                "           |#################################|\n" +
                "           |#################################|              Author: Pablo Fonseca. \n" +
                "            |###############################|               GitHub: pablofonseca-dev. \n" +
                "             \\############################/\n" +
                "              `.#########################,'\n" +
                "                `._###################_,'\n" +
                "                   `--..#########..--'            \n"
                ;

        System.out.println(mainLogo);
    }
}

