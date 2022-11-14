package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IngresoParticipante extends JFrame implements ActionListener {

    Inicio inicio;
    JButton buttonVolver;
    JLabel labelUsername;
    JLabel labelPassword;
    JTextField textUsername;
    JTextField textPassword;
    JButton buttonRegistrarse;
    JButton buttonIniciarSesion;

    public IngresoParticipante(Inicio inicio) {

        this.inicio = inicio;

        buttonVolver = new JButton("Volver");
        buttonVolver.setBounds(10, 10, 100, 50);
        buttonVolver.addActionListener(this);

        labelUsername = new JLabel("Username");
        labelUsername.setBounds(250, 100, 100, 50);
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(250, 150, 100, 50);

        textUsername = new JTextField();
        textUsername.setBounds(350, 100, 100, 50);

        this.add(buttonVolver);
        this.add(labelUsername);
        this.add(labelPassword);
        this.add(textUsername);

        this.setSize(700, 700);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Ingreso Participantes");
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(255, 251, 193));
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonVolver) {

            this.setVisible(false);
            // new Inicio();
            inicio.setVisible(true);

        }
    }

}
