package B;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVA439 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] chess={
                {1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}
        };


            while (true) {
                try{
                    HashSet<String> vis=new HashSet<>();
                int ans = 0;
                String x = scanner.next();
                String y = scanner.next();
                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(0, x));
                while (!queue.isEmpty()) {
                    Pair pair = queue.poll();
                    if (pair.str.equals(y)) {
                        ans = pair.w;
                        break;
                    }
                    if (!vis.add(pair.str))continue;
                    char[] temp = pair.str.toCharArray();
                    for (int i = 0; i < 8; i++) {
                        char newX = (char) (temp[0] + chess[i][0]);
                        char newY = (char) (temp[1] + chess[i][1]);
                        if (newX <= 'h' && newX >= 'a' && newY <= '8' && newY >= '1') {
                            queue.add(new Pair(pair.w + 1, "" + newX + newY));
                        }
                    }
                }
                System.out.println("To get from " + x + " to " + y + " takes " + ans + " knight moves.");
                }catch (Exception e){
                    break;
                }

        }
    }
    static class Pair{
        int w;
        String str;

        public Pair(int w, String str) {
            this.w = w;
            this.str = str;
        }
    }
}
