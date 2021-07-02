package B;

import java.util.Scanner;

public class UVA713 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        while (t-->0){

            String[] numbers=s.nextLine().split(" ");
            char[] x=numbers[0].toCharArray();
            char[] y=numbers[1].toCharArray();
            int n=Math.min(x.length,y.length);
            int carry=0;
            boolean zeroStart=false;
            for (int i = 0; i < n; i++) {
                carry+=x[i]+y[i]-2*'0';
                if (carry%10!=0)zeroStart=true;
                if (zeroStart)
                    System.out.print(carry%10);
                carry/=10;
            }
            if (x.length==y.length) {
                if (carry>0)
                    System.out.println("1");
                else
                    System.out.println();
                continue;
            }
            char[]temp=x.length>y.length?x:y;
            for (int i = n; i < temp.length; i++) {
                carry+=temp[i]-'0';
                if (carry%10!=0)zeroStart=true;
                if (zeroStart)
                    System.out.print(carry%10);
                carry/=10;
            }
            if (carry>0)
                System.out.println("1");
            else
                System.out.println();
        }
    }
}
