package C;

import java.util.Scanner;

public class UVA10394 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        boolean[] primes=new boolean[20000002];
        primes[0]=primes[1]=true;
        for (int i = 2; i*i < 20000002; i++) {
            if (primes[i])continue;
            for (int j = 2*i; j < 20000002; j+=i) {
                primes[j]=true;
            }
        }
        int[]pairs=new int[100002];
        int count=0;
        for (int i = 1; i <20000000; i+=2) {
            if (!primes[i]&&!primes[i+2]){
                pairs[count++]=i;
                if (count==100002)
                    break;
            }
        }
        while (s.hasNext()){
            int n=s.nextInt()-1;
            System.out.printf("(%d, %d)\n",pairs[n],pairs[n]+2);
        }
    }
}
