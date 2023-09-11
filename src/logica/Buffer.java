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
    private List<BufferListener> listeners;
    private int numConsumidores;
    private int numProductores;
    private int capacidad;
    private boolean estaVacio;
    private boolean estaLLeno;

    // <editor-fold defaultstate="collapsed" desc="Constructor e Inicializadores">
    public Buffer(int capacidad, int numConsumidores, int numProductores) {
        initVariables(capacidad, numConsumidores, numProductores);
        initConsumidores(numConsumidores);
        initProductores(numProductores);
    }

    private void initVariables(int capacidad, int numConsumidores, int numProductores) {
        this.buffer = new ArrayList<>(capacidad);
        this.consumidores = new ArrayList<>();
        this.productores = new ArrayList<>();
        this.listeners = new ArrayList<>();
        this.numConsumidores = numConsumidores;
        this.numProductores = numProductores;
        this.capacidad = capacidad;
        this.estaLLeno = false;
        this.estaVacio = true;
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
        for (int i = 0; i < numProductores; i++) {
            productores.add(new Productor(i, this));
        }

        for (Productor productor : productores) {
            System.out.println("PRODUCTOR : " + productor.getPid());
        }
    }

    public void iniciar() {
        for (int i = 0; i < numConsumidores; i++) {
            consumidores.get(i).start();
        }

        for (int i = 0; i < numProductores; i++) {
            productores.get(i).start();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos BufferListener">
    public synchronized void addBufferListener(BufferListener listener) {
        listeners.add(listener);
    }

    public void notificarCambios() {
        for (BufferListener listener : listeners) {
            listener.bufferActualizado(buffer, consumidores, productores);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Consumir/Producir y Estados">
    public synchronized Productos consumir() {
        while (estaVacio) {
            try {
//                System.out.println("CONSUMIDOR DORMIDOOOOOO");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Productos p = buffer.remove(0);

        estaLLeno = false;
        if (buffer.isEmpty()) {
            estaVacio = true;
        }

        notifyAll();
        notificarCambios();
        return p;
    }

    public synchronized void producir(Productos producto, Estados estado) {
        while (estaLLeno) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (buffer.size() >= capacidad) {
            estaLLeno = true;
        } else{
            buffer.add(producto);
            estaVacio = false; 
        }

        notifyAll();
        notificarCambios();
    }

    public synchronized Estados dormirProductor() {
        if (estaLLeno) {
            return Estados.DURMIENDO;
        } else {
            return Estados.COCINANDO_1;
        }
    }

    public synchronized Estados dormirConsumidor() {
        if (estaVacio) {
            return Estados.DURMIENDO;
        } else {
            Productos p = consumir();
            Estados nuevoEstado = null;
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
                case PIZZA:
                    nuevoEstado = Estados.CM_PIZZA;
                    break;
            }
            return nuevoEstado;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Metodos Aumentar/Disminuir e Imprecion">
    public synchronized void imprimirBuffer() {
//        System.out.print("[ ");
        for (Productos c : buffer) {
            System.out.print(c + " ");
        }
        System.out.println("");
    }

    public void establecerCapacidadBuffer(int capacidad) {
        this.capacidad = capacidad;
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

    public void disminuirNumConsumidores() {
        consumidores.get(consumidores.size() - 1).stop();
        consumidores.remove(consumidores.size() - 1);

        this.numConsumidores--;
    }

    public void disminuirNumProductores() {
        productores.get(productores.size() - 1).stop();
        productores.remove(productores.size() - 1);

        this.numProductores--;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<Consumidor> getConsumidores() {
        return consumidores;
    }

    public int getNumConsumidores() {
        return consumidores.size();
    }

    public int getNumProductores() {
        return productores.size();
    }

    public void setTiempoMaxConsumidor(int tiempo) {
        Consumidor.setTiempoMax(tiempo);
    }

    public void setTiempoMinConsumidor(int tiempo) {
        Consumidor.setTiempoMin(tiempo);
    }

    public void setTiempoMaxProductor(int tiempo) {
        Productor.setTiempoMax(tiempo);
    }

    public void setTiempoMinProductor(int tiempo) {
        Productor.setTiempoMin(tiempo);
    }
    // </editor-fold>

}
