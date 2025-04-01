import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Diese Klasse testet den Wortschatz.
 *
 * @author Fredrik Winkler
 * @version 2021
 */
public class WortschatzTest
{
    private final Wortschatz _schatz;
    
    /**
     * Jede Testmethode arbeitet auf einem frisch erzeugten Exemplar.
     */
    public WortschatzTest()
    {
        _schatz = new HashWortschatz(new Delegation(), 10);
    }
    
    /**
     * Stellt sicher, dass ein neuer Wortschatz leer ist.
     */
    @Test
    public void testNeuerWortschatzIstLeer()
    {
        assertEquals(0, _schatz.anzahlWoerter());
    }

    /**
     * 
     */
    @Test
    public void testHinzugefuegtesWortIstEnthalten()
    {
        _schatz.fuegeWortHinzu("Banana");
        assertEquals(true, _schatz.enthaeltWort("Banana"));
    }
    
    /**
     * 
     */
    @Test
    public void testEntferntesWortIstNichtEnthalten()
    {
        _schatz.fuegeWortHinzu("Banana");
        _schatz.entferneWort("Banana");
        assertEquals(false, _schatz.enthaeltWort("Banana"));
    }
    
    /**
     * 
     */
    @Test
    public void testNichtHinzugefuegtesWortIstNichtEnthalten()
    {
        assertEquals(false, _schatz.enthaeltWort("Aaaaaaaaaijdoiewoid23"));
    }
    
    /**
     * 
     */
    @Test
    public void testDuplikateWerdenNichtHinzugefuegt()
    {
        _schatz.fuegeWortHinzu("Banana");
        _schatz.fuegeWortHinzu("Banana");
        assertEquals(1, _schatz.anzahlWoerter());
    }
    
    /**
     * 
     */
    @Test
    public void testEntfernenNichtEnthaltenerWoerterBewirktNichts()
    {
        _schatz.entferneWort("Hallo");
        assertEquals(0, _schatz.anzahlWoerter());
    }
    
    /**
     * 
     */
    @Test
    public void testBadHash()
    {
        HashWortschatz badSchatz = new HashWortschatz(new BadHash(), 10);
        
        badSchatz.fuegeWortHinzu("Hallo");
        badSchatz.fuegeWortHinzu("Orange");
        badSchatz.fuegeWortHinzu("ohne");
        badSchatz.fuegeWortHinzu("Beere");
        badSchatz.fuegeWortHinzu("Olaf");
        
        assertEquals(badSchatz.anzahlWoerter(), badSchatz.laengsteKette());
    }
}
