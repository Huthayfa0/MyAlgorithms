package B;

import java.util.Scanner;

public class UVA11094 {
    static int c=0;
    static char l='l';
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
            while (true) {        try {

                int m = scan.nextInt();
                int n = scan.nextInt();
                char[][] map = new char[m][];
                for (int i = 0; i < m; i++) {
                    map[i] = scan.next().toCharArray();
                }
                int x = scan.nextInt() ;
                int y = scan.nextInt() ;
                boolean[][] vis = new boolean[m][n];
                int max = 0;
                l=map[x][y];
                dfs(map,vis,x,y);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (!vis[i][j]) {
                            if (map[i][j] == l) {
                                c = 0;
                                dfs(map, vis, i, j);
                                if ( c > max) {
                                    max = c;
                                }
                            } else
                                vis[i][j] = true;
                        }
                    }
                }
                System.out.println(max);
            }catch (Exception ignored){
                break;
            }
            }

    }

    private static void dfs(char[][] map, boolean[][] vis, int i, int j) {
        if (vis[i][j])return;
        vis[i][j]=true;
        if (map[i][j]==l) {
            c++;
        }else
            return;
        if (j==0){
            dfs(map,vis,i,map[0].length-1);
            dfs(map,vis,i,j+1);
        }else if (j==map[0].length-1){
            dfs(map,vis,i,0);
            dfs(map,vis,i,j-1);
        }else{
            dfs(map,vis,i,j-1);
            dfs(map,vis,i,j+1);
        }
        if (i==0){
            //dfs(map,vis,i,map.length-1);
            dfs(map,vis,i+1,j);
        }else if (i==map.length-1){
            //dfs(map,vis,i,0);
            dfs(map,vis,i-1,j);
        }else{
            dfs(map,vis,i-1,j);
            dfs(map,vis,i+1,j);
        }

    }
}
