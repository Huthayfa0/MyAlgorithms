package B;

import java.util.Scanner;

public class UVA10077 {
    public static void main(String[] args) {

        int count=1;
        Scanner s=new Scanner(System.in);
        while (true){
            int m=s.nextInt();
            int n=s.nextInt();
            if (m==1&&n==1)
                break;
            if (m==n) {
                System.out.println("I");
                continue;
            }
            long a = 0L, b = 1, c = 1, d = 0L;
            StringBuilder ans= new StringBuilder();

            while (true){
                long vm= a + c;
                long vn=b + d;

                if (m*vn>n*vm){
                    ans.append("R");
                    a = vm; b = vn;
                }else if (m*vn<n*vm){
                    ans.append("L");
                    c = vm; d = vn;
                }else {
                    break;
                }

            }
            System.out.println(ans);

        }
    }
}
