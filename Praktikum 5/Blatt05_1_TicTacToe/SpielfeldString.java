/**
 * Ein Spielfeld besteht aus drei Zeilen mit je drei Spalten. Man kann an den neun
 * Positionen einen der beiden Spieler als Besitzer eintragen und auslesen.
 * 
 * @author Finn, Daniil
 * @version 12.2021
 */
class SpielfeldString implements Spielfeld 
{
    private String _spielfeld;
    
    /**
     * Initialisiert ein neues, leeres Spielfeld.
     */
    public SpielfeldString()
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
     *            
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     * 
     * @throws IllegalArgumentException
     */
    public int gibBesitzer(int zeile, int spalte)
    {
        int position;
        int besitzer;
        
        
        
        if(!((zeile == 0) || (zeile == 1) || (zeile == 2)))
        {
            throw new IllegalArgumentException("Zeile darf nur Werte von 0, 1 oder 2 annehmen");
        }
        if(!((spalte == 0) || (spalte == 1) || (spalte == 2)))
        {
            throw new IllegalArgumentException("Spalte darf nur Werte von 0, 1 oder 2 annehmen");
        }
        
        
        position = (3 * zeile) + spalte;
        
        switch (_spielfeld.charAt(position))
        {
            case '0':
                besitzer = 0;
                break;
    
            case '1':
                besitzer = 1;
                break;
    
            case '2':
                besitzer = 2;
                break;
    
            default:
                throw new IllegalArgumentException();
        }
        
        return besitzer;
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
     *            
     * @throws IllegalArgumentException
     */
    public void besetzePosition(int zeile, int spalte, int spieler)
    {
        int position;
        int spielerChar;
        
        
        
        if(!((zeile == 0) || (zeile == 1) || (zeile == 2)))
        {
            throw new IllegalArgumentException("Zeile darf nur Werte von 0, 1 oder 2 annehmen");
        }
        if(!((spalte == 0) || (spalte == 1) || (spalte == 2)))
        {
            throw new IllegalArgumentException("Spalte darf nur Werte von 0, 1 oder 2 annehmen");
        }
        if(!((spieler == 0) || (spieler == 1) || (spieler == 2)))
        {
            throw new IllegalArgumentException("Spieler darf nur Werte von 0, 1 oder 2 annehmen");
        }
        
        
        
        position = (3 * zeile) + spalte;
        spielerChar = 48 + spieler;
        
        if(_spielfeld.charAt(position) == '0')
        {
            String spielfeld = "";
            
            for(int i = 0; i < 9; i++)
            {
                if(i == position)
                {
                    spielfeld += (char)spielerChar;
                }
                else
                {
                    spielfeld += _spielfeld.charAt(i);
                }
            }
            
            _spielfeld = spielfeld;
        }
        else
        {
            throw new IllegalStateException("Die Position ist schon besetzt");
        }
    }
    
    
    
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll()
    {
        int a = 0;
        
        for(int i = 0;(i < 9) && (_spielfeld.charAt(i) != '0'); i++)
        {
            a++;
        }
        
        if(a != 9)
        {
            return false;
        }
        return true;
    }
}
