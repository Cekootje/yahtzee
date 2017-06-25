import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testSorting() {
        for (int i = 0; i < 100; i++) {
            Dobbelsteen dobbelsteen1 = new Dobbelsteen();
            Dobbelsteen dobbelsteen2 = new Dobbelsteen();
            Dobbelsteen dobbelsteen3 = new Dobbelsteen();
            Dobbelsteen dobbelsteen4 = new Dobbelsteen();
            dobbelsteen1.gooi();
            dobbelsteen2.gooi();
            dobbelsteen3.gooi();
            dobbelsteen4.gooi();

            Dobbelsteen[] dobbelstenen = new Dobbelsteen[]{dobbelsteen1, dobbelsteen2, dobbelsteen3, dobbelsteen4};
            Arrays.sort(dobbelstenen);

            assertTrue(dobbelstenen[0].getWaarde() <= dobbelstenen[1].getWaarde());
            assertTrue(dobbelstenen[1].getWaarde() <= dobbelstenen[2].getWaarde());
            assertTrue(dobbelstenen[2].getWaarde() <= dobbelstenen[3].getWaarde());
        }
    }

}