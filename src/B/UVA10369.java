package B;

import java.util.*;

public class UVA10369 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int s=scanner.nextInt();
            int n=scanner.nextInt();
            int[][] points=new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    points[i][j]=scanner.nextInt();
                }
            }
            ArrayList<int[]> edges=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    edges.add(new int[]{i,j,(points[i][0]-points[j][0])*(points[i][0]-points[j][0])+(points[i][1]-points[j][1])*(points[i][1]-points[j][1])});
                }
            }
            edges.sort(Comparator.comparing(e->e[2]));
            //Arrays.sort(edges, Comparator.comparing(e->e[2]));

            int[] rank=new int[n];
            int[] parent=new int[n];
            for (int i = 1; i < n ; i++) {
                parent[i]=i;
            }
            int i;
            for (i = 0; i <edges.size() ; i++) {
                int [] e=edges.get(i);
                if (unionSets(e[0],e[1],rank,parent)){
                    // unionSets(e[0],e[1],rank,parent);
                    n--;
                }
                if (n==s)break;
            }
            System.out.printf("%.2f\n",Math.sqrt(edges.get(i)[2]));

        }
    }
    static int getSet(int i,int[] parent){
        if (parent[i]==i){
            return i;
        }
        return parent[i]=getSet(parent[i],parent);
    }
    static boolean unionSets(int i,int j,int[] ranks,int[] parent){

        int ii=getSet(i,parent);
        int jj=getSet(j,parent);
        if (ii!=jj) {
            if (ranks[ii]>ranks[jj]){
                parent[jj]=ii;
            }else if (ranks[jj]>ranks[ii]){
                parent[ii]=jj;
            }else {
                parent[ii]=jj;
                ranks[jj]++;
            }
            return true;
        }
        return false;
    }
}
