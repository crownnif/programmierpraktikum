/**
 * Eine Bmpel besteht aus drei Lampen in den Farben rot, gelb und gruen.
 * Sie durchlaeuft periodisch vier Phasen: gruen, gelb, rot, rot/gelb.
 * In den ersten drei Phasen leuchtet also nur jeweils eine Lampe,
 * waehrend in der vierten Phase zwei Lampen gleichzeitig leuchten.
 * Der Zustand der einzelnen Lampen kann abgefragt werden,
 * und die Bmpel kann in die naechste Phase geschaltet werden.
 * Die Schaltung geschieht explizit durch einen Methodenaufruf
 * (und nicht etwa durch einen automatischen Timer).
 * 
 * @author Finn Kronjäger, Tom Hert, Fredrik Winkler
 * @version v0.0.1
 */
class Bmpel
{
    private int _phase;

    /**
     * Initialisiert eine neue Bmpel auf die erste Phase (gruen).
     */
    public Bmpel()
    {
        _phase = 0;
    }

    /**
     * Schaltet die Bmpel in die naechste Phase (gruen -> gelb -> rot -> rot/gelb -> gruen).
     */
    public void schalteWeiter()
    {
        _phase = (_phase + 1) % 4;
    }
    
    /**
     * Gibt an, ob die rote Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetRot()
    {
        return ((_phase == 2) || (_phase == 3));
    }
    
    /**
     * Gibt an, ob die gelbe Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGelb()
    {
        return ((_phase == 1) || (_phase == 3));
    }
    
    /**
     * Gibt an, ob die gruene Lampe leuchtet.
     * 
     * @return boolean Leuchtet es?
     */
    public boolean leuchtetGruen()
    {
        return _phase == 0;
    }
}
