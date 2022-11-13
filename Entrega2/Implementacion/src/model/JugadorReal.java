package model;

public class JugadorReal {

    // -----------------------
    // Atributos
    // -----------------------

    protected String nombre;
    protected String posicion;
    protected float precio;
    protected String equipo;

    // -----------------------
    // Constructor
    // -----------------------

    public JugadorReal(String nombre, String posicion, float precio, String equipo) {

        this.nombre = nombre;
        this.posicion = posicion;
        this.precio = precio;
        this.equipo = equipo;

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Obtener el atributo nombre
     */
    public String getNombre() {

        return nombre;

    }

    /*
     * Obtener el atributo posicion
     */
    public String getPosicion() {

        return posicion;

    }

    /*
     * Obtener el atributo precio
     */
    public float getPrecio() {

        return precio;

    }

    /*
     * Obtener el atributo equipo
     */
    public String getEquipo() {

        return equipo;

    }

}
