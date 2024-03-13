package gui;

/**
 * La classe Partie représente une instance de jeu du pendu, avec un mot à deviner et son état actuel.
 */
public class Partie {

    /**
     * Le mot à deviner dans cette partie.
     */
    private String motADeviner;

    /**
     * Le mot actuel, partiellement révélé au fur et à mesure que le joueur devine les lettres.
     */
    private String motActuel;

    /**
     * Constructeur de la classe Partie.
     *
     * @param motADeviner Le mot à deviner pour cette partie.
     */
    public Partie(String motADeviner) {
        this.motADeviner = motADeviner;
        this.motActuel = "_".repeat(motADeviner.length()); // Initialise avec des underscores
    }

    /**
     * Méthode permettant de deviner une lettre dans le mot à deviner.
     *
     * @param lettre La lettre proposée par le joueur.
     * @return true si la lettre est présente dans le mot à deviner, false sinon.
     */
    public boolean devinerLettre(char lettre) {
        boolean trouve = false;
        StringBuilder nouveauMotActuel = new StringBuilder();

        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre) {
                nouveauMotActuel.append(lettre);
                trouve = true;
            } else {
                nouveauMotActuel.append(motActuel.charAt(i));
            }
        }

        motActuel = nouveauMotActuel.toString();
        return trouve;
    }

    /**
     * Récupère le mot actuel, avec les lettres déjà devinées et les underscores pour les lettres manquantes.
     *
     * @return Le mot actuel.
     */
    public String getMotActuel() {
        return motActuel;
    }

    /**
     * Vérifie si le mot a été entièrement deviné.
     *
     * @return true si le mot a été entièrement deviné, false sinon.
     */
    public boolean estMotDevine() {
        return motActuel.equals(motADeviner);
    }
}
