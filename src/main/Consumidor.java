package main;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    private Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            char producto = buffer.consumir();

            System.out.println("Consumido el producto: " + producto + " del buffer.");
            buffer.imprimirBuffer();
            try {
                sleep(random(3, 1) * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private int random(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
}
