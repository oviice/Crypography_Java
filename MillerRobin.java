import java.util.Random;
import java.util.Scanner;

/**
 * Created by ovi on 3/5/2017.
 */
public class MillerRobin {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Give the number:");
        int n=scanner.nextInt();
        test(n);
    }

    private static void test(int n) {
        if(n%2==0){
            System.out.println("composite");
            return;
        }
        int k, i = 1, q, a;
        for (k = 0; i < n - 1; k++)
            i *= 2;
        q = (int) ((n - 1) / Math.pow(2, k));
        Random random = new Random();
        a = random.nextInt(n - 1);
        if (Math.pow(a, q) % n == 1) {
            System.out.println("Inconclusive");
            return;
        }
        for (int j = 0; j < k; j++) {
            int x = (int) Math.pow(2, j);
            if (Math.pow(a, x * q) % n == n - 1) {
                System.out.println("Inconclusive");
                return;
            }
        }
        System.out.println("composite");
    }
}
