package logica;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.estados.Estados;
import logica.estados.Productos;

public class Consumidor extends Thread {

    private int cid;
    private Estados estado;
    private Buffer buffer;
    private static int tiempoMax = 5;
    private static int tiempoMin = 3;

    public Consumidor(int cid, Buffer buffer) {
        this.cid = cid;
        this.estado = Estados.DURMIENDO;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            estado = buffer.dormirConsumidor();
            Productos producto = obtenerProductoSegunEstado();

            System.out.println(" - Consumido el producto: " + producto + " del buffer. ID: " + cid + " ESTADO: " + estado);
            buffer.notificarCambios();
//            buffer.imprimirBuffer();
            try {
                sleep(random(tiempoMax, tiempoMin) * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Productos obtenerProductoSegunEstado() {
        switch (estado) {
            case CM_CHEETOS:
                return Productos.CHEETOS;
            case CM_FIDEOS:
                return Productos.FIDEOS;
            case CM_GALLETA:
                return Productos.GALLETA;
            case CM_SUSHI:
                return Productos.SUSHI;
            case CM_PIZZA:
                return Productos.PIZZA;

            default:
                return null;
        }
    }

    public int getCId() {
        return cid;
    }

    public void setId(int cid) {
        this.cid = cid;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
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

    private int random(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

}
