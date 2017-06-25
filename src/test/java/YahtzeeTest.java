import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by KootAJ on 23-6-2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class YahtzeeTest {

    @Mock
    Dobbelsteen dobbelsteen1;
    @Mock
    Dobbelsteen dobbelsteen2;
    @Mock
    Dobbelsteen dobbelsteen3;
    @Mock
    Dobbelsteen dobbelsteen4;
    @Mock
    Dobbelsteen dobbelsteen5;

    @Test
    public void testYahtzee() {
        Yahtzee yahtzee = new Yahtzee();
        Dobbelsteen[] dobbelstenen = yahtzee.getDobbelstenen();
        assertEquals(dobbelstenen.length, 5);
        for (Dobbelsteen dobbelsteen : dobbelstenen) {
            assertNotEquals(dobbelsteen.getWaarde(), 0);
        }
    }

    @Test
    public void testIsThreeOfAKind_insertYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(2,2,2,2,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_insertCarre_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_insertThreeOfAKind_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,2,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_false() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,3,2,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertFalse(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsCarre_insertYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,1);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isCarre());
    }

    @Test
    public void testIsCarre_insertCarre_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isCarre());
    }

    @Test
    public void testIsCarre_false() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,2,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertFalse(yahtzee.isCarre());
    }

    @Test
    public void testIsYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,1);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isYahtzee());
    }

    @Test
    public void testIsYahtzee_false() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertFalse(yahtzee.isYahtzee());
    }

    @Test
    public void testIsFullHouse_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,2,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_insertYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,1);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertTrue(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_insertCarre_false() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,1,1,1,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertFalse(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_false() throws NoSuchFieldException, IllegalAccessException {
        initiateMockDobbelstenen(1,2,3,1,2);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        assertFalse(yahtzee.isFullHouse());
    }

    private void initiateMockDobbelstenen(int ... i) {
        when(dobbelsteen1.getWaarde()).thenReturn(i[0]);
        when(dobbelsteen2.getWaarde()).thenReturn(i[1]);
        when(dobbelsteen3.getWaarde()).thenReturn(i[2]);
        when(dobbelsteen4.getWaarde()).thenReturn(i[3]);
        when(dobbelsteen5.getWaarde()).thenReturn(i[4]);
    }

    private void injectDobbelstenen(Yahtzee yahtzee) throws NoSuchFieldException, IllegalAccessException {
        Field dobbelstenenField = Yahtzee.class.getDeclaredField("dobbelstenen");
        dobbelstenenField.set(yahtzee, new Dobbelsteen[]{dobbelsteen1, dobbelsteen2, dobbelsteen3, dobbelsteen4, dobbelsteen5});
    }

    @Test
    public void testHoeVaakGooienVoordatYahtzee() {
        Yahtzee yahtzee = new Yahtzee();
        int aantalKeerGegooid = 0;
        while (!yahtzee.isYahtzee()) {
            yahtzee.gooiAlleDobbelstenen();
            aantalKeerGegooid++;
        }
        System.out.println(aantalKeerGegooid);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGooiEnkeleDobbelstenen_zonderDobbelstenen() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.gooiEnkeleDobbelstenen();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGooiEnkeleDobbelstenen_teVeelDobbelstenen() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.gooiEnkeleDobbelstenen(1,2,3,4,5,1);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGooiEnkeleDobbelstenen_teHoogGetalDobbelstenen() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.gooiEnkeleDobbelstenen(6);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGooiEnkeleDobbelstenen_dubbeleDobbelstenen() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.gooiEnkeleDobbelstenen(1,1,2,3);
    }

    @Test
    public void testGooiEnkeleDobbelstenen_goedeDobbelstenen() {
        Yahtzee yahtzee = new Yahtzee();
        yahtzee.gooiEnkeleDobbelstenen(1,2,3,4,5);
        yahtzee.gooiEnkeleDobbelstenen(1);
        yahtzee.gooiEnkeleDobbelstenen(1,2);
        yahtzee.gooiEnkeleDobbelstenen(5);
    }

}