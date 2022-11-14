package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TemporadaReal {

    // -----------------------
    // Atributos
    // -----------------------

    private static Administrador administrador;
    private static HashMap<String, Participante> participantes;

    private static HashMap<String, EquipoReal> equipos;
    private static HashMap<String, JugadorReal> jugadores;

    private static HashMap<Integer, FechaReal> fechas;

    private static float presupuestoBase;

    private static String archivoAdministradores;
    private static String archivoParticipantes;
    private static String archivoEquipos;
    private static String archivoFechas;

    // -----------------------
    // Constructor
    // -----------------------

    public TemporadaReal() {

        archivoAdministradores = "./Entrega2/Implementacion/data/Usuarios/Administradores.txt";
        archivoParticipantes = "./Entrega2/Implementacion/data/Usuarios/Participantes.txt";
        archivoEquipos = "./Entrega2/Implementacion/data/EquiposReales/equiposReales.txt";
        archivoFechas = "./Entrega2/Implementacion/data/Fechas/fechas.txt";

        participantes = new HashMap<String, Participante>();
        equipos = new HashMap<String, EquipoReal>();
        jugadores = new HashMap<String, JugadorReal>();
        fechas = new HashMap<Integer, FechaReal>();

        boolean cargadoAdministrador = cargarAdministrador(archivoAdministradores);
        boolean cargadoParticipantes = cargarParticipantes(archivoParticipantes);
        boolean cargardoEquipos = cargarEquipos(archivoEquipos);
        boolean cargadoFechas = cargarFechas(archivoFechas);

        System.out.println();

    }

    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Iniciar Sesion Administrador
     * Parametros: username, password
     * Retorno: true si fue exitoso
     * false si no fue exitoso
     */
    public boolean iniciarSesionAdministrador(String username, String password) {

        // Ready

        if (administrador.getUsername().equals(username) && administrador.getPassword().equals(password)) {

            return true;

        } else {

            return false;

        }

    }

    /*
     * Iniciar Sesion Participante
     * Parametros: username, password
     * Retorno: true si fue exitoso
     * false si no fue exitoso
     */
    public boolean iniciarSesionParticipante(String username, String password) {

        // Ready

        if (participantes.containsKey(username)) {

            if (participantes.get(username).getPassword().equals(password)) {

                return true;

            } else {

                return false;

            }

        } else {

            return false;

        }

    }

    /*
     * Registrar nuevo Administrador
     * Parametros: username, password
     * Retorno: true si fue exitoso
     * false si no fue exitoso
     */
    public boolean registrarAdministrador(String username, String password) {

        administrador = new Administrador(username, password);

        return true;

    }

    /*
     * Registrar nuevo Participante
     * Parametros: username, password
     * Retorno: true si fue exitoso
     * false si no fue exitoso
     */
    public boolean registrarParticipante(String username, String password) {

        if (participantes.containsKey(username)) {

            return false;

        } else {

            // Agregar nuevo partiipante y escribirlo en el txt
            Participante participante = new Participante(username, password);
            participantes.put(username, participante);

            // Poner el nuevo participante en el archivo de participantes
            String cadena = username + ", " + password;
            llenarTxt(archivoParticipantes, cadena);

            return true;

        }

    }

    /*
     * Leer archivo administradores para cargarlos
     * Parametros: archivo de administradores
     * Retorno: boolean - true exitoso, false no exitoso
     */
    public boolean cargarAdministrador(String archivoAdministradores) {

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoAdministradores));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                // Definimos los valores de cada linea
                String username = partes[0].trim();
                String password = partes[1].trim();

                // Llenar el administrador
                registrarAdministrador(username, password);

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
     * Leer archivo participantes para cargarlos
     * Parametros: archivo de administradores
     * Retorno: boolean - true exitoso, false no exitoso
     */
    public boolean cargarParticipantes(String archivoParticipantes) {

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoParticipantes));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                // Definimos los valores de cada linea
                String username = partes[0].trim();
                String password = partes[1].trim();

                // Llenar el hash de participantes
                Participante participante = new Participante(username, password);
                participantes.put(username, participante);

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
     * Leer archivo de Equipos y cargarlos
     * Parametros: String archivo del q se lee
     * Retorno: boolean - true exito, false fracaso
     */
    public boolean cargarEquipos(String archivoEquipos) {

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoEquipos));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                String nombreEquipo = linea.trim();

                EquipoReal equipo = new EquipoReal(nombreEquipo);
                equipos.put(equipo.getNombre(), equipo);

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
     * Agregar Jugador a la lista de jugadores total
     * Parametros: jugador a agregar
     * Retorno. void
     */
    public static void cargarJugador(JugadorReal jugador) {

        jugadores.put(jugador.getNombre(), jugador);

    }

    /*
     * Definir el atributo presupuestoBase
     * Parametros: float presupuestoBase
     * Retorno: void
     */
    public static void setPresupuestoBase(float presupuestoBase) {

        TemporadaReal.presupuestoBase = presupuestoBase;

    }

    /*
     * Metodo para llenar archivos ya existentes
     * Parametros: String Nombre archivo a modificar, String modificacion
     * Retorno: void
     */
    public void llenarTxt(String filename, String mensaje) {

        try {

            File file = new File(filename);
            file.createNewFile();

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

            writer.write("\n" + mensaje);
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /*
     * Cargar las fechas del calendario
     * Parametros: String del archivo de las fechas
     * Retorno: boolean
     */
    public boolean cargarFechas(String archivoFechas) {

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoFechas));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                // Definimos los valores de cada linea
                int numFecha = Integer.parseInt(partes[0].trim());
                String nombreLocal = partes[1].trim();
                String nombreVisitante = partes[2].trim();
                String dia = partes[3].trim();
                String hora = partes[4].trim();

                EquipoReal local = equipos.get(nombreLocal);
                EquipoReal visitante = equipos.get(nombreVisitante);

                FechaReal fecha;
                PartidoReal partido;
                // Llenar el hash de fechas
                if (fechas.containsKey(numFecha)) {

                    fecha = fechas.get(numFecha);

                    partido = new PartidoReal(local, visitante, numFecha, dia, hora);

                    fecha.addPartido(partido);

                } else {

                    fecha = new FechaReal(numFecha);
                    partido = new PartidoReal(local, visitante, numFecha, dia, hora);

                    fechas.put(numFecha, fecha);
                    fecha = fechas.get(numFecha);
                    fecha.addPartido(partido);

                }

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
     * Devuelve el atributo administrador
     */
    public static Administrador getAdministrador() {
        return administrador;
    }

    /*
     * Devuelve el atributo participantes
     */
    public static HashMap<String, Participante> getParticipantes() {
        return participantes;
    }

    /*
     * Devuelve el atributo equipos
     */
    public static HashMap<String, EquipoReal> getEquipos() {
        return equipos;
    }

    /*
     * Devuelve el atributo jugadores
     */
    public static HashMap<String, JugadorReal> getJugadores() {
        return jugadores;
    }

    /*
     * Devuelve el atributo fechas
     */
    public static HashMap<Integer, FechaReal> getFechas() {
        return fechas;
    }

    /*
     * Devuelve el atributo presupuestoBase
     */
    public static float getPresupuestoBase() {
        return presupuestoBase;
    }

    /*
     * Devuelve el atributo archivoAdministradores
     */
    public static String getArchivoAdministradores() {
        return archivoAdministradores;
    }

    /*
     * Devuelve el atributo archivoParticipantes
     */
    public static String getArchivoParticipantes() {
        return archivoParticipantes;
    }

    /*
     * Devuelve el atributo archivoEquipos
     */
    public static String getArchivoEquipos() {
        return archivoEquipos;
    }

    /*
     * Devuelve el atributo archivoFechas
     */
    public static String getArchivoFechas() {
        return archivoFechas;
    }

    public static void main(String[] args) {

        new TemporadaReal();

    }

}
