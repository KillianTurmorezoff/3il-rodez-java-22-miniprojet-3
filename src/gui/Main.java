package gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MotsReader motsReader = new MotsReader("mots.txt");
        String motAleatoire = motsReader.choisirMotAleatoire();

        SwingUtilities.invokeLater(() -> new ControlleurJeu(motAleatoire));
    }
}
