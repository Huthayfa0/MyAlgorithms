package B;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class UVA10600 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[][] edges=new int[m][3];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    edges[i][j]=scanner.nextInt();
                }
            }
            Arrays.sort(edges, Comparator.comparing(e->e[2]));


            int[] rank=new int[n+1];
            int[] parent=new int[n+1];
            for (int i = 1; i < n + 1; i++) {
                parent[i]=i;
            }
            int cost=0;
            HashSet<int[]> pairs=new HashSet<>();
            for (int[] e: edges){
                if (unionSets(e[0],e[1],rank,parent)){
                   // unionSets(e[0],e[1],rank,parent);
                    pairs.add(e);
                    cost+=e[2];
                }
            }
            System.out.print(cost+" ");
            int secondMin=Integer.MAX_VALUE;
            for (int[] x:pairs){
                HashSet<int[]> sset=new HashSet<>();
                for (int i = 1; i < n + 1; i++) {
                    rank[i]=0;
                    parent[i]=i;
                }
                cost=0;
                for (int[] e: edges){
                    if (e!=x&&unionSets(e[0],e[1],rank,parent)){
                        sset.add(e);
                        cost+=e[2];
                    }
                }
                if (sset.size()==n-1)
                if (cost<secondMin)secondMin=cost;
            }
            System.out.println(secondMin);
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
