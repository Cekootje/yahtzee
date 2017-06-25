/**
 * Created by KootAJ on 22-6-2017.
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        Yahtzee yahtzee = new Yahtzee();
        int aantalWorpen = 0;

        int fullHousesThrown = 0;
        int threeOfAKindsThrown = 0;
        int carresThrown = 0;
        int yahtzeesThrown = 0;

        while (yahtzeesThrown == 0) {
            aantalWorpen++;
            yahtzee.gooiAlleDobbelstenen();

            if (yahtzee.isYahtzee()) {
                yahtzeesThrown++;
                continue;
            }

            if (yahtzee.isCarre()) {
                carresThrown++;
                continue;
            }

            if (yahtzee.isFullHouse()) {
                fullHousesThrown++;
                continue;
            }

            if (yahtzee.isThreeOfAKind()) {
                threeOfAKindsThrown++;
                continue;
            }
        }

        System.out.println("We hebben een yahtzee in " + aantalWorpen + " worpen!");
        System.out.println("Aantal full houses in de tussentijd: " + fullHousesThrown);
        System.out.println("Aantal pure three of a kinds in de tussentijd: " + threeOfAKindsThrown);
        System.out.println("Aantal pure carrees in de tussentijd: " + carresThrown);

    }
}
