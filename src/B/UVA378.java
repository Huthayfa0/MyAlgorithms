package B;

import java.util.Scanner;

public class UVA378 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        System.out.println("INTERSECTING LINES OUTPUT");
        while (t-- > 0) {
            double x11 = s.nextDouble(),
                    y11 = s.nextDouble(),
                    x12 = s.nextDouble(),
                    y12 = s.nextDouble(),
                    x21 = s.nextDouble(),
                    y21 = s.nextDouble(),
                    x22 = s.nextDouble(),
                    y22 = s.nextDouble();

            double m1=(y12-y11)/(x12-x11),m2=(y22-y21)/(x22-x21);
            if (equal(m1,m2)){
                if (m1*(x22-x11)+y11==y22){
                    System.out.println("LINE");
                }else
                    System.out.println("NONE");
            }else {
                if (equal(x11,x12)||equal(x21,x22)){
                    if (equal(x11,x12)&&equal(x21,x22)){
                        System.out.println(x11==x22?"LINE":"NONE");
                    }else if (equal(x11,x12)){
                        double x = x11;
                        double y = m2 * (x - x22) + y22;
                        System.out.printf("POINT %.2f %.2f\n", x, y);
                    }else{
                        double x = x22;
                        double y = m1 * (x - x11) + y11;
                        System.out.printf("POINT %.2f %.2f\n", x, y);
                    }
                }
                else {
                    double x = (m1 * x11 - m2 * x22 - y11 + y22) / (m1 - m2);
                    double y = m1 * (x - x11) + y11;
                    System.out.printf("POINT %.2f %.2f\n", x, y);
                }
            }
        }
        System.out.println("END OF OUTPUT");
    }
    public static boolean equal(double x1, double x2){
        double EPS=1E-9;
        double d=x1-x2;
        return d<EPS&&d>-EPS;
    }
}
