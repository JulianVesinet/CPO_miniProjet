/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cpo_mastermind;

import javax.swing.*;
import java.awt.*;

public class AccueilFenetre extends JFrame {

    public AccueilFenetre() {
        // Configurer la fenêtre principale
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Ouvrir directement en plein écran
        setTitle("Accueil - Mastermind");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panneau principal avec BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // Titre
        JLabel lblTitre = new JLabel("Mastermind", SwingConstants.CENTER);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 48)); // Police pour le titre
        mainPanel.add(lblTitre, BorderLayout.NORTH);

        // Panneau pour les règles (à gauche)
        JTextPane txtRegles = new JTextPane();
        txtRegles.setContentType("text/html"); // Support HTML
        txtRegles.setText("""
            <html>
                <div style='font-size: 20px; line-height: 1.8;'>
                    <p><strong>Bienvenue dans le jeu du Mastermind !</strong></p>
                    <p>Votre objectif est de deviner une combinaison secrète de 4 couleurs parmi 
                        <span style='color: red;'>Rouge</span>, 
                        <span style='color: blue;'>Bleu</span>, 
                        <span style='color: yellow;'>Jaune</span>, 
                        et <span style='color: green;'>Vert</span>.
                    </p>
                    <p>Vous avez jusqu'à 12 essais pour trouver la combinaison correcte.</p>
                    <p>Chaque essai vous donne des indices : 
                        <strong>pions bien placés</strong> et <strong>pions mal placés</strong>.</p>
                    <p>Bonne chance !</p>
                </div>
            </html>
        """);
        txtRegles.setEditable(false);
        txtRegles.setBackground(Color.WHITE);

        JScrollPane scrollRegles = new JScrollPane(txtRegles); // Ajout d'un scroll si nécessaire
        scrollRegles.setPreferredSize(new Dimension(600, 0)); // Largeur réduite pour les règles
        mainPanel.add(scrollRegles, BorderLayout.WEST);

        // Panneau pour les difficultés (à droite)
        JPanel difficultyPanel = new JPanel(new GridLayout(3, 2, 30, 30)); // Espacement ajusté
        difficultyPanel.setPreferredSize(new Dimension(800, 0)); // Largeur inchangée pour le panneau
        difficultyPanel.setBackground(Color.WHITE);

        // Boutons et explications pour chaque difficulté
        // Bouton Facile
        JButton btnFacile = new JButton("Facile");
        btnFacile.setFont(new Font("Arial", Font.PLAIN, 28)); // Taille de police augmentée
        btnFacile.addActionListener(e -> {
            new MasterMindInter("Facile").setVisible(true);
            dispose();
        });

        JTextArea txtFacile = new JTextArea("""
            Combinaison de 4 couleurs uniques.
            
            Vous avez 12 essais pour réussir.
        """);
        configureDifficultyDescription(txtFacile);

        // Bouton Moyen
        JButton btnMoyen = new JButton("Moyen");
        btnMoyen.setFont(new Font("Arial", Font.PLAIN, 28)); // Taille de police augmentée
        btnMoyen.addActionListener(e -> {
            new MasterMindInter("Moyen").setVisible(true);
            dispose();
        });

        JTextArea txtMoyen = new JTextArea("""
            Combinaison de 4 couleurs, doublons possibles.
            
            Vous avez 12 essais pour réussir.
        """);
        configureDifficultyDescription(txtMoyen);

        // Bouton Difficile
        JButton btnDifficile = new JButton("Difficile");
        btnDifficile.setFont(new Font("Arial", Font.PLAIN, 28)); // Taille de police augmentée
        btnDifficile.addActionListener(e -> {
            new MasterMindInter("Difficile").setVisible(true);
            dispose();
        });

        JTextArea txtDifficile = new JTextArea("""
            Combinaison de 4 couleurs, doublons possibles.
            
            Vous avez 8 essais pour réussir.
        """);
        configureDifficultyDescription(txtDifficile);

        // Ajouter les composants au panneau des difficultés
        difficultyPanel.add(btnFacile);
        difficultyPanel.add(txtFacile);
        difficultyPanel.add(btnMoyen);
        difficultyPanel.add(txtMoyen);
        difficultyPanel.add(btnDifficile);
        difficultyPanel.add(txtDifficile);

        mainPanel.add(difficultyPanel, BorderLayout.EAST);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);
    }

    private void configureDifficultyDescription(JTextArea textArea) {
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Police ajustée
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setPreferredSize(new Dimension(600, 120)); // Largeur augmentée
    }



  


    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Lancer l'application
        SwingUtilities.invokeLater(() -> {
            AccueilFenetre accueil = new AccueilFenetre();
            accueil.setVisible(true);
        });
    
    
    
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
            java.util.logging.Logger.getLogger(AccueilFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilFenetre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilFenetre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
