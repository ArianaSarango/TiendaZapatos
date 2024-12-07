package controlador.tda.List.stack;
import controlador.tda.List.LinkedList;
import controlador.tda.List.ListEmptyException;

public class Stack<E> extends LinkedList<E> {
    public void push(E element) {
        addHeader(element); 
    }

    public E pop() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, no puede eliminar datos de una lista vacia.");
        }
        
        E data = getFirst();
        removeFirst();
        return data;
    }


}
