import java.util.*;

/**
 * 
 * 
 * @author Finn K.
 * @version 2022
 */

public class KettenNeuron implements Neuron
{
    List<Neuron> eingaenge;
    String _letzteAusgabe;
    
    KettenNeuron()
    {
        eingaenge = new ArrayList<Neuron>();
        _letzteAusgabe = "";
    }
    
    /**
     * Fügt neues Eingangneuron hinzu.
     * 
     *@param n  Das Neuron. 
     */
    public void eingangHinzufuegen(Neuron n)
    {
        eingaenge.add(n);
    }
    
    public String getAusgangswert()
    {
        StringBuilder sb = new StringBuilder(_letzteAusgabe);
        for(Neuron n : eingaenge)
        {
            if(sb.length() != 0)
                sb.append(" ");
            sb.append(n.getAusgangswert());
        }
        
        _letzteAusgabe = sb.toString();
        
        return _letzteAusgabe;
    }
}
