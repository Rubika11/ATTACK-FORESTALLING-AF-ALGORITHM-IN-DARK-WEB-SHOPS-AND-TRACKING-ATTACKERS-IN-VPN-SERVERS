
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sivagnanam
 */
public class node4 extends javax.swing.JFrame {

    /**
     * Creates new form node1
     */
    public node4() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("node 4");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(320, 10, 120, 30);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(34, 43, 643, 157);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(165, 218, 373, 33);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setText("SUBMIT");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 270, 130, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BACK.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 710, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          send();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     Socket s;
     public void send()
    {
        
        
        
       
        try
        {
            
    
    
             s=new Socket("localhost",5001);
            System.out.println("connect");
        ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
          Vector a = new Vector() ;
       a.add(0,"hi");
       
        String ss="\nNODE4\n"+jTextField1.getText();
      long keyval1=1269;
			    ECIES crypt;
 


	            ECDomainParameters dp = ECDomainParameters.NIST_B_163();
            	ECPrivKey skA = new ECPrivKey(dp, BigInteger.valueOf(keyval1));
				System.out.println("the value skA is  "+skA);
    System.out.println("multiply");
    ECPubKey pkA = new ECPubKey(skA);
                                System.out.println("===>"+ss);
				crypt = new ECIES(skA, pkA, ss.getBytes()); // encrypt the data
				    System.out.println("the encrypted value is "+crypt);
                                    
                                  

       a.add(1,crypt);
    
       out.writeObject(a);
       
       
       
       
        ObjectInputStream inn=new ObjectInputStream(s.getInputStream());
                        String b =(String) inn.readObject();
                        System.out.println(b);
    
	out.flush();
	out.close();
	s.close();
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
        catch( Exception exe)
        {
            System.out.println(exe+"");
        }
    
        
        
       
    }
    
    
     /////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  ServerSocket ss;
      
    public void sstart()
    {
       
     
         try{
       
             
             
             
             
      ss =new ServerSocket(5005);
        String data;
         System.out.println("listening");
         
         while(true)
         {
              s=ss.accept();

         // jTextArea1.append(s.toString());
         
	ObjectInputStream inn=new ObjectInputStream(s.getInputStream());
   Vector   b=(Vector)inn.readObject();
   
      System.out.println("the received values is"+b);
     String bb=b.get(1).toString();
     long keyval1=1269;
     ECDomainParameters dp = ECDomainParameters.NIST_B_163();
			ECPrivKey skA = new ECPrivKey(dp, BigInteger.valueOf(keyval1));
     DerIOBuffer der = new DerIOBuffer(bb.getBytes());
					ECIES decrypt = der.toECIES();
					byte[] pt1 = decrypt.decrypt(skA); // decrypt the data
					String str1 = new String(pt1);
					System.out.println("the data is"+str1);
     
     
      jTextArea1.append("\n"+str1);
         
         
     if(bb.equals("close"))
     {
         this.setVisible(false);
     }
         
     ObjectOutputStream dis=new ObjectOutputStream(s.getOutputStream());
     dis.writeObject("ack");
   
         }
        }
        catch(Exception e)
        {
           System.out.println(e); 
        }
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(node1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(node1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(node1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(node1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        node4 bb=new node4();
           bb.setVisible(true);
           bb.sstart();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
