package controller.Dao;

import models.Pedido;
import models.Pedido;
import controller.Dao.implement.AdapterDao;
import controller.tda.list.LinkedList;

public class PedidoDao extends AdapterDao<Pedido> {
    private Pedido pedido = new Pedido();
    private LinkedList<Pedido> listAll;

    public PedidoDao() {
        super(Pedido.class);
        this.listAll = new LinkedList<>();
    }

    // public void setIdPedido(Pedido pedido) {
    //     int id = 1;
    //     for (Pedido p : getListAll()) {
    //         if (p.getId() >= id) {
    //             id = p.getId() + 1;
    //         }
    //     }
    //     pedido.setId(id);
    // }

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

     public Boolean delete(int idPedido) throws Exception {
        LinkedList<Pedido> pedidos = listAll(); // Obtener todas las pedidos
    
        // Buscar el índice de la pedido con el ID dado
        int indexToRemove = -1;
        for (int i = 0; i < pedidos.getSize(); i++) {
            if (pedidos.get(i).getId() == idPedido) {
                indexToRemove = i;
                break;
            }
        }
    
        if (indexToRemove != -1) {
            // Si se encuentra el índice, eliminar la pedido
            supreme(indexToRemove);
            return true;
        } else {
            // Si no se encuentra, lanzar una excepción
            throw new Exception("Pedido con ID " + idPedido + " no encontrada");
        }
    }

    public Boolean delete(Integer id) throws Exception {
        LinkedList<Pedido> list = getListAll();
        Pedido pedido = get(id);
        if (pedido != null) {
            list.remove(0);
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