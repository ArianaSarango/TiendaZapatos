package controlador.tda.List;

public class ListEmptyException extends Exception {
    public ListEmptyException(){

    }
    public ListEmptyException(String msg){
        super(msg);
    }
}