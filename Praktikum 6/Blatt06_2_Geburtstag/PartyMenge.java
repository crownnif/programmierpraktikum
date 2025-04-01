import java.util.Objects;
import java.util.HashSet;

/**
 * Beschreiben Sie hier die Klasse PartyMenge.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PartyMenge implements Party
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private HashSet<Tag> _geburtstage;
    boolean _duplikatGeburtstag;

    /**
     * Konstruktor für Objekte der Klasse PartyMenge
     */
    public PartyMenge()
    {
        _geburtstage = new HashSet<Tag>();
        _duplikatGeburtstag = false;
    }

    public void fuegeGeburtstagHinzu(Tag geburtstag)
    {
        Objects.requireNonNull(geburtstag);
        if(!_geburtstage.add(geburtstag))
            _duplikatGeburtstag = true;
    }
    
    public boolean mindestensEinGeburtstagMehrfach()
    {
        return _duplikatGeburtstag;
    }
}
