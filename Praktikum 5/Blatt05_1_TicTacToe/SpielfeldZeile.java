/**
 * Modelliert eine Zeile eines Tic-Tac-Toe-Spielfelds, welche aus drei Spaltenpositionen
 * besteht. Die Spaltenpositionen koennen von den Spielern besetzt werden.
 * 
 * @author Fredrik Winkler, Christian M. Spaeh, Axel Schmolitzky
 * @version 2021
 */
class SpielfeldZeile
{
    private int _spalte0;
    private int _spalte1;
    private int _spalte2;

    /**
     * Initialisiert eine neue SpielfeldZeile
     */
    public SpielfeldZeile()
    {
        _spalte0 = 0;
        _spalte1 = 0;
        _spalte2 = 0;
    }
       
    /**
     * Gibt den Besitzer der angegebenen Spalte in dieser Zeile.
     * 
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int spalte)
    {
        int besitzer;
        switch (spalte)
        {
        case 0:
            besitzer = _spalte0;
            break;

        case 1:
            besitzer = _spalte1;
            break;

        case 2:
            besitzer = _spalte2;
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(spalte));
        }
        return besitzer;
    }

    /**
     * Besetze die angegebene Spalte in dieser Zeile.
     * 
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetze(int spalte, int spieler)
    {
        switch (spalte)
        {
        case 0:
            _spalte0 = spieler;
            break;

        case 1:
            _spalte1 = spieler;
            break;

        case 2:
            _spalte2 = spieler;
            break;

        default:
            throw new IllegalArgumentException(String.valueOf(spalte));
        }
    }
    
    /**
     * Gibt an, ob die Zeile an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        return (_spalte0 > 0) && (_spalte1 > 0) && (_spalte2 > 0);
    }
}
