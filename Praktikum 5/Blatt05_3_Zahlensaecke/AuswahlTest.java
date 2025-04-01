

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse AuswahlTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class AuswahlTest
{
    Zahlensack _zSack;
    int _sackGroesse = 20;
    
    /**
     * Konstruktor fuer die Test-Klasse AuswahlTest
     */
    public AuswahlTest()
    {
        _zSack = new Auswahl(_sackGroesse);
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    /**
     * 
     */
    @Test
    public void testZahlensackKorrektGross()
    {
        assertEquals(_zSack.gibGroesse(), _sackGroesse);
    }
    
    /**
     * 
     */
    @Test
    public void testAnzahlKorrekt()
    {
        assertEquals(_zSack.gibAnzahl(), 0);
        _zSack.entferneZahl();
        assertEquals(_zSack.gibAnzahl(), _sackGroesse-1);
        _zSack.leereSack();
        assertEquals(_zSack.gibAnzahl(), 0);
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
