package Jeu;

import Jeu.Ennemi;

public class Technique {
    private String nom;
    private int multiplicateur;
    private boolean utilisee;
    private Ennemi ennemi;

    public Ennemi getEnnemi() {
        return this.ennemi;
    }

    public Technique(String nom, int multiplicateur) {
        this.nom = nom;
        this.multiplicateur = multiplicateur;
        this.utilisee = false;
    }

    public void utiliser(Personnage personnage) {
        if (!this.utilisee) {
            int degats = personnage.getArme().getDegats() * this.multiplicateur;
            personnage.getArme().getEnnemi().subirDegats(degats);
            this.utilisee = true;
        } else {
            System.out.println("Cette technique a déjà été utilisée !");
        }
    }
    
    public String getNom() {
        return this.nom;
    }

    public int getMultiplicateur() {
        return this.multiplicateur;
    }
}
