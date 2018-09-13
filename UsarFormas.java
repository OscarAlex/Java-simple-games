import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * UsarFormas
 */
public class UsarFormas extends JFrame implements ActionListener
{
    //private JButton botonCirc,botonCuad;
    private JPanel panel;
    private Circulo miCirc;
    private Cuadrado miCuad;
    private javax.swing.Timer tempo;
    public static void main(String args[])
    {
        UsarFormas ventana= new UsarFormas();
        ventana.setSize(220,330);
        ventana.crearGUI();
        ventana.setVisible(true);
    }
    
    private void crearGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contenedor= getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        panel= new JPanel();
        panel.setPreferredSize(new Dimension(150,250));
        panel.setBackground(Color.white);
        contenedor.add(panel);
        /*
        botonCirc= new JButton("Circulo");
        contenedor.add(botonCirc);
        botonCirc.addActionListener(this);
        
        botonCuad= new JButton("Cuadrado");
        contenedor.add(botonCuad);
        botonCuad.addActionListener(this);
        */
        miCirc= new Circulo();
        miCuad= new Cuadrado();
        
        miCirc.x= (int)(Math.random()*131);
        miCirc.y= (int)(Math.random()*231);
        miCirc.dir= (int)(Math.random()*4);
        
        miCuad.x= (int)(Math.random()*131);
        miCuad.y= (int)(Math.random()*231);
        miCuad.dir= (int)(Math.random()*7);
        
        tempo= new javax.swing.Timer(10,this);
        tempo.start();
    }
    
    public void actionPerformed(ActionEvent event)
    {
        Graphics papel= panel.getGraphics();
        
        papel.setColor(Color.white);
        papel.fillRect(0,0,150,250);
        papel.setColor(Color.black);
        /*
        miCirc.moverArr();
        miCirc.mostrar(papel);
        miCuad.moverDer();
        miCuad.mostrar(papel);
        */
        
        //><
        if(miCirc.x <=1 || miCirc.x >=127 || miCirc.y >=228 || miCirc.y <=0)
        {
            if(miCirc.dir >=0 && miCirc.dir <=2)
            {
                miCirc.dir+=5;
            }
            else
            {
                miCirc.dir= Math.abs(miCirc.dir+5-8);
            }
        }
        miCirc.mostrar(papel);
        if(miCirc.dir==0 && miCirc.y >=1)
        {
            miCirc.moverArr();
        }
        else if(miCirc.dir==2 && miCirc.x <=126)
        {
            miCirc.moverDer();
        }
        else if(miCirc.dir==4 && miCirc.y <=227)
        {
            miCirc.moverAba();
        }
        else if(miCirc.dir==6 && miCirc.x >=2)
        {
            miCirc.moverIzq();
        }
        
        else if(miCirc.dir==1 && miCirc.x <=126 && miCirc.y >=1)
        {
            miCirc.moverArrD();
        }
        else if(miCirc.dir==3 && miCirc.x <=126 && miCirc.y <=227)
        {
            miCirc.moverAbaD();
        }
        else if(miCirc.dir==5 && miCirc.x >=2 && miCirc.y <=227)
        {
            miCirc.moverAbaI();
        }
        else if(miCirc.dir==7 && miCirc.x >=2 && miCirc.y >=1)
        {
            miCirc.moverArrI();
        }
        
        if(miCuad.x <=1 || miCuad.x >=127 || miCuad.y >=228 || miCuad.y <=0)
        {
            if(miCuad.dir >=0 && miCuad.dir <=2)
            {
                miCuad.dir+=5;
            }
            else
            {
                miCuad.dir= Math.abs(miCuad.dir+5-8);
            }
        }
        miCuad.mostrar(papel);
        if(miCuad.dir==0 && miCuad.y >=1)
        {
            miCuad.moverArr();
        }
        else if(miCuad.dir==2 && miCuad.x <=126)
        {
            miCuad.moverDer();
        }
        else if(miCuad.dir==4 && miCuad.y <=227)
        {
            miCuad.moverAba();
        }
        else if(miCuad.dir==6 && miCuad.x >=2)
        {
            miCuad.moverIzq();
        }
        
        else if(miCuad.dir==1 && miCuad.x <=126 && miCuad.y >=1)
        {
            miCuad.moverArrD();
        }
        else if(miCuad.dir==3 && miCuad.x <=126 && miCuad.y <=227)
        {
            miCuad.moverAbaD();
        }
        else if(miCuad.dir==5 && miCuad.x >=2 && miCuad.y <=227)
        {
            miCuad.moverAbaI();
        }
        else if(miCuad.dir==7 && miCuad.x >=2 && miCuad.y >=1)
        {
            miCuad.moverArrI();
        }
        /*
        if(event.getSource() == botonCirc)
        {
            miCirc.moverDer();
            miCirc.mostrar(papel);
        }
        else if(event.getSource() == botonCuad)
        {
            miCuad.moverDer();
            miCuad.mostrar(papel);
        }
        */
    }
}
