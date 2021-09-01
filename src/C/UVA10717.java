package C;

import java.util.Scanner;

public class UVA10717 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (true){
            int n=s.nextInt();
            int t=s.nextInt();
            if (n==0&&t==0)
                break;
            long[]arr=new long[n];
            for (int i = 0; i < n; i++) {
                arr[i]=s.nextLong();
            }

            while (t-->0){
                long a=s.nextLong();
                long mn=0L,mx=Long.MAX_VALUE;
                sss:
                for (int i = 0; i < n; i++) {
                    for (int j =i+1; j < n; j++) {
                        for (int k = j+1; k < n; k++) {
                            for (int l = k+1; l < n; l++) {
                                long lcm=lcm(lcm(arr[i],arr[j]),lcm(arr[k],arr[l]));
                                if (a%lcm==0){
                                    mx=a;
                                    mn=a;
                                    break sss;
                                }else{
                                    mx=Math.min((a/lcm+1)*lcm,mx);
                                    mn=Math.max((a/lcm)*lcm,mn);
                                }
                            }
                        }
                    }
                }
                System.out.println(mn+" "+mx);
            }
        }
    }
    static long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
    static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
