import java.util.Scanner;
public class CaeserCipher
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter message:");
        String str=sc.nextLine();
        System.out.println("Enter encryption key:");
        int key=sc.nextInt();
        for(;;)
        {
            System.out.println("1.Encrypt\n2.Decrypt\n3.Exit...");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Encrypted message..."+encrypt(str,key));
                    break;
                case 2:
                    System.out.println("Decryptedmessage..."+decrypt(encrypt(str,key),key));
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option..");
            }
        }
    }
    private static String encrypt(String str,int keyLength)
    {
        String encrypted="";
        for(int i=0;i<str.length();i++)
        {
            int c=str.charAt(i);
            if(Character.isUpperCase(c))
            {
                c=c+(keyLength%26);
                if(c>'Z')
                    c=c-26;
            }
            else if(Character.isLowerCase(c))
            {
                c=c+(keyLength%26);
                if(c>'z')
                    c=c-26;
            }
            encrypted=encrypted+ (char)c;
        }
        return encrypted;
    }
    public static String decrypt(String str,int keyLength)
    {
        String decrypted="";
        for(int i=0;i<str.length();i++)
        {
            int c=str.charAt(i);
            if(Character.isUpperCase(c))
            {
                c=c-(keyLength%26);
                if(c<'A')
                    c=c+26;
            }
            else if(Character.isLowerCase(c))
            {
                c=c-(keyLength%26);
                if(c<'a')
                    c=c+26;
            }
            decrypted=decrypted+(char) c;
        }
        return decrypted;
    }
}