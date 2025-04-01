import spielkarten.Spielkarte; 

/**
 * Beschreiben Sie hier die Klasse KartenTripel.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class KartenTripel
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Spielkarte _spielkarte1;
    private Spielkarte _spielkarte2;
    private Spielkarte _spielkarte3;

    /**
     * Konstruktor für Objekte der Klasse KartenTripel
     */
    public KartenTripel(Spielkarte k1, Spielkarte k2, Spielkarte k3)
    {
        if(k1.equals(k2)||k1.equals(k3)||k2.equals(k3)){
            throw new IllegalArgumentException("Karten müssen unterschiedlich sein");
        }
        _spielkarte1 = k1;
        _spielkarte2 = k2;
        _spielkarte3 = k3;
    }

    /**
     * Gibt die erste Karte.
     * 
     * @return        die erste Karte
     */
    public Spielkarte karte1()
    {
        return _spielkarte1;
    }
    
    /**
     * Gibt die zweite Karte.
     * 
     * @return        die zweite Karte
     */
    public Spielkarte karte2()
    {
        return _spielkarte2;
    }
    
    /**
     * Gibt die dritte Karte.
     * 
     * @return        die dritte Karte
     */
    public Spielkarte karte3()
    {
        return _spielkarte3;
    }
}
