package B;

import java.util.Scanner;

public class UVA369 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long[][] arr=new long[101][101];
        for (int i = 0; i < 101; i++) {
            arr[i][0]=1L;
        }
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j <=i; j++) {
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
            }
        }
        while (true){
            int n=scanner.nextInt();
            int m= scanner.nextInt();
            if (n==0&&m==0)break;
            long ans=arr[n][m];
            System.out.println(n+" things taken "+m+" at a time is "+ans+" exactly.");

        }
    }
}
