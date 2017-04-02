import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Sakkar on 3/4/2017.
 */
public class PrimitiveRoot {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        ArrayList<Integer> primitiveRoots=new ArrayList<>();
        for(int i=1;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            System.out.print(i+"\t: ");
            int b=1;
            for(int j=1;j<n;j++){
                b=(int)((b*i)%n);
                if(!list.contains(b)) {
                    System.out.print(" "+b);
                    list.add(b);
                }
            }
            System.out.println("");
            if(list.size()==n-1){
                primitiveRoots.add(i);
            }
        }
        System.out.println("Primitive root of "+n+" is :"+primitiveRoots.toString());
    }

}
