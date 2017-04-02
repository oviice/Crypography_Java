import java.util.Scanner;

/**
 * Created by ovi on 3/18/2017.
 */
public class DiscritLogarithm {
    public static void main(String[] args){
        int base,modulo,number;
        Scanner scanner=new Scanner(System.in);
        System.out.print("Give the base : ");
        base=scanner.nextInt();
        System.out.print("Give the modulo : ");
        modulo=scanner.nextInt();
        System.out.print("Give the number : ");
        number=scanner.nextInt();

        System.out.println("Discrete Logarithm : "+Math.pow(base,number)%modulo);
    }
}
