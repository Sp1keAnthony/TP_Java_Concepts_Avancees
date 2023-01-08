package Jeu;
import java.util.List;

public abstract class Arme {
    private String nom;
    private int degatsMin;
    private int degatsMax;
    private List<Technique> techniques;

    public Arme(String nom, int degatsMin, int degatsMax, List<Technique> techniques) {
        this.setNom(nom);
        this.degatsMin = degatsMin;
        this.degatsMax = degatsMax;
        this.techniques = techniques;
    }

    public abstract void attaquer(Personnage personnage);

    public int getDegats() {
        return this.degatsMin + (int)(Math.random() * (this.degatsMax - this.degatsMin + 1));
    }

    public List<Technique> getTechniques() {
        return this.techniques;
    }

	protected abstract Ennemi getEnnemi();

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
