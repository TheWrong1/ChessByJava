public class Position {
    private int rank;
    private int file;
    public char files[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

    public Position(int r, int f){
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

    public String toString(){return files[getFile()] + String.valueOf(getFile()+1);}
}
