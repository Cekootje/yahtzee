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
        Yahtzee yahtzee = initiateMockDobbelstenen(2,2,2,2,2);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_insertCarre_true() throws NoSuchFieldException, IllegalAccessException {

        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,2);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_insertThreeOfAKind_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,2,2);
        assertTrue(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsThreeOfAKind_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,3,2,2);
        assertFalse(yahtzee.isThreeOfAKind());
    }

    @Test
    public void testIsCarre_insertYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,1);
        assertTrue(yahtzee.isCarre());
    }

    @Test
    public void testIsCarre_insertCarre_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,2);
        assertTrue(yahtzee.isCarre());
    }

    @Test
    public void testIsCarre_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,2,2);
        assertFalse(yahtzee.isCarre());
    }

    @Test
    public void testIsYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,1);
        assertTrue(yahtzee.isYahtzee());
    }

    @Test
    public void testIsYahtzee_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,2);
        assertFalse(yahtzee.isYahtzee());
    }

    @Test
    public void testIsFullHouse_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,2,2);
        assertTrue(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_insertYahtzee_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,1);
        assertTrue(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_insertCarre_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,2);
        assertFalse(yahtzee.isFullHouse());
    }

    @Test
    public void testIsFullHouse_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,2,3,1,2);
        assertFalse(yahtzee.isFullHouse());
    }

    @Test
    public void testIsKleineStraat_start_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(2,3,4,4,1);
        assertTrue(yahtzee.isKleineStraat());
    }

    @Test
    public void testIsKleineStraat_middle_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(2,2,3,4,5);
        assertTrue(yahtzee.isKleineStraat());
    }

    @Test
    public void testIsKleineStraat_end_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,3,4,5,6);
        assertTrue(yahtzee.isKleineStraat());
    }

    @Test
    public void testIsKleineStraat_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,3,4,5,5);
        assertFalse(yahtzee.isKleineStraat());
    }

    @Test
    public void testIsGroteStraat_start_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(3,4,1,2,5);
        assertTrue(yahtzee.isGroteStraat());
    }

    @Test
    public void testIsGroteStraat_end_true() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(6,3,4,2,5);
        assertTrue(yahtzee.isGroteStraat());
    }

    @Test
    public void testIsGroteStraat_false() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(5,3,4,2,5);
        assertFalse(yahtzee.isGroteStraat());
    }

    @Test
    public void testGetChance_low() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,1,1,1,1);
        assertEquals(yahtzee.getChance(), 5);
    }

    @Test
    public void testGetChance_high() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(6,6,6,6,6);
        assertEquals(yahtzee.getChance(), 30);
    }

    @Test
    public void testGetTotaalPerWaarde() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(6,6,6,6,6);
        assertEquals(yahtzee.getTotaalPerWaarde(1), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(2), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(3), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(4), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(5), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(6), 30);
    }

    @Test
    public void testGetTotaalPerWaarde_doorElkaar() throws NoSuchFieldException, IllegalAccessException {
        Yahtzee yahtzee = initiateMockDobbelstenen(1,2,6,3,6);
        assertEquals(yahtzee.getTotaalPerWaarde(1), 1);
        assertEquals(yahtzee.getTotaalPerWaarde(2), 2);
        assertEquals(yahtzee.getTotaalPerWaarde(3), 3);
        assertEquals(yahtzee.getTotaalPerWaarde(4), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(5), 0);
        assertEquals(yahtzee.getTotaalPerWaarde(6), 12);
    }

    private Yahtzee initiateMockDobbelstenen(int ... i) throws NoSuchFieldException, IllegalAccessException {
        when(dobbelsteen1.getWaarde()).thenReturn(i[0]);
        when(dobbelsteen2.getWaarde()).thenReturn(i[1]);
        when(dobbelsteen3.getWaarde()).thenReturn(i[2]);
        when(dobbelsteen4.getWaarde()).thenReturn(i[3]);
        when(dobbelsteen5.getWaarde()).thenReturn(i[4]);
        Yahtzee yahtzee = new Yahtzee();
        injectDobbelstenen(yahtzee);
        return yahtzee;
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