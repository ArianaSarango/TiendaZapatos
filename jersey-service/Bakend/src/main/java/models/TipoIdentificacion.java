package models;

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

    public static TipoIdentificacion fromString(String tipo) {
        for (TipoIdentificacion ti : TipoIdentificacion.values()) {
            if (ti.tipo.equalsIgnoreCase(tipo)) {
                return ti;
            }
        }
        throw new IllegalArgumentException("Tipo de identificación no válido: " + tipo);
    }
}
