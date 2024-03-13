package gui;

import static org.junit.Assert.*;
import org.junit.Test;


public class TestJeuDePendu {

    @Test
    public void testChoisirMotAleatoire() {
        MotsReader motsReader = new MotsReader("mots.txt");
        String mot = motsReader.choisirMotAleatoire();
        assertNotNull(mot);
        assertFalse(mot.isEmpty());
    }

    @Test
    public void testDevineLettreCorrecte() {
        Partie partie = new Partie("test");
        assertTrue(partie.devinerLettre('t'));
        assertEquals("t__t", partie.getMotActuel());
    }

    @Test
    public void testDevineLettreIncorrecte() {
        Partie partie = new Partie("test");
        assertFalse(partie.devinerLettre('x'));
        assertEquals("____", partie.getMotActuel());
    }

    @Test
    public void testMotDevine() {
        Partie partie = new Partie("test");
        partie.devinerLettre('t');
        partie.devinerLettre('e');
        partie.devinerLettre('s');
        assertTrue(partie.estMotDevine());
    }

    @Test
    public void testMotNonDevine() {
        Partie partie = new Partie("test");
        partie.devinerLettre('t');
        partie.devinerLettre('e');
        assertFalse(partie.estMotDevine());
    }
}
