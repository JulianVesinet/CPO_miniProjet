/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpo_mastermind;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MasterMindInter extends javax.swing.JFrame {

    private int ligneVisible = 0;
    private String[] combinaisonSecrete = {"Rouge", "Bleu", "Jaune", "Vert"}; // Combinaison secrète
    private JLabel[] lblResultats = new JLabel[12]; // Labels pour afficher les résultats ligne par ligne
    private JPanel[] lignesPanel = new JPanel[12]; // Un JPanel pour chaque ligne
    private JComboBox<String>[][] matCombo = new JComboBox[12][4]; // Matrice de JComboBox pour les couleurs

    public MasterMindInter() {
        initComponents();
        initGrille();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Fenêtre en plein écran
    }

    private void initGrille() {
        grillePanel.removeAll(); // Efface les composants existants
        grillePanel.setLayout(new GridLayout(12, 1, 5, 5)); // Grille de 12 lignes, espacement vertical de 5px

        String[] couleurs = {"Rouge", "Bleu", "Vert", "Jaune"}; // Couleurs disponibles

        for (int i = 0; i < 12; i++) {
            // Créer un panel pour la ligne avec GridLayout (4 colonnes pour JComboBox, 1 pour JLabel)
            lignesPanel[i] = new JPanel(new GridLayout(1, 5, 10, 0));

            // Ajouter 4 JComboBox pour la ligne
            for (int j = 0; j < 4; j++) {
                JComboBox<String> comboBox = new JComboBox<>(couleurs);
                comboBox.setPreferredSize(new Dimension(60, 30)); // Taille fixe pour les JComboBox
                comboBox.setEnabled(i == 0); // Active uniquement la première ligne au début
                matCombo[i][j] = comboBox;

                // Listener pour changer la couleur de fond
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
                    comboBox.setOpaque(true); // Nécessaire pour afficher la couleur
                    comboBox.repaint();
                });

                lignesPanel[i].add(comboBox);
            }

            // Ajouter un JLabel pour afficher le résultat
            lblResultats[i] = new JLabel("");
            lblResultats[i].setVisible(i == 0); // Cache tous les labels sauf le premier
            lignesPanel[i].add(lblResultats[i]);

            // Cacher les lignes autres que la première
            lignesPanel[i].setVisible(i == 0);

            // Ajouter le panel de la ligne au panel principal
            grillePanel.add(lignesPanel[i]);
        }

        grillePanel.revalidate();
        grillePanel.repaint();
    }

    private void afficherProchaineLigne() {
        ligneVisible++; // Passer à la ligne suivante

        if (ligneVisible < 12) {
            // Rendre la nouvelle ligne visible
            lignesPanel[ligneVisible].setVisible(true);
            lblResultats[ligneVisible].setVisible(true);

            // Activer les JComboBox de la nouvelle ligne
            for (int j = 0; j < 4; j++) {
                matCombo[ligneVisible][j].setEnabled(true);
            }
        }

        grillePanel.revalidate();
        grillePanel.repaint();
    }

    private void desactiverLigne(int ligne) {
        for (int j = 0; j < 4; j++) {
            matCombo[ligne][j].setEnabled(false); // Désactiver les JComboBox de la ligne actuelle
        }
    }

    private String comparerCombinaisons(String[] proposition, String[] secret) {
        int bienPlaces = 0;
        int malPlaces = 0;
        boolean[] positionsMarquees = new boolean[secret.length];
        boolean[] positionsTestees = new boolean[proposition.length];

        // Étape 1 : Bien placés
        for (int i = 0; i < proposition.length; i++) {
            if (proposition[i].equals(secret[i])) {
                bienPlaces++;
                positionsMarquees[i] = true;
                positionsTestees[i] = true;
            }
        }

        // Étape 2 : Mal placés
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

        // Récupérer la proposition de la ligne actuelle
        for (int i = 0; i < 4; i++) {
            proposition[i] = (String) matCombo[ligneVisible][i].getSelectedItem();
        }

        // Comparer avec la combinaison secrète
        String resultat = comparerCombinaisons(proposition, combinaisonSecrete);

        // Afficher le résultat dans le JLabel de la ligne actuelle
        lblResultats[ligneVisible].setText(resultat);

        // Vérifier victoire ou progression
        if (resultat.startsWith("Bien placés : 4")) {
            lblResultats[ligneVisible].setText("Félicitations, vous avez gagné !");
            validerButton.setEnabled(false); // Désactiver le bouton
        } else if (ligneVisible == 11) { // Dernière tentative
            lblResultats[ligneVisible].setText("Défaite ! La combinaison était : " + String.join(", ", combinaisonSecrete));
            validerButton.setEnabled(false);
        } else {
            desactiverLigne(ligneVisible); // Désactiver la ligne actuelle
            afficherProchaineLigne(); // Afficher la suivante
        }
    




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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterMindInter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel grillePanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
