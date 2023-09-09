package main;

public class Main {

    public static void main(String[] args) {
        Buffer b = new Buffer(5, 1, 2);
        Productor p1 = new Productor(0, b);
        Productor p2 = new Productor(0, b);
        Consumidor c1 = new Consumidor(0, b);

        p1.start();
        p2.start();
        c1.start();

    }
}
