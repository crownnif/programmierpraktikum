import static org.junit.Assert.*;

import org.junit.Test;
/**
 * The test class TagTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TagTest
{
    /**
     * Testet, ob zwei Tag-Exemplare, die denselben Tag repraesentieren,
     * als gleich angesehen werden.
     */
    @Test
    public void testGleichheit()
    {
        Tag tag0 = new Tag(4);
        Tag tag1 = new Tag(4);
        
        assertEquals(tag0, tag1);
    }
    
    /**
     * Testet, ob zwei Tag-Exemplare, die verschiedene Tage repraesentieren,
     * als ungleich angesehen werden.
     */
    @Test
    public void testUngleichheit()
    {
        Tag tag0 = new Tag(4);
        Tag tag1 = new Tag(5);
        
        assertNotEquals(tag0, tag1);
    }
}
