package constants;

/**
 * Created by cesarkoot on 30/06/2017.
 */
public class Template {

    public static final int IDEAL_FIRST_COL_WIDTH = 40;

    public static final String ROW_NAMES_START = padLeft("", IDEAL_FIRST_COL_WIDTH);
    public static final String ROW_NAMES = "| %s ";
    public static final String ROW_NAMES_END = "|";

    public static final String ROW_1 = " A" + padLeft("1 ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String ROW_2 = " B" + padLeft("2 ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String ROW_3 = " C" + padLeft("3 ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String ROW_4 = " D" + padLeft("4 ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String ROW_5 = " E" + padLeft("5 ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String ROW_6 = " F" + padLeft("6 ", IDEAL_FIRST_COL_WIDTH-2);

    public static final String TOTAAL_1 = padLeft("Totaal 1: ", IDEAL_FIRST_COL_WIDTH);
    public static final String BONUS = padLeft("Bonus 35: ", IDEAL_FIRST_COL_WIDTH);

    public static final String THREE_OF_A_KIND = " G" + padLeft("Three of a kind (totaal) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String CARREE = " H" + padLeft("Carre (totaal) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String FULL_HOUSE = " I" + padLeft("Full house (25) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String KLEINE_STRAAT = " J" + padLeft("Kleine straat (30) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String GROTE_STRAAT = " K" + padLeft("Grote straat (40) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String YAHTZEE = " L" + padLeft("Yahtzee (50) ", IDEAL_FIRST_COL_WIDTH-2);
    public static final String CHANCE = " M" + padLeft("Chance (totaal) ", IDEAL_FIRST_COL_WIDTH-2);

    public static final String TOTAAL_2 = padLeft("Totaal 2: ", IDEAL_FIRST_COL_WIDTH);
    public static final String EIND_TOTAAL = padLeft("Eind totaal (1 + 2): ", IDEAL_FIRST_COL_WIDTH);

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public static String[] getPlayRows() {
        return new String[] {ROW_1, ROW_2, ROW_3, ROW_4, ROW_5, ROW_6, TOTAAL_1, BONUS, THREE_OF_A_KIND,
        CARREE, FULL_HOUSE, KLEINE_STRAAT, GROTE_STRAAT, YAHTZEE, CHANCE, TOTAAL_2, EIND_TOTAAL};
    }

}
