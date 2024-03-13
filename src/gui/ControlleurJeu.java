package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe représente le contrôleur du jeu de Pendu. Elle gère l'interface graphique et la logique du jeu.
 */
public class ControlleurJeu extends JFrame implements ActionListener {
    // Déclaration des variables de classe...
	private static final long serialVersionUID = 1L;
	private Partie partie;
    private JLabel motLabel;
    private JTextField lettreField;
    private int nombreErreurs;
    private JLabel penduLabel;
    private Set<Character> lettresProposees;
    
    /**
     * Constructeur de la classe ControlleurJeu.
     *
     * @param mot Le mot à deviner dans le jeu.
     */
    public ControlleurJeu(String mot) {
        this.partie = new Partie(mot);
        this.nombreErreurs = 0;
        this.lettresProposees = new HashSet<>();
        initUI();
    }
    
    /**
     * Initialise l'interface utilisateur.
     */
    private void initUI() {
        setTitle("Jeu de Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        motLabel = new JLabel(partie.getMotActuel(), SwingConstants.CENTER);
        add(motLabel, BorderLayout.CENTER);

        penduLabel = new JLabel("", SwingConstants.CENTER);
        penduLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
        updatePenduLabel();
        add(penduLabel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JLabel lettresProposeesLabel = new JLabel("Lettres proposées : ");
        bottomPanel.add(lettresProposeesLabel);

        lettreField = new JTextField(10);
        lettreField.addActionListener(this);
        bottomPanel.add(lettreField);

        add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    /**
     * Met à jour l'affichage du pendu en fonction du nombre d'erreurs.
     */
    private void updatePenduLabel() {
        StringBuilder penduStr = new StringBuilder("Pendu : ");
        for (int i = 0; i < nombreErreurs; i++) {
            penduStr.append("| ");
        }
        penduLabel.setText(penduStr.toString());
    }

    /**
     * Met à jour l'affichage des lettres déjà proposées par le joueur.
     *
     * @param lettre La lettre proposée par le joueur.
     */
    private void updateLettresProposeesLabel(char lettre) {
        lettresProposees.add(lettre);
        StringBuilder lettresProposeesStr = new StringBuilder("Lettres proposées : ");
        for (char l : lettresProposees) {
            lettresProposeesStr.append(l).append(" ");
        }
        lettreField.setText("");
        lettreField.setToolTipText(lettresProposeesStr.toString());
    }

    /**
     * Gère les actions à effectuer lorsqu'un événement (clic sur le bouton) se produit.
     *
     * @param e L'événement déclenché.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String lettreStr = lettreField.getText().toLowerCase();
        if (lettreStr.length() == 1 && Character.isLetter(lettreStr.charAt(0))) {
            char lettre = lettreStr.charAt(0);
            if (lettresProposees.contains(lettre)) {
                JOptionPane.showMessageDialog(this, "Vous avez déjà proposé cette lettre !");
                return;
            }
            if (partie.devinerLettre(lettre)) {
                JOptionPane.showMessageDialog(this, "Lettre trouvée !");
            } else {
                JOptionPane.showMessageDialog(this, "Lettre incorrecte !");
                nombreErreurs++;
                updatePenduLabel();
                if (nombreErreurs >= 6) {
                    JOptionPane.showMessageDialog(this, "Vous avez perdu !");
                    dispose();
                }
            }
            updateLettresProposeesLabel(lettre);
            motLabel.setText(partie.getMotActuel());
            if (partie.estMotDevine()) {
                JOptionPane.showMessageDialog(this, "Félicitations, vous avez deviné le mot : " + partie.getMotActuel());
                dispose();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une lettre valide !");
            lettreField.setText("");
        }
    }

    /**
     * Point d'entrée du programme. Crée une instance de la classe ControlleurJeu avec un mot aléatoire.
     *
     * @param args Les arguments de la ligne de commande (non utilisés).
     */
    public static void main(String[] args) {
        MotsReader motsReader = new MotsReader("mots.txt");
        String motAleatoire = motsReader.choisirMotAleatoire();
        System.out.println(motAleatoire);

        SwingUtilities.invokeLater(() -> new ControlleurJeu(motAleatoire));
    }
}
