

public class Cliente extends Persona {
    private String pin;
    public Cliente(String nombre, String cedula, int edad, String correo, String celular, String pin) {
        super(nombre, cedula, edad, correo, celular);
        this.pin = pin;
    }
    public String getPin() { return pin; }
}


