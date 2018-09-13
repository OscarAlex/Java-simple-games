import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
/**
 * Juego 512
 */
public class Juego5122 extends JFrame implements KeyListener
{
    int nums[][]= new int [4][4];
    boolean ver[][]= new boolean [4][4];
    int suma=0;
    int gan= 512;
    
    JPanel panel= new JPanel();
    JButton [][]botones = new JButton[4][4];
    JLabel puntaje= new JLabel();
    int boton=150;
    public static void main(String arg[])
    {
        Juego5122 juego= new Juego5122();
        juego.setPreferredSize(new Dimension(625,700));
        juego.setResizable(false);
        juego.setVisible(true);
        juego.pack();
        juego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        juego.addKeyListener(juego);
        
        juego.random();
        juego.random();
        juego.tab2();
        juego.tab3();
    }
    
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e)
    {
        tab3();
        int v=0;
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            v=3;
            while(v>0)
            {
                for(int f=1; f<nums.length; f++)
                {
                    for(int c=0; c<nums[f].length; c++)
                    {
                        if(ver[f][c]!=true)
                        {
                            if(nums[f][c]!=0 && nums[f-1][c]==0)
                            {
                                nums[f-1][c]= nums[f][c];
                                nums[f][c]= 0;
                            }
                            else if(nums[f][c]!=0 && nums[f-1][c]==nums[f][c] && ver[f-1][c]!=true)
                            {
                                nums[f-1][c]= 2*nums[f][c];
                                nums[f][c]= 0;
                                ver[f-1][c]=true;
                                
                                suma+=nums[f-1][c];
                            }
                        }
                    }
                }    
                v--;
            }
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            v=3;
            while(v>0)
            {
                for(int f=nums.length-1; f>0; f--)
                {
                    for(int c=0; c<nums[f].length; c++)
                    {
                        if(ver[f][c]!=true)
                        {
                            if(nums[f-1][c]!=0 && nums[f][c]==0)
                            {                          
                                nums[f][c]= nums[f-1][c];
                                nums[f-1][c]= 0;
                            }
                            else if(nums[f][c]!=0 && nums[f-1][c]==nums[f][c] && ver[f-1][c]!=true)
                            {
                                nums[f][c]= 2*nums[f-1][c];
                                nums[f-1][c]= 0;
                                ver[f][c]=true;
                                
                                suma+=nums[f][c];
                            }    
                        }
                    }
                }    
                v--;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            v=3;
            while(v>0)
            {
                for(int f=0; f<nums.length; f++)
                {
                    for(int c=1; c<nums[f].length; c++)
                    {
                        if(ver[f][c]!=true)
                        {
                            if(nums[f][c]!=0 && nums[f][c-1]==0)
                            {                          
                                nums[f][c-1]= nums[f][c];
                                nums[f][c]= 0;
                            }
                            else if(nums[f][c]!=0 && nums[f][c-1]==nums[f][c] && ver[f][c-1]!=true)
                            {
                                nums[f][c-1]= 2*nums[f][c];
                                nums[f][c]= 0;
                                ver[f][c-1]=true;
                                
                                suma+=nums[f][c-1];
                            }    
                        }
                    }
                }    
                v--;
            }
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            v=3;
            while(v>0)
            {
                for(int f=0; f<nums.length; f++)
                {
                    for(int c=nums[f].length-1; c>0; c--)
                    {
                        if(ver[f][c]!=true)
                        {
                            if(nums[f][c-1]!=0 && nums[f][c]==0)
                            {                          
                                nums[f][c]= nums[f][c-1];
                                nums[f][c-1]= 0;
                            }
                            else if(nums[f][c]!=0 && nums[f][c-1]==nums[f][c] && ver[f][c-1]!=true)
                            {
                                nums[f][c]= 2*nums[f][c-1];
                                nums[f][c-1]= 0;
                                ver[f][c]=true;
                                
                                suma+=nums[f][c];
                            }    
                        }
                    }
                }    
                v--;
            }
        }
        
        reset();
        random();
        tab();
        //comparar();
        tab3();
        if(ganar()==true)
        {
            JOptionPane.showMessageDialog(null,"Ganador\nPuntaje: "+suma);
        }
        else if(comparar()==true)
        {
            JOptionPane.showMessageDialog(null,"No hay más movimientos\nPuntaje: "+suma);
        }
    }
    public void keyReleased(KeyEvent e){} 
    
    public boolean comparar()
    {    
        boolean comp= false;
        int cas=0;
        int casop=0;
        co:
        for(int f=0; f<nums.length; f++)
        {
            for(int c=0; c<nums[f].length; c++)
            {
                if(nums[f][c] != 0)
                {
                    cas++;
                }
            }
        }
        if(cas == 16)// || nums[f][c]==nums[f-1][c] || nums[f][c]==nums[f][c-1])
        {
            for(int f=0; f<nums.length; f++)
            {
                for(int c=1; c<nums.length; c++)
                {
                    if(nums[f][c]!=nums[f][c-1])
                    {
                        casop++;
                    }
                }
            }
            for(int c=0; c<nums.length; c++)
            {
                for(int f=1; f<nums.length; f++)
                {
                    if(nums[f][c]!=nums[f-1][c])
                    {
                        casop++;
                    }
                }
            }
            if(casop == 24)
            {
                comp=true;
            }
        }
        return comp;
    }
    
    public void tab2()
    {
        Container contenedor= getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        panel.setPreferredSize(new Dimension(600,600));
        panel.setLayout(null);
        panel.setBackground(Color.white);
        contenedor.add(panel);
        
        getContentPane().add(puntaje, BorderLayout.SOUTH);
        for (int f=0; f<botones.length; f++)
        {
            for(int c=0; c<botones[f].length; c++)
            {   
                botones[f][c]=new JButton();
                botones[f][c].setVisible(true);
                botones[f][c].setFont(new java.awt.Font("Tahoma",40,30));
                botones[f][c].setForeground(Color.white);
                botones[f][c].setBounds(c*boton, f*boton, boton, boton);
                botones[f][c].setBackground(new Color(52,73,94));
                panel.add(botones[f][c]);
            }
        }
    }
    
    public void tab3()
    {
        puntaje.setText("Puntaje: "+suma);
        puntaje.setFont(new Font("Tahoma", Font.PLAIN, 40));
        for (int f=0; f<botones.length; f++)
        {
            for(int c=0; c<botones[f].length; c++)
            {
                if(nums[f][c] == 0)
                {
                    botones[f][c].setText("");
                    botones[f][c].setBackground(new Color(52,73,94));
                }
                else
                {
                    botones[f][c].setText(""+nums[f][c]);
                    if(nums[f][c]==2)
                    {
                        botones[f][c].setBackground(new Color(42,80,95));
                    }
                    else if(nums[f][c]==4)
                    {
                        botones[f][c].setBackground(new Color(30,50,64));
                    }
                    else if(nums[f][c]==8)
                    {
                        botones[f][c].setBackground(new Color(50,50,64));
                    }
                    else if(nums[f][c]==16)
                    {
                        botones[f][c].setBackground(new Color(40,50,94));
                    }
                    else if(nums[f][c]==32)
                    {
                        botones[f][c].setBackground(new Color(20,70,24));
                    }
                    else if(nums[f][c]==64)
                    {
                        botones[f][c].setBackground(new Color(14,52,2));
                    }
                    else if(nums[f][c]==128)
                    {
                        botones[f][c].setBackground(new Color(70,40,34));
                    }else if(nums[f][c]==256)
                    {
                        botones[f][c].setBackground(new Color(15,8,34));
                    }
                    else if(nums[f][c]==512)
                    {
                        botones[f][c].setBackground(new Color(65,40,9));
                    }
                }
                panel.add(botones[f][c]);
            }
        }
        //repaint();
    }
    
    public void tab()
    {    
        for(int f=0; f<nums.length; f++)
        {
            for(int c=0; c<nums[f].length; c++)
            {
                System.out.print(nums[f][c]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void random()
    {
        int f;
        int c;
        ran:
        for(int f1=0; f1<nums.length; f1++)
        {
            for(int c1=0; c1<nums[f1].length; c1++)
            {
                if(nums[f1][c1] == 0)
                {
                    do
                    {
                        f=(int)(Math.random()*4);
                        c=(int)(Math.random()*4);
                    }
                    while(nums[f][c] != 0);
                    nums[f][c]= ((int)(Math.random()*2)+1)*2;
                    break ran;
                }
            }
        }
    }
    
    public void reset()
    {
        for(int f=0; f<nums.length; f++)
        {
            for(int c=0; c<nums[f].length; c++)
            {
                ver[f][c]= false;
            }
        }
    }
    
    public boolean ganar()
    {
        boolean g= false;
        for(int f=0; f<nums.length; f++)
        {
            for(int c=0; c<nums[f].length; c++)
            {
                if(nums[f][c] == gan)
                {
                    g= true;
                }
            }
        }
        return g;
    }
}