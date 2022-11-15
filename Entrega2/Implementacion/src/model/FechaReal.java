package model;

import java.util.ArrayList;
import java.util.HashMap;

public class FechaReal {

    // -----------------------
    // Atributos
    // -----------------------
    private int numeroFecha;
    private ArrayList<PartidoReal> partidos;
    private HashMap<String, DesempenoJugadorReal> desempenoFechas;

    // -----------------------
    // Constructor
    // -----------------------

    public FechaReal(int numeroFecha) {

        this.numeroFecha = numeroFecha;
        partidos = new ArrayList<PartidoReal>();
        desempenoFechas = new HashMap<String, DesempenoJugadorReal>();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Agregar un desempeno de jugador en esa fecha
     */
    public void addDesempeno(String nombreJugador, DesempenoJugadorReal jugador) {
        desempenoFechas.put(nombreJugador, jugador);
    }

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

    public HashMap<String, DesempenoJugadorReal> getDesempenoFechas() {
        return desempenoFechas;
    }

}
