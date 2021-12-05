/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
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
public class PlongeeTest {
    
    public PlongeeTest() {
    }
    
    LocalDate d, naissance, delivrance;
    ArrayList<Licence> lesParticipants;
    Moniteur président;
    Club club;
    Personne possesseur;
    Licence l;
    Plongee p;
    
    @BeforeEach
    public void setUpClass() {
        lesParticipants = new ArrayList<>();
        
        d = LocalDate.now();
        naissance = LocalDate.now();
        delivrance = LocalDate.now();
        
        président = new Moniteur ("abc ", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance, 1);
        club = new Club(président, "LeMachin", "05 01 02 03 04");
        possesseur = new Personne("abc", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance);
        l = new Licence(possesseur, "01", delivrance, club);
        
        p = new Plongee(new Site("nom", "details"), président, d, 20, 10);
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
     * Test of ajouteParticipant method, of class Plongee.
     */
    @Test
    public void testAjouteParticipant() {
        lesParticipants.add(l);
        
        assertEquals(1, lesParticipants.size(),
                        "1 participant est dans la liste");
    }

    /**
     * Test of getDate method, of class Plongee.
     */
    @Test
    public void testGetDate() {
        assertEquals(d, p.getDate(),
                        "retourne la date actuelle");
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConforme() {
        Licence l2 = l;
        Licence l3 = l;
        p.ajouteParticipant(l);
        p.ajouteParticipant(l2);
        p.ajouteParticipant(l3);
        
        assertEquals(true, p.estConforme(),
                        "tous les participants de la plongee sont conformes");
        
        Licence l4 = new Licence(possesseur, "01", delivrance.minusYears(18), club);
        p.ajouteParticipant(l4);
        assertEquals(false, p.estConforme(),
                        "tous les participants de la plongee ne sont pas conformes");
    }
}
