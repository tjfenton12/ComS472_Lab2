package game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyler Fenton
 */

public class Util {

    public static final String RED = "red";
    public static final String WHITE = "white";
    public static final String MAN = "man";
    public static final String KING = "king";
    public static final char WHITE_MAN = 'w';
    public static final char WHITE_KING = 'W';
    public static final char RED_MAN = 'r';
    public static final char RED_KING = 'R';
    public static final char EMPTY_SPACE = '0';

    /**
     * Initialize each provided piece to the given team and set to man status.
     *
     * @param arrl The pieces to be initialized.
     * @param team The team each piece will be set to.
     */
    public static void initializeTeam(List<Piece> arrl, String team) {
        for(int i = 0; i < 12; i++) {
            Piece piece = new Piece();
            piece.setColor(team);
            piece.setStatus(MAN);
            arrl.add(piece);
        }
        if (team.equals(WHITE)) {
            placeWhiteTeam(arrl);
        } else if (team.equals(RED)){
            placeRedTeam(arrl);
        }
    }

    /**
     * Initializes all spaces on the board with 0, for empty. Then initializes all white team pieces on the board with
     * 1. Then initializes all red team pieces on the board with 2.
     *
     * @param board The board to be initialized.
     * @param whiteTeam The white team. Used to initialize board with white team positions.
     * @param redTeam The red team. Used to initialize board with red team positions.
     */
    public static void initializeBoard(char[][] board, List<Piece> whiteTeam, List<Piece> redTeam) {
        /* set each position on the board to 0 */
        for(char[] subArray : board) {
            for(char position : subArray) {
                position = EMPTY_SPACE;
            }
        }
        /* set each white piece to 'w' */
        for(Piece piece : whiteTeam) {
            board[piece.getyPosition()][piece.getxPosition()] = WHITE_MAN;
        }
        /* set each red piece to 'r' */
        for(Piece piece : redTeam) {
            board[piece.getyPosition()][piece.getxPosition()] = RED_MAN;
        }
    }

    /**
     * Brute force implementation for initializing white team positions.
     *
     * @param arrl White pieces.
     */
    private static void placeWhiteTeam(List<Piece> arrl) {
        /* y=0 row */
        arrl.get(0).setPosition(1, 0);
        arrl.get(1).setPosition(3, 0);
        arrl.get(2).setPosition(5, 0);
        arrl.get(3).setPosition(7, 0);
        /* y=1 row */
        arrl.get(4).setPosition(0, 1);
        arrl.get(5).setPosition(2, 1);
        arrl.get(6).setPosition(4, 1);
        arrl.get(7).setPosition(6, 1);
        /* y=2 row */
        arrl.get(8).setPosition(1, 2);
        arrl.get(9).setPosition(3, 2);
        arrl.get(10).setPosition(5, 2);
        arrl.get(11).setPosition(7, 2);
    }

    /**
     * Brute force implementation for initializing red team positions.
     *
     * @param arrl Red pieces.
     */
    private static void placeRedTeam(List<Piece> arrl) {
        /* y=5 row */
        arrl.get(0).setPosition(0, 5);
        arrl.get(1).setPosition(2, 5);
        arrl.get(2).setPosition(4, 5);
        arrl.get(3).setPosition(6, 5);
        /* y=6 row */
        arrl.get(4).setPosition(1, 6);
        arrl.get(5).setPosition(3, 6);
        arrl.get(6).setPosition(5, 6);
        arrl.get(7).setPosition(7, 6);
        /* y=7 row */
        arrl.get(8).setPosition(0, 7);
        arrl.get(9).setPosition(2, 7);
        arrl.get(10).setPosition(4, 7);
        arrl.get(11).setPosition(6, 7);
    }

    /**
     * Determines the correct character to return for the board based on the provided piece.
     *
     * @param piece Piece used to determine the correct character.
     * @return Character which represents the type and status of the given Piece.
     */
    public static char getCharType(Piece piece) {
        if(piece.getColor().equals(RED)) {
            if(piece.getStatus().equals(KING)) {
                return RED_KING;
            } else {
                return RED_MAN;
            }
        } else if(piece.getStatus().equals(WHITE)){
            if(piece.getStatus().equals(KING)) {
                return WHITE_KING;
            } else {
                return WHITE_MAN;
            }
        }
        return '0';
    }

    /**
     * Prints the checkerboard.
     */
    public static void printCheckers(char[][] board) {
        for(char[] subArray : board) {
            for(char position : subArray) {
                System.out.print(position + " ");
            }
            System.out.println();
        }
    }

}
