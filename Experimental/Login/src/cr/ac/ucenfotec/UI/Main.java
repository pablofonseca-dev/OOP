package cr.ac.ucenfotec.UI;

import cr.ac.ucenfotec.TL.UserController;

public class Main {
    public static UserController userController;

    public static void main(String[] args) {
        userController = new UserController();
        userController.printWorkers();
    }

}
