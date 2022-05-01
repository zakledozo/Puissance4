package puissance_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListePartie extends javax.swing.JFrame {

//On initialise le constructeur
    public ListePartie() {
        initComponents();

        SQL bdd = new SQL();

        try {
            bdd.Connect();

            ResultSet liste = bdd.query("SELECT * FROM `game` WHERE Result = ''");

            int y = 200;
            int x = 200;
            while (liste.next()) {

                ListePartie L = this;
                JButton b = new JButton();
                String txt = "Partie n" + liste.getString("Id") + "   " + liste.getString("Player1") + "  VS  "  + liste.getString("Player2");
                b.setText(txt);
                b.setBounds(x, y,600,50);
                b.setFont(new Font("Tahoma", Font.BOLD, 24));
                int p = Integer.parseInt(liste.getString("Id"));

                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        GamePage G = new GamePage(p);
                        G.setVisible(true);
                        L.setVisible(false);
                    }
                });
                this.add(b);
                y = y + 60;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Tahoma", 0, 36));
        jLabel1.setText("Parties sauvegardées");

        jButton1.setText("Home");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(347, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(jButton1)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(677, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        HomePage H = new HomePage();
        H.setVisible(true);
        this.setVisible(false);
    }

//On initialise le main
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListePartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ListePartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ListePartie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ListePartie.class.getName()).log(Level.SEVERE, null, ex);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListePartie().setVisible(true);
            }
        });
    }

    // Variables declaration (boutons)
    private JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//
}