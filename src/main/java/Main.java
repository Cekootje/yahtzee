import constants.Colors;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by KootAJ on 22-6-2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        checkArgs(args);

        Speler[] spelers = SpelerBuilder.buildSpelers(args);
        ScreenBuilder.buildScreen(spelers);

        Scanner scanner = new Scanner(System.in);
        String userInput = "exit";

        while (!userInput.equals("exit")) {
            System.out.println("Waiting for input: ");
            userInput = scanner.nextLine();
            System.out.println(Colors.ANSI_YELLOW + "Your input was: " + Colors.ANSI_RED + userInput);
            System.out.print(Colors.ANSI_RESET);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Bye!");
    }

    /**
     * Args moet gevuld zijn met minimaal 1 parameter. Als dat niet zo is, dan een println met uitleg.
     * De parameters zijn de namen van de speler.
     *
     * @param args
     */
    private static void checkArgs(String[] args) {
        if (args.length == 0) {
            System.out.println("Geef een aantal spelers op");
            System.exit(0);
        }

        for (String arg : args) {
            if (arg.length() > "biebelebonsemensen".length()) {
                System.out.println("De naam " + arg + " is te lang, deze mag maximaal " + "biebelebonsemensen".length() + " zijn");
                System.exit(0);
            }
        }
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
