import java.util.Scanner;

/**
 * Created by ovi on 4/1/17.
 */
public class Hellman {
    public static void main(String args[]){
        int q,g,x,a,y,b;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value of q and a : ");
        q=scanner.nextInt();
        g=scanner.nextInt();

        System.out.println("Enter the value of x for the first person : ");
        x=scanner.nextInt();
        a=power(g,x,q);
        System.out.println("Enter the value of y for the second person : ");
        y=scanner.nextInt();
        b=power(g,y,q);
        System.out.println("Public key for the first person is : "+a);
        System.out.println(" Public key for the second person is : "+b);
        int f=secret(b,x,q);
        System.out.println("First Person secret key:"+f);
        int f2=secret(a,y,q);
        System.out.println("second Person secret key:"+f2);

    }
    public static int power(int a, int b, int mod)
    {
        int t;
        if(b==1)
            return a;
        t=power(a,b/2,mod);
        if(b%2==0)
            return (t*t)%mod;
        else
            return (((t*t)%mod)*a)%mod;
    }
    private static int secret(int a,int x,int n){
        return power(a, x, n);
    }
}
