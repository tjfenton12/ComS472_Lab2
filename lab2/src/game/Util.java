package game;

/**
 * @author Tyler Fenton
 */

public class Util {

    public static final String RED = "red";
    public static final String WHITE = "white";
    public static final String MAN = "man";
    public static final String KING = "king";

    /**
     * Initialize each provided piece to the given team and set to man status.
     *
     * @param arr The pieces to be initialized.
     * @param team The team each piece will be set to.
     */
    public static void initializeTeam(Piece arr[], String team) {
        for(Piece piece : arr) {
            piece.setColor(team);
            piece.setStatus(MAN);
        }
        if (team.equals(WHITE)) {
            placeWhiteTeam(arr);
        } else if (team.equals(RED)){
            placeRedTeam(arr);
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
    public static void initializeBoard(int board[][], Piece whiteTeam[], Piece redTeam[]) {
        /* set each position on the board to 0 */
        for(int[] subArray : board) {
            for(int position : subArray) {
                position = 0;
            }
        }
        /* set each white piece to 1 */
        for(Piece piece : whiteTeam) {
            board[piece.getxPosition()][piece.getyPosition()] = 1;
        }
        /* set each red piece to 2 */
        for(Piece piece : redTeam) {
            board[piece.getxPosition()][piece.getyPosition()] = 2;
        }
    }

    /**
     * Brute force implementation for initializing white team positions.
     *
     * @param arr White pieces.
     */
    private static void placeWhiteTeam(Piece arr[]) {
        /* y=0 row */
        arr[0].setPosition(1, 0);
        arr[1].setPosition(3, 0);
        arr[2].setPosition(5, 0);
        arr[3].setPosition(7, 0);
        /* y=1 row */
        arr[4].setPosition(0, 1);
        arr[5].setPosition(2, 1);
        arr[6].setPosition(4, 1);
        arr[7].setPosition(6, 1);
        /* y=2 row */
        arr[8].setPosition(1, 2);
        arr[9].setPosition(3, 2);
        arr[10].setPosition(5, 2);
        arr[11].setPosition(7, 2);
    }

    /**
     * Brute force implementation for initializing red team positions.
     *
     * @param arr Red pieces.
     */
    private static void placeRedTeam(Piece arr[]) {
        /* y=5 row */
        arr[0].setPosition(0, 5);
        arr[1].setPosition(2, 5);
        arr[2].setPosition(4, 5);
        arr[3].setPosition(6, 5);
        /* y=6 row */
        arr[4].setPosition(1, 6);
        arr[5].setPosition(3, 6);
        arr[6].setPosition(5, 6);
        arr[7].setPosition(7, 6);
        /* y=7 row */
        arr[8].setPosition(0, 7);
        arr[9].setPosition(2, 7);
        arr[10].setPosition(4, 7);
        arr[11].setPosition(6, 7);
    }

}
