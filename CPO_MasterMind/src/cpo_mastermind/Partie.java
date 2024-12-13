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
import java.util.List;
import java.util.Scanner;

public class Partie {
    private PlateauDeJeu plateau;
    private ArrayList<Character> couleursDisponibles;
    

    // Constructeur
    public Partie(int tailleCombinaison, int nbToursMax, List<Character> couleursDisponibles) {
        this.couleursDisponibles = new ArrayList<>(couleursDisponibles);
        Combinaison combinaisonSecrete = Combinaison.genererAleatoire(tailleCombinaison, this.couleursDisponibles);
        this.plateau = new PlateauDeJeu(combinaisonSecrete, nbToursMax);
    }

    // Affiche les règles du jeu
    public void afficherRegles() {
        System.out.println("Bienvenue dans le jeu MasterMind !");
        System.out.println("Règles :");
        System.out.println("- Vous devez deviner une combinaison de 4 pions.");
        System.out.println("- Les pions peuvent avoir les couleurs suivantes : " + couleursDisponibles);
        System.out.println("- Après chaque tentative, vous recevrez des indices :");
        System.out.println("  * Noir : bonne couleur et bien placée.");
        System.out.println("  * Blanc : bonne couleur mais mal placée.");
        System.out.println("- Vous avez un nombre limité de tentatives pour trouver la bonne combinaison.");
    }

    // Lance la partie
    public void lancerPartie() {
        Scanner scanner = new Scanner(System.in);
        afficherRegles();

        while (!plateau.estVictoire() && !plateau.estDefaite()) {
            System.out.println("Entrez une combinaison (4 lettres parmi : " + couleursDisponibles + "):");
            String entreeUtilisateur = scanner.nextLine().toUpperCase().trim();

            if (entreeUtilisateur.length() != 4 || !estCombinaisonValide(entreeUtilisateur)) {
                System.out.println("Entrée invalide. Veuillez entrer exactement 4 lettres parmi les couleurs disponibles.");
                continue;
            }

            Pion[] pions = new Pion[4];
            for (int i = 0; i < 4; i++) {
                pions[i] = new Pion(entreeUtilisateur.charAt(i));
            }

            plateau.proposerCombinaison(new Combinaison(pions));
        }

        terminerPartie();
    }

    // Vérifie la validité d'une combinaison
    private boolean estCombinaisonValide(String combinaison) {
        for (char c : combinaison.toCharArray()) {
            if (!couleursDisponibles.contains(c)) {
                return false;
            }
        }
        return true;
    }

    // Affiche le résultat final
    public void terminerPartie() {
        if (plateau.estVictoire()) {
            System.out.println("Félicitations ! Vous avez trouvé la combinaison secrète !");
        } else {
            System.out.println("Défaite ! Vous avez épuisé toutes vos tentatives.");
            System.out.println("La combinaison secrète était : " + plateau.getCombinaisonSecrete().toString());
        }
    }

    // Méthode principale pour démarrer une partie
    public static void main(String[] args) {
        ArrayList<Character> couleursDisponibles = new ArrayList<>();
        couleursDisponibles.add('R');
        couleursDisponibles.add('B');
        couleursDisponibles.add('G');
        couleursDisponibles.add('Y');

        Partie partie = new Partie(4, 10, couleursDisponibles);
        partie.lancerPartie();
    }
}

