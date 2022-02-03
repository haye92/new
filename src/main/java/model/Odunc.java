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
import javax.swing.JOptionPane;

/**
 *
 * @author msi
*/

public class Odunc extends DataBase { 
    public String kisiAdi, kitapAdi;
    public String emanetTarihi, iadeTarihi;
    public int islemID;
    
    public Odunc(String kisiAdi, String kitapAdi, String emanetTarihi, String iaderTarihi) throws Exception {
        this.kisiAdi = kisiAdi;
        this.kitapAdi = kitapAdi;
        this.emanetTarihi = emanetTarihi;
        this.iadeTarihi = iaderTarihi;
    }
                
    public Odunc() throws Exception{

    }
    
    /*  Veritabanında kayıtlı olan kişi ve kitap eşleşmelerinin tümünü listeler. 
        testMi parametresi 1 olduğunda sadece test verileri çekilir. */  
public ArrayList<Odunc> listele() throws Exception{
    ResultSet rs=stmt.executeQuery("SELECT * FROM emanetkitap "
            + "INNER JOIN kitaplar ON kitaplar.kitapID = emanetkitap.kitapID "
            + "INNER JOIN kisiler ON kisiler.kisiID = emanetkitap.kisiID "
            + "HAVING emanetkitap.Test="+testMi);  

    ArrayList<Odunc> elemanlar = new ArrayList<Odunc>();
    while(rs.next())  {
        Odunc t = new Odunc();
        t.kisiAdi = rs.getString("kisiAdi");
        t.kitapAdi=rs.getString("kitapAdi");
        t.emanetTarihi=rs.getString("emanetTarihi");
        t.iadeTarihi=rs.getString("iadeTarihi");
        t.islemID=rs.getInt("islemID");
        elemanlar.add(t);
    }
    return elemanlar;
}
  
    
    /* Parametre olarak gelen kisiID'ye sahip kişiye yine parametre olarak gelen kitapID'ye sahip kitabı 
     sistem tarihi baz alınarak ödünç verilir. Ayrıca baz alınan sistem tarihinin  15 gün sonrası için 
     müddet tarihi belirlenir. */
public void oduncver(int kisiID, int kitapID) throws SQLException{ 
    //testMi=1 ise islemID = "999" değilse islemID = "null" yap
    String islemID = (testMi==1)?"999":"null";

    Date simdikiZaman = new Date();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String tarih = df.format(simdikiZaman);

    long theFuture = System.currentTimeMillis() + (86400 * 64 * 1000);
    Date ahy = new Date(theFuture);
    String muddet = df.format(ahy);

    String query = " insert into emanetkitap (islemID, kisiID, kitapID, emanetTarihi, muddet, Test)"
    + " values ("+ islemID +",'"+kisiID+"', '"+kitapID+"', '"+tarih+"', '"+muddet+"',"+testMi+")";

    stmt.execute(query);
}  
    
    /*Test işlemleri esnasında eklenen ödünç kayıtlarını silmek için kullanılmaktadır */
    public void oduncSil(String ID) throws SQLException{
        String query = "delete from emanetKitap where islemID="+ID;
        
        stmt.execute(query); 
    }
    
    /* Kitap iadesi işlemini gerçekleştirir. ucretHesapla fonksiyonunu kullanır. Üyenin ödemesi gereken 
    borç var ise bu borcu program kullanıcısına gösterir. Sistem tarihi alınarak veritabanında iadeTarihi
    kısmını günceller.*/
public void iadeal(String islemID) throws Exception{
    Date simdikiZaman = new Date();
    int yil = simdikiZaman.getYear()+1900;
    int ay = simdikiZaman.getMonth()+1;
    int gun = simdikiZaman.getDate();
    String veritabaniFormatindaTarih = yil+"-"+ay+"-"+gun;

    //geç gelme süresi hesapla..
    double ucret = ucretHesapla(islemID); 

    if(ucret > 0)
        JOptionPane.showMessageDialog(null, "Ödenmesi gereken ücret = "+ucret+"TL");

    String query = "update emanetkitap set iadeTarihi='"+veritabaniFormatindaTarih+"' "
    + "where islemID="+islemID;
    stmt.execute(query);
}
    
    /*emanetGunHesapla fonksiyonunu kullanır. Kullanıcıların 15 güne kadar kitapları geri getirmesi 
    beklenir. Ücret negatif değer çıktığında iadeal fonksiyonu tarafından yok sayılır. Geçen gün sayısnın 
    birim ücret olan 2 TL ile çarpılması sonucu ödenmesi gereken tutar hesaplanır.*/
public double ucretHesapla(String islemID) throws Exception {
    double gecGelenGunSayisi = emanetGunHesapla(islemID)-15; // 10 günden fazlası geç gelmiş sayılsın
    return gecGelenGunSayisi * 2; 
}
    
    /*Emanet alınan tarih ile o kitabın teslim tarihi arasında geçen gün sayısı hesaplanır. 
    Hesaplanan tarihler arasındaki fark milisaniye cinsinden olduğu için 
    son aşamada 86.400.000 (24*60*60*1000)'e bölünür */
public double emanetGunHesapla(String islemID) throws Exception {
    String emanetTarihi;
    ResultSet rs=stmt.executeQuery("SELECT * FROM emanetkitap WHERE islemID = "+islemID);  
    if(rs.next())  {
        emanetTarihi =rs.getString("emanetTarihi");  

        //Okunan tarihi integere çevirme
        String tarih[] = emanetTarihi.split("-");
        int yil = Integer.parseInt(tarih[0]) - 1900;
        int ay = Integer.parseInt(tarih[1]) - 1;
        int gun = Integer.parseInt(tarih[2]);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date simdikiTarih = sdf.parse(sdf.format(new Date()));  
        Date alinmaZamani = new Date(yil,ay,gun);

        long gecenSure = simdikiTarih.getTime() - alinmaZamani.getTime();  
        return Math.ceil(gecenSure / 86400000);
    }
    return -1;
}
    
}
