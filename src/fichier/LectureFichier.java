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
            List<String> premiersMots = new ArrayList<>();
            List<String> lignes = Files.readAllLines(Paths.get(nomFichier));
            for (String ligne : lignes) {
                String[] motsDansLigne = ligne.split("\\s+"); // Séparation par espace(s)
                if (motsDansLigne.length > 0) {
                    premiersMots.add(motsDansLigne[0]); // Ajouter le premier mot de la ligne
                }
            }

            // Afficher la liste des premiers mots; à supprimer
            System.out.println("Liste des premiers mots :");
            for (String mot : premiersMots) {
                System.out.println(mot);
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }
    }
}
