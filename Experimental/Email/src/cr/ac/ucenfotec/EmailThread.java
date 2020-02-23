
package cr.ac.ucenfotec;

import javax.mail.MessagingException;

public class EmailThread implements Runnable{
    private String fromEmailAccount;
    private String toEmailAccount;
    private String emailPassword;
    private int bombsNumber = 0;
    private boolean stop;
    public EmailThread(String fromEmailAccount, String emailPassword, String toEmailAccount, int bombsNumber){
        this.emailPassword = emailPassword;
        this.fromEmailAccount = fromEmailAccount;
        this.toEmailAccount = toEmailAccount;
        this.bombsNumber = bombsNumber;
    }
    @Override
    public void run() {
        try {
            for(int counter = 0; counter < bombsNumber; counter++) {
                JavaMailUtil.sendMail(fromEmailAccount, emailPassword, toEmailAccount);
                Thread.sleep(4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}