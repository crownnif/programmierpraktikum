/**
 * Die Klasse Nummernanzeige modelliert Objekte, die Werte von Null bis zu
 * einem vorgegebenen Limit anzeigen können. Das Limit wird definiert, wenn ein
 * Exemplar einer Nummernanzeige erzeugt wird. Die darstellbaren Werte reichen
 * von Null bis Limit-1. Wenn beispielsweise eine Nummernanzeige für die
 * Sekunden einer digitalen Uhr verwendet werden soll, würde man ihr Limit auf
 * 60 setzen, damit die dargestellten Werte von 0 bis 59 reichen. Wenn der Wert
 * einer Nummernanzeige erhöht wird, wird bei Erreichen des Limits der Wert
 * automatisch auf Null zurückgesetzt.
 * 
 * @author Michael Kolling, David J. Barnes, Axel Schmolitzky, Christian Spaeh
 * @version 2021
 */
class Nummernanzeige
{
    private final int _limit;

    private int _wert;

    /**
     * Konstruktor für Exemplare der Klasse Nummernanzeige
     * 
     * @param anzeigeGrenze
     *            das Limit fuer die Anzeige
     */
    public Nummernanzeige(int anzeigeGrenze)
    {
        _limit = anzeigeGrenze;
    }

    /**
     * Liefere das Limit dieser Anzeige.
     */
    public int gibLimit()
    {
        return _limit;
    }

    /**
     * Liefere den aktuellen Wert dieser Anzeige.
     */
    public int gibWert()
    {
        return _wert;
    }

    /**
     * Liefere den Anzeigewert, also den Wert dieser Anzeige als einen String
     * mit zwei Ziffern. Wenn der Wert der Anzeige kleiner als zehn ist, wird
     * das Ergebnis mit einer führenden Null versehen.
     */
    public String gibAnzeigewert()
    {
        String result;
        if (_wert < 10)
        {
            result = "0" + _wert;
        } else
        {
            result = "" + _wert;
        }
        return result;
    }

    /**
     * Setze den Wert der Anzeige auf den angegebenen 'wert'.
     * Wenn der angegebene Wert unter Null oder größer gleich
     * dem Limit ist, tue nichts.
     */
    public void setzeWert(int wert)
    {
        if ((wert >= 0) && (wert < _limit))
        {
            _wert = wert;
        }
    }

    /**
     * Erhöhe den Wert dieser Anzeige um Eins. Wenn das Limit erreicht ist,
     * setze den Wert wieder auf Null.
     */
    public void erhoehen()
    {
        _wert = (_wert + 1) % _limit;
    }
}