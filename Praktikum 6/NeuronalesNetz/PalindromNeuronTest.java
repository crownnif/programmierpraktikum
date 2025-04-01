import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse PalindromNeuronTest.
 *
 * @author  Finn K
 * @version 2022
 */
public class PalindromNeuronTest
{
    Signal _testSignal0 = new Signal("test");
    Signal _testSignal1 = new Signal("teseT");
    Signal _testSignal2 = new Signal("tet");
    Signal _testSignal3 = new Signal("teset");
    
    /**
     * Konstruktor fuer die Test-Klasse SignalTest
     */
    public PalindromNeuronTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
    }
    
    /**
     *  Testet, dass Caps berücksichtigt werden.
     */
    @Test
    public void testeMitCaps()
    {
        PalindromNeuron neuron = new PalindromNeuron(false);
        
        neuron.eingangHinzufuegen(_testSignal0);
        neuron.eingangHinzufuegen(_testSignal1);
        neuron.eingangHinzufuegen(_testSignal2);
        neuron.eingangHinzufuegen(_testSignal3);
        
        assertEquals(_testSignal3.getAusgangswert(), neuron.getAusgangswert());
    }
    
    /**
     *  Testet, dass bei keinem Palindrom null 
     */
    @Test
    public void testeNull()
    {
        PalindromNeuron neuron = new PalindromNeuron(false);

        neuron.eingangHinzufuegen(_testSignal0);
        
        assertEquals(null, neuron.getAusgangswert());
    }
    
    /**
     *  Testet, dass Caps nicht berücksichtigt werden.
     */
    @Test
    public void testeMitIgnoriereCaps()
    {
        PalindromNeuron neuron = new PalindromNeuron(true);
        
        neuron.eingangHinzufuegen(_testSignal0);
        neuron.eingangHinzufuegen(_testSignal1);
        neuron.eingangHinzufuegen(_testSignal2);
        
        assertEquals(_testSignal1.getAusgangswert(), neuron.getAusgangswert());
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
