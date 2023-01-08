package Jeu;
public class Ennemi {
    private String nom;
    private int vie;
    private int degatsMin;
    private int degatsMax;

    public Ennemi(String nom, int vie, int degatsMin, int degatsMax) {
        this.nom = nom;
        this.vie = vie;
        this.degatsMin = degatsMin;
        this.degatsMax = degatsMax;
    }

    public void attaquer(Personnage personnage) {
        int degats = this.getDegats();
        personnage.subirDegats(degats);
    }

    public void subirDegats(int degats) {
        this.vie -= degats;
    }

    public int getDegats() {
        return this.degatsMin + (int)(Math.random() * (this.degatsMax - this.degatsMin + 1));
    }

    public int getVie() {
        return this.vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getDegatsMin() {
        return this.degatsMin;
    }

    public void setDegatsMin(int degatsMin) {
        this.degatsMin = degatsMin;
    }

    public int getDegatsMax() {
        return this.degatsMax;
    }

    public void setDegatsMax(int degatsMax) {
        this.degatsMax = degatsMax;
    }

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    @Override
    public String toString() {
        return this.nom + " (" + this.vie + " PV, dégâts : " + this.degatsMin + "-" + this.degatsMax + ")";
    }
}
