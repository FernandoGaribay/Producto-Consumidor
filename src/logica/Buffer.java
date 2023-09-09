package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.estados.Estados;
import logica.estados.Productos;

public class Buffer {

    private List<Productos> buffer;
    private List<Consumidor> consumidores;
    private List<Productor> productores;
    private int numConsumidores;
    private int numProductores;
    private int capacidad;
    private boolean estaVacio;
    private boolean estaLLeno;
    private List<BufferListener> listeners;

    public Buffer(int capacidad, int numConsumidores, int numProductores) {
        initVariables(capacidad, numConsumidores, numProductores);
        initConsumidores(numConsumidores);
        initProductores(numProductores);
    }

    private void initVariables(int capacidad, int numConsumidores, int numProductores) {
        this.buffer = new ArrayList<>(capacidad);
        this.consumidores = new ArrayList<>();
        this.productores = new ArrayList<>();
        this.numConsumidores = numConsumidores;
        this.numProductores = numProductores;
        this.capacidad = capacidad;
        this.estaLLeno = false;
        this.estaVacio = true;
        this.listeners = new ArrayList<>();
    }

    private void initConsumidores(int numConsumidores) {
        for (int i = 0; i < numConsumidores; i++) {
            consumidores.add(new Consumidor(i, this));
        }

        for (Consumidor consumidor : consumidores) {
            System.out.println("CONSUMIDOR : " + consumidor.getCId());
        }
    }

    private void initProductores(int numProductores) {
        System.out.println("NUMERO DE PRODUCTORES : " + numProductores);
        for (int i = 0; i < numProductores; i++) {
            productores.add(new Productor(i, this));
        }

        for (Productor productor : productores) {
            System.out.println("PRODUCTOR : " + productor.getPid());
        }
    }

    public synchronized void addBufferListener(BufferListener listener) {
        listeners.add(listener);
    }

    private void notificarCambios() {
        for (BufferListener listener : listeners) {
            listener.bufferActualizado(buffer, consumidores, productores);
        }
    }

    public synchronized Estados consumir(Estados estado) {
        while (estaVacio) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Productos p = buffer.remove(0);
        estado = actualizarEstado(p, estado);

        estaLLeno = false;
        if (buffer.isEmpty()) {
            estaVacio = true;
        }

        notifyAll();
        notificarCambios();
        return estado;
    }

    public synchronized void producir(Productos producto, Estados estado) {
        while (estaLLeno) {
            try {
                notificarCambios();
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

        notificarCambios();
        notifyAll();
    }

    public synchronized Estados dormirProductor() {
        if (estaLLeno) {
            return Estados.DURMIENDO;
        } else {
            return Estados.COCINANDO_1;
        }
    }

    private Estados actualizarEstado(Productos p, Estados estado) {
        Estados nuevoEstado = estado;

        switch (p) {
            case CHEETOS:
                nuevoEstado = Estados.CM_CHEETOS;
                break;
            case FIDEOS:
                nuevoEstado = Estados.CM_FIDEOS;
                break;
            case GALLETA:
                nuevoEstado = Estados.CM_GALLETA;
                break;
            case SUSHI:
                nuevoEstado = Estados.CM_SUSHI;
                break;
        }

        return nuevoEstado;
    }

    public synchronized void imprimirBuffer() {
//        System.out.print("[ ");
        for (Productos c : buffer) {
            System.out.print(c + " ");
        }
        System.out.println("");
    }

    public void iniciar() {
        for (int i = 0; i < numConsumidores; i++) {
            consumidores.get(i).start();
        }

        for (int i = 0; i < numProductores; i++) {
            productores.get(i).start();
        }
    }

    public void aumentarNumConsumidores() {
        consumidores.add(new Consumidor(numConsumidores, this));
        consumidores.get(consumidores.size() - 1).start();

        this.numConsumidores++;
    }

    public void aumentarNumProductores() {
        productores.add(new Productor(numProductores, this));
        productores.get(productores.size() - 1).start();

        this.numProductores++;
    }

    public int getNumConsumidores() {
        return consumidores.size();
    }

    public int getNumProductores() {
        return productores.size();
    }
}
