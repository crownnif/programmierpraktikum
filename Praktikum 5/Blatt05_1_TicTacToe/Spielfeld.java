
/**
 * Ein Spielfeld besteht aus drei Zeilen mit je drei Spalten. Man kann an den neun
 * Positionen einen der beiden Spieler als Besitzer eintragen und auslesen.
 * 
 * @author Finn Kronjäger
 * @version 14.12.2021
 */

public interface Spielfeld
{
    /**
     * Gibt den Besitzer der angegebenen Position auf dem Spielfeld.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @return 0 (unbesetzt), 1 (Spieler 1), 2 (Spieler 2)
     */
    public int gibBesitzer(int zeile, int spalte);

    /**
     * Besetzt die angegebene Position auf dem Spielfeld fuer einen Spieler.
     * 
     * @param zeile
     *            vertikale Position (0-2)
     * @param spalte
     *            horizontale Position (0-2)
     * @param spieler
     *            0 (leer), 1 (Spieler 1), 2 (Spieler 2)
     */
    public void besetzePosition(int zeile, int spalte, int spieler);
    
    /**
     * Gibt an, ob das Spielfeld an allen Positionen belegt ist.
     */
    public boolean istVoll();
    
    /*
     * Ein Interface ohne Kommentare gibt über die Namen hinaus nicht vor, welchen Sinn die Methoden 
     * und Attribute haben sollen, wodurch es dazu kommen kann, dass bei der Implementation des
     * Interfaces das falsche Endergebnis geliefert wird.
     * 
     * 
     * Benutzt beziehung
     * Implementiert beziehung
     */
}
