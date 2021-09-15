package C;

import java.util.Scanner;

public class UVA10509 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while (true){
            double x=scan.nextDouble();
            if(x==0)
                break;
            double a=Math.floor(Math.pow(x,1/3.0));
            a+=(x-a*a*a)/3/a/a;
            System.out.printf("%.4f\n",a);
        }
    }
}
