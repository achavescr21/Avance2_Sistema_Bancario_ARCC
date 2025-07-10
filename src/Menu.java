import javax.swing.*;

public class Menu extends JFrame {
    public static Banco banco = new Banco();
    public Menu() {
        setTitle("Sistema Bancario");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        JButton crearBtn = new JButton("Crear Cuenta");
        JButton loginBtn = new JButton("Iniciar Sesión");
        JButton salirBtn = new JButton("Salir");
        crearBtn.setBounds(120, 40, 150, 30);
        loginBtn.setBounds(120, 100, 150, 30);
        salirBtn.setBounds(120, 160, 150, 30);
        add(crearBtn);
        add(loginBtn);
        add(salirBtn);
        crearBtn.addActionListener(e -> new CreacionDeCuentas().setVisible(true));
        loginBtn.addActionListener(e -> new IniciarSesion().setVisible(true));
        salirBtn.addActionListener(e -> System.exit(0));
    }
}
