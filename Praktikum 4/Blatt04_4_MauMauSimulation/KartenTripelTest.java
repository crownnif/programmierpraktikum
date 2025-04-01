import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse KartenTripelTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class KartenTripelTest
{
    /**
     * Konstruktor fuer die Test-Klasse KartenTripelTest
     */
    Kartenstapel _kartenstapel;
    
    public KartenTripelTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
        _kartenstapel = new Kartenstapel(new spielkarten.Skatspiel());
    }
    
    /**
     * Testet, dass das Tripel keine gleichen Karten enthalten kann.
     */
    @Test
    public void testKeineGleichenKarten()
    {
        spielkarten.Spielkarte k1 = _kartenstapel.obersteKarteZiehen();
        spielkarten.Spielkarte k2 = _kartenstapel.obersteKarteZiehen();
        
        assertThrows(IllegalArgumentException.class, () -> {
            new KartenTripel(k1,k2,k1);
        });
    }
    
    /**
     * Testet, dass das Tripel korrekt angelegt wird.
     */
    @Test
    public void testTripelAnlegen()
    {
        spielkarten.Spielkarte k1 = _kartenstapel.obersteKarteZiehen();
        spielkarten.Spielkarte k2 = _kartenstapel.obersteKarteZiehen();
        spielkarten.Spielkarte k3 = _kartenstapel.obersteKarteZiehen();
        
        KartenTripel tripel = new KartenTripel(k1,k2,k3);
        
        assertEquals(tripel.karte1(), k1);
        assertEquals(tripel.karte2(), k2);
        assertEquals(tripel.karte3(), k3);
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
