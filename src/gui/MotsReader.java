package gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MotsReader {
    private List<String> mots = new ArrayList<>();
    private Random random = new Random();

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

    public String choisirMotAleatoire() {
        return mots.get(random.nextInt(mots.size()));
    }
}
