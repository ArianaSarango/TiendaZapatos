package controlador.tda.List;

public class Node <E>{
    private E info;
    private Node<E> next;

    //geters and seters
    public E getInfo() {
        return this.info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    //constructor
    public Node(E info){
        this.info = info;
        this.next = null;
    }

    public Node(E info, Node<E> next){
        this.info = info;
        this.next = next;
    }

}

