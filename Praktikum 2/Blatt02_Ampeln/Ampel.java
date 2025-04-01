/**
 * Eine Ampel besteht aus drei Lampen in den Farben rot, gelb und gruen.
 * Sie durchlaeuft periodisch vier Phasen: gruen, gelb, rot, rot/gelb.
 * In den ersten drei Phasen leuchtet also nur jeweils eine Lampe,
 * waehrend in der vierten Phase zwei Lampen gleichzeitig leuchten.
 * Der Zustand der einzelnen Lampen kann abgefragt werden,
 * und die Ampel kann in die naechste Phase geschaltet werden.
 * Die Schaltung geschieht explizit durch einen Methodenaufruf
 * (und nicht etwa durch einen automatischen Timer).
 * 
 * @author Fredrik Winkler, Christian Spaeh
 * @version 2021
 */
class Ampel
{
    private boolean _rotLeuchtet;
    private boolean _gelbLeuchtet;
    private boolean _gruenLeuchtet;

    /**
     * Initialisiert eine neue Ampel auf die erste Phase (gruen).
     */
    public Ampel()
    {
        _gruenLeuchtet = true;
        _gelbLeuchtet = false;
        _rotLeuchtet = false;
    }
    
    /**
     * Gibt an, ob die rote Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetRot()
    {
        // unnoetig kompliziert geloest
        if (_rotLeuchtet == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Gibt an, ob die gelbe Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGelb()
    {
        // immer noch recht kompliziert
        if (_gelbLeuchtet)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Gibt an, ob die gruene Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGruen()
    {
        // keine unnoetige Fallunterscheidung
        return _gruenLeuchtet;
    }

    /**
     * Schaltet die Ampel in die naechste Phase (gruen -> gelb -> rot -> rot/gelb -> gruen).
     */
    public void schalteWeiter()
    {
        if (_gruenLeuchtet) // Grün auf Gelb
        {
            _gelbLeuchtet = true;
            _gruenLeuchtet = false;
        }
        else if (_gelbLeuchtet && !_rotLeuchtet) // Gelb auf Rot
        {
            _rotLeuchtet = true;
            _gelbLeuchtet = false;
        }
        else if (_rotLeuchtet && !_gelbLeuchtet) // Rot auf Gelb + Rot
        {
            _gelbLeuchtet = true;
        }
        else if (_rotLeuchtet && _gelbLeuchtet) // Gelb + Rot auf Grün
        {
            _gelbLeuchtet = false;
            _rotLeuchtet = false;
            _gruenLeuchtet = true;
        }
    }
}
