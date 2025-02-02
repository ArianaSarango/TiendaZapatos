package controller.Dao.servicies;

import controller.Dao.PedidoDao;
import controller.tda.list.LinkedList;
import models.Pedido;

public class PedidoServices {
    private PedidoDao obj;

    public PedidoServices() {
        obj = new PedidoDao();
    }

    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public Boolean delete(int id) throws Exception {
        return obj.delete(id);
    }

    public Boolean delete(Integer id) throws Exception {
        return obj.delete(id);
    }

    public LinkedList<Pedido> listAll() {
        return obj.getListAll();
    }

    public Pedido getPedido() {
        return obj.getPedido();
    }

    // public void setIdPedido(Pedido pedido) {
    //     obj.setIdPedido(pedido);
    // }

    public Pedido get(Integer id) throws Exception {
        return obj.get(id);
    }

    public void setPedido(Pedido pedido) {
        obj.setPedido(pedido);
    }
}
