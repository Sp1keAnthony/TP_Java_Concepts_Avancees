package Jeu;
import java.util.Scanner;

public class Jeu {
    public static void combattre(Personnage personnage, Ennemi ennemi) {
        try (Scanner sc = new Scanner(System.in)) {
			while (personnage.getVie() > 0 && ennemi.getVie() > 0) {
			    System.out.println("C'est ton tour, que veux-tu faire ?");
			    System.out.println("1. Attaquer");
			    System.out.println("3. Utiliser une technique");

			    int choix = sc.nextInt();
			    sc.nextLine();

			    switch (choix) {
			        case 1:
			            personnage.attaquer(ennemi);
			            break;
			        case 2:
			            System.out.println("Quelle technique veux-tu utiliser ?");
			            int i = 1;
			            for (Technique technique : personnage.getArme().getTechniques()) {
			                System.out.println(i + ". " + technique.getNom());
			                i++;
			            }
			            int choixTechnique = sc.nextInt();
			            sc.nextLine();

			            personnage.getArme().getTechniques().get(choixTechnique - 1).utiliser(personnage);
			            break;
			        default:
			            System.out.println("Choix incorrect !");
			            break;
			    }

			    if (ennemi.getVie() > 0) {
			        ennemi.attaquer(personnage);
			    }

			    System.out.println("Vie du personnage : " + personnage.getVie());
			    System.out.println("Vie de l'ennemi : " + ennemi.getVie());
			}
		}

        if (personnage.getVie() <= 0) {
            System.out.println("Le personnage est mort !");
        } else {
            System.out.println("L'ennemi est mort !");
        }
    }

    public static void jouer() {
        // TODO : instanciation du personnage et des ennemis via le pattern Facade
        Personnage personnage = Personnage.getInstance("Personnage", 200, new Epee("Epee", 10, 20, null, null));
        Ennemi ennemi = new Ennemi("Ennemi", 100, 5, 10);

        // TODO : exécution du combat dans un thread
        combattre(personnage, ennemi);
    }
}
