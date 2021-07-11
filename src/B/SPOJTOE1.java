package B;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SPOJTOE1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            boolean ans=false;
            String cur=scanner.next();
            cur+=scanner.next();
            cur+=scanner.next();
            char[]end=cur.toCharArray();
            Queue<Pair> queue=new LinkedList<>();
            queue.add(new Pair(true,"........."));
            while (!queue.isEmpty()){
                Pair pair= queue.poll();
                char xo=pair.next?'X':'O';
                if (pair.str.equals(cur)){
                    ans=true;
                    break;
                }

                char[] str=pair.str.toCharArray();
                if (done(str))continue;
                for (int i = 0; i < 9; i++) {
                    if (str[i]=='.'&&end[i]==xo){
                        str[i]=xo;
                        queue.add(new Pair(!pair.next, String.valueOf(str)));
                        str[i]='.';
                    }
                }
            }
            if (ans)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
    static boolean done(char[] x){
        return x[0] != '.' && x[0] == x[1] && x[1] == x[2]
                || x[3] != '.' && x[3] == x[4] && x[4] == x[5]
                || x[6] != '.' && x[6] == x[7] && x[7] == x[8]
                || x[0] != '.' && x[0] == x[3] && x[3] == x[6]
                || x[1] != '.' && x[1] == x[4] && x[4] == x[7]
                || x[2] != '.' && x[2] == x[5] && x[5] == x[8]
                || x[0] != '.' && x[0] == x[4] && x[4] == x[8]
                || x[2] != '.' && x[2] == x[4] && x[4] == x[6];
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
