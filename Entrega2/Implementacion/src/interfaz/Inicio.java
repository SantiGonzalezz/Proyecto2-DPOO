package interfaz;

import model.FechaReal;
import model.Participante;
import model.TemporadaReal;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Inicio extends JFrame implements ActionListener {

    private static TemporadaReal mundo = new TemporadaReal();
    private JLabel labelLiga;
    private JLabel labelTipo;
    private JButton buttonAdministrador;
    private JButton buttonParticipante;

    public Inicio() {

        labelLiga = new JLabel("Football Fantasy League");
        labelLiga.setBounds(100, 50, 500, 150);
        labelLiga.setHorizontalAlignment(JLabel.CENTER);
        labelLiga.setFont(new Font(Font.SERIF, Font.PLAIN, 40));
        labelLiga.setBackground(new Color(254, 190, 140));
        labelLiga.setOpaque(true);

        labelTipo = new JLabel("Elige tu tipo de usuario");
        labelTipo.setBounds(150, 300, 400, 100);
        labelTipo.setHorizontalAlignment(JLabel.CENTER);
        labelTipo.setFont(new Font(null, Font.PLAIN, 30));
        labelTipo.setBackground(new Color(247, 164, 164));
        labelTipo.setOpaque(true);

        buttonAdministrador = new JButton("Administrador");
        buttonAdministrador.setBounds(100, 450, 200, 100);
        buttonAdministrador.addActionListener(this);
        buttonAdministrador.setFocusable(false);
        buttonAdministrador.setBackground(new Color(247, 164, 164));

        buttonParticipante = new JButton("Participante");
        buttonParticipante.setBounds(400, 450, 200, 100);
        buttonParticipante.addActionListener(this);
        buttonParticipante.setFocusable(false);
        buttonParticipante.setBackground(new Color(247, 164, 164));

        this.add(labelLiga);
        this.add(labelTipo);
        this.add(buttonAdministrador);
        this.add(buttonParticipante);

        this.setSize(700, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Liga de Fantasía");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 251, 193));
        this.setVisible(true);

    }

    public static void main(String[] args) {

        Inicio inicio = new Inicio();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonAdministrador) {

            this.setVisible(false);
            new IngresoAdministrador(this);

        } else if (e.getSource() == buttonParticipante) {
            this.setVisible(false);
            new IngresoParticipante(this);

        }
    }

    public boolean iniciarSesionParticipante(String username, String password) {

        return (mundo.iniciarSesionParticipante(username, password));

    }

    public Participante getParticipante(String username) {

        return mundo.getParticipante(username);

    }

    public boolean registrarParticipante(String username, String password) {

        return mundo.registrarParticipante(username, password);

    }

    public boolean iniciarSesionAdministrador(String username, String password) {

        return mundo.iniciarSesionAdministrador(username, password);

    }

    public HashMap<Integer, FechaReal> getFechas() {
        return TemporadaReal.getFechas();
    }

    public int cargarPartido(int fecha, int indicePartido) {
        mundo.cargarPartido(fecha, indicePartido);

        return mundo.jugadoresCargadosPartido(fecha, indicePartido);
    }

}
