package main;

import java.util.List;

public interface BufferListener {

    void bufferActualizado(List<Productos> buffer, List<Consumidor> consumidores, List<Productor> productores);
}
