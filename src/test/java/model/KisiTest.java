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
public class KisiTest {
    Kisi k;
    
    public KisiTest() throws Exception {
    	k=new Kisi();
        k.testMi=1;
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

    ArrayList<Kisi> veritabaniKisiler = k.listele();
    ArrayList<Kisi> kontrolKisiler = new ArrayList<>();
    kontrolKisiler.add(new Kisi(1,"kisiAdi Test 1","kisiSoyadi Test 1", "kisiBolum Test 1"));
    kontrolKisiler.add(new Kisi(2,"kisiAdi Test 2","kisiSoyadi Test 2", "kisiBolum Test 2"));
    kontrolKisiler.add(new Kisi(3,"kisiAdi Test 3","kisiSoyadi Test 3", "kisiBolum Test 3"));

    for (int i = 0; i < veritabaniKisiler.size(); i++) {
        assertEquals(veritabaniKisiler.get(i).kisiAdi, kontrolKisiler.get(i).kisiAdi);
        assertEquals(veritabaniKisiler.get(i).kisiSoyadi, kontrolKisiler.get(i).kisiSoyadi);
        assertEquals(veritabaniKisiler.get(i).kisiBolum, kontrolKisiler.get(i).kisiBolum);
    }
}
     
@Test
public void testEkleSil() throws Exception {
    System.out.println("ekle");

    Kisi a= new Kisi(999,"Ayşe","Kahveci","Yazılım Mühendisliği");
    k.ekle(a);
    k.sil(999);
}
     
       
@Test
public void testGuncelle() throws Exception{
    System.out.println("guncelle");
    Kisi a=new Kisi(15,"İncisu","Yüngül","Matematik");
    k.ekle(a);
    a.kisiAdi="Miraç";
    k.guncelle(999, k);
    k.sil(999);
}
       
@Test
public void testAra() throws Exception{
    System.out.println("ara");
    ArrayList<Kisi> Kisiler = k.ara("kisiAdi Test 1");

    ArrayList<Kisi> kontrolKisiler = new ArrayList<>();
    kontrolKisiler.add(new Kisi(1,"kisiAdi Test 1","kisiSoyadi Test 1", "kisiBolum Test 1"));

    for (int i = 0; i < Kisiler.size(); i++) {
        assertEquals(Kisiler.get(i).kisiAdi, kontrolKisiler.get(i).kisiAdi);
        assertEquals(Kisiler.get(i).kisiSoyadi, kontrolKisiler.get(i).kisiSoyadi);
        assertEquals(Kisiler.get(i).kisiBolum, kontrolKisiler.get(i).kisiBolum);
    }
}
       
}
