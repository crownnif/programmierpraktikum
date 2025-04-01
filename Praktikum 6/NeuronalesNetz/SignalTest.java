

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse SignalTest.
 *
 * @author  Finn K
 * @version 2022
 */
public class SignalTest
{
    String _testSignal = "test";
    Neuron _neuron;
    
    /**
     * Konstruktor fuer die Test-Klasse SignalTest
     */
    public SignalTest()
    {
        _neuron = new Signal(_testSignal);
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
     *  Testes, dass das Ausgangssignal richtig ist.
     */
    @Test
    public void testeGetAusgangswert()
    {
        assertEquals(_testSignal, _neuron.getAusgangswert());
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
