/**
 * Gibt stets die gleiche Hash-Zahl aus
 * 
 * @author Finn Kronjäger
 * @version 2022
 */
class BadHash implements HashWertBerechner
{
    /**
     * Bildet das gegebene Wort auf 666 ab*/
    public int hashWert(String wort)
    {
        return 666;
    }
    
    /**
     * Liefert eine Beschreibung fuer die Art der Berechnung.
     */
    public String gibBeschreibung()
    {
        return "Gibt eine konstante Zahl";
    }
}
