package graphique;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Page {

    public static void main(String[] args) {
        // Cette partie doit être exécutée dans l'EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                creerEtAfficherFenetre();
            }
        });
    }

    public static void creerEtAfficherFenetre() {
        // Création de la fenêtre
        JFrame fenetre = new JFrame("Ma Fenêtre Swing");
        
        // Définition de la taille de la fenêtre
        fenetre.setSize(400, 300);
        
        // Définition du comportement de fermeture par défaut
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Rendre la fenêtre visible
        fenetre.setVisible(true);
    }
}

