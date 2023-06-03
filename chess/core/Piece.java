package chess.core;

import java.util.ArrayList;

public abstract class Piece implements Cloneable {
    private Chess.PieceColor color;
    public Piece(Chess.PieceColor color) {
        this.color = color;
    }
    public Piece() {
        this(Chess.PieceColor.WHITE);
    }
    public ArrayList<Position> allDestinations(Chess chess, Position p) {
        return null;
    }
    public final Chess.PieceColor getPieceColor() {
        return this.color;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Piece copy = (Piece)super.clone();
            return copy;
        }
        catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
