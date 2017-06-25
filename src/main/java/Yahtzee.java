import java.util.Arrays;

/**
 * Een set dobbelstenen.
 *
 * Created by KootAJ on 22-6-2017.
 */
public class Yahtzee {

    Dobbelsteen[] dobbelstenen = new Dobbelsteen[5];

    public Yahtzee() {
        for (int i = 0; i < dobbelstenen.length; i++) {
            dobbelstenen[i] = new Dobbelsteen();
        }
    }

    public String getHuidigeWaarde() {
        return Arrays.toString(dobbelstenen);
    }

    public void gooiAlleDobbelstenen() {
        for (Dobbelsteen dobbelsteen : dobbelstenen) {
            dobbelsteen.gooi();
        }
    }

    public void gooiEnkeleDobbelstenen(int ... teGooienDobbelstenen) {

        int[] checkDubbelTeGooienDobbelstenen = new int[5];

        if (teGooienDobbelstenen.length == 0) {
            throw new IllegalArgumentException("Er moet minimaal 1 dobbelsteen worden gegooid");
        }

        if (teGooienDobbelstenen.length > 5) {
            throw new IllegalArgumentException("Er kunnen hooguit 5 dobbelstenen worden gegooid");
        }

        for (int teGooienDobbelsteen : teGooienDobbelstenen) {
            if (teGooienDobbelsteen > 5) {
                throw new IllegalArgumentException("Er zijn maar 5 dobbelstenen");
            }
            checkDubbelTeGooienDobbelstenen[teGooienDobbelsteen-1]++;
        }

        for(int checkDubbelTeGooienDobbelsteen : checkDubbelTeGooienDobbelstenen) {
            if (checkDubbelTeGooienDobbelsteen > 1) {
                throw new IllegalArgumentException("Dobbelstenen mogen niet dubbel gegooid worden in dezelfde worp");
            }
        }

        for (int teGooienDobbelsteen : teGooienDobbelstenen) {
            dobbelstenen[teGooienDobbelsteen-1].gooi();
        }
    }

    public Dobbelsteen[] getDobbelstenen() {
        return dobbelstenen;
    }

    private int getAantalDobbelstenenMetOgen(int ogen) {
        int telling = 0;
        for (Dobbelsteen dobbelsteen : dobbelstenen) {
            if (dobbelsteen.getWaarde() == ogen) {
                telling++;
            }
        }
        return telling;
    }

    public boolean isThreeOfAKind() {
        for (int i = 1; i <= 6; i++) {
            int aantalDobbelstenenMetOgen = getAantalDobbelstenenMetOgen(i);

            // We've got a winner.
            if (aantalDobbelstenenMetOgen >= 3) {
                return true;
            }
        }
        return false;
    }

    // Als dit een carre is dan return true. Dat zijn vier dezelfde getallen. Geldt dus ook voor de yahtzee!
    public boolean isCarre() {
        for (int i = 1; i <= 6; i++) {
            int aantalDobbelstenenMetOgen = getAantalDobbelstenenMetOgen(i);

            // Hou maar op met tellen.
            if (aantalDobbelstenenMetOgen == 2 || aantalDobbelstenenMetOgen == 3) {
                return false;
            }

            // We've got a winner.
            if (aantalDobbelstenenMetOgen >= 4) {
                return true;
            }
        }
        return false;
    }

    // Als full house dan return true. Dat zijn 3 dezelfde en 2 dezelfde.
    public boolean isFullHouse() {
        for (int i = 1; i <= 6; i++) {
            int aantalDobbelstenenMetOgen = getAantalDobbelstenenMetOgen(i);

            // Hou maar op met tellen.
            if (aantalDobbelstenenMetOgen == 1 || aantalDobbelstenenMetOgen == 4) {
                return false;
            }
        }
        return true;
    }

    public boolean isKleineStraat() {
        Dobbelsteen[] gesorteerdeDobbelstenen = sorteerDobbelstenen();

        System.out.println("dobbelstenen: " + Arrays.toString(dobbelstenen));
        System.out.println("gesorteerde dobbelstenen: " + Arrays.toString(gesorteerdeDobbelstenen));
        return false;
    }

    private Dobbelsteen[] sorteerDobbelstenen() {
        Dobbelsteen[] gesorteerdeDobbelstenen = Arrays.copyOf(dobbelstenen, dobbelstenen.length);
        Arrays.sort(gesorteerdeDobbelstenen);
        return gesorteerdeDobbelstenen;
    }

    public boolean isGroteStraat() {
        return false;
    }

    // Als dit een yahtzee is dan return true.
    public boolean isYahtzee() {
        for (int i = 1; i <= 6; i++) {
            int aantalDobbelstenenMetOgen = getAantalDobbelstenenMetOgen(i);

            // Hou maar op met tellen.
            if (aantalDobbelstenenMetOgen > 0 && aantalDobbelstenenMetOgen < 5) {
                return false;
            }

            // We've got a winner.
            if (aantalDobbelstenenMetOgen == 5) {
                return true;
            }
        }
        return false;
    }
}
