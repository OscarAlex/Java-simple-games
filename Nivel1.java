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

public class Nivel1 extends JFrame implements MouseListener{
    int botonSize=80; //tamaño de los botones 
    int xRatonAnt, yRatonAnt, xRatonAct, yRatonAct; // posiciones del raton en el panel
    int botonPressed; //1=boton 1, 2=boton 2, 0=ninguno
    int f1=1, c1=1, f2=4, c2=6; //fila y columna de los botones boton 1 y boton 2
    int fGanar1=4, cGanar1=7; // fila y columna de ganar boton 1
    int fGanar2=5, cGanar2=8; //ganar boton 2
    JButton meta1 = new RoundButton();//botones de meta
    JButton meta2 = new RoundButton();
    JButton [][]botones = new JButton[10][12]; //Matriz de botones
    public static void main(String[] args) {
        Nivel1 window = new Nivel1();
        window.setVisible(true);
        window.setPreferredSize(new Dimension(980,870));
        window.pack();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public Nivel1(){
        super("Nivel 1");
        Container contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(960,800));
        panel.setBackground(Color.white);
        contenedor.add(panel);
        panel.addMouseListener(this);
        
        for (int f=0; f<botones.length; f++) {
            for(int c=0; c<botones[f].length; c++) {
                //Colocar los botones de fondo del panel
                if(f==0||f==botones.length-1||c==0||c==botones[f].length-1||(f==5&&c==1)||(f==4&&c==8)){
                    botones[f][c]=new JButton();
                    botones[f][c].setBounds(c*botonSize, f*botonSize, botonSize, botonSize);
                    botones[f][c].setBackground(new Color(52,73,94));
                    panel.add(botones[f][c]);
                    
                }
                //Colocar botones Rojos
                if((f==f1&&c==c1)||(f==f2&&c==c2)){
                    botones[f][c]=new JButton();
                    if(f==f1&&c==c1){
                        botones[f][c].setBackground(new Color(255,51,0));
                    }else if(f==f2&&c==c2){
                        botones[f][c].setBackground(new Color(0,126,229));
                    }
                    botones[f][c].setBounds(c*botonSize, f*botonSize, botonSize, botonSize);
                    panel.add(botones[f][c]);
                    botones[f][c].setBorder(null);
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
        } else
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
        }
        for (int f=0; f<botones.length; f++) {
            for (int c=0; c<botones[f].length; c++) {
                if(f==0||f==botones.length-1||c==0||c==botones[f].length-1||(f==5&&c==1)||(f==4&&c==8)
                ||(botonPressed==1&&f==f2&&c==c2)||(botonPressed==2&&f==f1&&c==c1)){ //botones prohibidos
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
                }
            }
            click++;
        }
        
        //Ganar
        if(c1==cGanar1 && f1==fGanar1 && c2==cGanar2 && f2==fGanar2 )
        {
            JOptionPane.showMessageDialog(null,"Nivel 1 - Completado\nMovimientos= "+click);
            Nivel2.main(null);
            super.dispose();
        }
        //System.out.println("Movimient= "+click);
    }
    int click=0;
    
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}
