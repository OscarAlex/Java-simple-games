import java.util.Scanner;
/**
 * Examen3
 */
public class Examen3
{
    static public void main(String[]arg)
    {
        System.out.print('\u000c');
        Scanner tc=new Scanner(System.in);
        Scanner tc2=new Scanner(System.in);
        int ds;
        String tos;
        
        //System.out.println("No. de datasets:");
        do
        {
            ds= tc.nextInt();
        }
        while(ds<1 || ds>1000);
        char arr[][]= new char[ds][42];
        int arr2[][]= new int[ds][9];
        
        //><
        for(int i=1; i<=ds; i++)
        {
            System.out.println(i);
            tos= tc2.nextLine();
            char tos2[]= tos.toCharArray();
            for(int r=0; r<tos2.length; r++)
            {
                arr[i-1][r]= tos2[r];
            }
        }
        
        int ths[][]= new int[ds][9];
        for(int f=0; f<arr.length; f++)
        {
            for(int c=0; c<arr[f].length; c++)
            {
                ths[f][0]=f+1;
                if(arr[f][c] == 'T' && arr[f][c+1] == 'T' && arr[f][c+2] == 'T')
                {
                    ths[f][1]++;
                }
                else if(arr[f][c] == 'T' && arr[f][c+1] == 'T' && arr[f][c+2] == 'H')
                {
                    ths[f][2]++;
                }
                else if(arr[f][c] == 'T' && arr[f][c+1] == 'H' && arr[f][c+2] == 'T')
                {
                    ths[f][3]++;
                }
                else if(arr[f][c] == 'T' && arr[f][c+1] == 'H' && arr[f][c+2] == 'H')
                {
                    ths[f][4]++;
                }
                else if(arr[f][c] == 'H' && arr[f][c+1] == 'T' && arr[f][c+2] == 'T')
                {
                    ths[f][5]++;
                }
                else if(arr[f][c] == 'H' && arr[f][c+1] == 'T' && arr[f][c+2] == 'H')
                {
                    ths[f][6]++;
                }
                else if(arr[f][c] == 'H' && arr[f][c+1] == 'H' && arr[f][c+2] == 'T')
                {
                    ths[f][7]++;
                }
                else if(arr[f][c] == 'H' && arr[f][c+1] == 'H' && arr[f][c+2] == 'H')
                {
                    ths[f][8]++;
                }
            }
        }
        
        System.out.println();
        for(int []z: ths)
        {
            for(int x: z)
            {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        
        //HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
        //TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
        //HHTTTHHTTTHTHHTHHTTHTTTHHHTHTTHTTHTTTHTH
        //HTHTHHHTHHHTHTHHHHTTTHTTTTTHHTTTTHTHHHHT
    }
}
