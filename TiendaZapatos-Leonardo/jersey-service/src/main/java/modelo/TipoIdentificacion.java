package modelo;

public enum TipoIdentificacion {
    CEDULA("Cedula"), 
    PASAPORTE("Pasaporte"), 
    RUC("RUC");
    
    private String tipo;

    TipoIdentificacion(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
