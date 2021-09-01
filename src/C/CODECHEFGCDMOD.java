package C;

import java.math.BigInteger;
import java.util.Scanner;

public class CODECHEFGCDMOD {
    final static long mod=1000000007;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while (t-->0) {
            long a = s.nextLong();
            long b = s.nextLong();
            long n = s.nextLong();
            long mn=a-b;
            a%=mn;
            b%=mn;
            long x=pow(a,n,mn)+pow(b,n,mn);
            System.out.println(gcd(x,mn)%mod);
        }
    }
    static long gcd(long a,long b){
        return b==0L?a:gcd(b,a%b);
    }

    static long pow(long a,long b,long mod){
        if (b==1L)
            return a;
        else if (b==0L)
            return 1L;
        long x=pow(a,b/2,mod);
        if (b%2==1){
            return (((a*x)%mod)*x)%mod;
        }else
            return (x*x)%mod;
    }
}
