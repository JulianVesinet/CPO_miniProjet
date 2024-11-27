/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author julia
 */
public class CPO_MasterMind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Création de quelques pions
        Pion pionRouge = new Pion('R');
        Pion pionBleu = new Pion('B');
        Pion pionVert = new Pion('V');

        // Affichage des couleurs des pions
        System.out.println("Couleur du pion rouge : " + pionRouge);
        System.out.println("Couleur du pion bleu : " + pionBleu);
        System.out.println("Couleur du pion vert : " + pionVert);

        // Test de la méthode getCouleur()
        System.out.println("Couleur du pion rouge : " + pionRouge.getCouleur());
        System.out.println("Couleur du pion bleu : " + pionBleu.getCouleur());
        System.out.println("Couleur du pion vert : " + pionVert.getCouleur());

        // Création d'une combinaison statique
        Pion[] pionsFixes = {pionRouge, pionBleu, pionVert, new Pion('Y')};
        Combinaison combinaisonFixe = new Combinaison(pionsFixes);
        System.out.println("Combinaison fixe : " + combinaisonFixe);

        // Génération d'une combinaison aléatoire
        ArrayList<Character> couleursDisponibles = new ArrayList<>(Arrays.asList('R', 'B', 'G', 'Y'));
        Combinaison combinaisonAleatoire = Combinaison.genererAleatoire(4, couleursDisponibles);
        System.out.println("Combinaison aléatoire : " + combinaisonAleatoire);

        // Comparaison des deux combinaisons
        int[] resultatComparaison = combinaisonFixe.comparer(combinaisonAleatoire);
        System.out.println("Résultat de la comparaison : " + resultatComparaison[0] + " noirs, " + resultatComparaison[1] + " blancs");
    }
}