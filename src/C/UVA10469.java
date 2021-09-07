import java.util.Scanner;

public class UVA10469 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long a= scanner.nextLong();
            long b=scanner.nextLong();
            System.out.println(a^b);
        }
    }
}
