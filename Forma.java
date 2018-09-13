import java.awt.Graphics;
/**
 * Forma
 */
public abstract class Forma
{
    protected int x,y;
    protected int tamano= 20;
    protected int dir;
    //><
    public void moverDer()
    {
        x+=1;    
    }
    public void moverIzq()
    {
        x-=1;
    }
    
    public void moverArr()
    {
        y-=1;   
    }
    public void moverAba()
    {
        y+=1;   
    }
    
    public void moverArrD()
    {
        y-=1;
        x+=1;
    }
    public void moverArrI()
    {
        y-=1;
        x-=1;
    }
    public void moverAbaD()
    {
        y+=1;
        x+=1;   
    }
    public void moverAbaI()
    {
        y+=1;
        x-=1;
    }
    
    public void dir()
    {
        if(dir==0)
        {
            moverArr();
            //y-=1;
        }
        else if(dir==2)
        {
            moverDer();
            //x+=1;
        }
        else if(dir==4)
        {
            moverAba();
            //y+=1;
        }
        else if(dir==6)
        {
            moverIzq();
            //x-=1;
        }
        else if(dir==1)
        {
            y-=1;
            x+=1;
        }
        else if(dir==3)
        {
            y+=1;
            x+=1;
        }
        else if(dir==5)
        {
            y+=1;
            x-=1;
        }
        else if(dir==7)
        {
            y-=1;
            x-=1;
        }
    }
    
    public abstract void mostrar(Graphics papel);
}
