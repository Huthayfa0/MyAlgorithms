package A;

import java.util.Scanner;

public class UVA10110 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        while (n!=0){
            System.out.println(solve(n)?"Yes":"No");
            n=scan.nextInt();
        }
    }
    public static boolean solve(int n) {
        int count = 0;

        int x;
        for(x = n; (x & 1) == 0; ++count) {
            x /= 2;
        }

        int ans = count;

        for(int i = 3; i <= x; i += 2) {
            for(count = 0; x % i == 0; ++count) {
                x /= i;
            }

            if (count != 0) {
                ans = (ans + 1) * (count + 1);
            }
        }

        return (ans & 1) == 1;
    }
}
