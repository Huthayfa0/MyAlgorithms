package A;

import java.util.ArrayList;
import java.util.Scanner;

public class UVA476 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<ArrayList<Double>> s=new ArrayList<>();
        while (scanner.next().equals("r")){
            ArrayList<Double> x=new ArrayList<>();
            s.add(x);
            for (int i = 0; i < 4; i++) {
                x.add(scanner.nextDouble());
            }
        }
        int i=0;
        double x=scanner.nextDouble(),y=scanner.nextDouble();
        while (x!=9999.9&&y!=9999.9){
            i++;
            boolean checked=false;
            int j=0;
            for (ArrayList<Double> list : s){
                j++;
                if ((Math.min(list.get(0), list.get(2))<x&&Math.max(list.get(0), list.get(2))>x)&&(Math.min(list.get(1), list.get(3))<y&&Math.max(list.get(1), list.get(3))>y)){
                    System.out.println("Point "+i+" is contained in figure "+j);
                    checked=true;
                }
            }
            if (!checked){
                System.out.println("Point "+i+" is not contained in any figure");
            }

            x=scanner.nextDouble();
            y=scanner.nextDouble();
        }
    }
}
