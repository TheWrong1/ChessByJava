public class Position {
    private int rank;
    private int file;
    public final char files[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public Position(int f, int r){
        this.rank = r;
        this.file = f;
    }
    public Position(){
        this.rank = 0;
        this.file = 0;
    }
    public Position(Position p){
        this.rank = p.rank;
        this.file = p.file;
    }
    public int getFile() {return file;}
    public int getRank() {return rank;}
    public void setFile(int file) {this.file = file;}
    public void setRank(int rank) {this.rank = rank;}

    public String toString(){return files[getFile()] + String.valueOf(getRank()+1);}

    public static void generateFromString(String str){
        switch (str.charAt(0)){
            case 'A':
                new Position(str.charAt(1)-1, 0);
                break;
            case 'B':
                new Position(str.charAt(1)-1, 1);
                break;
            case 'C':
                new Position(str.charAt(1)-1, 2);
                break;
            case 'D':
                new Position(str.charAt(1)-1, 3);
                break;
            case 'E':
                new Position(str.charAt(1)-1, 4);
                break;
            case 'F':
                new Position(str.charAt(1)-1, 5);
                break;
            case 'G':
                new Position(str.charAt(1)-1, 6);
                break;
            case 'H':
                new Position(str.charAt(1)-1, 7);
                break;
        }
    }
}
