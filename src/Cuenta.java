import javax.swing.*;

public class Cuenta {
    private Cliente cliente;
    private double saldo;
    private Transaccion[] historial;
    private int cantidadTransacciones;
    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0.0;
        this.historial = new Transaccion[100];
        this.cantidadTransacciones = 0;
    }
    public void depositar(double monto) {
        saldo += monto;
        registrarTransaccion("Depósito", monto);
    }
    public void retirar(double monto) throws FondosInsuficientes {
        if (monto <= saldo) {
            saldo -= monto;
            registrarTransaccion("Retiro", monto);
        } else {
            throw new FondosInsuficientes("Fondos insuficientes para retiro.");
        }
    }
    public boolean transferir(Cuenta destino, double monto) throws FondosInsuficientes {
        if (monto <= saldo) {
            this.retirar(monto);
            destino.depositar(monto);
            registrarTransaccion("Transferencia a " + destino.getCliente().getNombre(), monto);
            return true;
        } else {
            throw new FondosInsuficientes("Saldo insuficiente para transferir.");
        }
    }
    public void registrarTransaccion(String tipo, double monto) {
        if (cantidadTransacciones < historial.length) {
            historial[cantidadTransacciones++] = new Transaccion(tipo, monto);
        }
    }
    public void imprimirHistorial() {
        String texto = "";
        for (int i = 0; i < cantidadTransacciones; i++) {
            texto += (i + 1) + ". " + historial[i].getDetalle() + "\n";
        }
        if (texto.isEmpty()) texto = "No hay transacciones registradas.";
        JOptionPane.showMessageDialog(null, texto, "Historial", JOptionPane.INFORMATION_MESSAGE);
    }
    public Cliente getCliente() { return cliente; }
    public double getSaldo() { return saldo; }
    public Transaccion obtenerTransaccion(int i) {
    if (i >= 0 && i < cantidadTransacciones) {
        return historial[i];
    }
    return null;
}
}


