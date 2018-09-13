//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Timer;
/**
 * Usar Burbuja
 */
public class UsarBurbuja extends JFrame implements ActionListener
{
    private JButton botonMoverDer, botonMoverIzq,botonMoverAba,botonMoverArr;
    private JPanel panel;
    private Burbuja miBurbuja;
    private Timer tempo;
    
    public static void main(String args[])
    {
        UsarBurbuja ventana= new UsarBurbuja();//Crear ventana
        ventana.setSize(220,370);//De este tamaño
        ventana.crearGUI();//Con estos objetos
        ventana.setVisible(true);//Muestrala
    }
    
    private void crearGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Param. actual
        Container contenedor= getContentPane();
        contenedor.setLayout(new FlowLayout());//Param. actual - Distrib centrada
        
        panel= new JPanel();
        panel.setPreferredSize(new Dimension(150,250));//Param. actual
        panel.setBackground(Color.white);//Param. actual y atributo porque no tiene paréntesis
        contenedor.add(panel);
        
        botonMoverArr= new JButton("Arriba");
        contenedor.add(botonMoverArr);
        botonMoverArr.addActionListener(this);
        
        botonMoverAba= new JButton("Abajo");
        contenedor.add(botonMoverAba);
        botonMoverAba.addActionListener(this);
        
        botonMoverIzq= new JButton("Izquierda");
        contenedor.add(botonMoverIzq);
        botonMoverIzq.addActionListener(this);
        
        botonMoverDer= new JButton("Derecha");
        contenedor.add(botonMoverDer);
        botonMoverDer.addActionListener(this);
        
        miBurbuja= new Burbuja();
        tempo= new Timer(100,this);//Timer(Tiempo en miliseg, Esta ventana)
        tempo.start();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        Graphics papel= panel.getGraphics();//Del panel toma la parte gráfica
        //miBurbuja.moverDer();
        
        if(event.getSource() == botonMoverDer)
        {
            miBurbuja.moverDer();
        }
        else if(event.getSource() == botonMoverIzq)
        {
            miBurbuja.moverIzq();
        }
        else if(event.getSource() == botonMoverAba)
        {
            miBurbuja.moverAba();
        }
        else if(event.getSource() == botonMoverArr)
        {
            miBurbuja.moverArr();
        }
        
        papel.setColor(Color.white);
        papel.fillRect(0,0,150,250);
        papel.setColor(Color.black);
        miBurbuja.mostrar(papel,2);
    }
}
