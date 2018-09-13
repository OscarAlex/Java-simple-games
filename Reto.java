import java.util.Scanner;
/**
 * Reto
*/
public class Reto
{
    public static void main(String[]arg)
    {
        System.out.print('\u000c');
        int f,c,i;
        
        String mess;
        Scanner tc= new Scanner(System.in);
        Scanner pal= new Scanner(System.in);
        
        //><
        do
        {    
            //Obtener el número de filas y columnas
            System.out.println("No. de columnas: ");
            c= tc.nextInt();
            if(c != 0)
            {
                System.out.println("Mensaje: ");
                mess= pal.nextLine();
                f= mess.length()/c;
                char arr[][]=new char[f][c];
                //Ciclos!!
                for(i=0; i<=f+c-2; i++)
                {
                    for(int f1=0;f1<arr.length;f1++)
                    {
                        for(int c1=0;c1<arr[f1].length;c1++)
                        {
                            if(f1+c1 == i)
                            {
                                System.out.print(arr[f1][c1]= mess.charAt(f1*arr[f1].length+c1));
                            }
                        }
                    }   
                }
                System.out.println("\n");
            }
        }
        while(c != 0);
        
        /*
        5
        thrnaeeockspeefllmfoiyingocagaemyyxudxxx
        3
        thsiiesaysxd
        4
        thsgiioasnbhneestbtyedoyaflfmie!
        6
        moieorvmnnajitanaa
        */
    }
}
