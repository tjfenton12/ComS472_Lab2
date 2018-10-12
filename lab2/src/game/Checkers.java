package game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyler Fenton
 */

public class Checkers {

    private List<Piece> redTeam;
    private List<Piece> whiteTeam;
    private int[][] board;

    public Checkers() {
        this.redTeam = new ArrayList<>(12);
        this.whiteTeam = new ArrayList<>(12);
        Util.initializeTeam(redTeam, Util.RED);
        Util.initializeTeam(whiteTeam, Util.WHITE);
        this.board = new int[8][8];
        Util.initializeBoard(board, whiteTeam, redTeam);
    }

    public static void main(String args[]) {
        Checkers game = new Checkers();
    }

}
