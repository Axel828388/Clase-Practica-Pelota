package Practica2G1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class Lienzo extends JPanel implements ActionListener {
    private int x = 10;
    private int y = 10;
    private int dx = 5;
    private int dy = 5;
    private final int RADIO = 50;
    Timer timer;

    public Lienzo(){
        // Se usa un layout nulo solo para efectos del borde y dimensiones; 
        // el tamaño se controla mediante el contenedor principal.
        setLayout(null);
        setBorder(new EtchedBorder());
        setPreferredSize(new Dimension(865,700));
        // Ya no se inicia el rebote automáticamente.
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x, y, RADIO, RADIO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;
        if(x <= 0 || x + RADIO >= this.getWidth()){
            dx *= -1;
        }
        if(y <= 0 || y + RADIO >= this.getHeight()){
            dy *= -1;
        }
        repaint();
    }

    // Método para iniciar el rebote
    public void iniciarRebote(){
        if(timer == null){
            timer = new Timer(5, this);
        }
        if(!timer.isRunning()){
            timer.start();
        }
    }

    // Método para detener el rebote y reiniciar la posición de la pelotita
    public void detenerRebote(){
        if(timer != null && timer.isRunning()){
            timer.stop();
        }
        // Reinicia la posición
        x = 10;
        y = 10;
        repaint();
    }
}
