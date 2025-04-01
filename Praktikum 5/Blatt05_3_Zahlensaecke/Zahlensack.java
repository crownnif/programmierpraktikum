/**
 * Ein Zahlensack ist ein Datentyp, welcher eine gewisse Anzahl an
 * unterschiedlichen (!), zufälligen Zahlen liefert. Die Zahlen liegen 
 * dabei immer zwischen 0 und Größe - 1, d.h. ein Zahlensack der Größe 10 
 * liefert Zufallszahlen aus der Menge {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
 * 
 * Vorstellbar ist z.B. ein Zahlensack der Größe 32, welcher immer
 * wieder neue Skatblätter generiert. Denn: die ersten 32 gezogenen Zahlen
 * sind garantiert unterschiedlich, die nächsten 32 ebenfalls usw.
 * 
 * Ein frisch generierter Zahlensack ist immer leer; der erste Aufruf von 
 * entferneZahl bewirkt dann, dass der Zahlensack vorab automatisch befüllt wird,
 * siehe die Beschreibung von entferneZahl.
 * 
 * Der kleinste zulässige Wert für die Größe eines Zahlensackes ist 2.
 * Bei Angabe einer kleineren Größe soll eine IllegalArgumentException geworfen werden.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
interface Zahlensack
{
    /**
     * @return die Größe des Zahlensacks; liefert minimal 2.
     */
    public int gibGroesse();

    /**
     * @return die Anzahl der Zahlen, die sich momentan im Zahlensack befinden
     */
    public int gibAnzahl();
    
    /**
     * @return true, falls der Zahlensack leer ist
     */
    public boolean istLeer();
    
    /**
     * Entfernt eine Zahl aus dem Zahlensack und liefert sie zurück.
     * Danach ist der Zahlensack um ein Element kleiner.
     * Ausnahme: Falls der Zahlensack vor dem Aufruf leer ist,
     * wird er zuerst gefüllt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     * 
     * @return eine zufällige Zahl im Intervall [0, gibGroesse()-1]
     */
    public int entferneZahl();
    
    /**
     * Verwirft alle übrig gebliebenen Zahlen aus dem Zahlensack.
     * istLeer() liefert anschließend true zurück, und gibAnzahl() liefert 0.
     */
    public void leereSack();
}
