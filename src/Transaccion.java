

public class Transaccion {
    private String tipo;
    private double monto;
    public Transaccion(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }
    public String getDetalle() {
        return tipo + " por ₡" + monto;
    }
}



