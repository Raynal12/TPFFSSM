/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
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
public class LicenceTest {
    
    public LicenceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
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
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValide() {
        LocalDate d = LocalDate.now();
        LocalDate naissance = LocalDate.now();
        LocalDate delivrance = LocalDate.now();
        Moniteur président = new Moniteur ("abc ", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance, 1);
        Club club = new Club(président, "LeMachin", "05 01 02 03 04");
        Personne possesseur = new Personne("abc", "LeMachin", "Untel", "81 100 Castres", "05 01 02 03 04", naissance);
        
        Licence l = new Licence(possesseur, "01", delivrance, club);
        
        assertEquals(true, l.estValide(d),
                        "la licence est valide");
        
        d = d.plusYears(3);
        assertEquals(false, l.estValide(d),
                        "la licence est invalide");
    }
    
}
