package gui;


/**
 * La classe MotsReader permet de lire une liste de mots à partir d'un fichier texte
 * et de choisir aléatoirement un mot parmi ceux lus.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MotsReader {
    private List<String> mots = new ArrayList<>();
    private Random random = new Random();

    /**
     * Constructeur de la classe MotsReader.
     *
     * @param fileName Le nom du fichier texte à partir duquel les mots seront lus.
     */
    public MotsReader(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mots.add(line.split(" ")[0]); // Seulement le mot sans la définition
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Choisi aléatoirement un mot parmi ceux lus à partir du fichier texte.
     *
     * @return Le mot choisi aléatoirement.
     */
    public String choisirMotAleatoire() {
        return mots.get(random.nextInt(mots.size()));
    }
}
