import constants.Template;

/**
 * Created by cesarkoot on 30/06/2017.
 */
public class ScreenBuilder {

    public static void buildScreen(Speler[] spelers) {
        int columnWidth = calcIdealColumnWidth(spelers);
        buildHeader(spelers, columnWidth);
        buildPlayRows(spelers, columnWidth);
    }

    private static int calcIdealColumnWidth(Speler[] spelers) {
        int longestArgLength = 3; // Omdat het getal 100 drie lang is. Zo krijg je altijd kolommen waar dat in past.
        for(Speler speler : spelers) {
            if (speler.getNaam().length() > longestArgLength) {
                longestArgLength = speler.getNaam().length();
            }
        }
        return longestArgLength;
    }

    private static void buildHeader(Speler[] spelers, int columnWidth) {
        // HEADER
        String firstRow = Template.ROW_NAMES_START;
        for(Speler speler : spelers) {
            String paddedName = Template.padLeft(speler.getNaam(), columnWidth);
            firstRow += String.format(Template.ROW_NAMES, paddedName);
        }
        firstRow += Template.ROW_NAMES_END;
        System.out.println(firstRow);

        drawLine(spelers, columnWidth);
    }

    private static void drawLine(Speler[] spelers, int columnWidth) {
        for(int i = 0; i < Template.IDEAL_FIRST_COL_WIDTH; i++) {
            System.out.print("-");
        }

        for(int i = 0; i < spelers.length; i++) {
            System.out.print("+");
            for (int j = 0; j < columnWidth+2; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    private static void buildPlayRows(Speler[] spelers, int columnWidth) {
        for(String playRow : Template.getPlayRows()) {
            for(Speler speler : spelers) {
                String paddedName = Template.padLeft("", columnWidth);
                playRow += String.format(Template.ROW_NAMES, paddedName);
            }
            playRow += Template.ROW_NAMES_END;
            System.out.println(playRow);
            drawLine(spelers, columnWidth);
        }
    }
}
