package interfaz;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.FechaReal;
import model.PartidoReal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class PantallaAdmin extends JFrame implements ActionListener {

    Inicio inicio;
    JButton buttonVolver;

    JLabel labelCargar;

    JList<Integer> listFechas;
    JScrollPane scroll;

    JList listPartidos;
    JScrollPane scroll2;

    JButton buttonVerPartidos;
    JButton buttonCargarPartido;

    public PantallaAdmin(Inicio inicio) {

        this.inicio = inicio;

        // Volver
        buttonVolver = new JButton("Volver");
        buttonVolver.setBounds(10, 10, 100, 50);
        buttonVolver.addActionListener(this);

        // Titulo
        labelCargar = new JLabel("Cargar Partidos");
        labelCargar.setBounds(200, 50, 300, 60);
        labelCargar.setHorizontalAlignment(JLabel.CENTER);
        labelCargar.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelCargar.setBackground(new Color(254, 190, 140));
        labelCargar.setOpaque(true);

        // Lista con las fechas
        HashMap<Integer, FechaReal> fechas = inicio.getFechas();
        Set<Integer> listaFechas = fechas.keySet();
        Integer[] lista = listaFechas.toArray(new Integer[listaFechas.size()]);
        listFechas = new JList<Integer>(lista);
        listFechas.setVisibleRowCount(2);
        scroll = new JScrollPane(listFechas);
        scroll.setBounds(100, 200, 200, 50);

        // Lista Partidos
        listPartidos = new JList(new DefaultListModel<String>());
        scroll2 = new JScrollPane(listPartidos);
        scroll2.setBounds(450, 200, 200, 50);

        // Button ver partidos
        buttonVerPartidos = new JButton("Ver Partidos en Fecha Seleccionada");
        buttonVerPartidos.setBounds(200, 300, 300, 50);
        buttonVerPartidos.addActionListener(this);

        // Button Cargar Partidos
        buttonCargarPartido = new JButton("Cargar Partido Seleccionado");
        buttonCargarPartido.setBounds(200, 400, 300, 50);
        buttonCargarPartido.addActionListener(this);

        // Anadir elementos
        this.add(buttonVolver);
        this.add(labelCargar);
        this.add(scroll);
        this.add(scroll2);
        this.add(buttonVerPartidos);
        this.add(buttonCargarPartido);

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

        } else if (e.getSource() == buttonVerPartidos) {

            if (listFechas.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una fecha para la cual ver los partidos",
                        "Carga no Valida",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                ((DefaultListModel) listPartidos.getModel()).clear();
                HashMap<Integer, FechaReal> fechas = inicio.getFechas();
                int fechaElegida = listFechas.getSelectedValue();
                ArrayList<PartidoReal> partidos = fechas.get(fechaElegida).getPartidos();

                String[] arrayStringPartidos = new String[partidos.size()];
                for (int i = 0; i < partidos.size(); i++) {

                    arrayStringPartidos[i] = partidos.get(i).getStringPartido();
                    ((DefaultListModel) listPartidos.getModel()).addElement(partidos.get(i).getStringPartido());

                }

                for (int i = 0; i < partidos.size(); i++) {

                }

            }

        } else if (e.getSource() == buttonCargarPartido) {

            if (listFechas.isSelectionEmpty() || listPartidos.isSelectionEmpty()) {

                JOptionPane.showMessageDialog(this, "Seleccione una fecha y un partido que cargar",
                        "Carga no Valida",
                        JOptionPane.ERROR_MESSAGE);

            } else {
                int fechaElegida = listFechas.getSelectedValue();
                int indicePartido = listPartidos.getSelectedIndex();

                String cargados = String.valueOf(inicio.cargarPartido(fechaElegida, indicePartido));
                JOptionPane.showMessageDialog(this,
                        "Jugadores cargados en el partido " + listPartidos.getSelectedValue() + ": " + cargados,
                        "Carga Correcta",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }

    }

}
