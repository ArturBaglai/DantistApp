package sample.Controllers;

import com.sun.net.ssl.internal.ssl.Provider;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.awt.*;
import java.net.URL;
import java.security.Security;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

public  class NewMailMessageController {

    @FXML
    private ResourceBundle resourses;

    @FXML
    private URL location;

    @FXML
    private Button Sent;

    @FXML
     public TextField SentFrom;

    @FXML
   private TextField SentTo;
    @FXML
    private Button addFIle;

    @FXML
    private TextArea message;
    @FXML
    void initialize()
    {
        Sent.setOnAction(event-> {

            try {
                String host = "smtp.gmail.com";
                String user = SentFrom.getText();
                String pass = "fz6KR55Nst";
                String to = SentTo.getText();
                String from = SentFrom.getText();
                String subject = "Привет";
                String messageText = message.getText();
                boolean sessionDebug = false;

                Properties props = System.getProperties();
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);

                MimeMessage message = new MimeMessage(mailSession);
                message.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                message.setRecipients(Message.RecipientType.TO, address);
                message.setSubject(subject);
                message.setSentDate(new Date());
                message.setText(messageText);

                Multipart emailContent = new MimeMultipart();

                // text body content
                MimeBodyPart textBodyPart = new MimeBodyPart();
                textBodyPart.setText(messageText);


                emailContent.addBodyPart(textBodyPart);


                message.setContent(emailContent);
                Transport transport = mailSession.getTransport("smtp");
                transport.connect(host, user, pass);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                System.out.println("message send successfully");
            } catch (Exception var14) {
                System.out.println(var14);
            }
        });
    }
}
