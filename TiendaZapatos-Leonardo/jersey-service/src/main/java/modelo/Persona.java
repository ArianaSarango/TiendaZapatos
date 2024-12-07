package modelo;

public class Persona {
    private int idPersona;
    private String nombre;
    private String apellido;
    private TipoIdentificacion tipoIdentificacion;
    private String numeroIdentificacion;
    private String direccion;
    private String telefono;

    public int getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }
    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // constructor
    /*
    public Factura( int idFactura, int numeroFactura, Date fechaEmision, Double subtotal, float IVA, float descuento, Double totalFactura, EstadoPago estadoPago){
        this.idFactura = idFactura;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.subtotal = subtotal;
        this.IVA = IVA;
        this.descuento = descuento;
        this.totalFactura = totalFactura;
        this.estadoPago = estadoPago;
    }
    */

    // getters y setters
    
    


}
