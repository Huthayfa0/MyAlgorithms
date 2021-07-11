package B;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SPOJTOE2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashSet<String> s=new HashSet<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(true,"........."));
        while (!queue.isEmpty()){
            Pair pair= queue.poll();
            char xo=pair.next?'X':'O';
            if (!s.add(pair.str))
                continue;
            char[] str=pair.str.toCharArray();
            if (done(str))continue;
            for (int i = 0; i < 9; i++) {
                if (str[i]=='.'){
                    str[i]=xo;
                    queue.add(new Pair(!pair.next, String.valueOf(str)));
                    str[i]='.';
                }
            }
        }
        while (true) {
            String x=scanner.nextLine();
            if (x.equals("end"))
                break;
            if (s.contains(x) && done(x.toCharArray()))
                System.out.println("valid");
            else
                System.out.println("invalid");
        }

    }
    static boolean done(char[] x){
        boolean b=true;
        for (int i = 0; i <9; i++) {
            if (x[i] == '.') {
                b = false;
                break;
            }
        }
        return x[0] != '.' && x[0] == x[1] && x[1] == x[2]
                || x[3] != '.' && x[3] == x[4] && x[4] == x[5]
                || x[6] != '.' && x[6] == x[7] && x[7] == x[8]
                || x[0] != '.' && x[0] == x[3] && x[3] == x[6]
                || x[1] != '.' && x[1] == x[4] && x[4] == x[7]
                || x[2] != '.' && x[2] == x[5] && x[5] == x[8]
                || x[0] != '.' && x[0] == x[4] && x[4] == x[8]
                || x[2] != '.' && x[2] == x[4] && x[4] == x[6]
                || b;
    }
    static class Pair{
        boolean next;
        String str;

        public Pair(boolean next, String str) {
            this.next = next;
            this.str = str;
        }
    }
}
