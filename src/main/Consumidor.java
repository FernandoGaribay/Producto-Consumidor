package main;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread {

    private int cid;
    private EstadosConsumidor estado;
    private Buffer buffer;

    public Consumidor(int cid, Buffer buffer) {
        this.cid = cid;
        this.estado = EstadosConsumidor.DURMIENDO;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            estado = buffer.consumir(estado); // Captura el nuevo estado
            Productos producto = obtenerProductoSegunEstado();

            System.out.println(" - Consumido el producto: " + producto + " del buffer. ID: " + cid + " ESTADO: " + estado);
//            buffer.imprimirBuffer();
            try {
                sleep(random(10, 9) * 1000);
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
            default:
                // En caso de un estado no reconocido, puedes devolver un valor por defecto o manejarlo de acuerdo a tus necesidades.
                return null;
        }
    }

    public int getCId() {
        return cid;
    }

    public void setId(int cid) {
        this.cid = cid;
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
