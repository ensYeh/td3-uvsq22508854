package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Test;

public class NomMachineTest {
    @Test
    public void testNomValide() {
        NomMachine nm = new NomMachine("www.uvsq.fr");
        assertEquals("www", nm.getNomMachine());
        assertEquals("uvsq.fr", nm.getDomaine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNomInvalide() {
        new NomMachine("uvsqfr"); // pas de points
    }

    @Test
    public void testEqualsEtHashCode() {
        NomMachine n1 = new NomMachine("mail.google.com");
        NomMachine n2 = new NomMachine("mail.google.com");
        assertTrue(n1.equals(n2));
        assertEquals(n1.hashCode(), n2.hashCode());
    }
}
