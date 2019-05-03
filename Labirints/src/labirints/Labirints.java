package labirints;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Labirints extends javax.swing.JFrame {

    int m, n; //labirinta rindu un kolonnu skaits
    ArrayList<Integer> labirints[];
    Graphics g;

    public Labirints() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lasa = new javax.swing.JButton();
        zime = new javax.swing.JButton();
        panelis = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spinnerNo = new javax.swing.JSpinner();
        spinnerUz = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lasa.setText("Nolasīt");
        lasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasaActionPerformed(evt);
            }
        });

        zime.setText("Uzzīmēt");
        zime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisLayout = new javax.swing.GroupLayout(panelis);
        panelis.setLayout(panelisLayout);
        panelisLayout.setHorizontalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        panelisLayout.setVerticalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Ceļš no ");

        spinnerNo.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerNo.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerNo, ""));
        spinnerNo.setEnabled(false);

        spinnerUz.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spinnerUz.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerUz, ""));
        spinnerUz.setEnabled(false);

        jLabel2.setText("uz");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerNo)
                            .addComponent(spinnerUz)))
                    .addComponent(lasa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lasa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(spinnerNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerUz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zime)
                        .addGap(265, 265, 265))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makeItBFS(int no, int uz) {
        Queue<Integer> queue = new LinkedList<>();
        boolean bijaam[] = new boolean[m * n];
        for (int i = 0; i < (m * n); i++) {
            bijaam[i] = false;
        }

        //int v = 1;
        int before[] = new int[n * m + 1];
        queue.add(no);
        System.out.println(no);
        bijaam[no - 1] = true;
        before[no] = -1;
        boolean found = false;
        while (!queue.isEmpty()) {
            int p = queue.remove();
            for (int i = 0; i < labirints[p - 1].size(); i++) {
                int num = labirints[p - 1].get(i);
                if (!bijaam[num - 1]) {
                    queue.add(num);
                    bijaam[num - 1] = true;
                    before[num] = p;
                    System.out.println(num);
                    if (num == uz) {
                        found = true;
                        break;
                    }
                }
            }
            if (found) {
                break;
            }
        }

        int xy0 = 1;
        int lenX = panelis.getWidth() - 2;
        int lenY = panelis.getHeight() - 2;
        int dx = (lenX / n);
        int dy = (lenY / m);

        g.setColor(Color.GREEN);
        while (uz > 0) {
            System.out.print(uz + " ");
            int tileY = (uz - 1) / n;
            int tileX = (uz - 1) % n;
            int punktsX = xy0 + tileX * dx;
            int punktsY = xy0 + tileY * dy;
            g.fillRect(punktsX, punktsY, dx, dy);
            uz = before[uz];
        }
        g.setColor(panelis.getBackground());
    }

    private void lasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasaActionPerformed
        try {
            BufferedReader bufRdr = new BufferedReader(new FileReader("labirints.txt"));
            String failaRinda = bufRdr.readLine(); //nolasa no faila vienu teksta rindu
            String[] tmp = failaRinda.split(" ");    //sadala to atsevišķos gabaliņos, kurus saliek masīvā tmp
            m = Integer.parseInt(tmp[0]);            //iegūst rindu skaitu
            n = Integer.parseInt(tmp[1]);            //iegūst kolonnu skaitu
            System.out.println(m + " " + n);           //izvada rindu un kolonnu skaitu testa nolūkiem
            g = panelis.getGraphics();
            //g.drawLine(0, 0, 200, 300);
            labirints = new ArrayList[n * m];
            for (int i = 0; i < labirints.length; i++) {
                failaRinda = bufRdr.readLine();
                tmp = failaRinda.split(" ");
                labirints[i] = new ArrayList<>();
                for (int j = 1; j < tmp.length; j++) {
                    labirints[i].add(Integer.parseInt(tmp[j]));
                }
            }

            int xy0 = 1;
            int lenX = panelis.getWidth() - 2;
            int lenY = panelis.getHeight() - 2;
            int dx = lenX / n;
            int dy = lenY / m;
            for (int i = 0; i <= m; i++) {
                g.drawLine(xy0, xy0 + i * dy, xy0 + lenX, xy0 + i * dy);
            }
            for (int i = 0; i <= n; i++) {
                g.drawLine(xy0 + i * dx, xy0, xy0 + i * dx, xy0 + lenY);
            }

            g.setColor(panelis.getBackground());
            for (int i = 0; i < labirints.length; i++) {
                for (int j = 0; j < labirints[i].size(); j++) {
                    int num = labirints[i].get(j) - 1;
                    int virziens = num - i;
                    int tileY = i / n;
                    int tileX = i % n;
                    int punktsX = xy0 + tileX * dx;
                    int punktsY = xy0 + tileY * dy;

                    switch (virziens) {
                        case -1:
                            g.drawLine(punktsX, punktsY, punktsX, punktsY + dy);
                            break;
                        case 1:
                            g.drawLine(punktsX + dx, punktsY, punktsX + dx, punktsY + dy);
                            break;
                        default:
                            if (virziens == n) {
                                g.drawLine(punktsX, punktsY + dy, punktsX + dx, punktsY + dy);
                            } else {
                                g.drawLine(punktsX, punktsY, punktsX + dx, punktsY);
                            }
                    }
                }
            }

            SpinnerModel spinnerModel1 = new SpinnerNumberModel(1, 1, m * n, 1);
            SpinnerModel spinnerModel2 = new SpinnerNumberModel(1, 1, m * n, 1);
            spinnerNo.setEnabled(true);
            spinnerNo.setModel(spinnerModel1);
            spinnerUz.setEnabled(true);
            spinnerUz.setModel(spinnerModel2);

        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }

    }//GEN-LAST:event_lasaActionPerformed

    private void zimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zimeActionPerformed
        g = panelis.getGraphics();

        int checkNo = (int) spinnerNo.getValue();
        int checkUz = (int) spinnerUz.getValue();
        makeItBFS(checkUz, checkNo);
    }//GEN-LAST:event_zimeActionPerformed

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
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Labirints().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lasa;
    private javax.swing.JPanel panelis;
    private javax.swing.JSpinner spinnerNo;
    private javax.swing.JSpinner spinnerUz;
    private javax.swing.JButton zime;
    // End of variables declaration//GEN-END:variables
}
