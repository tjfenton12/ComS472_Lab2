package game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tyler Fenton
 */

public class Checkers {

    private List<Piece> redTeam; //Red Team's pieces.
    private List<Piece> whiteTeam; //White Team's pieces.
    /*
     * 0 = empty space
     * w = Regular white piece
     * W = King white piece
     * r = Regular red piece
     * R = King red piece
     */
    private char[][] board; //2D array of characters representing the board.

    public Checkers() {
        this.redTeam = new ArrayList<>(12);
        this.whiteTeam = new ArrayList<>(12);
        Util.initializeTeam(redTeam, Util.RED);
        Util.initializeTeam(whiteTeam, Util.WHITE);
        this.board = new char[8][8];
        Util.initializeBoard(board, whiteTeam, redTeam);
    }

    public static void main(String args[]) {
        Checkers game = new Checkers();
        Util.printCheckers(game.board);
    }

    /**
     * Get the board associated with this instance of Checkers.
     * @return The board.
     */
    public char[][] getBoard() {
        return this.board;
    }

    /**
     * Get the red team associated with this instance of Checkers.
     * @return The red team.
     */
    public List<Piece> getRedTeam() {
        return this.redTeam;
    }

    /**
     * Get the white team associated with this instance of Checkers.
     * @return The white team.
     */
    public List<Piece> getWhiteTeam() {
        return this.whiteTeam;
    }

    /**
     * Performs a move action on a given piece to a given destination.
     *
     * @param playerPiece Piece which will be moved.
     * @param destinationX X-Coordinate of the spot which will be moved to.
     * @param destinationY Y-Coordinate of the spot which will be moved to.
     * @return True if the piece moved and False if it did not move to the location requested.
     */
    public boolean move(Piece playerPiece, int destinationX, int destinationY) {
        if(!isLegalMove(playerPiece, destinationX, destinationY)) {
            return false;
        }
        /* Sets the former position of the playerPiece to empty */
        board[playerPiece.getyPosition()][playerPiece.getxPosition()] = Util.EMPTY_SPACE;
        /* Update the playerPiece's new position */
        playerPiece.setPosition(destinationX, destinationY);
        /* Assigns the space on the board to the appropriate character given the player piece */
        board[playerPiece.getyPosition()][playerPiece.getxPosition()] = Util.getCharType(playerPiece);

        return true;
    }

    /**
     * Helper method mostly to determine the legality of a provided move.
     *
     * @param playerPiece
     * @param destinationX
     * @param destinationY
     * @return True if move is legal and False if move is illegal.
     */
    public boolean isLegalMove(Piece playerPiece, int destinationX, int destinationY) {
        if(playerPiece.getColor().equals(Util.RED)) {
            if(playerPiece.getStatus().equals(Util.KING)) {
                if(((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)
                || ((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)) {
                    return true;
                }
            } else if(playerPiece.getStatus().equals(Util.MAN)) {
                if(((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)) {
                    return true;
                }
            }
        } else if(playerPiece.getColor().equals(Util.WHITE)) {
            if(playerPiece.getStatus().equals(Util.KING)) {
                if(((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)
                || ((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() - 1) == destinationY)) {
                    return true;
                }
            } else if (playerPiece.getStatus().equals(Util.MAN)){
                if(((playerPiece.getxPosition() + 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)
                || ((playerPiece.getxPosition() - 1) == destinationX && (playerPiece.getyPosition() + 1) == destinationY)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Provided a given X-Coordinate and Y-Coordinate, obtains gets the respective piece. This method assumes that all
     * pieces in the teams list are representative of the boards representation of them.
     *
     * @param xCoordinate X-Coordinate of the piece to look for.
     * @param yCoordinate Y-Coordinate of the piece to look for.
     * @return The Piece which is found if the X-Coordinate and Y-Coordinate are the same as a given piece. Null when
     *         the piece is not found
     */
    public Piece getPlayerPiece(int xCoordinate, int yCoordinate) {
        /* Checks if the coordinate provided is a red piece */
        for(Piece piece : redTeam) {
            if(piece.getxPosition() == xCoordinate && piece.getyPosition() == yCoordinate) {
                return piece;
            }
        }
        /* Checks if the coordinate provided is a white piece */
        for(Piece piece : whiteTeam) {
            if(piece.getxPosition() == xCoordinate && piece.getyPosition() == yCoordinate) {
                return piece;
            }
        }
        /* The coordinate was not found */
        return null;
    }

}
