import java.awt.Graphics;
/**
 * Cuadrado
 */
class Cuadrado extends Forma
{
    public void mostrar(Graphics papel)
    {
        papel.drawRect(x,y,tamano,tamano);
    }
}
