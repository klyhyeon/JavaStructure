package javastructure.arraystructure;

public class Scoreboard {
    private int numEntries;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length)
                numEntries++;
            int j = numEntries - 1;
            while (j > 0 && newScore > board[j].getScore()) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e;
        }
    }

    //int idx로 코드수정
    public GameEntry remove(int i) {
        if (i < 0 || i >= board.length)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        GameEntry removeEntry = board[i];
        int j = i;
        while(j < numEntries - 1) {
            board[j] = board[j+1];
            j++;
        }
        board[numEntries - 1] = null;
        numEntries--;
        return removeEntry;
    }
}


