package cpo_mastermind;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julia
 */
import java.util.ArrayList;
import java.util.Random;

public class Combinaison {
    private Pion[] elements;

    // Constructeur
    public Combinaison(Pion[] elements) {
        this.elements = elements;
    }

    // Accesseur pour les éléments
    public Pion[] getElements() {
        return elements;
    }

    // Génère une combinaison aléatoire
    public static Combinaison genererAleatoire(int taille, ArrayList<Character> couleursDisponibles) {
        Random random = new Random();
        Pion[] pions = new Pion[taille];

        for (int i = 0; i < taille; i++) {
            Character couleurAleatoire = couleursDisponibles.get(random.nextInt(couleursDisponibles.size()));
            pions[i] = new Pion(couleurAleatoire);
        }

        return new Combinaison(pions);
    }

    // Compare deux combinaisons et renvoie [noirs, blancs]
    public int[] comparer(Combinaison autre) {
        int noirs = 0;
        int blancs = 0;
        boolean[] marqueSecrete = new boolean[elements.length];
        boolean[] marqueTentative = new boolean[elements.length];

        // Comptage des pions bien placés (noirs)
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].getCouleur().equals(autre.elements[i].getCouleur())) {
                noirs++;
                marqueSecrete[i] = true;
                marqueTentative[i] = true;
            }
        }

        // Comptage des pions bien colorés mais mal placés (blancs)
        for (int i = 0; i < elements.length; i++) {
            if (!marqueTentative[i]) {
                for (int j = 0; j < elements.length; j++) {
                    if (!marqueSecrete[j] && elements[i].getCouleur().equals(autre.elements[j].getCouleur())) {
                        blancs++;
                        marqueSecrete[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{noirs, blancs};
    }

    // Représentation textuelle de la combinaison
    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        for (Pion pion : elements) {
            resultat.append(pion.toString());
        }
        return resultat.toString();
    }
}
