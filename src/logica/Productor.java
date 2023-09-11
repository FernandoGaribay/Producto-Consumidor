package logica;

import logica.estados.Productos;
import logica.estados.Estados;
import logica.Buffer;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread {

    private int pid;
    private Estados estado;
    private Buffer buffer;
    private List<Productos> productos;
    private static int tiempoMax = 5;
    private static int tiempoMin = 3;

    public Productor(int pid, Buffer buffer) {
        this.pid = pid;
        this.estado = Estados.DURMIENDO;
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
            buffer.notificarCambios();
//            buffer.imprimirBuffer();
            try {
                sleep(random(tiempoMax, tiempoMin) * 1000);
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

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    private int random(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }
    
    public static int getTiempoMax() {
        return tiempoMax;
    }

    public static void setTiempoMax(int aTiempoMax) {
        tiempoMax = aTiempoMax;
    }

    public static int getTiempoMin() {
        return tiempoMin;
    }

    public static void setTiempoMin(int aTiempoMin) {
        tiempoMin = aTiempoMin;
    }
}
