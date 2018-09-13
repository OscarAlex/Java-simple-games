import java.util.Scanner;
import java.awt.*;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseEvent;
import javax.swing.*;
//import java.awt.event.KeyListener;
/**
 * Juego 512
 */
public class Juego512 extends JFrame
{
    int nums[][]= new int [4][4];
    boolean ver[][]= new boolean [4][4];
    int suma=0;
    int gan= 512;
    Scanner tc= new Scanner(System.in);
    String dir;
    
    JPanel panel= new JPanel();
    JButton [][]botones = new JButton[4][4];
    JLabel puntaje= new JLabel();
    int boton=150;
    public static void main(String arg[])
    {
        Juego512 juego= new Juego512();
        juego.setPreferredSize(new Dimension(625,700));
        juego.setResizable(false);
        juego.setVisible(true);
        juego.pack();
        juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //System.out.print('\u000c');
        //juego.comparar();
        juego.random();
        juego.tab2();
        do
        {
            juego.reset();
            juego.random();
            //juego.tab();
            juego.tab3();
            juego.direccion();
        }
        while(juego.ganar()==false);// || juego.comparar()==false);
        juego.tab3();
        JOptionPane.showMessageDialog(null,"Ganador\nPuntaje: "+juego.suma);
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
        repaint();
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
        do
        {
            f=(int)(Math.random()*4);
            c=(int)(Math.random()*4);
        }
        while(nums[f][c] != 0);
        nums[f][c]= ((int)(Math.random()*2)+1)*2;
    }
    
    public boolean comparar()
    {    
        boolean comp= false;
        for(int f=0; f<nums.length; f++)
        {
            for(int c=0; c<nums[f].length; c++)
            {
                if(nums[f][c] != 0)
                {
                    if(c!=nums.length-1 && nums[f][c]!=nums[f][c+1])
                    {
                        comp= true;
                        break;
                    }
                    else if(f!=nums[f].length-1 && nums[f][c]!=nums[f+1][c])
                    {
                        comp= true;
                        break;
                    }
                }
            }
        }
        return comp;
    }

    public void direccion()
    {
        dir= tc.nextLine();
        
        int v;
        //><
        switch(dir)
        {
            case "w":
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
                                suma= suma!=0?suma+nums[f-1][c]/2:suma+nums[f-1][c];
                            }
                        }
                    }
                }    
                v--;
            }
            break;
            
            case "s":
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
                                suma= suma!=0?suma+nums[f][c]/2:suma+nums[f][c];
                            }    
                        }
                    }
                }    
                v--;
            }
            break;
            
            case "a":
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
                                suma= suma!=0?suma+nums[f][c-1]/2:suma+nums[f][c-1];
                            }    
                        }
                    }
                }    
                v--;
            }
            break;
            
            case "d":
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
                                suma= suma!=0?suma+nums[f][c]/2:suma+nums[f][c];
                            }    
                        }
                    }
                }    
                v--;
            }
            break;
        }
        repaint();
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
