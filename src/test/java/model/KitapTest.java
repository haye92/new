/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author msi
 */
public class KitapTest {
    
    Kitap k;
    
        
    public KitapTest() throws Exception {
    	k = new Kitap();
        k.testMi = 1;
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
 
    @Test
    public void testListele() throws Exception {
        System.out.println("listele");
        ArrayList<Kitap> veritabaniKitaplar = k.listele();
        
        ArrayList<Kitap> kontrolKitaplar = new ArrayList<>();
        kontrolKitaplar.add(new Kitap(4,"kitapAdi Test 1","kitapYazari Test 1", 1,
                "kitapKategori Test 1","kitapYayinevi Test 1"));
        kontrolKitaplar.add(new Kitap(5,"kitapAdi Test 2","kitapYazari Test 2", 2,
                "kitapKategori Test 2", "kitapYayinevi Test 2"));
        kontrolKitaplar.add(new Kitap(6,"kitapAdi Test 3","kitapYazari Test 3", 3, 
                "kitapKategori Test 3", "kitapYayinevi Test 3"));
 
        for (int i = 0; i < veritabaniKitaplar.size(); i++) {
            assertEquals(veritabaniKitaplar.get(i).kitapAdi, kontrolKitaplar.get(i).kitapAdi);
            assertEquals(veritabaniKitaplar.get(i).kitapYazari, kontrolKitaplar.get(i).kitapYazari);
            assertEquals(veritabaniKitaplar.get(i).kitapSayfa, kontrolKitaplar.get(i).kitapSayfa);
            assertEquals(veritabaniKitaplar.get(i).kitapKategori, kontrolKitaplar.get(i).kitapKategori);
            assertEquals(veritabaniKitaplar.get(i).kitapYayinevi, kontrolKitaplar.get(i).kitapYayinevi);         
        }
    }

   
    @Test
    public void testEkleSil() throws Exception {
        System.out.println("ekle");
        
        Kitap b = new Kitap(9, "Şeker Portakalı", "José Mauro de Vasconcelos", 197, 
                "Otobiyografi", "Can Yayınevi");
        
        k.ekle(b);
        k.sil(999);
    }

 
    @Test
    public void testGuncelle() throws Exception {
        System.out.println("guncelle");
        
        Kitap b = new Kitap(9, "Şeker Portakalı", "José Mauro de Vasconcelos", 197, 
                "Otobiyografi", "Can Yayınevi");
        
        k.ekle(b);
        b.kitapAdi = "Çikolata Portakalı";
        k.guncelle(999, b);
        k.sil(999);  
    }

 
    @Test
    public void testAra() throws Exception {
        System.out.println("ara");       
        ArrayList<Kitap> Kitaplar = k.ara("kitapAdi Test 1");                  
        
        ArrayList<Kitap> kontrolKitaplar = new ArrayList<>();
        kontrolKitaplar.add(new Kitap(4,"kitapAdi Test 1","kitapYazari Test 1", 1,
                "kitapKategori Test 1","kitapYayinevi Test 1"));
        
        for (int i = 0; i < Kitaplar.size(); i++) {
            assertEquals(Kitaplar.get(i).kitapAdi, kontrolKitaplar.get(i).kitapAdi);
            assertEquals(Kitaplar.get(i).kitapYazari, kontrolKitaplar.get(i).kitapYazari);
            assertEquals(Kitaplar.get(i).kitapSayfa, kontrolKitaplar.get(i).kitapSayfa);
            assertEquals(Kitaplar.get(i).kitapKategori, kontrolKitaplar.get(i).kitapKategori);
            assertEquals(Kitaplar.get(i).kitapYayinevi, kontrolKitaplar.get(i).kitapYayinevi);         
        }   
    }
    
}
