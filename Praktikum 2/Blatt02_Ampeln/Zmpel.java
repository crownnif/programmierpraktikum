/**
 * Eine Zmpel besteht aus drei Lampen in den Farben rot, gelb und gruen.
 * Sie durchlaeuft periodisch vier Phasen: gruen, gelb, rot, rot/gelb.
 * In den ersten drei Phasen leuchtet also nur jeweils eine Lampe,
 * waehrend in der vierten Phase zwei Lampen gleichzeitig leuchten.
 * Der Zustand der einzelnen Lampen kann abgefragt werden,
 * und die Zmpel kann in die naechste Phase geschaltet werden.
 * Die Schaltung geschieht explizit durch einen Methodenaufruf
 * (und nicht etwa durch einen automatischen Timer).
 * 
 * @author Tom Hert, Finn Kronjäger, Fredrik Winkler
 * @version v0.0.1
 */
class Zmpel
{
    private boolean _rot;
    private boolean _gelb;
    private boolean _gruen;

    /**
     * Initialisiert eine neue Zmpel auf die erste Phase (gruen).
     */
    public Zmpel()
    {
        _rot = false;
        _gelb = false;
        _gruen = true;
    }
    
    /**
     * Gibt an, ob die rote Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetRot()
    {
        return _rot;
    }
    
    /**
     * Gibt an, ob die gelbe Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGelb()
    {
        return _gelb;
    }
    
    /**
     * Gibt an, ob die gruene Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGruen()
    {
        return _gruen;
    }

    /**
     * Schaltet die Zmpel in die naechste Phase (gruen -> gelb -> rot -> rot/gelb -> gruen).
     */
    public void schalteWeiter()
    {
        // Grün kann es nur werden, wenn Rot und Gelb gerade leuchten
        _gruen = _rot && _gelb;
        
        // Wenn die nächste Farbe nicht grün ist, weil rot nicht direkt nach grün kommen kann
        // und Gelb XOR rot ist -> Nicht beides False oder True, weil das auch nicht geht
        _rot = _gelb ^ _rot;
        
        // Gelb schaltet in einem konstanten Muster
        _gelb = !_gelb;
    }
}
