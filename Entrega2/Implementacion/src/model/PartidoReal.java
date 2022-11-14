package model;

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
     * Registrar desempeno Local
     */
    public void registrarDesempenoLocal() {

        String archivoLocal = archivoDesempeno + local.getNombre() + ".txt";
        System.out.println(archivoLocal);

    }

    /*
     * Registrar resultado
     */
    public void registrarResultado(int resultado) {

        if (resultado == 1) {
            ganaLocal();
        } else if (resultado == 0) {
            empate();
        } else if (resultado == 2) {
            ganaVisitante();
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

}
