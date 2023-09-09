package logica;

import java.util.List;
import logica.estados.Productos;

public interface BufferListener {

    void bufferActualizado(List<Productos> buffer, List<Consumidor> consumidores, List<Productor> productores);
}
