import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String[] z=s.nextLine().split("\\.");
        int x=Integer.parseInt(z[0]);
        int y=Integer.parseInt(z[1]);
        System.out.print(x);
        if (y<=2)
            System.out.println("-");
        else if (y>=7)
            System.out.println("+");
        else
            System.out.println();

    }

}
