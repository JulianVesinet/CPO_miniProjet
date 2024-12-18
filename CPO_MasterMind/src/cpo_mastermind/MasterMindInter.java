/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpo_mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MasterMindInter extends javax.swing.JFrame {

    private int ligneVisible = 0;
    private String[] combinaisonSecrete;
    private JLabel[] lblResultats = new JLabel[12]; // Labels pour afficher les résultats ligne par ligne
    private JPanel[] lignesPanel = new JPanel[12]; // Un JPanel pour chaque ligne
    private JComboBox<String>[][] matCombo = new JComboBox[12][4]; // Matrice de JComboBox pour les couleurs
    private String difficulte;
    private int nbCoups = 12;

    public MasterMindInter(String difficulte) {
        this.difficulte = difficulte;
        initComponents();
        configurerDifficulte();
        initGrille();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Fenêtre en plein écran
    }

    private void configurerDifficulte() {
        switch (difficulte) {
            case "Facile":
                combinaisonSecrete = new String[]{"Rouge", "Bleu", "Jaune", "Vert"}; // Couleurs uniques
                break;

            case "Moyen":
                combinaisonSecrete = genererCombinaisonAvecDoublons();
                break;

            case "Difficile":
                combinaisonSecrete = genererCombinaisonAvecDoublons();
                nbCoups = 8; // Réduire le nombre d'essais
                break;

            default:
                throw new IllegalArgumentException("Difficulté non reconnue : " + difficulte);
        }
    }

    private String[] genererCombinaisonAvecDoublons() {
        String[] couleurs = {"Rouge", "Bleu", "Vert", "Jaune"};
        String[] combinaison = new String[4];
        for (int i = 0; i < 4; i++) {
            combinaison[i] = couleurs[(int) (Math.random() * couleurs.length)];
        }
        return combinaison;
    }

    private void initGrille() {
        grillePanel.removeAll(); // Efface les composants existants
        grillePanel.setLayout(new GridLayout(nbCoups, 1, 5, 5)); // Grille adaptée au nombre d'essais

        String[] couleurs = {"Rouge", "Bleu", "Vert", "Jaune"}; // Couleurs disponibles

        for (int i = 0; i < nbCoups; i++) {
            lignesPanel[i] = new JPanel(new GridLayout(1, 5, 10, 0));

            for (int j = 0; j < 4; j++) {
                JComboBox<String> comboBox = new JComboBox<>(couleurs);
                comboBox.setPreferredSize(new Dimension(60, 30));
                comboBox.setEnabled(i == 0);
                matCombo[i][j] = comboBox;

                comboBox.addActionListener(e -> {
                    String selectedColor = (String) comboBox.getSelectedItem();
                    switch (selectedColor) {
                        case "Rouge":
                            comboBox.setBackground(Color.RED);
                            break;
                        case "Bleu":
                            comboBox.setBackground(Color.BLUE);
                            break;
                        case "Vert":
                            comboBox.setBackground(Color.GREEN);
                            break;
                        case "Jaune":
                            comboBox.setBackground(Color.YELLOW);
                            break;
                        default:
                            comboBox.setBackground(Color.WHITE);
                    }
                    comboBox.setOpaque(true);
                    comboBox.repaint();
                });

                lignesPanel[i].add(comboBox);
            }

            lblResultats[i] = new JLabel("");
            lblResultats[i].setVisible(i == 0);
            lignesPanel[i].add(lblResultats[i]);
            lignesPanel[i].setVisible(i == 0);
            grillePanel.add(lignesPanel[i]);
        }

        grillePanel.revalidate();
        grillePanel.repaint();
    }

    private void afficherProchaineLigne() {
        ligneVisible++;

        if (ligneVisible < nbCoups) {
            lignesPanel[ligneVisible].setVisible(true);
            lblResultats[ligneVisible].setVisible(true);

            for (int j = 0; j < 4; j++) {
                matCombo[ligneVisible][j].setEnabled(true);
            }
        }

        grillePanel.revalidate();
        grillePanel.repaint();
    }

    private void desactiverLigne(int ligne) {
        for (int j = 0; j < 4; j++) {
            matCombo[ligne][j].setEnabled(false);
        }
    }

    private String comparerCombinaisons(String[] proposition, String[] secret) {
        int bienPlaces = 0;
        int malPlaces = 0;
        boolean[] positionsMarquees = new boolean[secret.length];
        boolean[] positionsTestees = new boolean[proposition.length];

        for (int i = 0; i < proposition.length; i++) {
            if (proposition[i].equals(secret[i])) {
                bienPlaces++;
                positionsMarquees[i] = true;
                positionsTestees[i] = true;
            }
        }

        for (int i = 0; i < proposition.length; i++) {
            if (!positionsTestees[i]) {
                for (int j = 0; j < secret.length; j++) {
                    if (!positionsMarquees[j] && proposition[i].equals(secret[j])) {
                        malPlaces++;
                        positionsMarquees[j] = true;
                        break;
                    }
                }
            }
        }

        return "Bien placés : " + bienPlaces + " | Mal placés : " + malPlaces;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        grillePanel = new javax.swing.JPanel();
        validerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Edwardian Script ITC", 1, 60)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MASTERMIND");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        grillePanel.setBackground(new java.awt.Color(204, 204, 204));
        grillePanel.setLayout(new java.awt.GridLayout(12, 4, 5, 5));
        getContentPane().add(grillePanel, java.awt.BorderLayout.CENTER);

        validerButton.setFont(new java.awt.Font("Segoe UI Symbol", 0, 48)); // NOI18N
        validerButton.setText("Valider");
        validerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(validerButton, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerButtonActionPerformed
        // TODO add your handling code here:

String[] proposition = new String[4];

        for (int i = 0; i < 4; i++) {
            proposition[i] = (String) matCombo[ligneVisible][i].getSelectedItem();
        }

        String resultat = comparerCombinaisons(proposition, combinaisonSecrete);
        lblResultats[ligneVisible].setText(resultat);

        if (resultat.startsWith("Bien placés : 4")) {
            finDePartie("Félicitations, vous avez gagné !");
        } else if (ligneVisible == nbCoups - 1) {
            finDePartie("Défaite ! La combinaison était : " + String.join(", ", combinaisonSecrete));
        } else {
            desactiverLigne(ligneVisible);
            afficherProchaineLigne();
        }
    }

    private void finDePartie(String message) {
    // Création de la boîte de dialogue pour la fin de partie
    JDialog finDialog = new JDialog(this, "Fin de partie", true);
    finDialog.setSize(600, 300); // Augmentation de la taille de la fenêtre
    finDialog.setLayout(new BoxLayout(finDialog.getContentPane(), BoxLayout.Y_AXIS));

    // Label pour afficher le message
    JLabel lblMessage = new JLabel(message, SwingConstants.CENTER);
    lblMessage.setAlignmentX(CENTER_ALIGNMENT);
    lblMessage.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20)); // Taille de police augmentée
    finDialog.add(lblMessage);

    // Panneau pour les boutons avec GridBagLayout pour le centrage
    JPanel boutonsPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // Marges entre les composants

    // Création des boutons
    JButton btnRejouer = new JButton("Rejouer");
    JButton btnQuitter = new JButton("Quitter");

    // Augmentation de la taille des boutons
    btnRejouer.setPreferredSize(new Dimension(200, 50)); // Taille augmentée
    btnRejouer.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16)); // Police augmentée
    btnQuitter.setPreferredSize(new Dimension(200, 50)); // Taille augmentée
    btnQuitter.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16)); // Police augmentée

    // Actions pour les boutons
    btnRejouer.addActionListener(e -> {
        new AccueilFenetre().setVisible(true);
        finDialog.dispose();
        this.dispose();
    });

    btnQuitter.addActionListener(e -> System.exit(0));

    // Ajout des boutons au panneau
    gbc.gridx = 0;
    gbc.gridy = 0;
    boutonsPanel.add(btnRejouer, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    boutonsPanel.add(btnQuitter, gbc);

    // Ajout du panneau des boutons à la fenêtre
    finDialog.add(boutonsPanel);

    // Centrer la boîte de dialogue par rapport à la fenêtre principale
    finDialog.setLocationRelativeTo(this);
    finDialog.setVisible(true);


    


    }//GEN-LAST:event_validerButtonActionPerformed

    private void Ligne2Colonne2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ligne2Colonne2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Ligne2Colonne2ActionPerformed

    private void Ligne1Colonne1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ligne1Colonne1ActionPerformed
           // TODO add your handling code here:
    }//GEN-LAST:event_Ligne1Colonne1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MasterMindInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasterMindInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasterMindInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasterMindInter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MasterMindInter("Facile").setVisible(true); // Mode par défaut : "Facile"
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grillePanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
