/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Kisi;

/**
 *
 * @author msi
 * 
 */
public class KisiPanel extends javax.swing.JPanel {

    int seciliSatirSirasi;
    String seciliKisiID;
    
    public KisiPanel() throws Exception {
        initComponents();
        tabloYenile();
        
    }
    
    public void tabloYenile() throws Exception{
        Kisi k = new Kisi();
        ArrayList<Kisi> kisiler = k.listele();
        tabloyuDoldur(kisiler);
    }
    
    public void tabloyuDoldur(ArrayList<Kisi> kisiler)
    {
          
          String veriler[][]=new String[kisiler.size()][];

          for (int i = 0; i < kisiler.size(); i++) {     
             veriler[i]=new String[]{                                   
                kisiler.get(i).kisiID +"",
                kisiler.get(i).kisiAdi,
                kisiler.get(i).kisiSoyadi,
                kisiler.get(i).kisiBolum                                 
             };                  
         }
          String [] tabloBaslik = new String[] {"Öğrenci ID", "İsim", "Soy İsim", "Bölüm"};
          TableModel tabloModeli=new DefaultTableModel( veriler, tabloBaslik );                                                
          jTable1.setModel(tabloModeli);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aranacakkelime = new javax.swing.JTextField();
        uyeara = new javax.swing.JButton();
        uyeguncelle = new javax.swing.JButton();
        uyesil = new javax.swing.JButton();
        uyeekle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        aranacakkelime.setText(" ");

        uyeara.setText("Ara");
        uyeara.setToolTipText("");
        uyeara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyearaActionPerformed(evt);
            }
        });

        uyeguncelle.setText("Üye Güncelle");
        uyeguncelle.setEnabled(false);
        uyeguncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeguncelleActionPerformed(evt);
            }
        });

        uyesil.setText("Üye Sil");
        uyesil.setEnabled(false);
        uyesil.setName(""); // NOI18N
        uyesil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyesilActionPerformed(evt);
            }
        });

        uyeekle.setText("Yeni Üye Ekle");
        uyeekle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uyeekleActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aranacakkelime, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uyeara)
                        .addGap(77, 77, 77)
                        .addComponent(uyeguncelle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uyesil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uyeekle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aranacakkelime, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uyeara)
                    .addComponent(uyeguncelle)
                    .addComponent(uyesil)
                    .addComponent(uyeekle))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        uyeara.getAccessibleContext().setAccessibleName("Ara");
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
       uyeguncelle.enable(true);
       uyesil.enable(true);
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
       
    }//GEN-LAST:event_jTable1FocusGained

    private void uyearaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyearaActionPerformed
        String kelime = aranacakkelime.getText().toString();
        System.out.println(kelime);
        try {
            Kisi k = new Kisi();
            ArrayList<Kisi> kisiler = k.ara(kelime);
            tabloyuDoldur(kisiler);
        }catch(Exception e) {
            System.out.println("Hata");
        }
   
    }//GEN-LAST:event_uyearaActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
        seciliSatirSirasi = jTable1.getSelectedRow();
        seciliKisiID = jTable1.getValueAt(seciliSatirSirasi, 0).toString();
        System.out.println(seciliKisiID);

        uyeguncelle.setEnabled(true);
        uyesil.setEnabled(true);
    }//GEN-LAST:event_jTable1MousePressed

    private void uyeguncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeguncelleActionPerformed
        
        try{
            Kisi k = new Kisi();
            k.kisiAdi = jTable1.getValueAt(seciliSatirSirasi, 1).toString();
            k.kisiSoyadi = jTable1.getValueAt(seciliSatirSirasi, 2).toString();
            k.kisiBolum = jTable1.getValueAt(seciliSatirSirasi, 3).toString();

            k.guncelle(Integer.parseInt(seciliKisiID),k);
            
            System.out.println("Başarılı");
            tabloYenile();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_uyeguncelleActionPerformed

    private void uyesilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyesilActionPerformed
        try{
            Kisi k = new Kisi();
            k.sil(Integer.parseInt(seciliKisiID));
            System.out.println("Başarılı");
            tabloYenile();
         }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_uyesilActionPerformed

    private void uyeekleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uyeekleActionPerformed
        try {
            KisiEkle uyeEkle= new KisiEkle(this);
            uyeEkle.pack();
            uyeEkle.setLocationRelativeTo(null);
            uyeEkle.setVisible(true);
            uyeEkle.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
        
        
    }//GEN-LAST:event_uyeekleActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aranacakkelime;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton uyeara;
    private javax.swing.JButton uyeekle;
    private javax.swing.JButton uyeguncelle;
    private javax.swing.JButton uyesil;
    // End of variables declaration//GEN-END:variables
}
