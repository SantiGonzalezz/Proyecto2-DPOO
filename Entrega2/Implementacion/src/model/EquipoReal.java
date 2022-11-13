package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EquipoReal {

    // -----------------------
    // Atributos
    // -----------------------

    private String nombre;
    private ArrayList<JugadorReal> jugadores;
    private String direccionArchivo;

    // -----------------------
    // Constructor
    // -----------------------

    public EquipoReal(String nombre) {

        direccionArchivo = "./Entrega2/Implementacion/data/EquiposReales/JugadoresReales/";

        this.nombre = nombre;
        jugadores = new ArrayList<JugadorReal>();

        cargarJugadores();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Agregar los jugadores reales
     * Parametros:
     * Retorno: boolean - true exito, false fracaso
     */
    public boolean cargarJugadores() {

        String archivoJugadores = direccionArchivo + nombre + ".txt";

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoJugadores));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                // Definimos los valores de cada linea
                String nombreJugador = partes[0].trim();
                String posicionJugador = partes[1].trim();
                float precioJugador = Integer.parseInt(partes[2].trim());

                // Llenar el hash de participantes
                JugadorReal jugador = new JugadorReal(nombreJugador, posicionJugador, precioJugador, nombre);
                jugadores.add(jugador);

                TemporadaReal.cargarJugador(jugador);

                linea = br.readLine();

            }

            // Cerrar conexion
            br.close();

            return true;

        } catch (IOException e) {

            // e.printStackTrace();

            return false;

        }

    }

    /*
     * Obtener atributo nombre
     */
    public String getNombre() {

        return this.nombre;

    }

    /*
     * Obtener atributo jugadores
     */
    public ArrayList<JugadorReal> getJugadores() {

        return jugadores;

    }

}
