/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vijayalakshmi
 */

import java.math.BigInteger;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sivagnanam
 */
public class d {
    
      public void enc(String ss)
   {
       try
       {
          long keyval1=1269;
			    ECIES crypt;
 


	            ECDomainParameters dp = ECDomainParameters.NIST_B_163();
            	ECPrivKey skA = new ECPrivKey(dp, BigInteger.valueOf(keyval1));
				System.out.println("the value skA is  "+skA);
    System.out.println("multiply");
    ECPubKey pkA = new ECPubKey(skA);
                                System.out.println(ss);
				crypt = new ECIES(skA, pkA, ss.getBytes()); // encrypt the data
				    System.out.println("the encrypted value is "+crypt);
                                    
                           dec(crypt);         
       }
       catch(Exception e)
       {
       System.out.println(e);
       }
      
   }
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      /////////////////////////////////////////////////////////////////////////////
      
      
      
      
      
      
      
      
       public void dec(ECIES bb)
   {
       try
       {
                                     long keyval1=1269;
     ECDomainParameters dp = ECDomainParameters.NIST_B_163();
			ECPrivKey skA = new ECPrivKey(dp, BigInteger.valueOf(keyval1));
                        
     DerIOBuffer der = new DerIOBuffer(bb);
					ECIES decrypt = der.toECIES();
					byte[] pt1 = decrypt.decrypt(skA); // decrypt the data
					String str1 = new String(pt1);
					System.out.println("the data is\t=>\t"+str1);
                                    
       }
       catch(Exception e)
       {
       System.out.println(e);
       }
      
   }
     
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       /////////////////////////////////////////////////////////////////////////////////////////////
     public static void main(String args[])
    {
    
    System.out.println("hi");
    
  
    d obj = new d();
    obj.enc("hi how are "
            + "you");
   
    
 
   
    }
}

