package game;

/**
 * @author Tyler Fenton
 */

public class Piece {

    private String color;
    private String status;
    private int xPosition;
    private int yPosition;

    public Piece() {

    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setPosition(int x, int y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public int getxPosition() {
        return this.xPosition;
    }

    public int getyPosition() {
        return this.yPosition;
    }

}
