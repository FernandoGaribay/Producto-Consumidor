package main;

public class Main {

    public static void main(String[] args) {
        Buffer b = new Buffer(5);
        Productor p1 = new Productor(b);
        Consumidor c1 = new Consumidor(b);

        p1.start();
        c1.start();

    }
}