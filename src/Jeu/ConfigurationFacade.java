package Jeu;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationFacade {

	public static List<Ennemi> lireEnnemis() {
	    List<Ennemi> ennemis = new ArrayList<>();

	    try (BufferedReader br = new BufferedReader(new FileReader("src/Jeu/ennemis.txt"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	            String nom = data[0];
	            int vie = Integer.parseInt(data[1]);
	            int degatsMin = Integer.parseInt(data[2]);
	            int degatsMax = Integer.parseInt(data[3]);
	            ennemis.add(new Ennemi(nom, vie, degatsMin, degatsMax));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return ennemis;
	}
	public static void main(String[] args) throws IOException {
	    List<Ennemi> ennemis = lireEnnemis();
	    System.out.println("Liste des ennemis :");
	    for (Ennemi ennemi : ennemis) {
	        System.out.println(ennemi);
	    }
	    List<Technique> techniques = lireTechniques();
	    System.out.println("Liste des techniques :");
	    for (Technique technique : techniques) {
	        System.out.println(technique.getNom() + " (" + technique.getMultiplicateur() + ")");
	    }
	    List<Arme> armes = lireArmes();
	    System.out.println("Liste des armes :");
	    for (Arme arme : armes) {
	        System.out.println(arme.getNom() + " (" + arme.getDegats() + ")");
	        for (Technique technique : arme.getTechniques()) {
	            System.out.println("  - " + technique.getNom() + " (" + technique.getMultiplicateur() + ")");
	        }
	    }
	}
    public static List<Arme> lireArmes() {
        List<Arme> armes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/Jeu/armes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String nom = data[0];
                int degatsMin = Integer.parseInt(data[1]);
                int degatsMax = Integer.parseInt(data[2]);
                List<Technique> techniques = new ArrayList<>();
                for (int i = 3; i < data.length; i++) {
                    techniques.add(new Technique(data[i], lireTechniques().get(i - 3).getMultiplicateur()));
                }
                if (nom.equals("Epee")) {
                    armes.add(new Epee(nom, degatsMin, degatsMax, techniques, null));
                } else if (nom.equals("Lance")) {
                    armes.add(new Lance(nom, degatsMin, degatsMax, techniques, null));
                } else if (nom.equals("Arc")) {
                    armes.add(new Arc(nom, degatsMin, degatsMax, techniques, null));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return armes;
    }

    public static List<Technique> lireTechniques() {
        List<Technique> techniques = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader("src/Jeu/techniques.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String nom = data[0];
                int multiplicateur = Integer.parseInt(data[1]);
                techniques.add(new Technique(nom, multiplicateur));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return techniques;
    }
}
