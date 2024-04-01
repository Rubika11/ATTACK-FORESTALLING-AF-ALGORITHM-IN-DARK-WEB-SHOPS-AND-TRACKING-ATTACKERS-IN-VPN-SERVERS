

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * 
 */
public class generate {
    String s="";
    public String gen()
    {
    try
    {
      
String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
Random rnd = new Random();
 s= chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+""+chars.charAt(rnd.nextInt(chars.length()))+"";
System.out.println(s);

    }
    catch(Exception e)
    {
    System.out.println(e);
    }
    return s;
    }
    
    
     
}
