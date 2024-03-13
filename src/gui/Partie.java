package gui;

public class Partie {
    private String motADeviner;
    private String motActuel;

    public Partie(String motADeviner) {
        this.motADeviner = motADeviner;
        this.motActuel = "_".repeat(motADeviner.length()); // Initialise avec des underscores
    }

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

    public String getMotActuel() {
        return motActuel;
    }

    public boolean estMotDevine() {
        return motActuel.equals(motADeviner);
    }
}
