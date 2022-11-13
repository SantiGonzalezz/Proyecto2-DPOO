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
    private Alineacion alineacion;

    // -----------------------
    // Constructor
    // -----------------------

    public EquipoFantasia(String participante, String nombre, float presupuesto) {

        numeroJugadores = 15;

        numeroPosicion = new HashMap<>();
        numeroPosicion.put("portero", 2);
        numeroPosicion.put("defensa", 5);
        numeroPosicion.put("mediocampista", 5);
        numeroPosicion.put("delantero", 3);

        this.participante = participante;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        jugadoresLista = new ArrayList<JugadorFantasia>();
        jugadoresHash = new HashMap<String, JugadorFantasia>();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Comprar jugador
     */
    public boolean comprarJugador(JugadorFantasia jugador) {

        // Revisar si hay cupos disponibles en la plantilla
        if (checkCondicionesEquipo()) {

            return false;

        } else {

            // Revisar si hay cupos disponibles en la posicion
            String posicion = jugador.getPosicion();
            if (checkNumeroPosicion(posicion)) {

                return false;

            } else {

                // Revisar si ya existe en la plantilla
                if (jugadoresHash.containsKey(jugador.getNombre())) {

                    return false;

                } else {

                    // Revisar si alcanza el dinero
                    if (jugador.getPrecio() > presupuesto) {

                        return false;

                    } else {

                        // Actualizar presupuesto
                        presupuesto -= jugador.getPrecio();

                        jugadoresLista.add(jugador);
                        jugadoresHash.put(jugador.getNombre(), jugador);

                    }

                    return true;

                }

            }

        }

    }

    /*
     * Vender un jugador
     */
    public boolean venderJugador(JugadorFantasia jugador) {

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
        for (JugadorFantasia jugador : jugadoresLista) {

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

}
