package model;

import java.util.ArrayList;

public class FechaReal {

    // -----------------------
    // Atributos
    // -----------------------
    private int numeroFecha;
    private ArrayList<PartidoReal> partidos;

    // -----------------------
    // Constructor
    // -----------------------

    public FechaReal(int numeroFecha) {

        this.numeroFecha = numeroFecha;
        partidos = new ArrayList<PartidoReal>();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Agrega un partido a los partidos de la fecha
     * Parametros: PartidoReal - partido a agregar
     * Retorno: void
     */
    public void addPartido(PartidoReal partido) {

        partidos.add(partido);

    }

    /*
     * Devuelve el atributo fecha
     */
    public int getNumeroFecha() {

        return numeroFecha;

    }

    /*
     * Devuelve el atributo partidos
     */
    public ArrayList<PartidoReal> getPartidos() {

        return partidos;

    }

}
