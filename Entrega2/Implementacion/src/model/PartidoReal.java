package model;

public class PartidoReal {

    // -----------------------
    // Atributos
    // -----------------------

    private EquipoReal local;
    private EquipoReal visitante;
    private int fecha;
    private String dia;
    private String hora;

    // -----------------------
    // Constructor
    // -----------------------

    public PartidoReal(EquipoReal local, EquipoReal visitante, int fecha, String dia, String hora) {

        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.dia = dia;
        this.hora = hora;

    }

    // -----------------------
    // Metodos
    // -----------------------

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
