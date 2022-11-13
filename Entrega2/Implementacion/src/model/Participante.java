package model;

import java.util.ArrayList;

public class Participante extends Usuario {

    // -----------------------
    // Atributos
    // -----------------------

    // username: String
    // password: String
    private EquipoFantasia equipoFantasiaActual;
    private ArrayList<EquipoFantasia> equipoFantasiaHistorico;
    private float presupuesto;

    // -----------------------
    // Constructor
    // -----------------------

    public Participante(String username, String password) {

        super(username, password);
        presupuesto = TemporadaReal.getPresupuestoBase();

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
     * Crear un nuevo equipoFantasia
     */
    public void nuevoEquipoFantasia(String nombreEquipo) {

        equipoFantasiaActual = new EquipoFantasia(username, nombreEquipo, presupuesto);

    }

    /*
     * Comprar Jugador
     */
    public void comprarJugador(JugadorReal jugador) {

    }

}
