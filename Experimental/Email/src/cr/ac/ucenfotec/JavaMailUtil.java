package cr.ac.ucenfotec;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class JavaMailUtil{

    public static int bombCounter = 0;

    //Receive the receiver of the mail
    public static void sendMail(String fromEmailAccount, String emailPassword, String toEmailAccount) throws MessagingException{
        //Properties is a key: value store like JSON
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(fromEmailAccount, emailPassword);
            }
        });

        //Prepare the message you want to send
        System.out.println(("<BOMB> " + "[" + (bombCounter + 1)) + "]");

        Message message = prepareMessage(session, fromEmailAccount, toEmailAccount);
        System.out.println("<<Attacking Target>>");
        Transport.send(message);
        bombCounter ++;
        //These are the four fields you need to configure in order to send an email.

        //mail.smtp.auth a note indication is needed to the email server fo for example: if is the smtp of Gmail is
        // mandatory to have a username and password to log into this maid right.

        //this is for TLS Encryption, in Gmail this value need to be true

        //this is the host, in every mail server you have a host and port, so for gmail is
        //mail.smtp.host = smtp.gmail.com

        //The port is 587 for Gmail
        //mail.smtp.port = 587
    }
    private static Message prepareMessage(Session session, String fromEmailAccount, String recipientEmailAccount) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(fromEmailAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmailAccount));
            message.setSubject("BOMB <" + bombCounter + ">");
            message.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam non interdum neque, et porttitor ligula. Sed blandit orci sed tellus sollicitudin fringilla. Aliquam erat volutpat. Pellentesque mattis, sem sit amet porta porta, lacus leo semper odio, ac bibendum ipsum sem elementum mi. Etiam cursus, ex vel pellentesque vulputate, metus metus lobortis lectus, ut dictum urna eros at tortor. Etiam lacus elit, porttitor pretium fermentum non, vulputate lobortis turpis. Cras convallis quam eu feugiat porttitor. Quisque convallis, sem eget volutpat dignissim, elit massa rutrum massa, a maximus mauris nibh sed neque.\n" +
                    "\n" +
                    "Ut laoreet congue mauris ac iaculis. Cras efficitur pulvinar neque vitae consequat. Sed luctus pretium lectus sed pretium. Praesent quis tellus nibh. Cras laoreet imperdiet est, at rhoncus mauris. Integer tincidunt iaculis erat eu porttitor. Aenean non consectetur dolor. Quisque sed porta augue. Nulla et sem nec metus lacinia lobortis sit amet vel augue. Phasellus eu luctus purus. Nulla at lectus quam. Sed pulvinar vitae tortor vel laoreet. Duis elementum finibus massa vel tincidunt.\n" +
                    "\n" +
                    "Sed vel odio sapien. Vestibulum blandit, neque sit amet vulputate varius, nisi lacus dictum mi, finibus tristique lacus odio ut mauris. Ut in arcu enim. Integer ut interdum justo. Nam ut lacus metus. Nam sit amet leo porta lectus aliquet tincidunt. Donec venenatis vehicula risus at consectetur. Integer pulvinar nibh lacinia tristique auctor. Curabitur non dolor libero. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec neque enim, elementum eu ante vel, maximus tincidunt ligula. Pellentesque a odio at velit suscipit pharetra id egestas est. Fusce auctor, dolor sit amet convallis pellentesque, leo lectus aliquam justo, pharetra tincidunt purus ante ut risus. Sed volutpat aliquet nunc.\n" +
                    "\n" +
                    "Maecenas eget enim dui. Nullam elit lorem, condimentum non sapien ut, malesuada tempor enim. Aenean faucibus leo at augue porta venenatis. Curabitur tristique interdum orci. Vivamus dolor sapien, viverra vitae interdum in, commodo ultricies ex. Phasellus in tincidunt libero, ut rutrum urna. Donec dignissim mi purus, id vehicula elit rutrum eget. Donec scelerisque sem vitae magna volutpat, vel aliquam arcu imperdiet. Mauris elit sapien, feugiat sit amet justo et, varius laoreet leo. Interdum et malesuada fames ac ante ipsum primis in faucibus.\n" +
                    "\n" +
                    "Integer porta bibendum laoreet. Vivamus rhoncus pulvinar justo, at pharetra eros imperdiet in. Maecenas a velit elit. Proin ornare ante et odio ornare, et pharetra libero dapibus. Donec porta pulvinar felis, vel placerat eros tincidunt sit amet. Quisque sed feugiat libero. Vestibulum lacinia nulla at finibus lobortis. Integer molestie mauris sed libero tempor, eu aliquam massa dictum. Vestibulum fringilla felis massa, at eleifend sem condimentum bibendum. Donec odio velit, bibendum vel cursus eu, sodales at urna. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc sed dapibus elit. Fusce ultrices blandit orci.");
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
