package model;

public class DesempenoJugadorReal extends JugadorReal {

    // -----------------------
    // Atributos
    // -----------------------
    private int minutosJugados;
    private int minutoIngreso;
    private int minutoSustitucion;
    private int golesAnotados;
    private int penaltisAnotados;
    private int penaltisErrados;
    private int autogoles;
    private int asistencias;
    private int tarjetasAmarillas;
    private int tarjetasRojas;
    private int golesRecibidos;
    private int penaltisDetenidos;
    private int capitan;

    private PartidoReal partido;
    private int local;
    private int puntos;

    // -----------------------
    // Constructor
    // -----------------------

    public int getCapitan() {
        return capitan;
    }

    public PartidoReal getPartido() {
        return partido;
    }

    public int getLocal() {
        return local;
    }

    public int getPuntos() {
        return puntos;
    }

    public DesempenoJugadorReal(JugadorReal jugador, PartidoReal partido, int local, int minutosJugados,
            int minutoIngreso, int minutoSustitucion,
            int golesAnotados, int penaltisAnotados, int penaltisErrados, int autogoles, int asistencias,
            int tarjetasAmarillas, int tarjetasRojas, int golesRecibidos, int penaltisDetenidos, int capitan) {

        super(jugador.getNombre(), jugador.getPosicion(), jugador.getPrecio(), jugador.getEquipo());

        this.partido = partido;
        this.local = local;

        this.minutosJugados = minutosJugados;
        this.minutoIngreso = minutoIngreso;
        this.minutoSustitucion = minutoSustitucion;
        this.golesAnotados = golesAnotados;
        this.penaltisAnotados = penaltisAnotados;
        this.penaltisErrados = penaltisErrados;
        this.autogoles = autogoles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
        this.golesRecibidos = golesRecibidos;
        this.penaltisDetenidos = penaltisDetenidos;
        this.capitan = capitan;

        calcularPuntos();

    }
    // -----------------------
    // Metodos
    // -----------------------

    /*
     * Calcular los puntos
     */
    public void calcularPuntos() {

        // Si juega menos de 60 1 puntos
        if (minutosJugados > 0 && minutosJugados <= 60) {
            puntos += 1;
        }
        // Si juego mas de 60 2 puntos
        if (minutosJugados > 60) {
            puntos += 2;
        }

        // Si anota gol depende de la posicion
        if (posicion.equals("delantero")) {
            puntos += golesAnotados * 4;
        } else if (posicion.equals("mediocampista")) {
            puntos += golesAnotados * 5;
        } else if (posicion.equals("defensa") || posicion.equals("portero")) {
            puntos += golesAnotados * 6;
        }

        // Si asite
        puntos += 3 * asistencias;

        // Si no recibe goles
        if (posicion.equals("defensa") || posicion.equals("portero")) {
            if (golesRecibidos == 0) {
                puntos += 4;
            }
        }

        // Si es capitan y gana
        if (partido.getResultado() == local) {
            puntos += capitan * 5;
        }

        // Si detiene un penal
        puntos += penaltisDetenidos;

        // Si falla un penal
        puntos += -2 * penaltisErrados;

        // Si recibe Amarilla
        puntos += -1 * tarjetasAmarillas;

        // Si recibe Roja
        puntos += -3 * tarjetasRojas;

        // Si hace autogol
        puntos += -2 * autogoles;

    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public int getMinutoIngreso() {
        return minutoIngreso;
    }

    public int getMinutoSustitucion() {
        return minutoSustitucion;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public int getPenaltisAnotados() {
        return penaltisAnotados;
    }

    public int getPenaltisErrados() {
        return penaltisErrados;
    }

    public int getAutogoles() {
        return autogoles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public int getGolesRecibidos() {
        return golesRecibidos;
    }

    public int getPenaltisDetenidos() {
        return penaltisDetenidos;
    }

}
