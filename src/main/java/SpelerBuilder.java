/**
 * Created by cesarkoot on 04/07/2017.
 */
public class SpelerBuilder {

    private SpelerBuilder() {
    }

    public static Speler[] buildSpelers(String[] args) {
        Speler[] spelers = new Speler[args.length];
        int i = 0;
        for(String arg : args) {
            Speler speler = new Speler(arg);
            spelers[i] = speler;
            i++;
        }
        return spelers;
    }

}
