/**
 * Created by cesarkoot on 04/07/2017.
 */
public class Speler {

    private String naam;

    private int score_1 = 0;
    private int score_2 = 0;
    private int score_3 = 0;
    private int score_4 = 0;
    private int score_5 = 0;
    private int score_6 = 0;

    private int score_bonus = 0;

    private int score_three_of_a_kind = 0;
    private int score_carree = 0;
    private int score_full_house = 0;
    private int score_kleine_straat = 0;
    private int score_grote_straat = 0;
    private int score_yahtzee = 0;
    private int score_chance = 0;

    public Speler(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public int getScore_1() {
        return score_1;
    }

    public void setScore_1(int score_1) {
        this.score_1 = score_1;
    }

    public int getScore_2() {
        return score_2;
    }

    public void setScore_2(int score_2) {
        this.score_2 = score_2;
    }

    public int getScore_3() {
        return score_3;
    }

    public void setScore_3(int score_3) {
        this.score_3 = score_3;
    }

    public int getScore_4() {
        return score_4;
    }

    public void setScore_4(int score_4) {
        this.score_4 = score_4;
    }

    public int getScore_5() {
        return score_5;
    }

    public void setScore_5(int score_5) {
        this.score_5 = score_5;
    }

    public int getScore_6() {
        return score_6;
    }

    public void setScore_6(int score_6) {
        this.score_6 = score_6;
    }

    public int getScore_bonus() {
        return score_bonus;
    }

    public void setScore_bonus(int score_bonus) {
        this.score_bonus = score_bonus;
    }

    public int getScore_three_of_a_kind() {
        return score_three_of_a_kind;
    }

    public void setScore_three_of_a_kind(int score_three_of_a_kind) {
        this.score_three_of_a_kind = score_three_of_a_kind;
    }

    public int getScore_carree() {
        return score_carree;
    }

    public void setScore_carree(int score_carree) {
        this.score_carree = score_carree;
    }

    public int getScore_full_house() {
        return score_full_house;
    }

    public void setScore_full_house(int score_full_house) {
        this.score_full_house = score_full_house;
    }

    public int getScore_kleine_straat() {
        return score_kleine_straat;
    }

    public void setScore_kleine_straat(int score_kleine_straat) {
        this.score_kleine_straat = score_kleine_straat;
    }

    public int getScore_grote_straat() {
        return score_grote_straat;
    }

    public void setScore_grote_straat(int score_grote_straat) {
        this.score_grote_straat = score_grote_straat;
    }

    public int getScore_yahtzee() {
        return score_yahtzee;
    }

    public void setScore_yahtzee(int score_yahtzee) {
        this.score_yahtzee = score_yahtzee;
    }

    public int getScore_chance() {
        return score_chance;
    }

    public void setScore_chance(int score_chance) {
        this.score_chance = score_chance;
    }
}
