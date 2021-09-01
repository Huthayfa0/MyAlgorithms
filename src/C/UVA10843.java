package C;

import java.util.Scanner;

public class UVA10843 {
    final static long mod=2000000011;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for (int i = 1; i <=t ; i++) {
            long n=s.nextLong();
            System.out.println("Case #"+(i)+": "+pow(n,n-2));
        }
    }
    static long pow(long a,long b){
        if (b==1L)
            return a;
        else if (b==0L)
            return 1L;
        long x=pow(a,b/2);
        if (b%2==1){
            return (((a*x)%mod)*x)%mod;
        }else
            return (x*x)%mod;
    }
}
