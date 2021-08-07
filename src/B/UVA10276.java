package B;

import java.util.Scanner;

public class UVA10276 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int t=scanner.nextInt();
        while (t-->0){
            int x=scanner.nextInt()+1;
            x=x*x;
            x=x/2;
            System.out.println(x-1);
        }
    }
}
