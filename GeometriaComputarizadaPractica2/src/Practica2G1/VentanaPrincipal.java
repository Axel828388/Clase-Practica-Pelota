package Practica2G1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame {
    Lienzo L = new Lienzo();
    
    public VentanaPrincipal(){
        setTitle("Interfaz de Dibujo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 50, 900, 900);
        setLayout(new BorderLayout());
        
        // Agregamos el panel de dibujo al centro
        add(L, BorderLayout.CENTER);
        
        // Panel inferior para los botones, centrados horizontalmente
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnIniciar = new JButton("Iniciar");
        JButton btnDetenerReiniciar = new JButton("Detener y Reiniciar");
        
        // Acción para iniciar el rebote
        btnIniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                L.iniciarRebote();
            }
        });
        
        // Acción para detener el rebote y reiniciar la posición
        btnDetenerReiniciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                L.detenerRebote();
            }
        });
        
        panelBotones.add(btnIniciar);
        panelBotones.add(btnDetenerReiniciar);
        
        // Agregamos el panel inferior a la ventana
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
}
