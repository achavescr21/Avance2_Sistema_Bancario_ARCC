

public class Banco {
    private Cuenta[] cuentas = new Cuenta[50];
    private int totalCuentas = 0;
    public void agregarCuenta(Cuenta cuenta) {
        if (totalCuentas < cuentas.length) {
            cuentas[totalCuentas++] = cuenta;
        }
    }
    public Cuenta buscarCuentaPorCedulaYPin(String cedula, String pin) {
        for (int i = 0; i < totalCuentas; i++) {
            Cliente c = cuentas[i].getCliente();
            if (c.getCedula().equals(cedula) && c.getPin().equals(pin)) {
                return cuentas[i];
            }
        }
        return null;
    }
    public Cuenta buscarCuentaPorCedula(String cedula) {
        for (int i = 0; i < totalCuentas; i++) {
            if (cuentas[i].getCliente().getCedula().equals(cedula)) {
                return cuentas[i];
            }
        }
        return null;
    }
}


