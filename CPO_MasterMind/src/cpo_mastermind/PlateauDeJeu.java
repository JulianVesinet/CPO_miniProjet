/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author julia
 */
public class PlateauDeJeu {
    private Combinaison combinaisonSecrete;
    private ArrayList<Combinaison> tentatives;
    private ArrayList<String> reponses;
    private int nbToursMax;

    // Constructeur
    public PlateauDeJeu(Combinaison combinaisonSecrete, int nbToursMax) {
        this.combinaisonSecrete = combinaisonSecrete;
        this.tentatives = new ArrayList<>();
        this.reponses = new ArrayList<>();
        this.nbToursMax = nbToursMax;
    }

    // Ajouter une tentative et calculer les indices
    public void proposerCombinaison(Combinaison tentative) {
        tentatives.add(tentative);
        int[] indices = combinaisonSecrete.comparer(tentative);
        String reponse = indices[0] + " noirs, " + indices[1] + " blancs";
        reponses.add(reponse);

        System.out.println("Tentative : " + tentative);
        System.out.println("Réponse : " + reponse);
    }

    // Afficher l'état actuel du plateau
    public void afficherPlateau() {
        System.out.println("État du plateau :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + " : " + tentatives.get(i) + " -> " + reponses.get(i));
        }
    }

    // Vérifier si la victoire est atteinte
    public boolean estVictoire() {
        if (tentatives.isEmpty()) return false;
        Combinaison derniereTentative = tentatives.get(tentatives.size() - 1);
        return combinaisonSecrete.comparer(derniereTentative)[0] == combinaisonSecrete.taille;
    }

    // Vérifier si le nombre maximal de tours est dépassé
    public boolean estDefaite() {
        return tentatives.size() >= nbToursMax && !estVictoire();
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        ArrayList<Character> couleursDisponibles = new ArrayList<>(Arrays.asList('R', 'B', 'G', 'Y'));
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(4, couleursDisponibles);
        PlateauDeJeu plateau = new PlateauDeJeu(combinaisonSecrete, 10);

        System.out.println("La combinaison secrète a été générée.");

        // Simulation de plusieurs tentatives
        for (int i = 0; i < 5; i++) {
            Combinaison tentative = Combinaison.genererAleatoire(4, couleursDisponibles);
            plateau.proposerCombinaison(tentative);
            plateau.afficherPlateau();

            if (plateau.estVictoire()) {
                System.out.println("Félicitations ! Vous avez gagné !");
                break;
            }

            if (plateau.estDefaite()) {
                System.out.println("Dommage, vous avez perdu !");
                break;
            }
        }
    }
}
