import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
public class Pieza extends JPanel //implements MouseListener
{
    private int x = 0;
    private int y = 0;
    private int num = 0;
    private Color color = Color.black;
    
    public Pieza(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void draw(Graphics cuadro) {
        Font font = new Font ("",0,45);
        cuadro.setColor(Color.black);
        cuadro.fillRect(x, y, 200, 200);
        cuadro.setColor(Color.white);
        cuadro.drawRect(x, y, 200, 200);
        cuadro.setFont(font);
        cuadro.drawString(getNum()+"", x+100, y+100);
    }
    
    public void setColor(Color newColor){
        color = newColor;
    }
    
    public int getX(){
        return x;
    }
    public void setX(int newX){
        x = newX;
    }
    
    public int getY(){
        return y;
    }
    public void setY(int newY){
        y = newY;
    }
    
    public int getNum(){
        return num;
    }
    public void setNum(int newNum){
        num = newNum;
    }
    
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e) {}
}