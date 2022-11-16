package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.EquipoFantasia;
import model.JugadorReal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class ModificarEquipoFantasia extends JFrame implements ActionListener {

    Inicio inicio;
    EquipoFantasia equipoFantasia;

    JButton buttonVolver;

    JLabel labelModificarEquipo;

    JLabel labelTituloListLabelJugadores;
    JList<String> listJugadoresTotales;
    JScrollPane scroll;

    JLabel labelInformacionJugador;
    JTextField textNombreJugador;
    JTextField textPosicionJugador;
    JTextField textPrecioJugador;

    JLabel labelTituloListJugadoresEquipo;
    JList listJugadoresEquipo;
    JScrollPane scroll2;

    JLabel labelInformacionJugadorEquipo;
    JTextField textNombreJugadorEquipo;
    JTextField textPosicionJugadorEquipo;
    JTextField textPrecioJugadorEquipo;

    public ModificarEquipoFantasia(Inicio inicio, EquipoFantasia equipoFantasia) {

        this.inicio = inicio;
        this.equipoFantasia = equipoFantasia;

        // Volver
        buttonVolver = new JButton("Volver");
        buttonVolver.setBounds(10, 10, 100, 50);
        buttonVolver.addActionListener(this);

        // Titulo
        labelModificarEquipo = new JLabel(
                "Usuario: " + equipoFantasia.getParticipante() + ", Equipo Fantasia: " + equipoFantasia.getNombre());
        labelModificarEquipo.setBounds(100, 70, 500, 60);
        labelModificarEquipo.setHorizontalAlignment(JLabel.CENTER);
        labelModificarEquipo.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelModificarEquipo.setBackground(new Color(254, 190, 140));
        labelModificarEquipo.setOpaque(true);

        // Lista
        // Titulo Lista
        labelTituloListLabelJugadores = new JLabel("Jugadores en la Liga");
        labelTituloListLabelJugadores.setBounds(50, 170, 200, 20);
        labelTituloListLabelJugadores.setHorizontalAlignment(JLabel.CENTER);

        HashMap<String, JugadorReal> jugadores = inicio.getJugadores();
        Set<String> listaJugadores = jugadores.keySet();
        String[] lista = listaJugadores.toArray(new String[listaJugadores.size()]);
        listJugadoresTotales = new JList<String>(lista);
        listJugadoresTotales.setVisibleRowCount(10);
        scroll = new JScrollPane(listJugadoresTotales);
        scroll.setBounds(50, 200, 200, 110);

        // Informacion Jugador
        labelInformacionJugador = new JLabel("Información Jugador");
        labelInformacionJugador.setBounds(400, 170, 100, 20);

        // Lista Jugadores del Equipo

        labelTituloListJugadoresEquipo = new JLabel("Jugadores en el Equipo");
        labelTituloListJugadoresEquipo.setBounds(50, 400, 200, 20);
        labelTituloListJugadoresEquipo.setHorizontalAlignment(JLabel.CENTER);

        listJugadoresEquipo = new JList(new DefaultListModel<String>());
        scroll2 = new JScrollPane(listJugadoresEquipo);
        scroll2.setBounds(50, 430, 200, 110);

        // Add
        this.add(buttonVolver);
        this.add(labelModificarEquipo);
        this.add(labelTituloListLabelJugadores);
        this.add(scroll);
        this.add(labelTituloListJugadoresEquipo);
        this.add(scroll2);

        // Propiedades Frame
        this.setSize(700, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Liga de Fantasía");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 251, 193));
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonVolver) {

            this.setVisible(false);
            inicio.setVisible(true);

        }

    }

}
