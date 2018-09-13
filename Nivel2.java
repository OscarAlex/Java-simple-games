import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component;

class Nivel2 extends JFrame implements MouseListener
{
    int botonSize=80; //tamaño de los botones 
    int xRatonAnt, yRatonAnt, xRatonAct, yRatonAct; // posiciones del raton en el panel
    int botonPressed; //1=boton 1, 2=boton 2, 0=ninguno
    int f1=1, c1=1, f2=1, c2=2, f3=1, c3=3, f4=1, c4=4; //fila y columna de los botones boton 1 y boton 2
    int fGanar1=3, cGanar1=2; // fila y columna de ganar boton 1
    int fGanar2=6, cGanar2=7; //ganar boton 2
    int fGanar3=3, cGanar3=8; // fila y columna de ganar boton 1
    int fGanar4=2, cGanar4=5; //ganar boton 2
    JButton meta1 = new RoundButton();//botones de meta
    JButton meta2 = new RoundButton();
    JButton meta3 = new RoundButton();//botones de meta
    JButton meta4 = new RoundButton();
    JButton [][]botones = new JButton[8][11]; //Matriz de botones
    public static void main(String[] args) {
        Nivel2 window = new Nivel2();
        window.setVisible(true);
        window.setPreferredSize(new Dimension(900,690));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Nivel2(){
        super("Nivel 1");
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(880,640));
        panel.setBackground(Color.white);
        contenedor.add(panel);
        panel.addMouseListener(this);
        panel.setBackground(new Color(236,240,241));
        for (int f=0; f<botones.length; f++) {
            for(int c=0; c<botones[f].length; c++) {
                //Colocar los botones de fondo del panel
                if(f==0||f==botones.length-1||c==0||c==botones[f].length-1|| c == 5 && f==1 || c == 6 && f==2 || c==8 && f==2 || 
                c==1 && f==3 || c==2 && f==4 || c==4 && f==4 || c==6 && f==4 || c==7 && f==5 || c==9 && f==5 || c==4 && f==6 || c==6 && f==6 || c==9 && f==6 || c==9 && f==3){
                    botones[f][c]=new JButton();
                    botones[f][c].setBounds(c*botonSize, f*botonSize, botonSize, botonSize);
                    botones[f][c].setBackground(new Color(52,73,94));
                    panel.add(botones[f][c]);
                }
                //Colocar botones Rojos
                if((f==f1&&c==c1)||(f==f2&&c==c2) || (f==f3&&c==c3) || (f==f4&&c==c4)){
                    botones[f][c]=new JButton();
                    if(f==f1&&c==c1){
                        botones[f][c].setBackground(new Color(255,51,0));
                    }else if(f==f2&&c==c2){
                        botones[f][c].setBackground(new Color(0,126,229));
                    }else if(f==f3&&c==c3){
                        botones[f][c].setBackground(new Color(9,184,62));
                    }else if(f==f4&&c==c4){
                        botones[f][c].setBackground(new Color(65,0,147));
                    }
                    botones[f][c].setBounds(c*botonSize, f*botonSize, botonSize, botonSize);
                    panel.add(botones[f][c]);
                    botones[f][c].addMouseListener(this);
                }
            }
        }
        meta1.setBounds(cGanar1*botonSize,fGanar1*botonSize,botonSize,botonSize);
        meta1.setBackground(new Color(255,51,0));
        panel.add(meta1);
        meta2.setBounds(cGanar2*botonSize,fGanar2*botonSize,botonSize,botonSize);
        meta2.setBackground(new Color(0,126,229));
        panel.add(meta2);
        meta3.setBounds(cGanar3*botonSize,fGanar3*botonSize,botonSize,botonSize);
        meta3.setBackground(new Color(9,184,62));
        panel.add(meta3);
        meta4.setBounds(cGanar4*botonSize,fGanar4*botonSize,botonSize,botonSize);
        meta4.setBackground(new Color(65,0,147));
        panel.add(meta4);
    }

    public void mousePressed(MouseEvent e){
        //Coordenadas del raton ANTES
        if (e.getSource()==botones[f1][c1]){//Si el boton presionado es el boton 1
            xRatonAnt=botones[f1][c1].getX()+e.getX();
            yRatonAnt=botones[f1][c1].getY()+e.getY();
            botonPressed=1;
        } else if (e.getSource()==botones[f2][c2]) { //Si el boton presionado es el boton 2
            xRatonAnt=botones[f2][c2].getX()+e.getX();
            yRatonAnt=botones[f2][c2].getY()+e.getY();
            botonPressed=2;
        } else if(e.getSource()==botones[f3][c3]){
            xRatonAnt=botones[f3][c3].getX()+e.getX();
            yRatonAnt=botones[f3][c3].getY()+e.getY();
            botonPressed=3;
        }else if(e.getSource()==botones[f4][c4]){
            xRatonAnt=botones[f4][c4].getX()+e.getX();
            yRatonAnt=botones[f4][c4].getY()+e.getY();
            botonPressed=4;
        }else
            botonPressed=0;
    }

    public void mouseReleased(MouseEvent e){
        //Coordenadas del raton ACTUALES
        if (e.getSource()==botones[f1][c1]) { //Si el boton presionado fue el 1
            xRatonAct=botones[f1][c1].getX()+e.getX();
            yRatonAct=botones[f1][c1].getY()+e.getY();
        } else if (e.getSource()==botones[f2][c2]) { //Si el boton presionado fue el 2
            xRatonAct=botones[f2][c2].getX()+e.getX();
            yRatonAct=botones[f2][c2].getY()+e.getY();
        } else if(e.getSource()==botones[f3][c3]){
            xRatonAct=botones[f3][c3].getX()+e.getX();
            yRatonAct=botones[f3][c3].getY()+e.getY();
        }else if(e.getSource()==botones[f4][c4]){
            xRatonAct=botones[f4][c4].getX()+e.getX();
            yRatonAct=botones[f4][c4].getY()+e.getY();
        }
        for (int f=0; f<botones.length; f++) {
            for (int c=0; c<botones[f].length; c++) {
                if(f==0||f==botones.length-1||c==0||c==botones[f].length-1||(f==5&&c==1)||(f==4&&c==8)
                ||(botonPressed==1&&f==f2&&c==c2)|| (botonPressed==1&&f==f3&&c==c3)||(botonPressed==1&&f==f4&&c==c4) ||
                (botonPressed==2&&f==f1&&c==c1)|| (botonPressed==2&&f==f3&&c==c3)||(botonPressed==2&&f==f4&&c==c4)||
                (botonPressed==3&&f==f2&&c==c2)|| (botonPressed==3&&f==f1&&c==c1)||(botonPressed==3&&f==f4&&c==c4)||
                (botonPressed==4&&f==f2&&c==c2)|| (botonPressed==4&&f==f3&&c==c3)||(botonPressed==4&&f==f1&&c==c1)){ //botones prohibidos
                  if ((xRatonAct>c*botonSize&&xRatonAct<c*botonSize+botonSize)
                    &&(yRatonAct>f*botonSize&&yRatonAct<f*botonSize+botonSize)) // Raton se levanta dentro de estos botones
                        botonPressed=0; //es como si ningun boton fue presionado
                }
            }
        }

        //DIRECCION del raton
        int fAux=0, cAux=0;
        if (Math.abs(yRatonAct-yRatonAnt)>Math.abs(xRatonAct-xRatonAnt)&&botonPressed!=0) { //Movimiento vertical
            if (yRatonAct>yRatonAnt) {//hacia abajo
                if (botonPressed==1) {
                    fAux=f1;
                    while(botones[fAux+1][c1]==null)
                        fAux++;
                    botones[fAux][c1]=botones[f1][c1];
                    botones[f1][c1]=null;
                    f1=fAux;
                    botones[f1][c1].setLocation(c1*botonSize, f1*botonSize);
                } 
                if (botonPressed==2) {
                    fAux=f2;
                    while(botones[fAux+1][c2]==null)
                        fAux++;
                    botones[fAux][c2]=botones[f2][c2];
                    botones[f2][c2]=null;
                    f2=fAux;
                    botones[f2][c2].setLocation(c2*botonSize, f2*botonSize);
                }
                if (botonPressed==3) {
                    fAux=f3;
                    while(botones[fAux+1][c3]==null)
                        fAux++;
                    botones[fAux][c3]=botones[f3][c3];
                    botones[f3][c3]=null;
                    f3=fAux;
                    botones[f3][c3].setLocation(c3*botonSize, f3*botonSize);
                }
                if (botonPressed==4) {
                    fAux=f4;
                    while(botones[fAux+1][c4]==null)
                        fAux++;
                    botones[fAux][c4]=botones[f4][c4];
                    botones[f4][c4]=null;
                    f4=fAux;
                    botones[f4][c4].setLocation(c4*botonSize, f4*botonSize);
                }
            }
            else if (yRatonAct<yRatonAnt) {//hacia arriba
                if (botonPressed==1) {
                    fAux=f1;
                    while(botones[fAux-1][c1]==null)
                        fAux--;
                    botones[fAux][c1]=botones[f1][c1];
                    botones[f1][c1]=null;
                    f1=fAux;
                    botones[f1][c1].setLocation(c1*botonSize, f1*botonSize);
                }
                if (botonPressed==2) {
                    fAux=f2;
                    while(botones[fAux-1][c2]==null)
                        fAux--;
                    botones[fAux][c2]=botones[f2][c2];
                    botones[f2][c2]=null;
                    f2=fAux;
                    botones[f2][c2].setLocation(c2*botonSize, f2*botonSize);
                }
                if (botonPressed==3) {
                    fAux=f3;
                    while(botones[fAux-1][c3]==null)
                        fAux--;
                    botones[fAux][c3]=botones[f3][c3];
                    botones[f3][c3]=null;
                    f3=fAux;
                    botones[f3][c3].setLocation(c3*botonSize, f3*botonSize);
                }
                if (botonPressed==4) {
                    fAux=f4;
                    while(botones[fAux-1][c4]==null)
                        fAux--;
                    botones[fAux][c4]=botones[f4][c4];
                    botones[f4][c4]=null;
                    f4=fAux;
                    botones[f4][c4].setLocation(c4*botonSize, f4*botonSize);
                }
            }
            click++;
        } else if (Math.abs(yRatonAct-yRatonAnt)<Math.abs(xRatonAct-xRatonAnt)&&botonPressed!=0) { //Movimiento horizontal
            if (xRatonAct>xRatonAnt) {//a la derecha
                if (botonPressed==1) {
                    cAux=c1;
                    while(botones[f1][cAux+1]==null)
                        cAux++;
                    botones[f1][cAux]=botones[f1][c1];
                    botones[f1][c1]=null;
                    c1=cAux;
                    botones[f1][c1].setLocation(c1*botonSize, f1*botonSize);
                } else if (botonPressed==2) {
                    cAux=c2;
                    while(botones[f2][cAux+1]==null)
                        cAux++;
                    botones[f2][cAux]=botones[f2][c2];
                    botones[f2][c2]=null;
                    c2=cAux;
                    botones[f2][c2].setLocation(c2*botonSize, f2*botonSize);
                }else if (botonPressed==3) {
                    cAux=c3;
                    while(botones[f3][cAux+1]==null)
                        cAux++;
                    botones[f3][cAux]=botones[f3][c3];
                    botones[f3][c3]=null;
                    c3=cAux;
                    botones[f3][c3].setLocation(c3*botonSize, f3*botonSize);
                } else if (botonPressed==4) {
                    cAux=c4;
                    while(botones[f4][cAux+1]==null)
                        cAux++;
                    botones[f4][cAux]=botones[f4][c4];
                    botones[f4][c4]=null;
                    c4=cAux;
                    botones[f4][c4].setLocation(c4*botonSize, f4*botonSize);
                }
            }
            else if (xRatonAct<xRatonAnt) {//a la izquierda
                if (botonPressed==1) {
                    cAux=c1;
                    while(botones[f1][cAux-1]==null)
                        cAux--;
                    botones[f1][cAux]=botones[f1][c1];
                    botones[f1][c1]=null;
                    c1=cAux;
                    botones[f1][c1].setLocation(c1*botonSize, f1*botonSize);
                } else if (botonPressed==2) {
                    cAux=c2;
                    while(botones[f2][cAux-1]==null)
                        cAux--;
                    botones[f2][cAux]=botones[f2][c2];
                    botones[f2][c2]=null;
                    c2=cAux;
                    botones[f2][c2].setLocation(c2*botonSize, f2*botonSize);
                }else if (botonPressed==3) {
                    cAux=c3;
                    while(botones[f3][cAux-1]==null)
                        cAux--;
                    botones[f3][cAux]=botones[f3][c3];
                    botones[f3][c3]=null;
                    c3=cAux;
                    botones[f3][c3].setLocation(c3*botonSize, f3*botonSize);
                } else if (botonPressed==4) {
                    cAux=c4;
                    while(botones[f4][cAux-1]==null)
                        cAux--;
                    botones[f4][cAux]=botones[f4][c4];
                    botones[f4][c4]=null;
                    c4=cAux;
                    botones[f4][c4].setLocation(c4*botonSize, f4*botonSize);
                }
            }
            click++;
        }
        
        //Ganar
        if(c1==cGanar1 && f1==fGanar1 && c2==cGanar2 && f2==fGanar2 && c3==cGanar3 && f3==fGanar3 && c4==cGanar4 && f4==fGanar4)
        {
            JOptionPane.showMessageDialog(null,"Ultimo nivel completado\nMovimientos= "+click);
            super.dispose();
        }
    }
    int click=0;
    
    public void mouseClicked(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
   
}

class RoundButton extends JButton {

    public RoundButton() {
        setBackground(Color.lightGray);
        setFocusable(false);
        Dimension size = getPreferredSize();
        size.width = size.height = 20;
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.gray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(60/2, 60/2, 19, 19);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(null);
        g.drawOval(70/2, 70/2, 0, 0);
    }
    Shape forma;
    public boolean contains(int x, int y) {
        if (forma == null || !forma.getBounds().equals(getBounds())) {
            forma = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return forma.contains(x, y);
    }
}
