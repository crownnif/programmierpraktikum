/**
 * Dieses Interface definiert die Schnittstelle von Objekten, die 
 * einen Hash-Wert f�r ein gegebenes Wort (einen String) liefern.
 * Diese Werte k�nnen als Basis f�r Hash-Funktionen dienen.
 * 
 * Verschiedene Implementationen dieses Interfaces k�nnen Hash-Werte
 * unterschiedlicher G�te realisieren.
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
     * Liefere eine Beschreibung f�r die Art der Berechnung.
     */
    public String gibBeschreibung();
}
