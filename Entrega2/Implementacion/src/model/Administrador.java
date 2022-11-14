package model;

public class Administrador extends Usuario {

    // -----------------------
    // Atributos
    // -----------------------

    // username: String
    // password: String

    // -----------------------
    // Constructor
    // -----------------------

    public Administrador(String username, String password) {

        super(username, password);

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Obtener el atributo username
     */
    // getUsername()

    /*
     * Obtener el atributo password
     */
    // getPassword()

    /*
     * Configurar el presupuesto base para la creacion de la temporada
     */
    public void setPresupuestoBase(float presupuestoBase) {

        TemporadaReal.setPresupuestoBase(presupuestoBase);

    }

}
