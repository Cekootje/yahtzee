import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cesarkoot on 04/07/2017.
 */
public class SpelerBuilderTest {

    @Test
    public void testSpelerBuilder() {
        String[] args = new String[]{"Cesar", "Andrea"};
        Speler[] spelers = SpelerBuilder.buildSpelers(args);
        assertEquals(spelers.length, 2);
        assertEquals(spelers[0].getNaam(), "Cesar");
        assertEquals(spelers[1].getNaam(), "Andrea");
    }
}