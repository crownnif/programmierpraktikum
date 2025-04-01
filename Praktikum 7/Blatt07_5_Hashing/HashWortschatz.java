import java.util.*;

/**
 * Eine hashbasierte Implementation eines Wortschatzes.
 * 
 * @author  Finn Kronjäger
 * @version 2022
 */
class HashWortschatz implements Wortschatz
{
    WortListe[] _wortSpeicher;
    int _groesse;
    int _anzahl;
    HashWertBerechner _berechner;
    
    /**
     * Initialisiert ein neues Exemplar von HashWortschatz.
     * 
     * @param berechner der Berechner, welcher die Hashfunktion umsetzt
     * @param groesse die (initiale) Größe der Hashtabelle
     */
    public HashWortschatz(HashWertBerechner berechner, int groesse)
    {
        _groesse = groesse;
        _anzahl = 0;
        _wortSpeicher = new WortListe[_groesse];
        _berechner = berechner;
    }
    
    /**
     * Fügt ein Wort zum Wortschatz hinzu, sofern es noch nicht enthalten ist.
     * 
     * @param wort das hinzuzufügende Wort
     */
    public void fuegeWortHinzu(String wort)
    {
        WortListe existingList = gibWortListe(wort);
        
        if(!existingList.enthaeltWort(wort))
        {
            _anzahl++;
            existingList.fuegeWortHinzu(wort);
        }
    }
    
    /**
     * Entfernt ein Wort aus dem Wortschatz, sofern es darin enthalten ist.
     * 
     * @param wort das zu entfernende Wort
     */
    public void entferneWort(String wort)
    {
        WortListe existingList = gibWortListe(wort);

        if(existingList.enthaeltWort(wort))
        {
            _anzahl--;
            existingList.entferneWort(wort);        
        }
    }
    
    /**
     * Gibt an, ob ein Wort im Wortschatz enthalten ist.
     * 
     * @param wort das zu überprüfende Wort
     * @return true, falls das Wort enthalten ist, false sonst
     */
    public boolean enthaeltWort(String wort)
    {
        WortListe existingList = gibWortListe(wort);
        
        return existingList.enthaeltWort(wort);
    }
    //Komplexität im günstigsten Fall: O(2)
    // ungünstigster Fall: O(n)
    
    private WortListe gibWortListe(String wort)
    {
        int hash = _berechner.hashWert(wort);
        if(hash < 0 )
        {
            if(hash > Integer.MIN_VALUE)
            {
                hash = -hash;
            } 
            else
            {
                hash = Integer.MAX_VALUE;
            }
        } 
        if (hash >= _groesse)
        {
            hash = hash % _groesse;
        }
        
        WortListe liste = _wortSpeicher[hash];
        if(liste == null)
        {
            _wortSpeicher[hash] = new WortListe();
            liste = _wortSpeicher[hash];
        }
        
        return liste;
    }
    
    /**
     * Gibt an, wieviele Wörter im Wortschatz enthalten sind.
     * 
     * @return die Anzahl der Wörter im Wortschatz
     */
    public int anzahlWoerter()
    {
        return _anzahl;
    }

    /**
     * Schreibt den Wortschatz auf die Konsole (als Debugging-Hilfe gedacht).
     */
    public void schreibeAufKonsole()
    {
        for(int i=0; i<_groesse; i++)
        {
            System.out.print("[" + i + "]:");
            System.out.println(_wortSpeicher[i].toString());
        }
    }
    
    /**
     * Liefert den Füllgrad (Verhältnis Wörter zur Größe der Hash-Tabelle)
     */
    public int fuellgrad()
    {
        return _anzahl / _groesse;
    }
    
    /**
     * Liefert die längste Kette an Überläufern.
     */
    public int laengsteKette()
    {
        int maxLaenge = 0;
        for(WortListe liste: _wortSpeicher)
        {
            if(liste != null && liste.anzahlWoerter() > maxLaenge)
            {
                maxLaenge = liste.anzahlWoerter();
            }
        }
        return maxLaenge;
    }
}
