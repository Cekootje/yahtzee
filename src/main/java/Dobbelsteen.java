import java.util.Random;

/**
 * Een dobbelsteen. Die kun je gooien en je kan de waarde uitlezen. Waarde is altijd tussen 1 en 6 (incl 1 en 6).
 *
 * Created by KootAJ on 22-6-2017.
 */
public class Dobbelsteen {

    private int huidigeWaarde = 0;

    public Dobbelsteen() {
        gooi();
    }

    public void gooi() {
        Random random = new Random();
        huidigeWaarde = random.nextInt(6) + 1;
    }

    public int getWaarde() {
        return huidigeWaarde;
    }

    @Override
    public String toString() {
        return "" + huidigeWaarde;
    }
}
