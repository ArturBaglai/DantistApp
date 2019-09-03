package sample;

import com.sun.net.ssl.internal.ssl.Provider;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public  class MailSender {

    /**
     static PrintStream ps =null;

     static DataInputStream dis = null;

     public static void send (String str)
     throws IOException
     {
     ps.println(str);
     ps.flush();

     System.out.println("Сообщение отослано");
     }

     public static void receive()
     throws IOException
     {
     String readsrt=dis.readLine();
     System.out.println("SMTP-response: "+readsrt);
     }
     public static void sendEmail()
     {
     String hello="HELLO";
     String mailfrom = "MAIL FROM:kartartur@mail.ru";
     String rcptto = "RCPT TO: artur-baglai@mail.ru";
     String subject = "SUBJECT: Java is cool!";
     String data= "This is to my uncle";
     String body="Congratulations with first SMTP-channel to you";

     Socket smtp=null;
     try
     {
     smtp= new Socket("www.mail.ru",25);
     OutputStream os = new smtp.getOutputStream();
     ps = new PrintStream(os);
     InputStream is= smtp.getInputStream();
     dis = new DataInputStream(is);
     }catch (IOException e)
     {}

     try
     {
     String loc = "www.mail.ru";//InetAddress.getLocalHost().getHostName();

     send(hello+loc);
     receive();
     send(mailfrom);
     receive();
     send(rcptto);
     receive();
     send(data);
     receive();
     send(subject);
     receive();
     send(body);
     receive();
     smtp.close();
     }
     catch (IOException e)
     {}
     System.out.println("Mail sent");

     }

     */
    public static void SendEmail (){

    }
}
