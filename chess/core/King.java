package chess.core;

public class King extends Piece implements Cloneable {
    private boolean hasMoved;

    public King() {
        this(Chess.PieceColor.WHITE);
    }

    public King(Chess.PieceColor color) {
        this(color, false);
    }

    public King(Chess.PieceColor color, boolean hasMoved) {
        super(color);
        this.hasMoved = hasMoved;
    }

    public String toString() {
        if (this.getPieceColor() == Chess.PieceColor.WHITE)
            return "K";
        else
            return "k";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        King copy = (King)super.clone();
        return copy;
    }

    public Position[] allDestinations(Chess chess, Position p) {
        //preliminary, check mechanism not implemented.
        int[][] pattern = {
                {p.getRank() - 1, p.getFile() - 1},
                {p.getRank(),     p.getFile() - 1},
                {p.getRank() + 1, p.getFile() - 1},

                {p.getRank() - 1, p.getFile()},
                {p.getRank() + 1, p.getFile()},

                {p.getRank() - 1, p.getFile() + 1},
                {p.getRank(),     p.getFile() + 1},
                {p.getRank() + 1, p.getFile() + 1}
        };

        Position[] result = new Position[0];

        for (int i = 0; i < pattern.length; i++) {
            Position potential = Position.generateFromRankAndFile(pattern[i][0],
                    pattern[i][1]);
            if (potential != null && (chess.isEmpty(potential)
                    || chess.getPieceAt(potential).getPieceColor()
                    != chess.getPieceAt(p).getPieceColor()))
                result = Position.appendPositionsToArray(result, potential);
        }

        return result;
    }
}
