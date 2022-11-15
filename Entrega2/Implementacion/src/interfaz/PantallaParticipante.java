package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EquipoFantasia;
import model.Participante;

public class PantallaParticipante extends JFrame implements ActionListener {

    Inicio inicio;
    Participante participante;

    JButton buttonVolver;

    JLabel labelNuevoEquipo;

    JButton buttonNuevoEquipo;

    JLabel labelNombreEquipo;
    JTextField textNombreEquipo;

    JList listJugadores;

    public PantallaParticipante(Inicio inicio, Participante participante) {

        this.inicio = inicio;
        this.participante = participante;

        // Volver
        buttonVolver = new JButton("Volver");
        buttonVolver.setBounds(10, 10, 100, 50);
        buttonVolver.addActionListener(this);

        // Titulo
        labelNuevoEquipo = new JLabel("Crear Nuevo Equipo");
        labelNuevoEquipo.setBounds(200, 50, 300, 60);
        labelNuevoEquipo.setHorizontalAlignment(JLabel.CENTER);
        labelNuevoEquipo.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelNuevoEquipo.setBackground(new Color(254, 190, 140));
        labelNuevoEquipo.setOpaque(true);

        // Nombre Equipo Nuevo
        labelNombreEquipo = new JLabel("Nombre del equipo");
        labelNombreEquipo.setBounds(200, 300, 150, 50);
        textNombreEquipo = new JTextField();
        textNombreEquipo.setBounds(350, 300, 150, 50);

        // Button Crear Nuevo Equipo
        buttonNuevoEquipo = new JButton("Crear Nuevo Equipo");
        buttonNuevoEquipo.setBounds(250, 500, 200, 50);
        buttonNuevoEquipo.addActionListener(this);

        // Add
        this.add(buttonVolver);
        this.add(labelNuevoEquipo);
        this.add(labelNombreEquipo);
        this.add(textNombreEquipo);
        this.add(buttonNuevoEquipo);

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

        } else if (e.getSource() == buttonNuevoEquipo) {

            String nombreEquipo = textNombreEquipo.getText();

            if (!nombreEquipo.equals("")) {

                JOptionPane.showMessageDialog(this, "Creación de Equipo Correcta", "Equipo Creado Correctamente",
                        JOptionPane.INFORMATION_MESSAGE);

                participante.nuevoEquipoFantasia(nombreEquipo);
                EquipoFantasia equipoFantasia = participante.getEquipoFantasiaActual();
                this.setVisible(false);
                new ModificarEquipoFantasia(inicio, equipoFantasia);

            } else {

                JOptionPane.showMessageDialog(this, "Ingrese un nombre para el equipo a crear", "Creación Incorrecta",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
