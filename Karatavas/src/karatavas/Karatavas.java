package karatavas;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;

public class Karatavas extends javax.swing.JFrame {
    public Karatavas() {
        initComponents();
        minet.setEnabled(false);
        ielasaVardus();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        izvele = new javax.swing.JButton();
        minet = new javax.swing.JButton();
        svitras = new javax.swing.JLabel();
        burti = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        izvele.setText("Izvēle");
        izvele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izveleActionPerformed(evt);
            }
        });

        minet.setText("Minēt");
        minet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minetActionPerformed(evt);
            }
        });

        svitras.setText("                            ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(svitras, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(burti, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(izvele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(minet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(izvele)
                        .addGap(11, 11, 11)
                        .addComponent(svitras, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(burti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(minet))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String vards, iedoma;
    String[] vardi;
    int varduSk, kluduSk;
    
    //metode, kas ielasa vārdus no faila masīvā vardi
    public void ielasaVardus(){
        try(BufferedReader buf=new BufferedReader(new FileReader("vardi.txt"))){
            String rinda = buf.readLine();
            vardi = rinda.split(" ");
            buf.close();
            varduSk = vardi.length;
        }catch(IOException e){
            JOptionPane.showMessageDialog(this, "Problēma ar vārdu failu, nevaram sākt spēli!");
            izvele.setEnabled(false);
        }	
    }
    public String generetSvitras(String teksts){
        String s="";
        //te jārāksta cikls, kas mainīgajam s pievieno tekstu "-" tik reizes, cik burtu ir mainīgajā teksts
        for (int i = 0; i < teksts.length(); i++) {
            s += "-";
        }
        return s;
    }
    private void izveleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izveleActionPerformed
        // jāuzģenerē random skaitlis n no intervāla [0;varduSk-1]
        // mainigajam kluduSk jāpiešķir vērtība 0
        // mainīgajam iedoma jāpiešķir masīva vardi n-tā elementa vērtība
        // mainīgajam vards kā vērtība jāpiešķir funkcijas generetSvitras vērtība, kā argumentu norādot mainīgo iedoma 
        // teksta elementā svitras jāparāda mainīgā vards vērtība 
        // aktivizē minēšanas pogu
        // bloķē vārda izvēles pogu
        burti.requestFocus(); // ieliek kursoru teksta laukā
        
        Random rand = new Random();
        int n = rand.nextInt(varduSk);
        
        kluduSk = 0;
        iedoma = vardi[n];
        
        vards = generetSvitras(iedoma);
        svitras.setText(vards);
        
        minet.setEnabled(true);
        izvele.setEnabled(false);
    }//GEN-LAST:event_izveleActionPerformed
public void zimetKaratavas(){
    // analizē mainīgā kluduSk vērtību un atkarībā no tā vērtības papildina karātavu attēlu 
    Graphics g = jPanel1.getGraphics();
    switch (kluduSk) {
        case 1: g.drawLine(10, 10, 10, 220); break;
        case 2: g.drawLine(10, 10, 180, 10); break;
        case 3: g.drawLine(120, 10, 120, 35); break;
        case 4: g.drawOval(100, 35, 40, 40); break;
        case 5: 
            g.drawLine(120, 75, 120, 140);
            g.drawLine(120, 140, 100, 165);
            g.drawLine(120, 140, 140, 165);
            g.drawLine(120, 95, 100, 120);
            g.drawLine(120, 95, 140, 120);
        break;
    }
}
    
    private void minetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minetActionPerformed
        // jāievieš lokāls mainīgais tmp ar vērtību ""
        // jāievieš lokāls mainīgais irBurts ar vērtību false 
        // no teksta lauka burti jānolasa teksts, jāpaņem tā 0-tais burts un jāsaglabā lokālā mainīgajā burts
        // jāveido cikls priekš i, kas strādās tik reižu, cik mainīgajā iedoma ir burtu
        // ja mainīgā iedoma i-tais burts ir vienāds ar mainīgo burts, tad mainīgajam irBurts piešķir vērtību true un
        // mainīgajam tmp pievieno šo burtu, pretējā gadījumā mainīgajam tmp pievieno simbolu "-"
        // kad cikls beidzies, analizē mainīgā irBurts vērtību: jā tā ir false, kļūdu skaitu palielina par viens
        // pretējā gadījumā ja vārds ir uzminēts (mainīgais tmp nesatur nevienu svītru), tad paziņo par uzvaru un bloķē minēšanas pogu
        // ja klūdu skaits nepārsniedz maksimālo, tad izsauc metodi zimetKaratavas un
        // mainīgajam vards piešķir mainīgā tmp vērtību un attēlo to teksta elementā svitras un
        // notīra teksta lauku un atjauno tajā kursoru
        // pretējā gadījumā paziņo zaudējumu un bloķē minēšanas pogu
        
        String tmp = "";
        boolean irBurts = false;
        char burts = burti.getText().charAt(0);
        for (int i = 0; i < iedoma.length(); i++) {
            if (iedoma.charAt(i) == burts) {
                irBurts = true;
                tmp = tmp + iedoma.charAt(i);
            } else {
                tmp = tmp + "-";
            }
        }
        
        boolean win = true;
        if (!irBurts) {
            kluduSk++;
        } else {
            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == '-') {
                    win = false;
                }
            }
            if (win) {
                burti.setText("YOU WON!");
                minet.setEnabled(false);
            }
        }
        
        if (kluduSk <= 5) {
            zimetKaratavas();
            vards = tmp;
            svitras.setText(vards);
            burti.setText("");
            burti.requestFocus();
        } else {
            minet.setEnabled(false);
            JOptionPane.showMessageDialog(this, "TU ESI ZAUDĒJIS, MUAHAHA!");
        }
    }//GEN-LAST:event_minetActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karatavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karatavas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField burti;
    private javax.swing.JButton izvele;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton minet;
    private javax.swing.JLabel svitras;
    // End of variables declaration//GEN-END:variables
}
