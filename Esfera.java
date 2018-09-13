import java.awt.Graphics;
/**
 * Esfera
 */
public class Esfera
{
    //protected int x=10, y=10; Default
    protected int x, y;
    //Constructores son buenos para inicializar valores    
    public void Esfera()
    {
        x=0;
        y=0;
    }
    
    public void Esfera(int x, int y)
    {
        //this.x= Instancia -- x= Actual
        this.x=x;
        this.y=y;
    }
    //En el encabezado: Parametros fomales
    protected void setX(int x)
    {
        this.x=x;
    }
    //Cuando se invoca: Parametro actual
    protected void setY(int y)
    {
        this.y=y;
    }
    
    protected void mostrar(Graphics papel)
    {
        papel.drawOval(x,y,5,5);
    }
}
