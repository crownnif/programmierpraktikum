/**
 * Diese Klasse vergleicht die Effizienz verschiedener Implementationen von Zahlensack.
 *
 * Implementiert in der Methode vermesse(Zahlensack) den fehlenden Code!
 *
 * @author Fredrik Winkler, Christian M. Spaeh
 * @version 2021
 */
class Effizienzvergleicher
{
    /**
     * Vergleicht die Effizienz verschiedener Implementationen von Zahlensack.
     * Alle Zahlensaecke werden mit der gleichen Groesse erzeugt.
     * 
     * @param groesse die Groesse der Zahlensaecke
     */
    public void vergleiche(int groesse)
    {
        if (groesse < 1)
        {
            throw new IllegalArgumentException("groesse < 1");
        }
        
        Zahlensack zs = new Naiv(groesse);
        vermesse(zs);
        
        zs = new Permutation(groesse);
        vermesse(zs);
        
        zs = new Auswahl(groesse);
        vermesse(zs);
    }
    
    /*
     * Der statische Typ (festgelegt im Quellcode) der Variable zs ist Zahlensack, der dynamische
     * (während der Laufzeit bestimmt) verändert sich im laufe der Methode. Erst ist dieser 
     * "Naiv", dann "Permutation" und dann "Auswahl". Der jeweilige dynamische Typ einer Variable ist immer
     * auch verwandt mit dem statischen Typ durch Vererbung oder Implementation. 
     * (Naiv, Permutation und Auswahl sind alles Zahlensäcke)
     */

    /**
     * Misst die Zeit, die fuer das Entfernen von sehr vielen Zahlen aus dem
     * Zahlensack benoetigt wird. Das Ergebnis wird auf der Konsole ausgegeben.
     * 
     * @param sack der zu vermessende Zahlensack
     */
    private void vermesse(Zahlensack sack)
    {
        // Speichere die aktuelle Zeit als Startzeit
        long startTime = System.nanoTime();
 
        // Rufe 1 Mio. Mal "entferneZahl" auf
        for(int i =0 ; i<1_000_000; i++)
        {
            sack.entferneZahl();
        }

        // Speichere die aktuelle Zeit als Stoppzeit
        long stopTime = System.nanoTime();

        // Bilde die Differenz aus Stoppzeit und Startzeit
        // Teile die Differenz durch 1_000_000, um von ns nach ms umzurechnen
        double duration = (stopTime - startTime)/1_000_000;

        System.out.print(sack); // Beschreibung des Zahlensacks ausgeben
        System.out.print(": "); // gefolgt von einem Doppelpunkt
        // Gib das Ergebnis auf der Konsole aus
        System.out.print(duration+"\n");
        
    }
}
