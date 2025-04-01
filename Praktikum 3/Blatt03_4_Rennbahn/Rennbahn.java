
/**
 * Diese Klasse modelliert eine Rennbahn mit beliebiger Länge,
 * auf der Objekte der Klasse Rennauto fahren können.
 * 
 * @author Tommy, Finn 
 * @version 11.2021
 */
public class Rennbahn
{
    private Rennauto _bahn1;
    private Rennauto _bahn2;
    private Rennauto _bahn3;
    private Rennauto _bahn4;
    private int _streckenlaenge;

    /**
     * Initialisiert die Streckenlänge der Rennbahn.
     * 
     * @param streckenlaenge    Die Streckenlänge in km.
     */
    public Rennbahn(int streckenlaenge)
    {
        _streckenlaenge = streckenlaenge;
    }

    /**
     * Die Methode setzt ein Auto auf eine bestimmte Spur.
     * 
     * @param  spur     Die Nummer der Spur.
     * @param  auto     Das Rennauto.
     */
    public void setzeAufSpur(int spur, Rennauto auto)
    {
        switch(spur)
        {
            case 1:
                _bahn1 = auto;
                break;
            case 2:
                _bahn2 = auto;
                break;
            case 3:
                _bahn3 = auto;
                break;
            case 4:
                _bahn4 = auto;
                break;
            default:
                throw new IllegalArgumentException("Bahn ist nicht verfügbar");
        }
    }
    
    /**
     * Die Methode entfernt die Belegung einer Spur.
     * 
     * @param spur  Die Nummer der Spur.
     */
    public void entferneVonSpur(int spur)
    {
        setzeAufSpur(spur, null);
    }
    
    /**
     * Die Methode gibt das Auto auf einer bestimmten Spur.
     * 
     * @param spur  Die Nummer der Spur.
     * @return      Das Auto auf der Spur. Gibt null, wenn Spur leer ist.
     */
    private Rennauto gibAutoAufSpur(int spur)
    {
        switch(spur)
        {
            case 1:
                return _bahn1;
            case 2:
                return _bahn2;
            case 3:
                return _bahn3;
            case 4:
                return _bahn4;
            default:
                return null;
        }
    }
    
    /**
     * Die Methode gibt den Sieger des Rennens.
     * 
     * @return Das Siegerauto. Wenn es noch keinen Sieger gibt, null.
     */
    public Rennauto liefereSieger()
    {
        int laengsteStrecke = _streckenlaenge;
        Rennauto sieger = null;
        if(_bahn1 != null)
        {
            int bahn1Strecke = _bahn1.gibGefahreneStrecke();
            if(bahn1Strecke >= laengsteStrecke)
            {
                laengsteStrecke = bahn1Strecke;
                sieger = _bahn1;
            }
        }
        if(_bahn2 != null)
        {
            int bahn2Strecke = _bahn2.gibGefahreneStrecke();
            if(bahn2Strecke >= laengsteStrecke)
            {
                laengsteStrecke = bahn2Strecke;
                sieger = _bahn2;
            }
        }
        if(_bahn3 != null)
        {
            int bahn3Strecke = _bahn3.gibGefahreneStrecke();
            if(bahn3Strecke >= laengsteStrecke)
            {
                laengsteStrecke = bahn3Strecke;
                sieger = _bahn3;
            }
        }
        if(_bahn4 != null)
        {
            int bahn4Strecke = _bahn4.gibGefahreneStrecke();
            if(bahn4Strecke >= laengsteStrecke)
            {
                laengsteStrecke = bahn4Strecke;
                sieger = _bahn4;
            }
        }
        return sieger;
    }
    
    /**
     * Die Methode simuliert einen Zeitabschnitt vom Rennen.
     * 
     * @param zeitabschnitt Der Zeitabschnitt in Sekunden.
     */
    private void simuliereZeitabschnitt(int zeitabschnitt)
    {
        for(int i=1; i<5; i++)
        {
            Rennauto auto = gibAutoAufSpur(i);
            if(auto != null)
            {
                auto.fahre(zeitabschnitt);
            }
        }
    }
    
    /**
     * Die Methode führt das Rennen durch.
     * 
     * @return Das Siegerauto.
     */
    public Rennauto rennenDurchfuehren()
    {
        if(_bahn1 == null && _bahn2 == null && _bahn3 == null && _bahn4 == null)
        {
            throw new NullPointerException("Kein Auto auf der Rennbahn");
        }
        else
        {
            Rennauto auto;
            do
            {
                simuliereZeitabschnitt(240);
                auto = liefereSieger();
            }
            while (auto == null);
            return auto;
        }
    }
}
