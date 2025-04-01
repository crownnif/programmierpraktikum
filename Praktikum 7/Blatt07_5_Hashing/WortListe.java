import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Diese Klasse modelliert einfache Wort-Listen, �ber die mit
 * der erweiterten for-Schleife iteriert werden kann.
 * <BR>
 * Duplikate sind zugelassen (wie immer bei Listen), so dass ein
 * Klient sich bei Bedarf selbst um ihre Vermeidung k�mmern muss.
 * 
 * @author Fredrik Winkler, Petra Becker-Pechau, Axel Schmolitzky
 * @version 2021
 */
class WortListe implements Iterable<String>
{
    private final List<String> _liste;

    /**
     * Konstruktor f�r Objekte der Klasse WortListe
     */
    public WortListe()
    {
        _liste = new ArrayList<String>();
    }

    /**
     * F�gt der Liste ein Wort hinzu.
     * @param wort das hinzuzuf�gende Wort
     */
    public void fuegeWortHinzu(String wort)
    {
        _liste.add(wort);
    }

    /**
     * L�scht ein Wort aus der Liste.
     * @param wort das zu l�schende Wort
     * @return true, sofern das Wort vorher enthalten war und somit 
     * entfernt wurde, false sonst
     */
    public boolean entferneWort(String wort)
    {
        return _liste.remove(wort);
    }
    
    /**
     * Pr�ft, ob ein Wort in der Liste enthalten ist.
     * @param wort das zu pr�fende Wort
     * @true, falls das Wort in der Liste enthalten ist
     */
    public boolean enthaeltWort(String wort)
    {
        return _liste.contains(wort);
    }
    
    /**
     * Liefert die Anzahl der W�rter in der Liste.
     * @return die Anzahl der W�rter in der Liste
     */
    public int anzahlWoerter()
    {
        return _liste.size();
    }

    /**
     * Liefert das Wort an der Indexposition index.
     * @param index der Index
     */
    public String gibWort(int index)
    {
        return _liste.get(index);
    }
    
    /**
     * Liefert einen Iterator �ber die Liste der Woerter.
     * @return den Iterator
     */
    public Iterator<String> iterator()
    {
        return _liste.iterator();
    }
    
    /**
     * Liefert eine String-Repr�sentation der Liste.
     * @return eine String-Repr�sentation der Liste
     */
    public String toString()
    {
        return _liste.toString();
    }
}
