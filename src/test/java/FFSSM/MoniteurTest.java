/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RAYNAL Philippe
 */
public class MoniteurTest {
    
    public MoniteurTest() {
    }
    
    LocalDate d, naissance, delivrance;
    public ArrayList<Plongee> lesPlongees;
    Moniteur m;
    Club club;
    Personne possesseur;
    Licence l;
    Plongee p;
    
    @BeforeEach
    public void setUpClass() {
        lesPlongees = new ArrayList<> ();
        
        d = LocalDate.now();
        naissance = LocalDate.now();
        delivrance = LocalDate.now();
        
        m = new Moniteur ("abc ", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance, 1);
        club = new Club(m, "LeMachin", "05 01 02 03 04");
        possesseur = new Personne("abc", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance);
        l = new Licence(possesseur, "01", delivrance, club);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    @Test
    public void testEmployeurActuel() {
        assertEquals(Optional.empty(), m.employeurActuel(),
                        "il n'y a pas de dernier employeur");
        
        m.nouvelleEmbauche(club, d);
        assertEquals(club, m.employeurActuel().get(),
                        "le dernier employeur est le seul club");
    }

    /**
     * Test of nouvelleEmbauche method, of class Moniteur.
     */
    @Test
    public void testNouvelleEmbauche() {
        Embauche e = new Embauche(d, m, club);
        m.nouvelleEmbauche(club, d);
        
        assertEquals(1, m.lesEmbauches.size(),
                        "la nouvelle embauche a été effectuée");
    }

    /**
     * Test of emplois method, of class Moniteur.
     */
    @Test
    public void testEmplois() {
        assertEquals(m.lesEmbauches, m.emplois(),
                        "emplois renvois lesEmbauches");
    }
    
}
