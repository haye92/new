/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/** 
 *
 * @author msi
 */
public class DataBase {
    public Connection con;
    public Statement stmt;
    public int testMi = 0;
    
    DataBase() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/kutuphaneotomasyon?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","");  
        stmt=con.createStatement();  
    }
    
    public void kapat() throws Exception{
        con.close();
    }
}

