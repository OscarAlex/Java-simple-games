import java.util.Scanner;
/**
 * Examen
 */
public class Examen
{
    static public void main(String[]arg)
    {
        System.out.print('\u000c');
        int f,c,i;
        int bin;
        String mess,mens;
        
        Scanner tc= new Scanner(System.in);
        Scanner pal= new Scanner(System.in);
        do
        {
            System.out.println("No. de columnas: ");
            c= tc.nextInt();
            if(c != 0)
            {
                System.out.println("Mensaje: ");
                mess= pal.nextLine();
                f= mess.length()/c;
        
                char arr[][]=new char[f][c];
                char arr2[]= new char[mess.length()];
                //><
                int n=0;
                for(i=0; i<=f+c-2; i++)
                {
                    for(int f1=0;f1<arr.length;f1++)
                    {
                        for(int c1=0;c1<arr[f1].length;c1++)
                        {
                            if(f1+c1 == i)
                            {
                                arr2[n]= mess.charAt(f1*arr[f1].length+c1);
                                n++;
                            }
                        }
                    }
                }
                mens=String.valueOf(arr2);
                System.out.println(mens);
                System.out.println();
                
                int p,q;
                p=0;
                q=7;
                int num[]= new int[mens.length()/7];
                for(int j=0; j<mens.length()/7; j++)
                {
                    num[j]= Integer.parseInt(mens.substring(p,q),2);
                    System.out.print((char)num[j]);
                    p+=7;
                    q+=7;
                }
                System.out.println("\n");
            }
        }
        while(c != 0);
        //5
        //110010110111010010111110000100010001100010000
        //3
        //110001010101011101101
    }
}
