/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpo_mastermind;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
/**
 *
 * @author julian
 */
public class MasterMindInter extends javax.swing.JFrame {
    private int ligneVisible = 0;
    private String[] combinaisonSecrete = {"Rouge", "Bleu", "Jaune", "Vert"}; // Combinaison secrète

    public MasterMindInter() {
        initComponents();
        initGrille();
        
      
                };

private void initGrille() {
    grillePanel.removeAll(); // Efface les composants existants
    String[] couleurs = {"Rouge", "Bleu", "Vert", "Jaune"}; // Couleurs disponibles

    for (int i = 0; i < 12 * 4; i++) { // Crée 12 lignes de 4 JComboBox chacune
        JComboBox<String> comboBox = new JComboBox<>(couleurs);

        // Ajouter ActionListener pour gérer les changements de couleur
        comboBox.addActionListener(e -> {
            JComboBox<String> source = (JComboBox<String>) e.getSource();
            String selectedColor = (String) source.getSelectedItem();

            // Change la couleur de fond en fonction de la sélection
            switch (selectedColor) {
                case "Rouge":
                    source.setBackground(Color.RED);
                    break;
                case "Bleu":
                    source.setBackground(Color.BLUE);
                    break;
                case "Vert":
                    source.setBackground(Color.GREEN);
                    break;
                case "Jaune":
                    source.setBackground(Color.YELLOW);
                    break;
                default:
                    source.setBackground(Color.WHITE);
            }
            source.setOpaque(true);
            source.repaint();
        });

        // Par défaut, masquer toutes les cases sauf la première ligne
        comboBox.setVisible(i < 4); // Seule la première ligne est visible au départ
        grillePanel.add(comboBox);
    }

    grillePanel.revalidate();
    grillePanel.repaint();
}

    private void afficherProchaineLigne() {
    ligneVisible++; // Incrémenter l'index de ligne visible
    for (int i = ligneVisible * 4; i < (ligneVisible + 1) * 4; i++) {
        if (i < grillePanel.getComponentCount()) {
            grillePanel.getComponent(i).setVisible(true); // Rendre visible la ligne suivante
        }
    }

    grillePanel.revalidate();
    grillePanel.repaint();
}
    private void desactiverLigne(int ligne) {
    for (int i = ligne * 4; i < (ligne + 1) * 4; i++) {
        if (i < grillePanel.getComponentCount()) {
            grillePanel.getComponent(i).setEnabled(false); // Désactiver les JComboBox de la ligne
        }
    }
}

    private String comparerCombinaisons(String[] proposition, String[] secret) {
        int bienPlaces = 0;
        int malPlaces = 0;
        boolean[] positionsMarquees = new boolean[secret.length];
        boolean[] positionsTestees = new boolean[proposition.length];

        // Étape 1 : Trouver les bien placés
        for (int i = 0; i < proposition.length; i++) {
            if (proposition[i].equals(secret[i])) {
                bienPlaces++;
                positionsMarquees[i] = true; // Marque la position dans la combinaison secrète
                positionsTestees[i] = true; // Marque la position dans la proposition
            }
        }

        // Étape 2 : Trouver les mal placés
        for (int i = 0; i < proposition.length; i++) {
            if (!positionsTestees[i]) {
                for (int j = 0; j < secret.length; j++) {
                    if (!positionsMarquees[j] && proposition[i].equals(secret[j])) {
                        malPlaces++;
                        positionsMarquees[j] = true; // Marque la position dans la combinaison secrète
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
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("<html> <center>Bienvenue dans Mastermind !<br>Devinez la combinaison en un maximum de 12 tours.</center> </html>");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        grillePanel.setBackground(new java.awt.Color(204, 204, 204));
        grillePanel.setLayout(new java.awt.GridLayout(12, 4, 5, 5));
        getContentPane().add(grillePanel, java.awt.BorderLayout.CENTER);

        validerButton.setText("Valider");
        validerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(validerButton, java.awt.BorderLayout.PAGE_END);

        lblMessage.setText("jLabel1");
        getContentPane().add(lblMessage, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerButtonActionPerformed
        // TODO add your handling code here:

String[] proposition = new String[4];

    // Récupérer les valeurs sélectionnées de la ligne actuelle
    for (int i = 0; i < 4; i++) {
        JComboBox<String> comboBox = (JComboBox<String>) grillePanel.getComponent(ligneVisible * 4 + i);
        proposition[i] = (String) comboBox.getSelectedItem();
    }

    // Comparer la tentative avec la combinaison secrète
    String resultat = comparerCombinaisons(proposition, combinaisonSecrete);

    // Afficher le résultat dans lblMessage
    lblMessage.setText(resultat);

    // Vérifier si le joueur a gagné
    if (resultat.startsWith("Bien placés : 4")) {
        lblMessage.setText("Félicitations, vous avez gagné !");
        validerButton.setEnabled(false); // Désactiver le bouton en cas de victoire
    } else if (ligneVisible == 11) { // Dernière tentative
        lblMessage.setText("Défaite ! La combinaison secrète était : " + String.join(", ", combinaisonSecrete));
        validerButton.setEnabled(false);
    } else {
        // Désactiver la ligne actuelle et afficher la suivante
        desactiverLigne(ligneVisible);
        afficherProchaineLigne();
    }
    
   
    

    }//GEN-LAST:event_validerButtonActionPerformed

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
    private javax.swing.JLabel lblMessage;
    private javax.swing.JButton validerButton;
    // End of variables declaration//GEN-END:variables
}
