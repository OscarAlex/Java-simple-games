import java.util.Scanner;
/**
 * Examen2
 */
public class Examen2
{
    public static void main(String args[])
    {
        int cook,pos;
        System.out.print('\u000c');
        Scanner tc= new Scanner(System.in);
        int i,f,di,df;
        //><
        do
        {
            //System.out.println("Galleta:");
            cook= tc.nextInt();
            if (cook < 5280 && cook > -5280)
            {
                i=0;
                do
                {
                    pos= tc.nextInt();
                    if(pos != cook)
                    {
                        f= pos;
                        di= Math.abs(cook-i);
                        df= Math.abs(cook-f);
                        if(df < di)
                        {
                            System.out.println("Moving from "+i+" to "+f+": Warmer");
                        }
                        else if(df > di)
                        {
                            System.out.println("Moving from "+i+" to "+f+": Colder");
                        }
                        else
                        {
                            System.out.println("Moving from "+i+" to "+f+": Same");
                        }
                        i=f; 
                    }
                    else
                    {
                        System.out.println("Moving from "+i+" to "+pos+": Found it!\n");
                    }
                }
                while(pos != cook);
            }
        }
        while(cook < 5280 && cook > -5280);
        //5 10 11 12 3 4 5
        //3 10 10 7 3
        //12 5 -3 1 4 6 7 8 9 12
        //5280 10
    }
}
