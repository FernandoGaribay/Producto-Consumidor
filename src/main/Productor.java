package main;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private int pid;
    private EstadosConsumidor estado;
    private Buffer buffer;
    private List<Productos> productos;

    public Productor(int pid, Buffer buffer) {
        this.pid = pid;
        this.estado = EstadosConsumidor.DURMIENDO;
        this.buffer = buffer;
        this.productos = Arrays.asList(Productos.values());
    }

    @Override
    public void run() {
        while (true) {
            Productos producto = productos.get((int) (Math.random() * productos.size()));
            estado = buffer.dormirProductor();
            buffer.producir(producto, estado);

            System.out.println(" + Producido el producto: " + producto + " del buffer. ID: " + pid + " ESTADO: ");
//            buffer.imprimirBuffer();
            try {
                sleep(random(3, 1) * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public EstadosConsumidor getEstado() {
        return estado;
    }

    public void setEstado(EstadosConsumidor estado) {
        this.estado = estado;
    }

    private int random(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
}
