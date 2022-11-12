package model;

public class JugadorReal {

    // -----------------------
    // Atributos
    // -----------------------

    private String nombre;
    private String posicion;
    private float precio;

    // -----------------------
    // Constructor
    // -----------------------

    public JugadorReal(String nombre, String posicion, float precio) {

        this.nombre = nombre;
        this.posicion = posicion;
        this.precio = precio;

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

}
