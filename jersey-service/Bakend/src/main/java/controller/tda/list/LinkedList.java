package controller.tda.list;

<<<<<<< HEAD
import controller.tda.list.Node;
import models.Kardex;
import models.Pedido;
import models.Producto;
import controller.tda.list.ListEmptyException;

import java.lang.reflect.Method;

import controller.tda.list.LinkedList;
=======
import controller.tda.list.LinkedList;
import models.Factura;

import java.lang.reflect.Method;

>>>>>>> origin/Juan

public class LinkedList<E> {
    private Node<E> header; // Nodo cabecera (el primer nodo de la lista)
    private Node<E> last; // Nodo último (el último nodo de la lista)
    private Integer size; // Tamaño de la lista (cuenta el número de nodos en la lista)
<<<<<<< HEAD
=======
    public static Integer ASC = 1;
    public static Integer DESC = 0;

    public LinkedList<E> clonar() {
        LinkedList<E> nuevaLista = new LinkedList<>();
        Node<E> actual = this.header; // Suponiendo que tienes un nodo cabeza en tu LinkedList
        while (actual != null) {
            nuevaLista.add(actual.getInfo()); // Asumiendo que `add` agrega un elemento a la lista
            actual = actual.getNext(); // Asumiendo que `getSiguiente` da acceso al siguiente nodo
        }
        return nuevaLista;
    }
>>>>>>> origin/Juan

    // Constructor de la clase LinkedList
    public LinkedList() {
        this.header = null; // Inicialmente, la cabecera es nula (no hay nodos en la lista)
        this.last = null; // Inicialmente, el último nodo es nulo
        this.size = 0; // Inicialmente, el tamaño de la lista es 0
    }

    // Método para verificar si la lista está vacía
    public Boolean isEmpty() {
        // Retorna verdadero si la cabecera es nula o el tamaño es 0, es decir, si la
        // lista está vacía
<<<<<<< HEAD
        
=======
>>>>>>> origin/Juan
        return (this.header == null || this.size == 0);
    }

    // Método privado para agregar un elemento al principio de la lista
<<<<<<< HEAD
    protected void addHeader(E dato) { 
        Node<E> help; // Nodo de ayuda para insertar el nuevo dato

        // Si la lista está vacía
=======
    protected void addHeader(E dato) {
        Node<E> help; // Nodo de ayuda para insertar el nuevo dato
>>>>>>> origin/Juan
        if (isEmpty()) {
            help = new Node<>(dato); // Crea un nuevo nodo con el dato
            this.header = help; // El nuevo nodo se convierte en el nodo cabecera
            this.last = help; // Al ser el primero tambien es el ultimo
        } else {
            // Si la lista no está vacía
            Node<E> healpHeader = this.header; // Guarda el nodo cabecera actual en una variable auxiliar
            help = new Node<>(dato, healpHeader); // Crea un nuevo nodo que apunta al nodo cabecera actual
            this.header = help; // El nuevo nodo se convierte en la nueva cabecera
        }
        this.size++; // Incrementa el tamaño de la lista
    }

<<<<<<< HEAD
    private void addLast(E info) {
        Node<E> help; // Nodo para ayudar a agregar el nuevo elemento
        if (isEmpty()) { // Verificar si la lista está vacía
            help = new Node<>(info); // Crear un nuevo nodo
            this.header = help; // Establecer el nuevo nodo como cabecera
            this.last = help; // Establecer el nuevo nodo como último
=======
    public void addLast(E info) {
        Node<E> help; // Nodo para ayudar a agregar el nuevo elemento
        if (isEmpty()) { // Verificar si la lista está vacía
            addHeader(info); // Crear un nuevo nodo
>>>>>>> origin/Juan
        } else {
            help = new Node<>(info, null); // Crear un nuevo nodo
            last.setNext(help); // Conectar el último nodo al nuevo nodo
            last = help; // Actualizar 'last' al nuevo nodo
<<<<<<< HEAD
        }
        this.size++; // Incrementar el tamaño de la lista
=======
            this.size++; // Incrementar el tamaño de la lista
        }
>>>>>>> origin/Juan
    }

    public void add(E info) {
        addLast(info);
    }

    private Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, List empty");
        } else if (index.intValue() < 0 || index.intValue() >= this.size) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
<<<<<<< HEAD
=======
        } else if (index.intValue() == 0) {
            return header;
>>>>>>> origin/Juan
        } else if (index.intValue() == (this.size - 1)) {
            return last;
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    public E getFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, lista vacia");
        }
        return header.getInfo();
    }

    public E getLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista Vacia");
        }
        return last.getInfo();
    }

    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, list empty");
        } else if (index.intValue() < 0 || index.intValue() >= this.size.intValue()) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0) {
            return header.getInfo();
        } else if (index.intValue() == (this.size - 1)) {
            return last.getInfo();
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search.getInfo();
        }
    }

    public void add(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty() || index.intValue() == 0) {
            addHeader(info);
        } else if (index.intValue() == this.size.intValue()) {
            addLast(info);
        } else {
            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            this.size++;
        }
    }

<<<<<<< HEAD
    public void update(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista está vacía");
        }
        
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Índice fuera de límites");
        }
    
        // Obtener el nodo en la posición dada
        Node<E> help = getNode(index);
        help.setInfo(info); // Suponiendo que tienes un método setInfo en tu clase Node
    }
    

=======
>>>>>>> origin/Juan
    /*** END BYPOSITION */
    public void reset() {
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        StringBuilder sb = new StringBuilder("List data");
=======
        StringBuilder sb = new StringBuilder("List data \n");
>>>>>>> origin/Juan
        try {
            Node<E> help = header;
            while (help != null) {
                sb.append(help.getInfo()).append(" ->");
                help = help.getNext();
            }
        } catch (Exception e) {
            sb.append(e.getMessage());
        }
        return sb.toString();
    }

    public Integer getSize() {
        return this.size;
    }

    public Node<E> getHeader() {
        return header; // Devuelve el nodo cabecera
    }

    // esta bien
    public E[] toArray() {
        E[] matrix = null;
        if (!isEmpty()) {
            Class clazz = header.getInfo().getClass();
            matrix = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            Node<E> aux = header;
            for (int i = 0; i < this.size; i++) {
                matrix[i] = aux.getInfo();
                aux = aux.getNext();
            }

        }
        return matrix;
    }

<<<<<<< HEAD
    public LinkedList<E> toList(E[] matrix) { //Recibe un array de objetos
        reset(); //Reinicia la lista
        for (int i = 0; i < matrix.length; i++) { //Recorre el array
            this.add(matrix[i]); //Agrega cada objeto del array a un nodo de la lista
        }
        return this; //Devuelve la instancia LinkedList
    }

=======
    public LinkedList<E> toList(E[] matrix) { // Recibe un array de objetos
        reset(); // Reinicia la lista
        for (int i = 0; i < matrix.length; i++) { // Recorre el array
            this.add(matrix[i]); // Agrega cada objeto del array a un nodo de la lista
        }
        return this; // Devuelve la instancia LinkedList
    }

    public void update(E data, Integer post) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error la lista esta vacia");
        } else if (post < 0 || post >= size) {
            throw new IndexOutOfBoundsException("Error, esta fuera de los limites de la lista");
        } else if (post == 0) {
            header.setInfo(data);
        } else if (post == (size - 1)) {
            last.setInfo(data);
        } else {
            Node<E> search = header;
            Integer cont = 0;
            while (cont < post) {
                cont++;
                search = search.getNext();
            }
            search.setInfo(data);
        }
    }
>>>>>>> origin/Juan
    // REMOVE AGREGADO 24/OCT/2024

    public int getLength() {
        return this.size.intValue();
    }

<<<<<<< HEAD
    protected void removeLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, no puede eliminar datos de una lista vacia.");
        } else {
            Node<E> nodo_last = getNode((getLength() - 2));
            nodo_last.setNext(null);
            this.last = nodo_last;
            this.size--;
        }
    }

    public void removeFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, no puede eliminar datos de una lista vacia.");
        } else {
            Node<E> help = this.header;
            Node<E> nextHeader = help.getNext();
            this.header = nextHeader;
            this.size--;
        }
    }

    // public void remove(Producto producto) throws ListEmptyException, IndexOutOfBoundsException {
    //     if (isEmpty()) {
    //         throw new ListEmptyException("Lista vacia, no puede eliminar elementos");
    //     } else if (producto < 0 || producto >= this.size) {
    //         throw new IndexOutOfBoundsException("Índice fuera de límites: " + producto);
    //     } else if (producto == 0) {
    //         removeFirst();
    //     } else if (producto == (this.size - 1)) {
    //         removeLast();
    //     } else{
    //             Node <E> nodoDeath = getNode(producto);
    //             Node <E> previousNode = getNode(producto - 1);
    //             previousNode.setNext(nodoDeath.getNext());
    //             this.size --;
    //     }

        
    // }

    public void remove(int index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Lista vacia, no puede eliminar elementos");
        } else if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Índice fuera de límites: " + index);
        } else if (index == 0) {
            removeFirst();
        } else if (index == (this.size - 1)) {
            removeLast();
        } else{
                Node <E> nodoDeath = getNode(index);
                Node <E> previousNode = getNode(index - 1);
                previousNode.setNext(nodoDeath.getNext());
                this.size --;
        }

        
    }


    //metodo calse 09 nov
    public LinkedList<E> order() throws Exception{
        if (!isEmpty()){
            E data = this.header.getInfo();
            if (data instanceof Number || data instanceof Boolean || data instanceof String){
                E [] lista = this.toArray();
                reset();
                for(int i = 1; i < lista.length; i++){
                    E aux = lista[i];
                    int j = i- 1;
                    while (j >= 0 && compare(lista[j], aux)){
                        lista[j + 1] = lista[j--];
                    }
                    lista[j + 1] = aux;
                }
                this.toList(lista);
            } else {
                System.out.println("Objeto");
            }
        }
        return this;

    }

    private Boolean compare(E a, E b){
        if (a instanceof Number) {
            Number a1 = (Number) a;
            Number b1 = (Number) b;
            return a1.doubleValue() > b1.doubleValue();
        }
        else {
            return a.toString().compareTo(b.toString()) > 0;
        }
    
    }

    //Metodo kicksort 
    //en espera y correciones......
    public void quicksort() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista está vacía.");
        }
        quicksort(0, size - 1); // Llama a la versión recursiva
    }
    
    private void quicksort(int low, int high) throws ListEmptyException {
        if (low < high) { // Caso base: sublista con al menos dos elementos
            int pivotIndex = partition(low, high); // Realiza la partición
            quicksort(low, pivotIndex - 1); // Ordena la sublista izquierda
            quicksort(pivotIndex + 1, high); // Ordena la sublista derecha
        }
    }
    
    private int partition(int low, int high) throws ListEmptyException {
        E pivot = get(high); // Escoge el último elemento como pivote
        int i = low - 1; // Índice para elementos menores al pivote
    
        for (int j = low; j < high; j++) {
            if (compare(get(j), pivot)) { // Si `get(j)` es menor o igual al pivote
                i++; // Incrementa el índice de los menores
                swap(i, j); // Intercambia los nodos en posiciones `i` y `j`
            }
        }
        swap(i + 1, high); // Coloca el pivote en su posición correcta
        return i + 1; // Retorna el índice del pivote
    }
    
    private void swap(int i, int j) throws ListEmptyException {
        if (i == j) return; // No hay necesidad de intercambiar si los índices son iguales
        E temp = get(i); // Almacena temporalmente el valor en la posición `i`
        update(get(j), i); // Asigna el valor de la posición `j` a la posición `i`
        update(temp, j); // Asigna el valor temporal a la posición `j`
    }


    //Metodo en ejecucion ordenamiento
    // private Object exist_attribut(E a, String atributo) throws Exception {
    //     Method methot = null;

    // }
}
=======
    public E removeFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, lista vacia");
        } else {
            E element = header.getInfo();
            Node<E> help = header.getNext();
            header = help;
            if (size.intValue() == 1) {
                last = null;
            }
            size--;
            return element;
        }
    }

    public E removeLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, lista vacia");
        } else {
            E element = last.getInfo();
            Node<E> help = getNode(size - 2);
            if (help == null) {
                last = null;
                if (size == 2) {
                    last = header;
                } else {
                    header = null;
                }
            } else {
                last = null;
                last = help;
                last.setNext(null);
            }
            size--;
            return element;
        }
    }

    public E remove(int index) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, lista vacia");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == (size - 1)) {
            return removeLast();
        } else {
            Node<E> preview = getNode(index - 1);
            Node<E> actually = getNode(index);
            E element = preview.getInfo();
            Node<E> next = actually.getNext();
            actually = null;
            preview.setNext(next);
            size--;
            return element;

        }
    }

    public LinkedList<E> order(Integer type) throws Exception {
        if (!isEmpty()) {
            E data = this.header.getInfo();
            if (data instanceof Number || data instanceof String) {
                E[] lista = this.toArray();
                reset();
                for (int i = 1; i < lista.length; i++) {
                    E aux = lista[i]; // valor a ordenar
                    int j = i - 1; // índice anterior
                    while (j >= 0 && compare(lista[j], aux, type)) {
                        lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                    }
                    lista[j + 1] = aux; // inserta el valor en su posición correcta
                }
                this.toList(lista);
            }
        }
        return this;
    }

    public LinkedList<E> order(String att, Integer type) throws Exception {
        if (!isEmpty()) {
            E data = this.header.getInfo();
            if (data instanceof Object) {
                E[] lista = this.toArray();
                reset();
                for (int i = 1; i < lista.length; i++) {
                    E aux = lista[i]; // valor a ordenar
                    int j = i - 1; // índice anterior
                    while (j >= 0 && atrribute_compare(att, lista[j], aux, type)) {
                        lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                    }
                    lista[j + 1] = aux; // inserta el valor en su posición correcta
                }
                this.toList(lista);
            }
        }
        return this;
    }

    private Boolean compare(Object a, Object b, Integer type) {
        switch (type) {
            case 0:
                if (a instanceof Number) {
                    Number a1 = (Number) a;
                    Number b1 = (Number) b;
                    return a1.doubleValue() > b1.doubleValue();
                } else {
                    // "casa" > "pedro"
                    return (a.toString()).compareTo(b.toString()) > 0;
                }
                // break;

            default:
                // mayor a menor
                if (a instanceof Number) {
                    Number a1 = (Number) a;
                    Number b1 = (Number) b;
                    return a1.doubleValue() < b1.doubleValue();
                } else {
                    // "casa" > "pedro"
                    return (a.toString()).compareTo(b.toString()) < 0;
                }
                // break;
        }

    }

    // compare class
    private Boolean atrribute_compare(String att, E a, E b, Integer type) throws Exception {
        return compare(exist_att(a, att), exist_att(b, att), type);
    }

    private Object exist_att(E a, String att) throws Exception {
        Method method = null;
        att = att.substring(0, 1).toUpperCase() + att.substring(1);
        att = "get" + att;
        for (Method aux : a.getClass().getMethods()) {
            if (aux.getName().contains(att)) {
                method = aux;
                break;
            }
        }
        if (method == null) {
            for (Method aux : a.getClass().getSuperclass().getMethods()) {
                if (aux.getName().contains(att)) {
                    method = aux;
                    break;
                }
            }
        }
        if (method != null) {
            return method.invoke(a);
        }

        return null;
    }
}
>>>>>>> origin/Juan
