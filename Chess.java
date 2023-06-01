import java.lang.*;
public class Chess {
    private char[][] board = new char[8][8];
    private int count = 0;

    public Chess(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 'X';
            }
        }
        board[0][0] = 'R';
        board[0][7] = 'R';
        board[7][7] = 'r';
        board[7][0] = 'r';
    }

    public void print(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getTurn(){
        if(count%2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public boolean gameOver(){
        return false;
    }

    public boolean isWhitePieceAt(Position p){
        if(board[p.getFile()][p.getRank()] == Character.toUpperCase(board[p.getFile()][p.getRank()]) ){
            return true;
        }
        return false;
    }

    public boolean isEmpty(Position p){
        if (board[p.getFile()][p.getRank()] == 'X'){
            return true;
        }else{
            return false;
        }
    }
    public char getPieceAt(Position p){
        return board[p.getFile()][p.getRank()];
    }
    public Position[] reachableFrom(Position origin){
        if(origin == null || isEmpty(origin)){
            return null;
        }
        //TODO: add knight
        return null;
    }

    public void makeMove() {
        //Todo: finish this;
    }
}
