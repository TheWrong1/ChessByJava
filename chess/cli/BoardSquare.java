package chess.cli;

import javax.swing.*;
import java.awt.*;

public class BoardSquare extends JButton {
    public final Color red = new Color(63, 208, 227);
    public final Color white = new Color(255, 255, 255);
    public final Color black = new Color(192, 183, 183);

    private int x, y;

    public Color getBlack() {
        return black;
    }

    boolean isWhite;
    public BoardSquare(boolean ISWHITE, int X, int Y){
        this.x = X;
        this.y = Y;
        this.isWhite = ISWHITE;

        if (isWhite) {
            this.setBackground(white);
        }else{
            this.setBackground(black);
        }

        this.setBounds(x*64,y*64, 64, 64);
        this.setFont(new Font(null, Font.PLAIN, 30));

    }
    public int[] getCords(){
        return new int[]{x, y};
    }
    public void setPiece(String piece) {
        if (piece == null) {
            setText("");
            return;
        }
        switch (piece) {
            case "k", "s":
                setText("\u265A"); // BLACK CHESS KING
                break;
            case "q":
                setText("\u265B"); // BLACK CHESS QUEEN
                break;
            case "r":
                setText("\u265C"); // BLACK CHESS ROOK
                break;
            case "b":
                setText("\u265D"); // BLACK CHESS BISHOP
                break;
            case "n":
                setText("\u265E"); // BLACK CHESS KNIGHT
                break;
            case "p":
                setText("\u265F"); // BLACK CHESS PAWN
                break;
            case "K", "S":
                setText("\u2654"); // WHITE CHESS KING
                break;
            case "Q":
                setText("\u2655"); // WHITE CHESS QUEEN
                break;
            case "R":
                setText("\u2656"); // WHITE CHESS ROOK
                break;
            case "B":
                setText("\u2657"); // WHITE CHESS BISHOP
                break;
            case "N":
                setText("\u2658"); // WHITE CHESS KNIGHT
                break;
            case "P":
                setText("\u2659"); // WHITE CHESS PAWN
                break;
            default:
                // Error handling: If the piece is not recognized, do nothing or log an error
                break;
        }
    }
    // Overloaded setPiece method
    public void setHighlight(boolean b){
        if (b){
            setBackground(red);
        }else{
            if (isWhite) {
                this.setBackground(white);
            }else{
                this.setBackground(black);
            }
        }
    }
}
