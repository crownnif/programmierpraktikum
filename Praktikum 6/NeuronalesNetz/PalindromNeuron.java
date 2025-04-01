import java.util.*;

/**
 * 
 * 
 * @author Finn K.
 * @version 2022
 */

public class PalindromNeuron implements Neuron
{
    boolean ignoriereCaps;
    Set<Neuron> eingaenge;
    
    PalindromNeuron(boolean b)
    {
        ignoriereCaps = b;
        eingaenge = new HashSet<Neuron>();
    }
    
    /**
     * Fügt neues Eingangneuron hinzu.
     * 
     * @param n  Das Neuron. 
     */
    public void eingangHinzufuegen(Neuron n)
    {
        eingaenge.add(n);
    }
    
    public String getAusgangswert()
    {
        String palindrom = "";
        for(Neuron n : eingaenge)
        {
            String s = n.getAusgangswert();
            boolean istPalindrom = istPalindrom(s, ignoriereCaps);
            if( istPalindrom &&  palindrom.length() < s.length())
            {
                palindrom = s;
            }
        }
        
        if(palindrom == "")
        {
            return null;
        }
        
        return palindrom;
    }
    
    private boolean istPalindrom(String s, boolean ignoriereCaps)
    {
        int i = 0, j = s.length() - 1;
        if(ignoriereCaps)
        {
            s = s.toLowerCase();
        }
 
        while (i < j) {
            
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
 
        return true;
    }
}
