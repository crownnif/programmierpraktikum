import static java.util.Objects.requireNonNull;

/**
 * Vergleicht zwei Personen anhand eines primären Vergleichers.
 * Wenn die beiden Personen laut diesem primären Vergleicher gleich sind,
 * dann werden die Personen anhand eines sekundären Vergleichers verglichen.
 * 
 * @author Fredrik Winkler
 * @version 2021
 */
class Umgekehrt implements Vergleicher
{
    private final Vergleicher _vergleicher;
    
    /**
     * @param primaer der primäre Vergleicher; darf nicht null sein
     * @param sekundaer der sekundäre Vergleicher; darf nicht null sein
     */
    public Umgekehrt(Vergleicher vergleicher)
    {
        _vergleicher = requireNonNull(vergleicher);
    }

    /**
     * @see Vergleicher.vergleiche
     */
    public int vergleiche(Person a, Person b)
    {
        int ergebnis = 0 - _vergleicher.vergleiche(a, b);
        
        return ergebnis;
    }
}
