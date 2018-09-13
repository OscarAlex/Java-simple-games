import java.awt.Graphics;
/**
 * Circulo
 */
class Circulo extends Forma
{
    public void mostrar(Graphics papel)
    {
        papel.drawOval(x,y,tamano,tamano);
    }
}