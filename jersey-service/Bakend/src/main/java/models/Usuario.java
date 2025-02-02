package models;

public class Usuario {
    private int idUser;
    private String user;
    private String password;
    private String email;
    private Boolean estado;
    private Persona persona;

    // Constructor sin parámetros
    public Usuario() {
    }

    public Usuario(int idUser, String user, String password, String email, Boolean estado, Persona persona) {
        this.idUser = idUser;
        this.user = user;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.persona = persona;
    }

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
