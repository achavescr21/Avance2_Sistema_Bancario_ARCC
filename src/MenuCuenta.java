import javax.swing.*;

public class MenuCuenta extends JFrame {
    private Cuenta cuenta;
    public MenuCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
        setTitle("Menú de Cuenta");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        JLabel saludo = new JLabel("Bienvenido, " + cuenta.getCliente().getNombre());
        saludo.setBounds(30, 20, 300, 25);
        add(saludo);
        JButton btnSaldo = new JButton("Ver Saldo");
        JButton btnDeposito = new JButton("Depósito");
        JButton btnRetiro = new JButton("Retiro");
        JButton btnTransferencia = new JButton("Transferencia");
        JButton btnHistorial = new JButton("Historial");
        JButton btnCerrar = new JButton("Cerrar Sesión");
        btnSaldo.setBounds(100, 60, 200, 30);
        btnDeposito.setBounds(100, 100, 200, 30);
        btnRetiro.setBounds(100, 140, 200, 30);
        btnTransferencia.setBounds(100, 180, 200, 30);
        btnHistorial.setBounds(100, 220, 200, 30);
        btnCerrar.setBounds(100, 270, 200, 30);
        add(btnSaldo);
        add(btnDeposito);
        add(btnRetiro);
        add(btnTransferencia);
        add(btnHistorial);
        add(btnCerrar);
        btnSaldo.addActionListener(e -> mostrarSaldo());
        btnDeposito.addActionListener(e -> mostrarDeposito());
        btnRetiro.addActionListener(e -> mostrarRetiro());
        btnTransferencia.addActionListener(e -> mostrarTransferencia());
        btnHistorial.addActionListener(e -> mostrarHistorial());
        btnCerrar.addActionListener(e -> {
            dispose();
            new Menu().setVisible(true);
        });
    }
    private void mostrarSaldo() {
        JFrame saldoVentana = new JFrame("Saldo Actual");
        saldoVentana.setSize(300, 150);
        saldoVentana.setLayout(null);
        saldoVentana.setLocationRelativeTo(null);
        JLabel saldoLabel = new JLabel("Saldo actual: ₡" + cuenta.getSaldo());
        saldoLabel.setBounds(50, 40, 250, 30);
        saldoVentana.add(saldoLabel);
        saldoVentana.setVisible(true);
    }
    private void mostrarDeposito() {
        JFrame depVentana = new JFrame("Depósito");
        depVentana.setSize(300, 200);
        depVentana.setLayout(null);
        depVentana.setLocationRelativeTo(null);
        JLabel label = new JLabel("Monto a depositar:");
        JTextField campo = new JTextField();
        JButton btn = new JButton("Depositar");
        label.setBounds(30, 30, 150, 25);
        campo.setBounds(30, 60, 220, 25);
        btn.setBounds(80, 100, 120, 30);
        depVentana.add(label);
        depVentana.add(campo);
        depVentana.add(btn);
        btn.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(campo.getText());
                cuenta.depositar(monto);
                JOptionPane.showMessageDialog(depVentana, "Depósito exitoso.");
                depVentana.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(depVentana, "Error: ingrese un número válido.");
            }
        });
        depVentana.setVisible(true);
    }
    private void mostrarRetiro() {
        JFrame retVentana = new JFrame("Retiro");
        retVentana.setSize(300, 200);
        retVentana.setLayout(null);
        retVentana.setLocationRelativeTo(null);
        JLabel label = new JLabel("Monto a retirar:");
        JTextField campo = new JTextField();
        JButton btn = new JButton("Retirar");
        label.setBounds(30, 30, 150, 25);
        campo.setBounds(30, 60, 220, 25);
        btn.setBounds(80, 100, 120, 30);
        retVentana.add(label);
        retVentana.add(campo);
        retVentana.add(btn);
        btn.addActionListener(e -> {
            try {
                double monto = Double.parseDouble(campo.getText());
                cuenta.retirar(monto);
                JOptionPane.showMessageDialog(retVentana, "Retiro exitoso.");
                retVentana.dispose();
            } catch (FondosInsuficientes ex) {
                JOptionPane.showMessageDialog(retVentana, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(retVentana, "Error: ingrese un número válido.");
            }
        });
        retVentana.setVisible(true);
    }
    private void mostrarTransferencia() {
        JFrame transVentana = new JFrame("Transferencia");
        transVentana.setSize(350, 250);
        transVentana.setLayout(null);
        transVentana.setLocationRelativeTo(null);
        JLabel l1 = new JLabel("Cédula del destinatario:");
        JTextField t1 = new JTextField();
        JLabel l2 = new JLabel("Monto:");
        JTextField t2 = new JTextField();
        JButton btn = new JButton("Transferir");
        l1.setBounds(30, 30, 200, 25);
        t1.setBounds(30, 60, 250, 25);
        l2.setBounds(30, 90, 150, 25);
        t2.setBounds(30, 120, 250, 25);
        btn.setBounds(100, 160, 120, 30);
        transVentana.add(l1);
        transVentana.add(t1);
        transVentana.add(l2);
        transVentana.add(t2);
        transVentana.add(btn);
        btn.addActionListener(e -> {
            try {
                String cedula = t1.getText();
                double monto = Double.parseDouble(t2.getText());
                Cuenta destino = Menu.banco.buscarCuentaPorCedula(cedula);

                if (destino != null) {
                    cuenta.transferir(destino, monto);
                    JOptionPane.showMessageDialog(transVentana, "Transferencia exitosa a " + destino.getCliente().getNombre());
                } else {
                    cuenta.retirar(monto);
                    JOptionPane.showMessageDialog(transVentana, "Transferencia externa registrada.");
                }
                transVentana.dispose();
            } catch (FondosInsuficientes ex) {
                JOptionPane.showMessageDialog(transVentana, ex.getMessage());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(transVentana, "Datos inválidos.");
            }
        });
        transVentana.setVisible(true);
    }
    private void mostrarHistorial() {
        JFrame histVentana = new JFrame("Historial de Transacciones");
        histVentana.setSize(400, 300);
        histVentana.setLayout(null);
        histVentana.setLocationRelativeTo(null);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(20, 20, 340, 200);
        String texto = "";
        for (int i = 0; i < 100; i++) {
            Transaccion t = cuenta.obtenerTransaccion(i);
            if (t != null) {
                texto += (i + 1) + ". " + t.getDetalle() + "\n";
            }
        }
        if (texto.isEmpty()) texto = "No hay transacciones registradas.";
        area.setText(texto);
        histVentana.add(scroll);
        histVentana.setVisible(true);
    }
}

