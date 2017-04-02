import java.util.Scanner;

/**
 * Created by Sakkar on 2/26/2017.
 */

public class PlayFairCipher {
    private static final int ENCRIPR=1;
    private static final int DECRIPR=2;
    public static void main(String [] args){
        int typeOfOperation;
        Scanner scanner=new Scanner(System.in);
        String key,message;
        char []matrix=new char[26];
        do {
            System.out.println("Give the type of operation:\n 1.Encript \n 2.Decript\n 0.Exit");
            switch (typeOfOperation = Integer.parseInt(scanner.nextLine())){
                case ENCRIPR:
                case DECRIPR:
                    System.out.print("Give  the key: ");
                    key=scanner.nextLine().toLowerCase();
                    key=optimizeKey(key);
                    matrix=generateMatrix(matrix,key);
                    showMatrix(matrix);
                    System.out.print("Give  the Message: ");
                    message=scanner.nextLine().toLowerCase();
                    message=optimizeMessage(message);
                    message=encriptOrDecriptData(message,matrix,typeOfOperation);
                    System.out.println("Message output: "+message+"\n");
                    break;
                default:
                    break;
            }
        }while (typeOfOperation!=0);
    }

    private static String optimizeMessage(String message) {
        String temp=message.replaceAll(" ","");
        message="";
        int i;
        for (i=0;i<temp.length()-1;i++){
            message+=temp.charAt(i);
            if(temp.charAt(i)==temp.charAt(i+1))
                message+='x';
        }
        message+=temp.charAt(i);
        if(message.length()%2==1)
            message+='x';
        return message;
    }

    private static char[] generateMatrix(char[] matrix, String key) {
        int i;
        int []alphabets=new int[26];
        for(i=0;i< key.length();i++) {
            char c = key.charAt(i);
            matrix[i]=c;
            alphabets[c-'a']=1;
        }
        for(int j=0;j<26;j++)
            if(alphabets[j]==0 && j!=9)
                matrix[i++]=(char)( 'a'+j);
        return matrix;
    }

    private static String encriptOrDecriptData(String message, char[] matrix,int type) {
        String data=new String(matrix);
        int key=0;
        if(type==ENCRIPR)
            key=1;
        else if(type==DECRIPR)
            key=4;
        int []rows=new int[26];
        int []columns=new int[26];
        for(int i=0;i<26;i++){
            rows[i]=data.indexOf((char)('a'+i))/5;
            columns[i]=data.indexOf((char)('a'+i))%5;
        }
        rows[9]=rows[8];
        columns[9]=columns[8];
        data="";
        for (int i=0;i<message.length()/2;i++){
            int pos1=message.charAt(i*2)-'a',pos2=message.charAt(i*2+1)-'a';
            if(rows[pos1]==rows[pos2]){
                data+=matrix[rows[pos1]*5+((columns[pos1]+key)%5)]+""+matrix[rows[pos2]*5+((columns[pos2]+key)%5)];
            }else if(columns[pos1]==columns[pos2]){
                data+=matrix[((rows[pos1]+key)%5)*5+columns[pos1]]+""+matrix[((rows[pos2]+key)%5)*5+columns[pos2]];
            }else {
                data+=matrix[rows[pos1]*5+columns[pos2]]+""+matrix[rows[pos2]*5+columns[pos1]];
            }
        }
        return data;
    }

    private static void showMatrix(char[] matrix) {
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[5*i+j]+" ");
            }
            System.out.println("");
        }
    }

    private static String optimizeKey(String key) {
        String s="";
        key=key.replaceAll("j","i");
        for(int i=0;i<key.length();i++)
            if(s.indexOf(key.charAt(i))==-1)
                s+=key.charAt(i);
        return s;
    }
}
