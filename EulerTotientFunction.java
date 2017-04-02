import java.util.Scanner;

/**
 * Created by ovi on 3/5/2017.
 */
public class EulerTotientFunction {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Give the number for which the Totient Function is to calculate:");
        int counter=0,n=scanner.nextInt();
        for(int i=1;i<n;i++)
            if(relativePrime(i,n)) {
                System.out.print(" "+i);
                counter++;
            }
        System.out.println("\nThe answer is :"+counter);
    }

    private static boolean relativePrime(int min,int max){
        if(min==1){
            return true;
        }else{
            if(max%min==0)
                return false;
            else {
                return relativePrime(max%min,min);
            }
        }
    }
}
