import java.util.Scanner;

public class RelativePrime {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        if(relativePrime(Math.min(n,m),Math.max(n,m))){
            System.out.println("\n"+n+" and "+m+" is relative prime");
        }
        else
            System.out.println("\n"+n+" and "+m+" is not relative prime");
    }

    static boolean relativePrime(int min,int max){
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
