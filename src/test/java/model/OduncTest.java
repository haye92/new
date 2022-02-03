/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lenovo
 */
public class OduncTest {

    Odunc o;
    
    public OduncTest() throws Exception {
    	o = new Odunc();
        o.testMi = 1;
    }
    
    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

   
@Test
public void testListele() throws Exception {
    System.out.println("listele");
/*
    ArrayList<Odunc>  veritabaniOdunc = o.listele();

    ArrayList<Odunc> kontrolOdunc = new ArrayList<>();
    kontrolOdunc.add(new Odunc("kisiAdi Test 3","kitapAdi Test 1", "2021-01-07",null));
    kontrolOdunc.add(new Odunc("kisiAdi Test 3","kitapAdi Test 2", "2021-01-07",null));
    kontrolOdunc.add(new Odunc("kisiAdi Test 3","kitapAdi Test 3", "2021-01-07",null));
    kontrolOdunc.add(new Odunc("kisiAdi Test 2","kitapAdi Test 1", "2021-01-07",null));
    kontrolOdunc.add(new Odunc("kisiAdi Test 1","kitapAdi Test 1", "2021-01-03",null));

    for (int i = 0; i < veritabaniOdunc.size(); i++) {
        assertEquals(veritabaniOdunc.get(i).kitapAdi, kontrolOdunc.get(i).kitapAdi);
        assertEquals(veritabaniOdunc.get(i).kisiAdi, kontrolOdunc.get(i).kisiAdi);
        assertEquals(veritabaniOdunc.get(i).iadeTarihi, kontrolOdunc.get(i).iadeTarihi);
        assertEquals(veritabaniOdunc.get(i).emanetTarihi, kontrolOdunc.get(i).emanetTarihi);
    }
*/
}

@Test
public void testOduncverIadeAl() throws Exception {
    System.out.println("oduncver");
    int kisiID = 3;
    int kitapID = 1;
    o.oduncver(kisiID, kitapID); 
    o.iadeal("999");  
    o.oduncSil("999");  
}

 
@Test
public void testEmanetGunveUcretHesapla() throws Exception { 
    System.out.println("emanetGunHesapla");

    //07.01.2021 'den bugüne geçen sürenin hesaplanması
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date simdikiTarih = sdf.parse(sdf.format(new Date()));  
    Date alinmaZamani = new Date(121,0,7); 
    long gecenSure = simdikiTarih.getTime() - alinmaZamani.getTime();  
    double beklenenGecenSure = Math.ceil(gecenSure / 86400000);

    //Fonksiyon sonucunda elde edilen geçen gün sayısının beklenen değer ile karşılaştırılması
    String islemID = "1";
    double result = o.emanetGunHesapla(islemID);
    //assertEquals(beklenenGecenSure, result, 0.0);

    //Fonksiyon sonucunda elde edilen ücretin beklenen ücret değeri ile karşılaştırılması
    System.out.println("ucretHesapla");
    double beklenenUcret = (beklenenGecenSure - 10)*2;
    double result2 = o.ucretHesapla(islemID);
    //assertEquals(beklenenUcret, result2, 0.0); 
} 
}
