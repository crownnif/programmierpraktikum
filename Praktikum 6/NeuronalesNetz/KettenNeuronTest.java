

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse KettenNeuronTest.
 *
 * @author  Finn K
 * @version 2022
 */
public class KettenNeuronTest
{
    Signal _testSignal0 = new Signal("test");
    Signal _testSignal1 = new Signal("teseT");
    Signal _testSignal2 = new Signal("tet");
    Signal _testSignal3 = new Signal("teset");
    
    /**
     * Konstruktor fuer die Test-Klasse KettenNeuronTest
     */
    public KettenNeuronTest()
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
     *  Testet, dass korrekt verkettet wird.
     */
    @Test
    public void testeVerkettung()
    {
        KettenNeuron neuron = new KettenNeuron();
        
        neuron.eingangHinzufuegen(_testSignal0);
        neuron.eingangHinzufuegen(_testSignal1);
        
        String ausgang0 = _testSignal0.getAusgangswert() + " " + _testSignal1.getAusgangswert();
        
        assertEquals(ausgang0, neuron.getAusgangswert());
        
        neuron.eingangHinzufuegen(_testSignal2);
        neuron.eingangHinzufuegen(_testSignal3);
        
        String ausgang1 = ausgang0 + " " + ausgang0 + " " + _testSignal2.getAusgangswert() + " " + _testSignal3.getAusgangswert();
        
        assertEquals(ausgang1, neuron.getAusgangswert());
    }
    
    /**
     *  Testet, dass Caps berücksichtigt werden.
     */
    @Test
    public void testeOhneEingang()
    {
        KettenNeuron neuron = new KettenNeuron();
        
        assertEquals("", neuron.getAusgangswert());
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
