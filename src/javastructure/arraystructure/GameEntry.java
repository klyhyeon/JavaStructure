package javastructure.arraystructure;

public class GameEntry {
    private String name;
    private int score;

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public GameEntry() {}

    public static GameEntry emptyGameEntryConstructor() {
        return new GameEntry();
    }

    public String getName() { return name;}

    public int getScore() { return score;}

    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
