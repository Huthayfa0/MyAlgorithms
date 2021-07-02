package B;

import java.util.HashSet;
import java.util.Scanner;

public class UVA412 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while (n!=0){
            HashSet<Integer>[] arr=new HashSet[n];
            for (int i = 0; i < n; i++) {
                arr[i]=primeFactors(scanner.nextInt());
            }
            int answer=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    HashSet<Integer> x=new HashSet<>(arr[i]);
                    x.retainAll(arr[j]);
                    if (x.isEmpty())
                        answer++;
                }
            }
            if (answer==0) System.out.println("No estimate for this data set.");
            else {
                double s=answer/(n*(n-1)/2.0);
                s=6/s;
                System.out.printf("%.6f\n",Math.sqrt(s));
            }
            n=scanner.nextInt();
        }
    }
    static HashSet<Integer> primeFactors(int n) {
        HashSet<Integer> f = new HashSet<>();
        int x = 2;
        while (x * x <= n) {
            while (n % x == 0) {
                f.add(x);
                n /= x;
            }
            x++;
        }
        if (n > 1) f.add(n);
        return f;
    }
}
