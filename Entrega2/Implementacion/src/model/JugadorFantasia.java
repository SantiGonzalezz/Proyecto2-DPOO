package model;

import java.util.HashMap;

public class JugadorFantasia extends JugadorReal {

    // -----------------------
    // Atributos
    // -----------------------

    // nombre: String
    // posicion: String
    // precio: float
    // equipo: String
    int puntos;

    // -----------------------
    // Constructor
    // -----------------------

    public JugadorFantasia(String nombre, String posicion, float precio, String equipo) {

        super(nombre, posicion, precio, equipo);

    }

    // -----------------------
    // Metodos
    // -----------------------

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos() {

    }

}
