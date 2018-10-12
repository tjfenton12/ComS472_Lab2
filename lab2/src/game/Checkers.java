package game;

/**
 * @author Tyler Fenton
 */

public class Checkers {

    private Piece redTeam[];
    private Piece whiteTeam[];
    private int board[][];

    public Checkers() {
        this.redTeam = new Piece[12];
        this.whiteTeam = new Piece[12];
        Util.initializeTeam(redTeam, Util.RED);
        Util.initializeTeam(whiteTeam, Util.WHITE);
        this.board = new int[8][8];
        Util.initializeBoard(board, whiteTeam, redTeam);
    }

}
