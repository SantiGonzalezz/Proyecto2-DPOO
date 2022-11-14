package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Participante;

import java.awt.event.ActionEvent;

public class IngresoParticipante extends Ingreso {

    public IngresoParticipante(Inicio inicio) {

        super(inicio);

        labelTitulo.setText("Ingreso Participante");

        buttonRegistrarse = new JButton("Registrarse");
        buttonRegistrarse.setBounds(100, 450, 200, 50);
        buttonRegistrarse.addActionListener(this);
        buttonRegistrarse.setFocusable(false);
        buttonRegistrarse.setBackground(new Color(229, 235, 178));

        this.add(buttonRegistrarse);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = textUsername.getText();
        String password = textPassword.getText();

        if (e.getSource() == buttonVolver) {

            this.setVisible(false);
            // new Inicio();
            inicio.setVisible(true);

        } else if (e.getSource() == buttonIniciarSesion) {

            if (inicio.iniciarSesionParticipante(username, password)) {

                Participante participante = inicio.getParticipante(username);
                // System.out.println(participante.getUsername() + participante.getPassword());

                JOptionPane.showMessageDialog(this, "Ingreso correcto", "Ingreso Válido",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(this, "Username o Password incorrectas", "Ingreso Inválido",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == buttonRegistrarse) {

            if ((!username.equals("")) || (!password.equals(""))) {

                if (inicio.registrarParticipante(username, password)) {

                    Participante participante = inicio.getParticipante(username);
                    // System.out.println(participante.getUsername() + participante.getPassword());

                    JOptionPane.showMessageDialog(this, "Registro correcto", "Registro Válido",
                            JOptionPane.INFORMATION_MESSAGE);

                } else {

                    JOptionPane.showMessageDialog(this, "Username ya existente", "Registro Inválido",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {

                JOptionPane.showMessageDialog(this, "Ingrese username y password", "Registro Incorrecto",
                        JOptionPane.ERROR_MESSAGE);

            }
        }

    }

}
