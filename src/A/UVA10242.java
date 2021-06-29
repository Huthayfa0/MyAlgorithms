package A;

import java.util.Scanner;

public class UVA10242 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (true){
            try{
                String[] x=s.nextLine().split(" ");
                float[] t=new float[8];
                for (int i = 0; i <8; i++) {
                    t[i]=Float.parseFloat(x[i]);
                }
                System.out.printf("%.3f %.3f\n",t[0]-t[2]+t[6],t[1]-t[3]+t[7]);
            }catch (Exception e){
                System.exit(0);
            }
        }
    }
}
