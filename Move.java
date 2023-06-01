public class Move {
    Position origin;
    Position destination;

    public Move(Position o, Position d){
        this.origin = o;
        this.destination = d;
    }
    public Position getOrigin(){
        return this.origin;
    }
    public Position getDestination(){
        return this.destination;
    }

    //TODO: add copy constructor
    public String toString(){
        return getOrigin().toString() + " " + getDestination().toString();
    }
}
