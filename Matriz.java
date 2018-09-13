
/**
 * Write a description of class Matriz here.
 */
public class Matriz
{
    static public void main(String[]arg)
    {
        System.out.print('\u000c');
        int arr[][]= new int[5][5];
        
        for(int f=0;f<arr.length;f++)
        {
            for(int c=0;c<arr[f].length;c++)
            {
                arr[f][c]= f*arr.length+c+1;
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
