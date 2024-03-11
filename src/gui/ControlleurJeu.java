package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurJeu extends JFrame implements ActionListener {
    private Partie partie;
    private JLabel motLabel;
    private JTextField lettreField;

    public ControlleurJeu(String mot) {
        this.partie = new Partie(mot);
        initUI();
    }

    private void initUI() {
        setTitle("Jeu de Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        motLabel = new JLabel(partie.getMotActuel(), SwingConstants.CENTER);
        add(motLabel, BorderLayout.CENTER);

        lettreField = new JTextField(10);
        lettreField.addActionListener(this);
        add(lettreField, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String lettreStr = lettreField.getText().toLowerCase();
        if (lettreStr.length() == 1 && Character.isLetter(lettreStr.charAt(0))) {
            char lettre = lettreStr.charAt(0);
            if (partie.devinerLettre(lettre)) {
                JOptionPane.showMessageDialog(this, "Lettre trouvée !");
            } else {
                JOptionPane.showMessageDialog(this, "Lettre incorrecte !");
            }
            lettreField.setText("");
            motLabel.setText(partie.getMotActuel());
            if (partie.estMotDevine()) {
                JOptionPane.showMessageDialog(this, "Félicitations, vous avez deviné le mot : " + partie.getMotActuel());
                dispose(); // Fermer la fenêtre après la fin de la partie
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une lettre valide !");
            lettreField.setText("");
        }
    }

    public static void main(String[] args) {
        MotsReader motsReader = new MotsReader("mots.txt");
        String motAleatoire = motsReader.choisirMotAleatoire();

        SwingUtilities.invokeLater(() -> new ControlleurJeu(motAleatoire));
    }
}
