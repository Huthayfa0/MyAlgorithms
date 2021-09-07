package C;

import java.util.Scanner;

public class UVA10302 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()){
            long n=s.nextLong();
            System.out.println((n*(n+1)/2)*(n*(n+1)/2));
        }
    }
}
