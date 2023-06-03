package chess.core;

import java.util.ArrayList;

public class Chess {
    static boolean whiteKingPresent = false;
    static boolean blackKingPresent = false;
    public enum PieceColor {WHITE, BLACK}
    public static final int BOARD_RANKS = 8;
    public static final int BOARD_FILES = 8;
    public static final int WHITE_PAWN_STARTING_RANK = 6;
    public static final int BLACK_PAWN_STARTING_RANK = 1;
    protected Object clone() throws CloneNotSupportedException {
        Chess copy = (Chess)super.clone();

        return copy;
    }
    private Piece[][] board;
    private int numberOfMoves;
    public Chess() {
        this("rnbqkbnr" +
                        "pppppppp" +
                        "--------" +
                        "--------" +
                        "--------" +
                        "--------" +
                        "PPPPPPPP" +
                        "RNBQKBNR",
                PieceColor.WHITE);
    }
    public Chess(String arrangement, PieceColor turn) {
        this.numberOfMoves = turn.ordinal();
        this.board = new Piece[BOARD_RANKS][BOARD_FILES];

//        boolean whiteKingPresent = false, blackKingPresent = false;
        for (int i = 0; i < arrangement.length(); i++) {
            switch (arrangement.charAt(i)) {
                case 'R':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Rook(PieceColor.WHITE);
                    break;
                case 'r':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Rook(PieceColor.BLACK);
                    break;
                case 'S':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Rook(PieceColor.WHITE, true);
                    break;
                case 's':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Rook(PieceColor.BLACK, true);
                    break;
                case 'N':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Knight(PieceColor.WHITE);
                    break;
                case 'n':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Knight(PieceColor.BLACK);
                    break;
                case 'B':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Bishop(PieceColor.WHITE);
                    break;
                case 'b':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Bishop(PieceColor.BLACK);
                    break;
                case 'K':
                    if (whiteKingPresent) {
                        System.out.println("More than one white king");
                        System.exit(0);
                    }
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new King(PieceColor.WHITE);
                    whiteKingPresent = true;
                    break;
                case 'k':
                    if (blackKingPresent) {
                        System.out.println("More than one black king");
                        System.exit(0);
                    }
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new King(PieceColor.BLACK);
                    blackKingPresent = true;
                    break;
                case 'L':
                    if (whiteKingPresent) {
                        System.out.println("More than one white king");
                        System.exit(0);
                    }
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new King(PieceColor.WHITE, true);
                    whiteKingPresent = true;
                    break;
                case 'l':
                    if (blackKingPresent) {
                        System.out.println("More than one black king");
                        System.exit(0);
                    }
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new King(PieceColor.BLACK, true);
                    blackKingPresent = true;
                    break;
                case 'Q':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Queen(PieceColor.WHITE);
                    break;
                case 'q':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Queen(PieceColor.BLACK);
                    break;
                case 'P':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Pawn(PieceColor.WHITE);
                    break;
                case 'p':
                    this.board[i/BOARD_RANKS][i%BOARD_FILES] = new Pawn(PieceColor.BLACK);
                    break;
            }
        }
        if (!whiteKingPresent || !blackKingPresent) {
            System.out.println("There should be at least one king of each color");
            System.exit(0);
        }
    }
    public Piece[][] getBoard() {
        Piece[][] boardCopy = new Piece[BOARD_RANKS][BOARD_FILES];
        for (int i = 0; i < BOARD_RANKS; i++)
            for (int j = 0; j < BOARD_FILES; j++)
                boardCopy[i][j] = this.board[i][j];
        return boardCopy;
    }
    public PieceColor getTurn() {
        return PieceColor.values()[this.numberOfMoves % 2];
    }
    public boolean isGameOver() {
        return false;
    }
    public boolean isEmpty(Position p) {
        return this.board[p.getRank()][p.getFile()] == null;
    }
    public Piece getPieceAt(Position p) {
        return this.board[p.getRank()][p.getFile()];
    }
    public ArrayList<Position> reachableFrom(Position origin) {
        if (origin == null || this.isEmpty(origin))
            return null;

        return board[origin.getRank()][origin.getFile()].allDestinations(this,
                origin);
    }
    public boolean performMove(Move m) {
        Position o = m.getOrigin();
        Position d = m.getDestination();

        if (this.getPieceAt(o).getPieceColor() != this.getTurn())
            return false;

        ArrayList<Position> reachable = this.reachableFrom(o);

        for (int i = 0; i < reachable.size(); i++)
            if (d.getRank() == reachable.get(i).getRank()
                    && d.getFile() == reachable.get(i).getFile()) {
                this.board[d.getRank()][d.getFile()] = this.board[o.getRank()][o.getFile()];
                this.board[o.getRank()][o.getFile()] = null;
                this.numberOfMoves++;
                return true;
            }

        return false;
    }
    public static void verifyArrangement(String s) throws IllegalArrangementException {
        try {
            if (s.length() != 64) {
                throw new IllegalArrangementException("The length is not equal to 64");
            }
        }
        catch (IllegalArrangementException e) {
            System.out.println(e.getMessage());
        }

        try {
            if (!blackKingPresent || !whiteKingPresent ) {
                throw new InvalidNumberOfKingsException();
            }
         }
        catch (IllegalArrangementException e) {
            System.out.println(e.getMessage());
        }

    }
}
