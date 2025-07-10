import javax.swing.*;

public class CreacionDeCuentas extends JFrame {
    public CreacionDeCuentas() {
        setTitle("Crear Cuenta");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel l1 = new JLabel("Nombre:");
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("Cédula:");
        JTextField t2 = new JTextField();
        JLabel l3 = new JLabel("Edad:");
        JTextField t3 = new JTextField();
        JLabel l4 = new JLabel("Correo:");
        JTextField t4 = new JTextField();
        JLabel l5 = new JLabel("Celular:");
        JTextField t5 = new JTextField();
        JLabel l6 = new JLabel("PIN:");
        JPasswordField t6 = new JPasswordField();
        JButton guardarBtn = new JButton("Guardar");
        l1.setBounds(30, 20, 80, 25); t1.setBounds(120, 20, 180, 25);
        l2.setBounds(30, 50, 80, 25); t2.setBounds(120, 50, 180, 25);
        l3.setBounds(30, 80, 80, 25); t3.setBounds(120, 80, 180, 25);
        l4.setBounds(30, 110, 80, 25); t4.setBounds(120, 110, 180, 25);
        l5.setBounds(30, 140, 80, 25); t5.setBounds(120, 140, 180, 25);
        l6.setBounds(30, 170, 80, 25); t6.setBounds(120, 170, 180, 25);
        guardarBtn.setBounds(100, 220, 120, 30);
        add(l1); add(t1); add(l2); add(t2); add(l3); add(t3);
        add(l4); add(t4); add(l5); add(t5); add(l6); add(t6);
        add(guardarBtn);
        guardarBtn.addActionListener(e -> {
            try {
                String nombre = t1.getText();
                String cedula = t2.getText();
                int edad = Integer.parseInt(t3.getText());
                String correo = t4.getText();
                String celular = t5.getText();
                String pin = new String(t6.getPassword());
                Cliente cliente = new Cliente(nombre, cedula, edad, correo, celular, pin);
                Cuenta cuenta = new Cuenta(cliente);
                Menu.banco.agregarCuenta(cuenta);
                JOptionPane.showMessageDialog(this, "Cuenta creada correctamente.");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Datos ingresado no válidos.");
            }
        });
    }
}
