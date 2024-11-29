/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author julia
 */
public class Combinaison {
    private Pion[] elements;
    int taille;

    // Constructeur
    public Combinaison(Pion[] elements) {
        this.taille = elements.length;
        this.elements = Arrays.copyOf(elements, taille);
    }

    // Générer une combinaison aléatoire
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Random random = new Random();
        Pion[] pions = new Pion[taille];
        for (int i = 0; i < taille; i++) {
            char couleurAleatoire = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            pions[i] = new Pion(couleurAleatoire);
        }
        return new Combinaison(pions);
    }

    // Comparer deux combinaisons
    public int[] comparer(Combinaison autre) {
        int bienPlaces = 0;
        int malPlaces = 0;
        boolean[] marquesAutre = new boolean[taille];
        boolean[] marquesCette = new boolean[taille];

        // Calcul des pions bien placés (noirs)
        for (int i = 0; i < taille; i++) {
            if (this.elements[i].getCouleur() == autre.elements[i].getCouleur()) {
                bienPlaces++;
                marquesAutre[i] = true;
                marquesCette[i] = true;
            }
        }

        // Calcul des pions mal placés (blancs)
        for (int i = 0; i < taille; i++) {
            if (!marquesCette[i]) {
                for (int j = 0; j < taille; j++) {
                    if (!marquesAutre[j] && this.elements[i].getCouleur() == autre.elements[j].getCouleur()) {
                        malPlaces++;
                        marquesAutre[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{bienPlaces, malPlaces};
    }

    // Représentation textuelle
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pion pion : elements) {
            sb.append(pion.toString());
        }
        return sb.toString();
    }
}