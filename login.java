/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class login {
    public static void main(String[] args) {
        
         try{
            String mysqlJDBCDriver = "com.mysql.jdbc.Driver";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/mysql","root","");
            System.out.println("Connected to the database!"); 
            
          //  String query="select * fron bank where username and password";
          //String query="insert into bank where(username,password) values(?,?)";
          String query = "SELECT * FROM bank WHERE username = ? AND password = ?"; 
             
            try (PreparedStatement statement = con.prepareStatement(query))
            {
             Scanner sc = new Scanner(System.in);
                System.out.println("enter name:- ");
                String uname = sc.nextLine();
                System.out.println("enter password:- ");
                String pass = sc.nextLine();             
               statement.setString(1, uname);
               statement.setString(2, pass); 
               ResultSet resultSet = statement.executeQuery();
                if (resultSet.next())
                {
                System.out.println("Login successful!");
                // Add your login functionality here
            }
                else
                {
                System.out.println("Invalid username or password. Not logged in.");
            }            
            } 
            catch (SQLException e) {
                e.printStackTrace();
            } 
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
