public class main {
    public static void main(String[] args) {

        Position mama = new Position();
        Position kaka = new Position(7, 0);
        Position tata = new Position(7, 4);

        System.out.println(mama.toString());
        System.out.println(kaka.toString());
        System.out.println(tata.toString());

        System.out.println("...");
        Move m = new Move(kaka, mama);
        System.out.println(m.toString());

        Chess ch = new Chess();
        ch.print();


    }
}
