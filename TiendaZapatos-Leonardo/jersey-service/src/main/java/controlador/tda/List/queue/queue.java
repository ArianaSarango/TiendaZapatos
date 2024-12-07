package controlador.tda.List.queue;
import controlador.tda.List.LinkedList;
import controlador.tda.List.ListEmptyException;

public class queue<E> extends LinkedList<E> {
   
    public void enqueue(E element) {
        add(element);  
    }

    public E dequeue() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, no puede eliminar datos de una lista vacia.");
        }
        
        E data = getFirst();
        removeFirst();
        return data;
    }
    
}
