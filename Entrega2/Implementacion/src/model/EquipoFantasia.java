package model;

import java.util.ArrayList;
import java.util.HashMap;

public class EquipoFantasia {

    // -----------------------
    // Atributos
    // -----------------------
    private String participante;
    private String nombre;
    private int puntos;
    private float presupuesto;
    private HashMap<String, Integer> numeroPosicion;
    private int numeroJugadores;
    private ArrayList<JugadorFantasia> jugadoresLista;
    private HashMap<String, JugadorFantasia> jugadoresHash;

    private HashMap<String, JugadorFantasia> porteros;
    private HashMap<String, JugadorFantasia> defensas;
    private HashMap<String, JugadorFantasia> mediocampistas;
    private HashMap<String, JugadorFantasia> delanteros;
    private Alineacion alineacion;

    // -----------------------
    // Constructor
    // -----------------------

    public EquipoFantasia(String participante, String nombre, float presupuesto) {

        this.participante = participante;
        this.nombre = nombre;
        this.presupuesto = presupuesto;

        numeroJugadores = 15;

        numeroPosicion = new HashMap<String, Integer>();
        numeroPosicion.put("portero", 2);
        numeroPosicion.put("defensa", 5);
        numeroPosicion.put("mediocampista", 5);
        numeroPosicion.put("delantero", 3);

        jugadoresLista = new ArrayList<JugadorFantasia>();
        jugadoresHash = new HashMap<String, JugadorFantasia>();

        porteros = new HashMap<String, JugadorFantasia>();
        defensas = new HashMap<String, JugadorFantasia>();
        mediocampistas = new HashMap<String, JugadorFantasia>();
        delanteros = new HashMap<String, JugadorFantasia>();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Comprar Jugador
     */
    public boolean comprarJugador(JugadorReal jugadorReal) {

        JugadorFantasia jugador = new JugadorFantasia(jugadorReal.getNombre(), jugadorReal.getPosicion(),
                jugadorReal.getPrecio(), jugadorReal.getEquipo());

        if (!jugadoresHash.containsKey(jugador.getNombre())) {

            // Hay cupo disponible en la plantilla
            // Osea es menor a 15
            if (jugadoresLista.size() < numeroJugadores) {

                String posicion = jugador.getPosicion();

                // Revisar si hay cupo en la posicion
                if (posicion.equals("portero")) {

                    if (porteros.size() < numeroPosicion.get("portero")) {

                        // Anadir a la posicion y la lista general
                        jugadoresLista.add(jugador);
                        jugadoresHash.put(jugador.getNombre(), jugador);
                        porteros.put(jugador.getNombre(), jugador);

                        return true;

                    } else {

                        return false;

                    }

                } else if (posicion.equals("defensa")) {

                    if (defensas.size() < numeroPosicion.get("defensa")) {

                        jugadoresLista.add(jugador);
                        jugadoresHash.put(jugador.getNombre(), jugador);
                        defensas.put(jugador.getNombre(), jugador);

                        return true;

                    } else {
                        return false;
                    }

                } else if (posicion.equals("mediocampista")) {

                    if (mediocampistas.size() < numeroPosicion.get("mediocampista")) {

                        jugadoresLista.add(jugador);
                        jugadoresHash.put(jugador.getNombre(), jugador);

                        mediocampistas.put(jugador.getNombre(), jugador);

                        return true;

                    } else {
                        return false;
                    }

                } else if (posicion.equals("delantero")) {

                    if (delanteros.size() < numeroPosicion.get("delantero")) {

                        jugadoresLista.add(jugador);
                        jugadoresHash.put(jugador.getNombre(), jugador);

                        delanteros.put(jugador.getNombre(), jugador);

                        return true;

                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /*
     * Vender Jugador
     */
    public boolean venderJugador(JugadorReal jugadorReal) {

        if (jugadoresHash.containsKey(jugadorReal.getNombre())) {

            JugadorFantasia jugador = jugadoresHash.get(jugadorReal.getNombre());
            String posicion = jugador.getPosicion();

            if (posicion.equals("portero")) {

                if (porteros.size() < numeroPosicion.get("portero")) {

                    // Anadir a la posicion y la lista general
                    jugadoresLista.add(jugador);
                    jugadoresHash.put(jugador.getNombre(), jugador);
                    porteros.put(jugador.getNombre(), jugador);

                    return true;

                } else {

                    return false;

                }

            } else if (posicion.equals("defensa")) {

                if (defensas.size() < numeroPosicion.get("defensa")) {

                    jugadoresLista.add(jugador);
                    jugadoresHash.put(jugador.getNombre(), jugador);
                    defensas.put(jugador.getNombre(), jugador);

                    return true;

                } else {
                    return false;
                }

            } else if (posicion.equals("mediocampista")) {

                if (mediocampistas.size() < numeroPosicion.get("mediocampista")) {

                    jugadoresLista.add(jugador);
                    jugadoresHash.put(jugador.getNombre(), jugador);

                    mediocampistas.put(jugador.getNombre(), jugador);

                    return true;

                } else {
                    return false;
                }

            } else if (posicion.equals("delantero")) {

                if (delanteros.size() < numeroPosicion.get("delantero")) {

                    jugadoresLista.add(jugador);
                    jugadoresHash.put(jugador.getNombre(), jugador);

                    delanteros.put(jugador.getNombre(), jugador);

                    return true;

                } else {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }
    }

    /*
     * Vender un jugador
     */
    public boolean venderJugador1(JugadorReal jugador) {

        // Hay al menos un jugador
        if (jugadoresLista.size() == 0) {

            return false;

        } else {

            // Jugador existe en la plantilla
            if (jugadoresHash.containsKey(jugador.getPosicion())) {

                // Actualizar presupuesto
                presupuesto += jugador.getPrecio() * 0.97;

                jugadoresLista.remove(jugador);
                jugadoresHash.remove(jugador.getNombre());

                return true;

            } else {

                return false;

            }

        }

    }

    /*
     * Cumple condiciones
     */
    public boolean checkCondicionesEquipo() {

        boolean valido1 = checkNumeroJugadores();
        boolean valido2 = checkNumeroPosicion("portero");
        boolean valido3 = checkNumeroPosicion("defensa");
        boolean valido4 = checkNumeroPosicion("mediocampista");
        boolean valido5 = checkNumeroPosicion("delantero");

        if (valido1 && valido2 && valido3 && valido4 && valido5) {

            return true;

        } else {

            return false;

        }

    }

    /*
     * Revisa si hay 15 jugadores
     */
    public boolean checkNumeroJugadores() {

        if (jugadoresLista.size() == numeroJugadores) {

            return true;

        } else {

            return false;

        }

    }

    /*
     * Revisa si hay n jugadores en x posicion
     * Parametros: String posicion, int numeroPosicion
     * Retorno: boolean - true exito, false fracaso
     */
    public boolean checkNumeroPosicion(String posicion) {

        int numPosicionMust = numeroPosicion.get(posicion);

        int numPosicion = 0;
        for (JugadorReal jugador : jugadoresLista) {

            if (jugador.getPosicion().equals(posicion)) {

                numPosicion += 1;

            }

        }

        if (numPosicion == numPosicionMust) {

            return true;

        } else {

            return false;

        }

    }

    /*
     * Devuelve el atributo nombre
     */
    public String getNombre() {

        return nombre;

    }

    /*
     * Devuelve el atributo puntos
     */
    public int getPuntos() {

        return puntos;

    }

    /*
     * Devuelve el atributo presupuesto
     */
    public float getPresupuestoBase() {

        return presupuesto;

    }

    /*
     * Devuelve el atributo jugadoresLista
     */
    public ArrayList<JugadorFantasia> getJugadoresLista() {

        return jugadoresLista;

    }

    /*
     * Devuelve el atributo jugadoresHash
     */
    public HashMap<String, JugadorFantasia> getJugadoresHash() {
        return jugadoresHash;
    }

    /*
     * Devuelve el atributo participante
     */
    public String getParticipante() {
        return participante;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public HashMap<String, Integer> getNumeroPosicion() {
        return numeroPosicion;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public HashMap<String, JugadorFantasia> getPorteros() {
        return porteros;
    }

    public HashMap<String, JugadorFantasia> getDefensas() {
        return defensas;
    }

    public HashMap<String, JugadorFantasia> getMediocampistas() {
        return mediocampistas;
    }

    public HashMap<String, JugadorFantasia> getDelanteros() {
        return delanteros;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

}
