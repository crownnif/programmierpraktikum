
/**
 * Ein SignalNeuron hat keinen Eingang, nur einen festgelegten Ausgang.
 * 
 * @author Finn K.
 * @version 2022
 */
public class Signal implements Neuron
{
    private String _s;

    public Signal(String s)
    {
        _s = s;
    }

    public String getAusgangswert()
    {
        return _s;
    }
}
