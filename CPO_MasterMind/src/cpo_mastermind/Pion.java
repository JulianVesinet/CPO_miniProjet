package cpo_mastermind;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author julia
 */
public class Pion {
    private Character couleur;

    // Constructeur
    public Pion(Character couleur) {
        this.couleur = couleur;
    }

    // Accesseur
    public Character getCouleur() {
        return couleur;
    }

    // Représentation textuelle du pion
    @Override
    public String toString() {
        return couleur.toString();
    }
}
