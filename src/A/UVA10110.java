package A;

import java.util.Comparator;
import java.util.Scanner;

public class UVA10110 {
    public static void main(String[] args) {
        Comparator.comparing()
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        while (n!=0){
            System.out.println(solve(n)?"yes":"no");
            n=scan.nextInt();
        }
    }
    public static boolean solve(int n) {
        int x=(int)Math.sqrt(n);

        return x*x==n;
    }
}
