package C;

import java.util.Scanner;

public class UVA10325 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()) {
            int n=s.nextInt();
            int m=s.nextInt();
             arr=new int[m];

            for (int i = 0; i < m; i++) {
                arr[i]=s.nextInt();
            }
            ans=0;
            iterate(0,m,0,1L,n);
            System.out.println(n-ans);
        }
    }
    static int ans=0;
    static void iterate(int i,int size,int n,long m,int x){
        if (i==size){
            if (m==1)
                return;
            if (n%2==0){
                ans-=x/m;
            }else{
                ans+=x/m;
            }
        }else{
            iterate(i+1,size,n,m,x);
            iterate(i+1,size,n+1,lcm(arr[i],m),x);
        }

    }
    static long lcm(long a,long b){
        return a/gcd(a,b)*b;
    }
    static long gcd(long a,long b){
        return b==0?a:gcd(b,a%b);
    }
}
