/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cpo_mastermind;

/**
 *
 * @author julia
 */
public class Pion {
    // Attributs
    private char couleur; // Représente la couleur du pion

    // Constructeur
    public Pion(char couleur) {
        this.couleur = couleur; // Initialisation de la couleur
    }

    // Méthode getCouleur : retourne la couleur du pion
    public char getCouleur() {
        return this.couleur;
    }

    // Méthode toString : retourne une représentation textuelle de la couleur du pion
    @Override
    public String toString() {
        return String.valueOf(this.couleur); // Convertit la couleur en String
    }
}