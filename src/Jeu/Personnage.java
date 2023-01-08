package Jeu;

public class Personnage {
    private String nom;
    private int vie;
    private Arme arme;

    private static Personnage instance = null;

    private Personnage(String nom, int vie, Arme arme) {
        this.nom = nom;
        this.vie = vie;
        this.arme = arme;
    }

    public static Personnage getInstance(String nom, int vie, Arme arme) {
        if (instance == null) {
            instance = new Personnage(nom, vie, arme);
        }
        return instance;
    }

    public void attaquer(Ennemi ennemi) {
        int degats = this.arme.getDegats();
        ennemi.subirDegats(degats);
    }

    public void seDefendre() {
        this.vie += 10;
    }

    public int getVie() {
        return this.vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public Arme getArme() {
        return this.arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
}
