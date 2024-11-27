/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind;

/**
 *
 * @author julia
 */
public class CPO_MasterMind {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        // TODO code application logic here
                // Création de quelques pions
        Pion pionRouge = new Pion('R');
        Pion pionBleu = new Pion('B');
        Pion pionVert = new Pion('V');
        
        // Affichage des couleurs des pions
        System.out.println("Couleur du pion rouge : " + pionRouge.toString());
        System.out.println("Couleur du pion bleu : " + pionBleu.toString());
        System.out.println("Couleur du pion vert : " + pionVert.toString());

        // Test de la méthode getCouleur()
        System.out.println("Couleur du pion rouge : " + pionRouge.getCouleur());
        System.out.println("Couleur du pion bleu : " + pionBleu.getCouleur());
        System.out.println("Couleur du pion vert : " + pionVert.getCouleur());
    }
   
}
