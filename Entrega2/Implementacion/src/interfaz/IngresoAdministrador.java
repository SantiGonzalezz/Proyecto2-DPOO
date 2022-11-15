package interfaz;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

public class IngresoAdministrador extends Ingreso {

    public IngresoAdministrador(Inicio inicio) {

        super(inicio);

        labelTitulo.setText("Ingreso Administrador");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String username = textUsername.getText();
        String password = textPassword.getText();

        if (e.getSource() == buttonVolver) {

            this.setVisible(false);
            inicio.setVisible(true);

        } else if (e.getSource() == buttonIniciarSesion) {

            if (inicio.iniciarSesionAdministrador(username, password)) {

                JOptionPane.showMessageDialog(this, "Ingreso correcto", "Ingreso Válido",
                        JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new PantallaAdmin(inicio);

            } else {

                JOptionPane.showMessageDialog(this, "Username o Password incorrectas", "Ingreso Inválido",
                        JOptionPane.ERROR_MESSAGE);

            }

        }
    }

}
