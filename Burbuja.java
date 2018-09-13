import java.awt.Graphics;
/**
 * Burbuja 
*/
public class Burbuja extends Esfera
{
    private int radio= 10;
    
    public void setRadio(int radio)
    {
        this.radio= radio;
    }
    
    public int getRadio()
    {
        return radio;
    }
    
    public void mostrar(Graphics papel, int opcion)
    {
        if(opcion == 1)
        {
            super.mostrar(papel);
        }
        else
        {
            papel.drawOval(x,y,2*radio,2*radio);
        }
    }
    
    public void moverIzq()
    {
        if(x>0)
        {
            x-=3;
        }
        else
        {
            x=x;
        }
    }
    public void moverDer()
    {
        if(x<128)
        {
            x+=3;
        }
        else
        {
            x=x;
        }
    }
    
    public void moverAba()
    {
        y+=3;
        if(y>230)
        {
            y-=3;
        }
        else
        {
            y=y;
        }
    }
    public void moverArr()
    {
        y-=3;
        if(y<0)
        {
            y+=3;
        }
        else
        {
            y=y;
        }
    }
}
