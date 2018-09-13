import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class UsarCuadro extends JFrame implements ActionListener, MouseMotionListener, MouseListener
{
    private JButton botonJugar;
    private JPanel panel;
    private boolean arrastrando = false;
    private Pieza [][] piezas = new Pieza [4][4];
    private int [][] ganar = new int [4][4];
    private int [][] piezas2 = new int [4][4];
    private int xAnt, yAnt,fAct, cAct, fVac, cVac;

    public static void main(String [] args) 
    {
        UsarCuadro ventana = new UsarCuadro();
        ventana.setSize(850, 1000);
        ventana.crearGUI();
        ventana.setVisible(true);
    }

    private void crearGUI() 
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(800,800));
        panel.setBackground(Color.white);
        panel.addMouseMotionListener(this);
        panel.addMouseListener(this);
        contenedor.add(panel);

        botonJugar = new JButton ("Jugar");
        contenedor.add(botonJugar);
        botonJugar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) 
    {
        panel.removeAll();
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.black);
        for (int f= 0; f<4; f++) 
        {
            for(int c= 0; c<4; c++) 
            {
                piezas[f][c] = new Pieza(f*200,c*200);
                panel.add(piezas[f][c]);
            }
        }
        int n = 1;
        for (int f= 0; f<4; f++) 
        {
            for(int c= 0; c<4; c++) 
            {
                ganar[f][c] = n;
                n++;
            }
        }
        int f,c,i;
        for(i=1; i<=16; i++) {
            f = (int)(Math.random()*4);
            c = (int)(Math.random()*4);
            if(piezas[f][c].getNum() == 0) 
            {
                piezas[f][c].setNum(i); 
                piezas2[f][c]=i;
                if(piezas[f][c].getNum()!=16)
                {
                    piezas[f][c].draw(papel);
                }
            }
            else 
            {
                while(piezas[f][c].getNum() != 0) 
                {
                    f = (int)(Math.random()*4); 
                    c = (int)(Math.random()*4);
                }
                piezas[f][c].setNum(i); 
                piezas2[f][c]=i;
                piezas[f][c].draw(papel);
                if(i == 16)
                {
                    papel.setColor(Color.white); 
                    papel.fillRect(f*200, c*200, 200, 200);
                }
            }
        }
    }

    public void repaint() {
        Graphics papel = panel.getGraphics();
        papel.setColor(Color.black);
        for (int f2 = 0; f2 < 4; f2++)
        {
            for(int c2 = 0; c2 < 4; c2++) 
            {
                if (piezas[f2][c2].getNum() != piezas[fAct][cAct].getNum() && piezas[f2][c2].getNum() != 16)
                {
                    piezas[f2][c2].draw(papel);
                }    
                else if (piezas[f2][c2].getNum() == 16)
                {
                    papel.setColor(Color.white); 
                    papel.fillRect(f2*200, c2*200, 200, 200); 
                    fVac=f2;
                    cVac=c2;
                }
            }
        }
        //piezas[fAct][cAct].draw(papel);
    }

    public void mouseDragged(MouseEvent e)
    {
        if ((fAct == fVac && (cAct == cVac-1 || cAct == cVac+1)) || (cAct == cVac && (fAct == fVac-1 || fAct == fVac+1))) {
            piezas[fAct][cAct].setX(piezas[fAct][cAct].getX() + e.getX() - xAnt);
            piezas[fAct][cAct].setY(piezas[fAct][cAct].getY() + e.getY() - yAnt);
            xAnt = e.getX();
            yAnt = e.getY();
            repaint();
        }
    }
    
    public void mouseMoved(MouseEvent e) {}
    
    public void mousePressed(MouseEvent e)
    {
        fAct = e.getX()/200;
        cAct = e.getY()/200;
        xAnt = e.getX();
        yAnt = e.getY();
    }

    public void mouseReleased(MouseEvent e)
    {
        if ((fAct == fVac && (cAct == cVac-1 || cAct == cVac+1)) || (cAct == cVac && (fAct == fVac-1 || fAct == fVac+1))) 
        {
            if (e.getX() >= piezas[fVac][cVac].getX() && e.getX() < piezas[fVac][cVac].getX()+200 
            && e.getY() >= piezas[fVac][cVac].getY() && e.getY() < piezas[fVac][cVac].getY()+200){
                piezas[fVac][cVac].setNum(piezas[fAct][cAct].getNum());
                piezas[fAct][cAct].setNum(16);
                piezas[fAct][cAct].setX(fAct*200);
                piezas[fAct][cAct].setY(cAct*200);
                for (int f=0; f<4; f++) 
                {
                    for(int c=0; c<4; c++) 
                    {
                        piezas2[f][c]=piezas[c][f].getNum();
                    }
                }
                int b = 0;
                for (int f=0; f<4; f++)
                {
                    for(int c=0; c<4; c++) 
                    {
                        if(piezas2[f][c]==ganar[f][c])
                        {
                            b = 1;
                        }
                        else
                        {
                            b = 0;
                            break;
                        }
                    }
                }
                repaint();
                if (b==1)
                {    
                    JOptionPane.showMessageDialog(null,"Ganaste");
                }   
            } 
            else 
            {
                piezas[fAct][cAct].setX(fAct*200);
                piezas[fAct][cAct].setY(cAct*200);
                repaint();
            }
        }
    }

    public void mouseClicked(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
}