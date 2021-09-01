package C;

import java.util.Arrays;
import java.util.Scanner;

public class UVA10168 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        boolean[] primes=new boolean[10000001];
        primes[0]=primes[1]=true;
        for (int i = 2; i*i < 10000001; i++) {
            if (primes[i])continue;
            for (int j = 2*i; j < 10000001; j+=i) {
                primes[j]=true;
            }
        }

        while (s.hasNext()){
            int n=s.nextInt();
            if (n<8){
                System.out.println("Impossible.");
                continue ;
            }

            int[] ans=new int[4];
            int count=0;
            for (int i = 3; i>=0 ; i--) {
                int c=n-count-i*2;
                while (primes[c]&&c>1){
                    c--;
                }
                ans[i]=c;
                count+=c;

            }
            for (int i = 0; i < 3; i++) {
                System.out.print(ans[i]+" ");
            }
            System.out.println(ans[3]);
        }
    }
}
