/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class Kitap extends DataBase{
    public int kitapID;
    public String kitapAdi;
    public String kitapYazari;
    public int kitapSayfa;
    public String kitapKategori;
    public String kitapYayinevi;
    
   
    
    public Kitap () throws Exception{
        this.kitapID = 0;
    }
    
    public Kitap (int kitapID, String kitapAdi, String kitapYazari, int kitapSayfa, String kitapKategori, String kitapYayinevi) throws Exception{
        this.kitapID=kitapID;
        this.kitapAdi=kitapAdi;
        this.kitapYazari=kitapYazari;
        this.kitapSayfa=kitapSayfa;
        this.kitapKategori=kitapKategori;
        this.kitapYayinevi=kitapYayinevi;
    }
    
    /*  Veritabanında kayıtlı kitapların tümünün listelenmesini sağlar. testMi parametresi 1 olduğunda
        sadece test verileri çekilir, diğer durumlarda uygulama verileri getirilir. */   
    public ArrayList<Kitap> listele() throws Exception{
        ResultSet rs=stmt.executeQuery("select * from kitaplar WHERE Test="+testMi);  
        ArrayList<Kitap> elemanlar = new ArrayList<Kitap>();
        while(rs.next())  {
            Kitap t = new Kitap();
            t.kitapID = rs.getInt("kitapID");
            t.kitapAdi = rs.getString("kitapAdi");
            t.kitapYazari = rs.getString("kitapYazari");
            t.kitapSayfa=rs.getInt("kitapSayfa");
            t.kitapKategori=rs.getString("kitapKategori");
            t.kitapYayinevi=rs.getString("kitapYayinevi");
            elemanlar.add(t);
        }
        return elemanlar;
    }
    
    /* Parametre olarak gelen kitap nesnesi veritabanına kaydedilir. */ 
    public void ekle(Kitap b) throws SQLException {
        //testMi=1 ise kitapID = "999" değilse kitapID = "null" yap 
        String kitapID = (testMi==1)?"999":"null";
        
        String query = "insert into kitaplar "
        + "(kitapID, kitapAdi, kitapYazari, kitapSayfa, kitapKategori, kitapYayinevi, Test)"
        + " values ("+kitapID+", '"+b.kitapAdi+"', '"+b.kitapYazari+"', '"+b.kitapSayfa+"', " 
        + "'"+b.kitapKategori+"', '"+b.kitapYayinevi+"',"+testMi+")";
        
        stmt.execute(query);
    }
    
    /* kitapID parametresine denk gelen kitabın kaydına ait tüm bilgileri veritabanından siler. */
    public void sil(int kitapID) throws SQLException {
        String query = " delete from kitaplar where kitapID = "+kitapID;
        
        stmt.execute(query);
    }
    
     /* kitapID'ye denk gelen satırın bilgilerini kitap nesnesinin bilgileri ile günceller.  */
    public void guncelle(int kitapID, Kitap b) throws SQLException {
        String query = " update kitaplar set kitapAdi='"+b.kitapAdi+"', kitapYazari='"+b.kitapYazari+"',"  
        + "kitapSayfa='"+b.kitapSayfa+"', kitapKategori='"+b.kitapKategori+"', "
        + "kitapYayinevi='"+b.kitapYayinevi+"' where kitapID = "+kitapID;
        
        stmt.execute(query);
    }
    
    /* Kitap adında veya yazarında parametre olarak girilen değeri arar.  */
    public ArrayList<Kitap> ara(String aranacakIfade) throws Exception{
        ResultSet rs=stmt.executeQuery("select * from kitaplar "
        + "where (kitapAdi LIKE '"+aranacakIfade+"%' or kitapYazari LIKE '"+aranacakIfade+"%') "
        + "AND Test="+testMi);  
        
        ArrayList<Kitap> elemanlar = new ArrayList<Kitap>();
        while(rs.next())  {
            Kitap t = new Kitap();
            t.kitapID = rs.getInt("kitapID");
            t.kitapAdi = rs.getString("kitapAdi");
            t.kitapYazari = rs.getString("kitapYazari");
            t.kitapSayfa = rs.getInt("kitapSayfa");
            t.kitapKategori=rs.getString("kitapKategori");
            t.kitapYayinevi=rs.getString("kitapYayinevi");
            elemanlar.add(t);
        }
        return elemanlar;
    }
}
