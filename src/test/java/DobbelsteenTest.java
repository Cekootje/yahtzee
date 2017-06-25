import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by KootAJ on 22-6-2017.
 */
public class DobbelsteenTest {

    @Test
    public void testDobbelsteenGooien() {

        Dobbelsteen dobbelsteen = new Dobbelsteen();

        // Duizend keer gooien:
        for (int i = 0; i < 1000; i++) {
            dobbelsteen.gooi();
            int worp = dobbelsteen.getWaarde();
            assertTrue(worp >= 1 && worp <= 6); // Worp moet altijd tussen 1 en 6 liggen (1 en 6 inclusief).
        }
    }

}