/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind;

import java.util.ArrayList;
import java.util.Arrays;

public class CPO_MasterMind {

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

        // Génération d'une combinaison aléatoire pour le plateau
        ArrayList<Character> couleursDisponibles = new ArrayList<>(Arrays.asList('R', 'B', 'G', 'Y'));
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(4, couleursDisponibles);

        // Initialisation du plateau de jeu
        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);
        System.out.println("\nLa combinaison secrète a été générée.\n");

        // Simulation de plusieurs tentatives
        for (int i = 0; i < 5; i++) {
            Combinaison tentative = Combinaison.genererAleatoire(4, couleursDisponibles);
            System.out.println("Tentative " + (i + 1) + " : " + tentative);

            plateau.proposerCombinaison(tentative);
            plateau.afficherPlateau();

            // Vérification des conditions de victoire ou défaite
            if (plateau.estVictoire()) {
                System.out.println("Félicitations ! Vous avez deviné la combinaison secrète !");
                break;
            } else if (plateau.estDefaite()) {
                System.out.println("Dommage, vous avez épuisé vos tentatives !");
                break;
            }
        }
    }
}
