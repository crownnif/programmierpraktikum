/**
 * Ein Zahlensack ist ein Datentyp, welcher eine gewisse Anzahl an
 * unterschiedlichen (!), zuf�lligen Zahlen liefert. Die Zahlen liegen 
 * dabei immer zwischen 0 und Gr��e - 1, d.h. ein Zahlensack der Gr��e 10 
 * liefert Zufallszahlen aus der Menge {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}.
 * 
 * Vorstellbar ist z.B. ein Zahlensack der Gr��e 32, welcher immer
 * wieder neue Skatbl�tter generiert. Denn: die ersten 32 gezogenen Zahlen
 * sind garantiert unterschiedlich, die n�chsten 32 ebenfalls usw.
 * 
 * Ein frisch generierter Zahlensack ist immer leer; der erste Aufruf von 
 * entferneZahl bewirkt dann, dass der Zahlensack vorab automatisch bef�llt wird,
 * siehe die Beschreibung von entferneZahl.
 * 
 * Der kleinste zul�ssige Wert f�r die Gr��e eines Zahlensackes ist 2.
 * Bei Angabe einer kleineren Gr��e soll eine IllegalArgumentException geworfen werden.
 * 
 * @author Fredrik Winkler, Axel Schmolitzky
 * @version 2021
 */
interface Zahlensack
{
    /**
     * @return die Gr��e des Zahlensacks; liefert minimal 2.
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
     * Entfernt eine Zahl aus dem Zahlensack und liefert sie zur�ck.
     * Danach ist der Zahlensack um ein Element kleiner.
     * Ausnahme: Falls der Zahlensack vor dem Aufruf leer ist,
     * wird er zuerst gef�llt, und nach dem Aufruf ist gibAnzahl() == gibGroesse()-1.
     * 
     * @return eine zuf�llige Zahl im Intervall [0, gibGroesse()-1]
     */
    public int entferneZahl();
    
    /**
     * Verwirft alle �brig gebliebenen Zahlen aus dem Zahlensack.
     * istLeer() liefert anschlie�end true zur�ck, und gibAnzahl() liefert 0.
     */
    public void leereSack();
}
