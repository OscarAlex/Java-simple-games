import java.util.Scanner;
/**
 * CuadMag2
 */
public class CuadMag2
{
    static public void main(String[]arg)
    {
        int n=0;
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        
        //System.out.println("Dimensión del cuadrado: ");
        do
        {
            n= tc.nextInt();
        }
        while(n%4 == 0 || n == 2);
        int arrn[][]= new int[n][n];
        char arrl[][]= new char[n/2][n/2];
        
        for(int f=0; f<arrl.length; f++)
        {
            for(int c=0; c<arrl[f].length; c++)
            {
                if(f <= arrl[f].length/2)
                {
                    arrl[f][c] = 'l';
                }
                else if(f == arrl[f].length/2+1)
                {
                    arrl[f][c] = 'u';
                }
                else
                {
                    arrl[f][c] = 'x';
                }
            }
        }
        char c3= arrl[n/2/2][n/2/2];
        arrl[n/2/2][n/2/2]= arrl[n/2/2+1][n/2/2];
        arrl[n/2/2+1][n/2/2]= c3;
        //><
        
        int fa= 0;
        int ca= n/2/2;
        int fn,cn;
        for(int num=1; num<n*n; num++)
        {
            if(arrl[fa][ca] == 'l')
            {
                arrn[2*fa][2*ca+1]= num++;
                arrn[2*fa+1][2*ca]= num++;
                arrn[2*fa+1][2*ca+1]= num++;
                arrn[2*fa][2*ca]= num;
            }
            else if(arrl[fa][ca] == 'u')
            {
                arrn[2*fa][2*ca]= num++;
                arrn[2*fa+1][2*ca]= num++;
                arrn[2*fa+1][2*ca+1]= num++;
                arrn[2*fa][2*ca+1]= num;
            }
            else if(arrl[fa][ca] == 'x')
            {
                arrn[2*fa][2*ca]= num++;
                arrn[2*fa+1][2*ca+1]= num++;
                arrn[2*fa+1][2*ca]= num++;
                arrn[2*fa][2*ca+1]= num;
            }
            fn= fa-1;
            if(fn < 0)
            {
                fn= n/2-1;
            }
            cn= ca+1;
            if(cn == n/2)
            {
                cn= 0;
            }
                    
            if(arrl[fn][cn] != '0')
            {
                arrl[fa][ca]= '0';
                fa= fn;
                ca= cn;
            }
            else
            {
                fa++;
                arrl[fa-1][ca]= '0';
            }
        }

        for(int ff1=0;ff1<arrn.length;ff1++)
        {
            for(int cf1=0;cf1<arrn.length;cf1++)
            {
                if(arrn[ff1][cf1]<10)
                {
                    System.out.print("00"+arrn[ff1][cf1]+" ");
                }
                else if(arrn[ff1][cf1]>=10 && arrn[ff1][cf1]<100)
                {
                    System.out.print("0"+arrn[ff1][cf1]+" ");
                }
                else
                {
                    System.out.print(arrn[ff1][cf1]+" ");
                }
            }
            System.out.println();
        }
        //2 4 6 8 10
        //2 4 8 12 16 20 22
    }
}
