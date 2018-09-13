import java.util.Scanner;
/**
 * Cuadrado Magico
 */
public class CuadMag
{
    static public void main(String [] args)
    {
        int n;
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        
        System.out.println("Ingresa un número impar:");
        n= tc.nextInt();
        if(n%2 == 0)
        {
            n++;
            System.out.println("Número = "+n);
        }
        
        int arr[][]= new int[n][n];
        int fa= 0;
        int ca= n/2;
        arr[fa][ca]= 1;
        //><
        int fn,cn;
        for(int num= 2; num<= n*n; num++)
        {
            //fn= (fa-1)<0? n-1: fa-1;
            fn= fa-1;
            if(fn < 0)
            {
                fn= n-1;
            }
            //cn= (ca+1)==n? 0: ca+1;
            cn= ca+1;
            if(cn == n)
            {
                cn= 0;
            }
            
            if(arr[fn][cn] == 0)
            {
                arr[fn][cn]= num;
                fa= fn;
                ca= cn;
            }
            else
            {
                fa++;
                arr[fa][ca]= num;
            }
        }
        for(int f1=0;f1<arr.length;f1++)
        {
            for(int c1=0;c1<arr.length;c1++)
            {
                if(arr[f1][c1]<10)
                {
                    System.out.print("0"+arr[f1][c1]+" ");
                }
                else
                {
                    System.out.print(arr[f1][c1]+" ");
                }
            }
            System.out.println();
        }
    }
}
