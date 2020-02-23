package cr.ac.ucenfotec;

import com.jfoenix.controls.JFXButton;

public class ThreadsAlive implements Runnable{
    private Thread selectedThread;
    private JFXButton selectedButton;
    public ThreadsAlive(Thread thread, JFXButton selectedButton){
        this.selectedThread = thread;
        this.selectedButton = selectedButton;
    }
    @Override
    public void run(){
        boolean validationFlow = true;
        while(validationFlow){
            if(selectedThread.isAlive()){
                validationFlow = true;
                selectedButton.setDisable(true);
            }else{
                validationFlow = false;
                selectedButton.setDisable(false);
            }
        }
        try{
            Thread.sleep(4);
        }catch(InterruptedException interrupedException){
            interrupedException.printStackTrace();
        }
    }

}
