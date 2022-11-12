package model;

public class Usuario {

    // -----------------------
    // Atributos
    // -----------------------

    protected String username;
    protected String password;

    // -----------------------
    // Constructor
    // -----------------------

    public Usuario(String username, String password) {

        this.username = username;
        this.password = password;

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Obtener el atributo username
     */
    public String getUsername() {

        return this.username;

    }

    /*
     * Obtener el atributo password
     */
    public String getPassword() {

        return this.password;

    }

}
