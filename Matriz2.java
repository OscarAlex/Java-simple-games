
/**
 * Matriz2
 */
public class Matriz2
{
    static public void main(String[]arg)
    {
        System.out.print('\u000c');
        int arr[][]= new int[4][4];
        //int f,c;
        //><
        for(int f=0; f<arr.length; f++)
        {
            for(int c=0; c<arr[f].length; c++)
            {
                arr[f][c]= f*arr.length+c+1;
            }
        }
        
        for(int c1=0; c1<arr.length; c1++)
        {
            for(int f1=0; f1<arr.length; f1++)
            {
                if(arr[f1][c1]<10)
                {
                    System.out.print(" "+arr[f1][c1]+" ");
                }
                else
                {
                    System.out.print(" "+arr[f1][c1]);
                }
            }
            System.out.println();
        }
        System.out.println();
        for(int c1=0; c1<arr.length; c1++)
        {
            for(int f1=arr.length-1; 0<=f1; f1--)
            {
                if(arr[f1][c1]<10)
                {
                    System.out.print(" "+arr[f1][c1]+" ");
                }
                else
                {
                    System.out.print(" "+arr[f1][c1]);
                }
            }
            System.out.println();
        }
        System.out.println();
        for(int c1=arr.length-1; 0<=c1; c1--)
        {
            for(int f1=arr[c1].length-1; 0<=f1; f1--)
            {
                if(arr[f1][c1]<10)
                {
                    System.out.print(" "+arr[f1][c1]+" ");
                }
                else
                {
                    System.out.print(" "+arr[f1][c1]);
                }
            }
            System.out.println();
        }
        
        System.out.println();
        for(int []z: arr)
        {
            for(int x: z)
            {
                System.out.println(x);
            }
        }
        
        //><
        System.out.println();
        for(int f1= arr.length-1; f1>=0; f1--)
        {
            for(int c1=0; c1<arr[f1].length; c1++)
            {
                if(arr[f1][c1]<10)
                {
                    System.out.print(" "+arr[f1][c1]+" ");
                }
                else
                {
                    System.out.print(" "+arr[f1][c1]);
                }
            }
            System.out.println();
        }
        System.out.println();
        for(int i=arr.length-1; i>=0; i--)
        {
            System.out.println(arr[i][arr.length-1]);
        }
    }
}
