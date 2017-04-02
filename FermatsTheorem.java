import java.util.Scanner;

/**
 * Created by ovi on 3/4/2017.
 *
 */
public class FermatsTheorem {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Provide p : ");
        int p=scanner.nextInt();
        System.out.print("Provide a : ");
        int a=scanner.nextInt();
        if(check(p)){
            if(a%p==0)
                System.out.println(""+a+" is divisible by "+p+" ...");
            else{
                if(Math.pow(a,p-1)%p==1)
                    System.out.println("Follows Fermat's Theorem "+p+" ...");
            }
        }else
            System.out.println("P is not prime...");

    }
    private static boolean check(int n){
        if(n%2==0)
            return false;
        for(int i=3;i<Math.sqrt(n);i+=2){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
