
import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties; 
import javax.mail.Authenticator;
import javax.mail.internet.AddressException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sivagnanam
 */
public class cyberm {
    private static final String SMTP_HOST_NAME = "smtp.mail.yahoo.com";
private static final String SMTP_AUTH_USER = "sivacan@yahoo.com";
private static final String SMTP_AUTH_PWD  = "kkqgtvwpvrsqlfqa";


    public void gm(String sm,String otp)
    {
             System.out.println("email"+sm);
     
            String   pay_email="";
             Session session;
            try
            {
           
            
            
            
         pay_email = sm;
        
         Properties properties = new Properties();
         
         

        properties.put("mail.smtp.host",SMTP_HOST_NAME);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  System.out.println("email>>2");
  
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sivacan@yahoo.com", "kkqgtvwpvrsqlfqa");
            }
        };
        
        
   System.out.println("email>>1");
         session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
      System.out.println("email>>"+sm);
        msg.setFrom(new InternetAddress("sivacan@yahoo.com"));
        InternetAddress[] toAddresses = { new InternetAddress(sm) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject("security code");
        msg.setSentDate(new Date());
        msg.setText(otp);
   System.out.println("email>>3");
        // sends the e-mail
        Transport.send(msg);
 
        

            
            } 
            catch(Exception e)
            {
               System.out.println(e);
                
            }}
    
    
    
    public void conf()
    {
    try{
       String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
        long diskSize = new File("/").getTotalSpace();
        String userName = System.getProperty("user.name");
        long maxMemory = Runtime.getRuntime().maxMemory();
        long memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
        System.out.println("Size of C:="+diskSize+" Bytes");
        System.out.println("User Name="+userName);

        System.out.println("RAM Size="+memorySize+" Bytes");
        
        
        String sett="\n"+"RAM Size="+memorySize+" Bytes"+"User Name="+userName+"Size of C:="+diskSize+" Bytes"+"Size of C:="+diskSize+" Bytes"+"Operating System: " + osName;
      
    }
    catch(Exception e)
    {
    System.out.println(e);
    
    }
    
    }
    
    
    
    
    
public static void main(String args[])
{

}
    
    
}
