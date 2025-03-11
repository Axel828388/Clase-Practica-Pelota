package Practica2G1;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    Lienzo L = new Lienzo();
    public VentanaPrincipal(){
        setTitle("Interfaz de Dibujo");
        this.setBounds(100, 50, 900, 900);
        add(L);
        setLayout(null );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}