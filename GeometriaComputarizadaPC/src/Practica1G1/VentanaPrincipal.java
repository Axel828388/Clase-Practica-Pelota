package Practica1G1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
    private int x=30, y=50;
    private int dx=5, dy=5;
    private final int RADIO = 50;
    Timer timer;
    
    public VentanaPrincipal(){
        setTitle("Interfaz de Dibujo");
        this.setBounds(100, 50, 900, 900);
        setLayout(null );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rebotar();
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(200,200,80));
        g.fillOval(x,y,RADIO,RADIO);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x+=dx;
        y+=dy;
        
        if(x <=0 || x+RADIO >= this.getWidth())
            dx *= -1;
        if(y <=0 || y+RADIO >= this.getHeight())
            dy *= -1;
                
        repaint();
    }
    private void rebotar(){
        timer = new Timer(10, this);
        timer.start();
    }
}
