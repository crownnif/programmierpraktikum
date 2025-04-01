
/**
 * Beschreiben Sie hier die Klasse Ueberweisungsmanager.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Ueberweisungsmanager
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private int x;

    /**
     * Konstruktor für Objekte der Klasse Ueberweisungsmanager
     */
    public Ueberweisungsmanager()
    {
        // Instanzvariable initialisieren
        x = 0;
    }

    public void ueberweisen(Konto quellKonto, Konto zielKonto, int betrag)
    {
        if(betrag>0)
        {
            quellKonto.abheben(betrag);
            zielKonto.einzahlen(betrag);            
        }

    }
}
