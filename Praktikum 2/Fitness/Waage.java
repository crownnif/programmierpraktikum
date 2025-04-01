
/**
 * Die Klasse Waage registiert neue Gewichte, gibt Trends zurück, berechnet das Durchschnittsgewicht
 * und noch viel mehr!
 * 
 * @author Finn Kronjäger, Tom Hert
 * @version v0.0.1
 */
public class Waage
{
    private int _letztesGewicht;
    private byte _trend;
    private int _minimalGewicht;
    private int _maximalGewicht;
    private int _anzahlAllerMessungen;
    private double _durchschnittsgewicht;

    /**
     * Konstruktor für Objekte der Klasse Waage
     * 
     * @param koerpergewicht
     *      Körpergewicht in Kilogram
     */
    public Waage(int koerpergewicht)
    {
        _letztesGewicht = koerpergewicht;
        _trend = 0;
        _minimalGewicht = koerpergewicht;
        _maximalGewicht = koerpergewicht;
        _anzahlAllerMessungen = 1;
        _durchschnittsgewicht = koerpergewicht;
    }
    
    /**
     * Registiere ein neues Gewicht auf der Waage.
     * 
     * @param neuesGewicht Das neue Gewicht, was registiert werden soll.
     */
    public void registriere(int neuesGewicht)
    {
        if (neuesGewicht != _letztesGewicht)
        {
            if (neuesGewicht > _letztesGewicht)
            {
                if (neuesGewicht > _maximalGewicht)
                {
                    _maximalGewicht = neuesGewicht;
                }
                
                _trend = 1;
            }
            else if (neuesGewicht < _letztesGewicht)
            {
                if (neuesGewicht < _minimalGewicht)
                {
                    _minimalGewicht = neuesGewicht;
                }
                
                _trend = -1;
            }
        }
        else
        {
            _trend = 0;
        }
        
        _letztesGewicht = neuesGewicht;
        
        // Ich gewichte das Durchschnittsgewicht mit der totalen Anzahl an Messungen, um eine Verwässerungen des Durchschnittswertes
        // Mit der Zeit zu verhindern. Dadurch entsteht diese "Komplizierte" Formel
        _durchschnittsgewicht = ((_durchschnittsgewicht * _anzahlAllerMessungen) + _letztesGewicht) / (_anzahlAllerMessungen + 1);
        _anzahlAllerMessungen += 1;
    }
    
    /**
     * Gibt den Trend zurück als Int
     * 
     * @return int -1 -> abnehmen, 1 -> zunehmend, 0 -> gleich
     */
    public int gibTrend()
    {
        return _trend;
    }
    
    /**
     * Gibt das Minimalgewicht zurück.
     * 
     * @return int Minimalgewicht
     */
    public int gibMinimalgewicht()
    {
        return _minimalGewicht;
    }
    
    /**
     * Gibt das Maximalgewicht zurück.
     * 
     * @return int Maximalgewicht
     */
    public int gibMaximalgewicht()
    {
        return _maximalGewicht;
    }
    
    /**
     * Gibt das Durchschnittsgewicht zurück.
     * 
     * @return int Durchschnittsgewicht
     */
    public int gibDurchschnittsgewicht()
    {
        // Das Durchschnittsgewicht wird intern als double gespeichert, um nicht stark
        // an Genauigkeit zu verlieren. Deswegen müssen wird explicit typecasten zum int.
        return (int) _durchschnittsgewicht;
    }
}
