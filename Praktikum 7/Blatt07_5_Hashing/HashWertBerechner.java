/**
 * Dieses Interface definiert die Schnittstelle von Objekten, die 
 * einen Hash-Wert für ein gegebenes Wort (einen String) liefern.
 * Diese Werte können als Basis für Hash-Funktionen dienen.
 * 
 * Verschiedene Implementationen dieses Interfaces können Hash-Werte
 * unterschiedlicher Güte realisieren.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2021
 */
interface HashWertBerechner
{
    /**
     * Bilde das gegebene Wort auf einen ganzzahligen Wert ab.
     */
    public int hashWert(String wort);
    
    /**
     * Liefere eine Beschreibung für die Art der Berechnung.
     */
    public String gibBeschreibung();
}
