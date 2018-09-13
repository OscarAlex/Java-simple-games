import java.util.Scanner;
/**
 * Desafio1
 */
public class Desafio1
{
    public static void main(String args[])
    {
        System.out.print('\u000c');
        int x,res;
        Scanner tc= new Scanner(System.in);
        
        System.out.println("Escribe un número: ");
        x= tc.nextInt();
        //><
        //Convertir un caracter a entero es con -48
        do{
            int suma=0;
            do{
                if(suma>9)
                {
                    x= suma;
                    suma=0;
                }
                String entArr= ((Integer)x).toString();
                for(int i=0; i<entArr.length(); i++)
                {
                    suma+=(entArr.charAt(i)-48);
                }  
                }while(suma > 9);
            res= suma;
            System.out.println(res);
            x= tc.nextInt();
        }while(x != 0);
        /**
         * 24 39 77 69 12
         * 111 222 121 333
         */
    }
}
