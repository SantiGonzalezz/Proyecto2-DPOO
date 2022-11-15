package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class PartidoReal {

    // -----------------------
    // Atributos
    // -----------------------

    private EquipoReal local;
    private EquipoReal visitante;
    private int fecha;
    private String dia;
    private String hora;
    private int resultado;
    private HashMap<String, DesempenoJugadorReal> desempenoLocal;
    private HashMap<String, DesempenoJugadorReal> desempenoVisitante;

    String archivoDesempeno;

    // -----------------------
    // Constructor
    // -----------------------

    public PartidoReal(EquipoReal local, EquipoReal visitante, int fecha, String dia, String hora) {

        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.dia = dia;
        this.hora = hora;

        this.desempenoLocal = new HashMap<>();
        this.desempenoVisitante = new HashMap<>();

        archivoDesempeno = "./Entrega2/Implementacion/data/Fechas/" + String.valueOf(fecha) + "/" + local.getNombre()
                + "-" + visitante.getNombre() + "/";

    }

    // -----------------------
    // Metodos
    // -----------------------¨

    /*
     * String local visitante
     */
    public String getStringPartido() {
        return local.getNombre() + "-" + visitante.getNombre();
    }

    /*
     * Cargar Partido
     */
    public boolean cargarPartido() {

        registrarResultado();

        registrarDesempenoLocal();
        registrarDesempenoVisitante();

        return true;
    }

    /*
     * Registrar desempeno Local
     */
    public boolean registrarDesempenoLocal() {

        String archivoLocal = archivoDesempeno + local.getNombre() + ".txt";

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoLocal));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                String nombreJugador = partes[0].trim();

                JugadorReal jugador = TemporadaReal.getJugadores().get(nombreJugador);

                // String posicion = partes[1].trim();

                int minutosJugados = Integer.parseInt(partes[2].trim());
                int minutoIngreso = Integer.parseInt(partes[3].trim());
                int minutoSustitucion = Integer.parseInt(partes[4].trim());
                int golesAnotados = Integer.parseInt(partes[5].trim());
                int penaltisAnotados = Integer.parseInt(partes[6].trim());
                int penaltisErrados = Integer.parseInt(partes[7].trim());
                int autogoles = Integer.parseInt(partes[8].trim());
                int asistencias = Integer.parseInt(partes[9].trim());
                int tarjetasAmarillas = Integer.parseInt(partes[10].trim());
                int tarjetasRojas = Integer.parseInt(partes[11].trim());
                int golesRecibidos = Integer.parseInt(partes[12].trim());
                int penaltisDetenidos = Integer.parseInt(partes[13].trim());
                int capitan = Integer.parseInt(partes[14].trim());

                // System.out.print(partes);
                DesempenoJugadorReal desempenoJugador = new DesempenoJugadorReal(jugador, this, 1, minutosJugados,
                        minutoIngreso,
                        minutoSustitucion, golesAnotados, penaltisAnotados, penaltisErrados, autogoles, asistencias,
                        tarjetasAmarillas, tarjetasRojas, golesRecibidos, penaltisDetenidos, capitan);

                // Guardar en Hash por fechas el jugador
                TemporadaReal.getFechas().get(fecha).addDesempeno(desempenoJugador.getNombre(), desempenoJugador);

                desempenoLocal.put(desempenoJugador.getNombre(), desempenoJugador);

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
     * Registrar desempeno Local
     */
    public boolean registrarDesempenoVisitante() {

        String archivoLocal = archivoDesempeno + visitante.getNombre() + ".txt";

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoLocal));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String[] partes = linea.split(",");

                String nombreJugador = partes[0].trim();

                JugadorReal jugador = TemporadaReal.getJugadores().get(nombreJugador);

                // String posicion = partes[1].trim();

                int minutosJugados = Integer.parseInt(partes[2].trim());
                int minutoIngreso = Integer.parseInt(partes[3].trim());
                int minutoSustitucion = Integer.parseInt(partes[4].trim());
                int golesAnotados = Integer.parseInt(partes[5].trim());
                int penaltisAnotados = Integer.parseInt(partes[6].trim());
                int penaltisErrados = Integer.parseInt(partes[7].trim());
                int autogoles = Integer.parseInt(partes[8].trim());
                int asistencias = Integer.parseInt(partes[9].trim());
                int tarjetasAmarillas = Integer.parseInt(partes[10].trim());
                int tarjetasRojas = Integer.parseInt(partes[11].trim());
                int golesRecibidos = Integer.parseInt(partes[12].trim());
                int penaltisDetenidos = Integer.parseInt(partes[13].trim());
                int capitan = Integer.parseInt(partes[14].trim());

                // System.out.print(partes);
                DesempenoJugadorReal desempenoJugador = new DesempenoJugadorReal(jugador, this, 2, minutosJugados,
                        minutoIngreso,
                        minutoSustitucion, golesAnotados, penaltisAnotados, penaltisErrados, autogoles, asistencias,
                        tarjetasAmarillas, tarjetasRojas, golesRecibidos, penaltisDetenidos, capitan);

                // Guardar en Hash por fechas el jugador
                TemporadaReal.getFechas().get(fecha).addDesempeno(desempenoJugador.getNombre(), desempenoJugador);

                desempenoVisitante.put(desempenoJugador.getNombre(), desempenoJugador);

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
     * Registrar resultado
     */
    public boolean registrarResultado() {

        String archivoResultado = archivoDesempeno + "Resultado.txt";

        try {

            // Leer archivo
            BufferedReader br;
            br = new BufferedReader(new FileReader(archivoResultado));

            // Leer primera fila que son los nombres de las columnas
            String linea;
            linea = br.readLine();
            linea = br.readLine();

            while (linea != null) {

                // CSV
                String resultado = linea.trim();

                if (resultado.equals("Local")) {

                    ganaLocal();

                } else if (resultado.equals("Empate")) {

                    ganaVisitante();

                } else if (resultado.equals("Empate")) {

                    empate();

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
     * Local Gana
     */
    public void ganaLocal() {
        resultado = 1;
    }

    /*
     * Empate
     */
    public void empate() {
        resultado = 2;
    }

    /*
     * Visitante Gana
     */
    public void ganaVisitante() {
        resultado = 0;
    }

    /*
     * Devuelve el atributo local
     */
    public EquipoReal getLocal() {

        return local;

    }

    /*
     * Devuelve el atributo visitante
     */
    public EquipoReal getVisitante() {

        return visitante;

    }

    /*
     * Devuelve el atributo fecha
     */
    public int getFecha() {

        return fecha;

    }

    /*
     * Devuelve el atributo dia
     */
    public String getDia() {

        return dia;

    }

    /*
     * Devuelve el atributo hora
     */
    public String getHora() {

        return hora;

    }

    public int getResultado() {
        return resultado;
    }

    public HashMap<String, DesempenoJugadorReal> getDesempenoLocal() {
        return desempenoLocal;
    }

    public HashMap<String, DesempenoJugadorReal> getDesempenoVisitante() {
        return desempenoVisitante;
    }

    public String getArchivoDesempeno() {
        return archivoDesempeno;
    }

}
