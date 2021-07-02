package B;

import java.util.Scanner;

public class UVA374 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            try {
                int B=scanner.nextInt();
                int P=scanner.nextInt();
                int M= scanner.nextInt();

                B%=M;
                int ans=1;
                int cur=B;
                while (P>0){
                    if ((P&1)==1){
                        ans=(ans*cur)%M;
                    }
                    P>>=1;
                    cur*=cur;
                    cur%=M;
                }
                System.out.println(ans);
            }catch (Exception e){
                break;
            }
        }
    }
}
