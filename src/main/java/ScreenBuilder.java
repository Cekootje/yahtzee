import constants.Template;

/**
 * Created by cesarkoot on 30/06/2017.
 */
public class ScreenBuilder {

    public static void buildScreen(String[] args) {
        int columnWidth = calcIdealColumnWidth(args);
        buildHeader(args, columnWidth);
        buildPlayRows(args, columnWidth);
    }

    private static int calcIdealColumnWidth(String[] args) {
        int longestArgLength = 3; // Omdat het getal 100 drie lang is. Zo krijg je altijd kolommen waar dat in past.
        for(String arg : args) {
            if (arg.length() > longestArgLength) {
                longestArgLength = arg.length();
            }
        }
        return longestArgLength;
    }

    private static void buildHeader(String[] args, int columnWidth) {
        // HEADER
        String firstRow = Template.ROW_NAMES_START;
        for(String arg : args) {
            String paddedName = Template.padLeft(arg, columnWidth);
            firstRow += String.format(Template.ROW_NAMES, paddedName);
        }
        firstRow += Template.ROW_NAMES_END;
        System.out.println(firstRow);

        drawLine(args, columnWidth);
    }

    private static void drawLine(String[] args, int columnWidth) {
        for(int i = 0; i < Template.IDEAL_FIRST_COL_WIDTH; i++) {
            System.out.print("-");
        }

        for(int i = 0; i < args.length; i++) {
            System.out.print("+");
            for (int j = 0; j < columnWidth+2; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    private static void buildPlayRows(String[] args, int columnWidth) {
        for(String playRow : Template.getPlayRows()) {
            for(String arg : args) {
                String paddedName = Template.padLeft("", columnWidth);
                playRow += String.format(Template.ROW_NAMES, paddedName);
            }
            playRow += Template.ROW_NAMES_END;
            System.out.println(playRow);
            drawLine(args, columnWidth);
        }
    }
}
