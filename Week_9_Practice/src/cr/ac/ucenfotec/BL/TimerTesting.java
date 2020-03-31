package cr.ac.ucenfotec.BL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerTesting implements ActionListener {

    private int counter;

    public TimerTesting(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(counter);
        counter++;
    }
}
