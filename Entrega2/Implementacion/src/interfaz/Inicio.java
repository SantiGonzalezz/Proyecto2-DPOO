package interfaz;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame implements ActionListener {

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

        } else if (e.getSource() == buttonParticipante) {
            this.setVisible(false);
            new IngresoParticipante(this);

        }
    }

}