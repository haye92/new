/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author msi
 */
public class Kisi extends DataBase{
    public int kisiID;
    public String kisiAdi;
    public String kisiSoyadi;
    public String kisiBolum;
       
    
    public Kisi () throws Exception{
        this.kisiID = 0;
    }
    
    public Kisi (int kisiID, String kisiAdi, String kisiSoyadi, String kisiBolum) throws Exception{
        this.kisiID=kisiID;
        this.kisiAdi=kisiAdi;
        this.kisiSoyadi=kisiSoyadi;
        this.kisiBolum=kisiBolum;
    }
        
/*  Veritabanında kayıtlı kişilerin tümünün listelenmesini sağlar. testMi parametresi 1 olduğunda
    sadece test verileri çekilir, diğer durumlarda uygulama verileri getirilir. */
public ArrayList<Kisi> listele() throws Exception{
    ResultSet rs=stmt.executeQuery("select * from kisiler WHERE Test = "+testMi);  
    ArrayList<Kisi> elemanlar = new ArrayList<Kisi>();
    while(rs.next())  {
        Kisi t = new Kisi();
        t.kisiID = rs.getInt("kisiID");
        t.kisiAdi = rs.getString("kisiAdi");
        t.kisiSoyadi = rs.getString("kisiSoyadi");
        t.kisiBolum=rs.getString("kisiBolum");
        elemanlar.add(t);
    }
    return elemanlar;
}
    
    /* Parametre olarak gelen kişi nesnesi veritabanına kaydedilir. */ 
public void ekle(Kisi k) throws SQLException {
    //testMi=1 ise kisiID = "999" değilse kisiID = "null" yap
    String kisiID = (testMi==1)?"999":"null"; 

    String query = " insert into kisiler (kisiID, kisiAdi, kisiSoyadi, kisiBolum, Test)"
    + " values ("+kisiID+", '"+k.kisiAdi+"', '"+k.kisiSoyadi+"', '"+k.kisiBolum+"',"+testMi+")";

    stmt.execute(query);
}
    
    /* kisiID parametresine denk gelen kisi kaydına ait tüm bilgileri veritabanından siler. */
public void sil(int kisiID) throws SQLException {
    String query = " delete from kisiler where kisiID = "+kisiID;

    stmt.execute(query);
}
    
    /* kisiID'ye denk gelen satırın bilgilerini kisi nesnesinin bilgileri ile günceller.  */
public void guncelle(int kisiID, Kisi k) throws SQLException {

    String query = " update kisiler set kisiAdi='"+k.kisiAdi+"', kisiSoyadi='"+k.kisiSoyadi+"', "
            + "kisiBolum='"+k.kisiBolum+"' where kisiID = "+kisiID;

    stmt.execute(query);
}
    
    /* Kişi adı veya soyadında parametre olarak girilen değeri arar.  */
public ArrayList<Kisi> ara(String aranacakIfade) throws Exception{
    ResultSet rs=stmt.executeQuery("select * from kisiler "
            + "where (kisiAdi LIKE '"+aranacakIfade+"%' or kisiSoyadi LIKE '"+aranacakIfade+"%') "
            + "AND Test="+testMi);  

    ArrayList<Kisi> elemanlar = new ArrayList<Kisi>();
    while(rs.next())  {
        Kisi t = new Kisi();
        t.kisiID = rs.getInt("kisiID");
        t.kisiAdi = rs.getString("kisiAdi");
        t.kisiSoyadi = rs.getString("kisiSoyadi");
        t.kisiBolum=rs.getString("kisiBolum");
        elemanlar.add(t);
    } 
    return elemanlar;
}   
}