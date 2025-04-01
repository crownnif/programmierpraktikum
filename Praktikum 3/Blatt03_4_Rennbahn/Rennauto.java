
/**
 * Die Klasse modelliert ein Rennauto mit verschiedenen Eigenschaften.
 * 
 * @author Tommy, Finn
 * @version 11.2021
 */
public class Rennauto
{
    private String _fahrerIn;
    private String _fahrzeugtyp;
    private int _maximalgeschwindigkeit; // in km/h
    private int _gefahreneStrecke; // in km

    /**
     * Konstruktor für Objekte der Klasse Rennauto
     * 
     * @param fahrerIn  Der Name der Fahrer:in
     * @param fahrzeugtyp Art des Fahrzeuges
     * @param maximalgeschwindigkeit    Die maximale Geschwindigkeit des Autos in km/h. 
     */
    public Rennauto(String fahrerIn, String fahrzeugtyp, int maximalgeschwindigkeit)
    {
        _fahrerIn = fahrerIn;
        _fahrzeugtyp = fahrzeugtyp;
        _maximalgeschwindigkeit = maximalgeschwindigkeit;
        _gefahreneStrecke = 0;
    }
    
    /**
     * Konstruktor für Objekte der Klasse Rennauto
     * 
     * @param fahrerIn    Der Name der Fahrer:in.
     */
    public Rennauto(String fahrerIn)
    {
        this(fahrerIn, "Bobby Car", 100);
    }

    /**
     * Die Methode simuliert das Fahren für einen Zeitabschnitt, welcher selber festgelegt wird.
     * 
     * @param zeitabschnitt     Zeit in Sekunden
     */
    public void fahre(int zeitabschnitt)
    {
        double geschwindigkeit = Math.random()*_maximalgeschwindigkeit;
        _gefahreneStrecke = _gefahreneStrecke + (int) (geschwindigkeit * (zeitabschnitt / 3600.0));
    }
    
    /**
     * Die Methode gibt die gefahrene Strecke.
     * 
     * @return gefahrene Strecke
     */
    public int gibGefahreneStrecke()
    {
        return _gefahreneStrecke;
    }
    
    /**
     * Die Methode gibt die Fahrer:in.
     * 
     * @return Fahrer:in
     */
    public String gibFahrerIn()
    {
        return _fahrerIn;
    }
}
