
/**
 * Beschreiben Sie hier die Klasse neKlasse.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class neKlasse
{
    public static void main(String[] args)
    {
        for(String arg: args)
        {
            int[] haeufigkeit = new int[26];
            analysiereText(arg, haeufigkeit);
            System.out.println(arg);
            for(int i=0; i<haeufigkeit.length; i++)
            {
                System.out.println(haeufigkeit[i]);
            }
            System.out.println();
        }
    }
    
    static void analysiereText(String text, int[] haeufigkeit)
    {
        char[] textArray = text.toCharArray();
        for(char c : textArray)
        {
            int index = c - 'a';
            if(index >= 0 && index < 26)
            {
                haeufigkeit[index]++;
            }
        }
    }
}
