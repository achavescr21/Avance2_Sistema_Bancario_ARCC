import javax.swing.*;

public class IniciarSesion extends JFrame {
    public IniciarSesion() {
        setTitle("Iniciar Sesión");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel l1 = new JLabel("Cédula:");
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("PIN:");
        JPasswordField t2 = new JPasswordField();
        JButton loginBtn = new JButton("Entrar");
        l1.setBounds(30, 30, 80, 25); t1.setBounds(100, 30, 150, 25);
        l2.setBounds(30, 70, 80, 25); t2.setBounds(100, 70, 150, 25);
        loginBtn.setBounds(90, 120, 100, 30);
        add(l1); add(t1); add(l2); add(t2); add(loginBtn);
        loginBtn.addActionListener(e -> {
            String ced = t1.getText();
            String pin = new String(t2.getPassword());
            Cuenta cuenta = Menu.banco.buscarCuentaPorCedulaYPin(ced, pin);
            if (cuenta != null) {
                new MenuCuenta(cuenta).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Datos incorrectos.");
            }
        });
    }
}
