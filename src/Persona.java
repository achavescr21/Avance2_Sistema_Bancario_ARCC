

public class Persona {
    protected String nombre;
    protected String cedula;
    protected int edad;
    protected String correo;
    protected String celular;
    public Persona(String nombre, String cedula, int edad, String correo, String celular) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.correo = correo;
        this.celular = celular;
    }
    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public int getEdad() { return edad; }
    public String getCorreo() { return correo; }
    public String getCelular() { return celular; }
}

