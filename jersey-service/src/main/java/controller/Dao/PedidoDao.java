package controller.Dao;

import models.Pedido;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class PedidoDao extends AdapterDao<Pedido> {
    private Pedido pedido;
    private LinkedList<Pedido> listAll;

    public PedidoDao() {
        super(Pedido.class);
        this.listAll = new LinkedList<>();
    }

    public void setIdPedido(Pedido pedido) {
        // Lógica para establecer el ID
    }

    public Pedido getPedido() {
        if (pedido == null) {
            pedido = new Pedido();
        }
        return this.pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LinkedList<Pedido> getListAll() {
        if (listAll.isEmpty()) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        pedido.setId(id);
        this.persist(this.pedido);
        this.listAll = getListAll();
        return true;
    }

    public Boolean update() throws Exception {
        try {
            this.merge(getPedido(), getPedido().getId() - 1);
            this.listAll = getListAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Pedido> list = getListAll();
        Pedido pedido = get(id);
        if (pedido != null) {
            list.remove(pedido);
            String info = g.toJson(list.toArray());
            saveFile(info);
            this.listAll = list;
            return true;
        } else {
            System.out.println("Pedido con id " + id + " no encontrado.");
            return false;
        }
    }
}
