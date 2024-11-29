package cpo_mastermind;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julia
 */
import cpo_mastermind.Combinaison;
import java.util.ArrayList;

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

    // Accesseur pour la combinaison secrète
    public Combinaison getCombinaisonSecrete() {
        return combinaisonSecrete;
    }

    // Ajoute une tentative et génère les indices correspondants
    public void proposerCombinaison(Combinaison tentative) {
        tentatives.add(tentative);
        int[] resultat = tentative.comparer(combinaisonSecrete);
        String reponse = resultat[0] + " noirs, " + resultat[1] + " blancs";
        reponses.add(reponse);
        afficherPlateau();
    }

    // Affiche l'état actuel du plateau
    public void afficherPlateau() {
        System.out.println("État actuel du plateau :");
        for (int i = 0; i < tentatives.size(); i++) {
            System.out.println("Tentative " + (i + 1) + " : " + tentatives.get(i) + " -> Réponse : " + reponses.get(i));
        }
    }

    // Vérifie si la dernière tentative est une victoire
    public boolean estVictoire() {
        if (tentatives.isEmpty()) return false;
        return tentatives.get(tentatives.size() - 1).comparer(combinaisonSecrete)[0] == combinaisonSecrete.getElements().length;
    }

    // Vérifie si le joueur a dépassé le nombre maximum de tours
    public boolean estDefaite() {
        return tentatives.size() >= nbToursMax && !estVictoire();
    }
}
