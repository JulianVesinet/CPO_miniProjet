/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cpo_mastermind;
import java.util.ArrayList;

public class Main {
    public static void dmain(String[] args) {
        // Liste des couleurs disponibles pour les pions
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');  // Rouge
        couleursDisponibles.add('B');  // Bleu
        couleursDisponibles.add('G');  // Vert
        couleursDisponibles.add('Y');  // Jaune

        // Création d'une nouvelle partie avec :
        // - une combinaison de 4 pions
        // - un nombre maximum de 10 tours
        // - les couleurs disponibles pour la combinaison
        Partie partie = new Partie(4, 10, couleursDisponibles);

        // Démarrer la partie
        partie.lancerPartie();
    }
}
