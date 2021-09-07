package C;

import java.util.Scanner;

public class UVA10812 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while (n-->0){
            long s= scanner.nextLong();
            long d= scanner.nextLong();
            if (d>s||(s+d)%2==1){
                System.out.println("impossible");
            }else {
                long a=(d+s)/2;
                System.out.println(a+" "+(s-a));
            }
        }
    }
}
