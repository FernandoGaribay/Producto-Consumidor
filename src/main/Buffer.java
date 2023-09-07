package main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {

    private List<Character> buffer;
    private int capacidad;
    private boolean estaVacio;
    private boolean estaLLeno;

    public Buffer(int capacidad) {
        this.buffer = new ArrayList<>(capacidad);
        this.capacidad = capacidad;
        this.estaLLeno = false;
        this.estaVacio = true;
    }

    public synchronized char consumir() {
        while (estaVacio) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        char c = buffer.remove(buffer.size() - 1);
        estaLLeno = false;
        if (buffer.isEmpty()) {
            estaVacio = true;
        }
        notifyAll();

        return c;
    }

    public synchronized void producir(char producto) {
        while (estaLLeno) {
            try {
                System.out.println("Me fui a dormir alv");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        buffer.add(producto);
        estaVacio = false;
        if (buffer.size() == capacidad) {
            estaLLeno = true;
        }
        notifyAll();
    }

    public synchronized void imprimirBuffer() {
//        System.out.print("[ ");
        for (char c : buffer) {
            System.out.print(c + " ");
        }
        System.out.println("");
    }
}
