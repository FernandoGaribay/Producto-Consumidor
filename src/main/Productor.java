package main;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private Buffer buffer;
    private final String letras = "abcdefghijklmnñopkrsuvwxyz";

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            char producto = letras.charAt((int) (Math.random() * letras.length()));
            buffer.producir(producto);
 
            System.out.println("Creado el producto: " + producto + " en el buffer.");
            buffer.imprimirBuffer();
            try {
                sleep(random(5, 3) * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private int random(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
}
