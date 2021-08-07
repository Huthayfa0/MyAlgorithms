package B;

import java.util.*;

public class UVA1174 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int ii=0;
            HashMap<String,Integer> map=new HashMap<>(n);
            int[][] edges=new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    String s=scanner.next();
                    if (!map.containsKey(s))
                        map.put(s,ii++);
                    edges[i][j]=map.get(s);
                }
                edges[i][2]=scanner.nextInt();
            }
            Arrays.sort(edges, Comparator.comparing(e->e[2]));
            int[] rank=new int[n];
            int[] parent=new int[n];
            for (int i = 0; i < n ; i++) {
                parent[i]=i;
            }
            int cost=0;
            for (int[] e: edges){
                if (unionSets(e[0],e[1],rank,parent)){
                    // unionSets(e[0],e[1],rank,parent);
                    cost+=e[2];
                }
            }
            System.out.println(cost);
            if (t>0)
                System.out.println();
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
