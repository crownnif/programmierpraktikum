
/**
 * Beschreiben Sie hier die Klasse Lotto.
 * 
 * @author Finn Kronjäger
 * @version 14.12.2021
 */
public class Lotto
{

    /**
     * Schreibt sechs zufällige Zahlen zwischen 1 und 49 in die Konsole
     */
    public void sechsAus49()
    {
        Zahlensack sack = new Auswahl(48);
        
        for(int i=0; i<6; i++)
        {
            System.out.println(sack.entferneZahl()+1);
        }
    }
}
