package C;

import java.util.Scanner;

public class UVA498 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()){
            String[] a=s.nextLine().split(" ");
            long[] arr=new long[a.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i]=Long.parseLong(a[i]);
            }
            a=s.nextLine().split(" ");
            for (int i = 0; i < a.length - 1; i++) {
                System.out.print(f(Long.parseLong(a[i]),arr)+" ");
            }
            System.out.println(f(Long.parseLong(a[a.length-1]),arr));

        }
    }
    public static long f(long x,long[] arr){
        long a=1L;
        long ans=0L;
        for (int i = arr.length-1; i >=0 ; i--) {
            ans+=arr[i]*a;
            a*=x;
        }
        return ans;
    }
}
