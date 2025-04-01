
/**
 * Beschreiben Sie hier die Klasse Bank.
 * 
 * @author Finn Kronjäger und Tom Hert
 * @version v0.1
 */
public class Konto
{
    private int _dispo;
    private int _saldo;
    private int _kontonummer;

    /**
     * Konstruktor für Objekte der Klasse Bank
     * 
     * @param kontonummer
     *      Die Kontonummer (Einzigartig)
     * @param dispo
     *      Wie hoch soll der Dispokredit sein
     */
    public Konto(int kontonummer, int dispo)
    {
        _saldo = 10; // Jeder Neukunde kriegt 10 Euro
        _kontonummer = kontonummer;
        _dispo = dispo;
    }
    
    /**
     * Getter für den Kontostand
     * 
     * @return int Kontostand
     */
    public int getKontostand() 
    {
        return _saldo;
    }
    
    /**
     * Getter für den Kontonummer
     * 
     * @return int Kontonummer
     */
    public int getKontonummer() 
    {
        return _kontonummer;
    }
    
    /**
     * Diese Funktion ändert das Dispolimit
     * 
     * @param neuerDispo
     *      Wie hoch soll das neue Limit sein?
     * 
     * @return String Erfolg der Änderung
     */
    public String aendereDispo(int neuerDispo)
    {        
        if (_saldo < 0 && (_saldo * -1) <= neuerDispo)
        {
            _dispo = neuerDispo;
            return "Erfolgreich Dispo geändert!";
        }
        
        return "Leider war die Änderung nicht möglich!";
    }

    /**
     * Funktion zur Einzahlung ins Konto
     * 
     * @param summe
     *      Der Betrag, der eingezahlt werden soll
     */
    public void einzahlen(int summe)
    {
        _saldo += summe;
    }

    /**
     * Funktion zur Abhebung vom Konto
     * 
     * @param summe
     *      Betrag, der abgehoben werden soll
     */
    public void abheben(int summe)
    {
        if (_saldo + _dispo - summe >= 0) // Check whether the diff is negative
        {
            _saldo -= summe;
        }
    }
}
