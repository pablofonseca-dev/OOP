package cr.ac.ucenfotec.UI;

import cr.ac.ucenfotec.BL.TimerTesting;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Timer_Use {

    public static void main(String[] args) {

        TimerTesting objTimeTesting = new TimerTesting(1);
        ActionListener objActionListener = new TimerTesting(1);

//        Timer objTimer = new Timer(1000, objTimeTesting);
//        objTimer.start();

        Timer objSecondTimer = new Timer(100, objActionListener);
        objSecondTimer.start();

        JOptionPane.showMessageDialog(null, "Pulsa para detener");

        System.exit(0);
    }

}
