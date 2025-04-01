
/**
 * Beschreiben Sie hier die Klasse SpielfeldGeflechtEnum.
 * 
 * @author Finn, Daniil
 * @version 15.12.2021
 */
public class SpielfeldGeflechtEnum implements Spielfeld
{
    private SpielfeldZeileEnum _zeile0;
    private SpielfeldZeileEnum _zeile1;
    private SpielfeldZeileEnum _zeile2;
    
    /**
     * Konstruktor für Objekte der Klasse SpielfeldGeflechtEnum
     */
    public SpielfeldGeflechtEnum()
    {
        _zeile0 = new SpielfeldZeileEnum();
        _zeile1 = new SpielfeldZeileEnum();
        _zeile2 = new SpielfeldZeileEnum();
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
        Besitzer besitzer;
        switch (zeile)
        {
            case 0:
                besitzer = _zeile0.gibBesitzer(spalte);
                break;
    
            case 1:
                besitzer = _zeile1.gibBesitzer(spalte);
                break;
    
            case 2:
                besitzer = _zeile2.gibBesitzer(spalte);
                break;
    
            default:
                throw new IllegalArgumentException(String.valueOf(zeile));
        }
        
        return besitzerZuSpieler(besitzer);
    }
    
    private Besitzer spielerZuBesitzer(int spieler)
    {
        switch(spieler)
        {
            case 0:
                return Besitzer.LEER;
            case 1:
                return Besitzer.SPIELER1;
            case 2:
                return Besitzer.SPIELER2;
            
            default:
                throw new IllegalArgumentException("Spieler muss zwischen 0-2");
        }
    }
    
    private int besitzerZuSpieler(Besitzer spieler)
    {
        switch(spieler)
        {
            case LEER:
                return 0;
            case SPIELER1:
                return 1;
            case SPIELER2:
                return 2;
            
            default:
                throw new IllegalArgumentException("Spieler muss Besitzer sein");
        }
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
        switch (zeile)
        {
            case 0:
                _zeile0.besetze(spalte, spielerZuBesitzer(spieler));
                break;
    
            case 1:
                _zeile1.besetze(spalte, spielerZuBesitzer(spieler));
                break;
    
            case 2:
                _zeile2.besetze(spalte, spielerZuBesitzer(spieler));
                break;
    
            default:
                throw new IllegalArgumentException(String.valueOf(zeile));
        }
    }

    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return _zeile0.istVoll() && _zeile1.istVoll() && _zeile2.istVoll();
    }
}
