package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;

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

    JList<String> listJugadoresTotales;
    JScrollPane scroll;

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
        labelModificarEquipo.setBounds(100, 100, 500, 60);
        labelModificarEquipo.setHorizontalAlignment(JLabel.CENTER);
        labelModificarEquipo.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelModificarEquipo.setBackground(new Color(254, 190, 140));
        labelModificarEquipo.setOpaque(true);

        // Lista
        HashMap<String, JugadorReal> jugadores = inicio.getJugadores();
        Set<String> listaJugadores = jugadores.keySet();
        String[] lista = listaJugadores.toArray(new String[listaJugadores.size()]);
        listJugadoresTotales = new JList<String>(lista);
        // listJugadoresEquipo.setBounds(50, 150, 200, 300);
        listJugadoresTotales.setVisibleRowCount(10);
        scroll = new JScrollPane(listJugadoresTotales);
        scroll.setBounds(50, 200, 200, 300);

        // Add
        this.add(buttonVolver);
        this.add(labelModificarEquipo);
        this.add(scroll);

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
