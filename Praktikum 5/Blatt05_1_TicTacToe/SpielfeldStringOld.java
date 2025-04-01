
/**
 * Ein Spielfeld besteht aus drei Zeilen mit je drei Spalten. Man kann an den neun
 * Positionen einen der beiden Spieler als Besitzer eintragen und auslesen.
 * 
 * @author Finn Kronjäger
 * @version 14.12.2021
 */
public class SpielfeldStringOld implements Spielfeld
{
    private String _spielfeld;

    /**
     * Initialisiert ein neues, leeres Spielfeld.
     */
    public SpielfeldStringOld()
    {
        _spielfeld = "000000000";
    }

    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        int index = 0;
        
        if(spalte < 0 || zeile < 0 || spalte > 2 || zeile > 2)
        {
            throw new IllegalArgumentException("Zeile und Spalte müssen in [0-2] sein.");
        }
        switch (zeile)
        {
            case 0:
                break;
    
            case 1:
                index = 3;
                break;
    
            case 2:
                index = 6;
                break;
        }
        
        return Integer.parseInt(String.valueOf(_spielfeld.charAt(index+spalte)));
    }

    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        int index = 0;
        
        if(spalte < 0 || zeile < 0 || spalte > 2 || zeile > 2)
        {
            throw new IllegalArgumentException("Zeile und Spalte müssen in [0-2] sein.");
        }
        switch (zeile)
        {
            case 0:
                break;
    
            case 1:
                index = 3;
                break;
    
            case 2:
                index = 6;;
                break;
        }
        
        _spielfeld = _spielfeld.substring(0,index) + spieler + _spielfeld.substring(index+1);
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return _spielfeld.contains("0");
    }
}
