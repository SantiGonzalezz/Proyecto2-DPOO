package interfaz;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ingreso extends JFrame implements ActionListener {

    Inicio inicio;
    JButton buttonVolver;
    JLabel labelTitulo;

    JLabel labelUsername;
    JLabel labelPassword;
    JTextField textUsername;
    JTextField textPassword;

    JButton buttonRegistrarse;
    JButton buttonIniciarSesion;

    public Ingreso(Inicio inicio) {

        this.inicio = inicio;

        buttonVolver = new JButton("Volver");
        buttonVolver.setBounds(10, 10, 100, 50);
        buttonVolver.addActionListener(this);

        labelTitulo = new JLabel();
        labelTitulo.setBounds(200, 50, 300, 100);
        labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        labelTitulo.setFont(new Font(Font.SERIF, Font.PLAIN, 30));
        labelTitulo.setBackground(new Color(254, 190, 140));
        labelTitulo.setOpaque(true);

        labelUsername = new JLabel("Username");
        labelUsername.setBounds(250, 300, 100, 50);
        labelPassword = new JLabel("Password");
        labelPassword.setBounds(250, 350, 100, 50);

        textUsername = new JTextField();
        textUsername.setBounds(350, 300, 100, 50);
        textPassword = new JTextField();
        textPassword.setBounds(350, 350, 100, 50);

        buttonIniciarSesion = new JButton("Iniciar Sesión");
        buttonIniciarSesion.setBounds(400, 450, 200, 50);
        buttonIniciarSesion.addActionListener(this);
        buttonIniciarSesion.setFocusable(false);
        buttonIniciarSesion.setBackground(new Color(188, 226, 158));

        this.add(buttonVolver);

        this.add(labelTitulo);

        this.add(labelUsername);
        this.add(labelPassword);
        this.add(textUsername);
        this.add(textPassword);

        this.add(buttonIniciarSesion);

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
