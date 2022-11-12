package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Temporada {

    // -----------------------
    // Atributos
    // -----------------------

    private Administrador administrador;
    private HashMap<String, Participante> participantes;
    private ArrayList<EquipoReal> equipos;
    private ArrayList<JugadorReal> jugadores;
    private HashMap<Integer, FechaReal> fechas;
    private float presupuestoBase;

    // -----------------------
    // Constructor
    // -----------------------

    public Temporada() {

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

        // Leer archivo
        try {

            FileReader file = new FileReader("../data/Administradores.txt");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        administrador = new Administrador(username, password);
        return true;

    }

    /*
     * Registrar nuevo Participante
     * Parametros: username, password
     * Retorno: true si fue exitoso
     * false si no fue exitoso
     */
    public boolean regsitrarParticipante() {

        return true;

    }

}
