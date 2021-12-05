/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Set;
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
public class ClubTest {
    
    public ClubTest() {
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
    
    LocalDate d, naissance, delivrance;
    public ArrayList<Plongee> lesPlongees;
    Moniteur président, présidentn;
    Club club;
    Personne possesseur;
    Licence l, ln;
    Plongee p;
    
    @BeforeEach
    public void setUpClass() {
        lesPlongees = new ArrayList<> ();
        
        d = LocalDate.now();
        naissance = LocalDate.now();
        delivrance = LocalDate.now();
        
        président = new Moniteur ("abc ", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance, 1);
        club = new Club(président, "LeMachin", "05 01 02 03 04");
        possesseur = new Personne("abc", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance);
        l = new Licence(possesseur, "01", delivrance, club);
        
        présidentn = new Moniteur ("abc ", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance, 1);
        club = new Club(président, "LeMachin", "05 01 02 03 04");
        possesseur = new Personne("abc", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance);
        ln = new Licence(possesseur, "01", delivrance.minusYears(18), club);
        
        p = new Plongee(new Site("nom", "details"), président, d, 20, 10);
    }

    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    @Test
    public void testPlongeesNonConformes() {
        Plongee p2 = p;
        club.organisePlongee(p);
        club.organisePlongee(p2);
        
        assertEquals(0, club.plongeesNonConformes().size(),
                        "la liste des plongées non conforme est vide");
        
        Plongee p3 = p;
        p3.ajouteParticipant(ln);
        club.organisePlongee(p3);
        assertEquals(1, club.plongeesNonConformes().size(),
                        "la liste des plongées non conforme contient 1 élément");
    }

    /**
     * Test of organisePlongee method, of class Club.
     */
    @Test
    public void testOrganisePlongee() {
        club.lesPlongees.add(p);
        
        assertEquals(1, club.lesPlongees.size(),
                        "1 plongée est dans la liste du club");
    }
}
