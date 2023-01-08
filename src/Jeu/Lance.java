package Jeu;

import java.util.List;

public class Lance extends Arme {
	
	private Ennemi ennemi;
	
    public Lance(String nom, int degatsMin, int degatsMax, List<Technique> techniques, Ennemi ennemi) {
        super(nom, degatsMin, degatsMax, techniques);
        this.ennemi = ennemi;
    }



	@Override
    public void attaquer(Personnage personnage) {
        int degats = this.getDegats();
        this.ennemi.subirDegats(degats);
    }

    @Override
    protected Ennemi getEnnemi() {
        return this.ennemi;
    }

}