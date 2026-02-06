import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String str=scan.next();
        String pal="";
        int n=str.length();
        for(int i=n-1; n>=0;n--){
            pal=pal+str.charAt(i);
        }
        if(pal.equals(str)){
            System.out.println("Given string is palindrome");
        }else{
            System.out.println("Given string is not a palindrome");
        }
    }
}
