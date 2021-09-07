package C;

import java.util.HashMap;
import java.util.Scanner;

public class UVA11053 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()){
            int n=s.nextInt();
            if (n==0){
                break;
            }
            int a=s.nextInt();
            int b=s.nextInt();
            HashMap<Long,Integer> map=new HashMap<>();
            long prevX=-1;
            long x=0L;
            int count=1;
            while (!map.containsKey(x)){
                map.put(x,count);
                prevX=x;
                x=(((a*x%n)*x%n)+b)%n;
                count++;
            }
            System.out.println(n-map.get(prevX)+map.get(x)-1);
        }
    }
}
