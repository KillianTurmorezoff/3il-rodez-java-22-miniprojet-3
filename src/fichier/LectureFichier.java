package fichier;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectureFichier {

    public static void main(String[] args) {
        String nomFichier = "mots.txt";

        try {
            List<String> mots = new ArrayList<>();
            List<String> lignes = Files.readAllLines(Paths.get(nomFichier));
            for (String ligne : lignes) {
                String[] motsDansLigne = ligne.split("\\s+"); // Séparation par espace(s)
                for (String mot : motsDansLigne) {
                    mots.add(mot);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
