package B;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UVA11503 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0){
            HashMap<String,Integer> strings=new HashMap<>();
            int F=scanner.nextInt();
            int[][] list=new int[F][2];
            int count=0;
            for (int i = 0; i < F; i++) {
                String s=scanner.next();
                if (!strings.containsKey(s)){
                    strings.put(s,count++);
                }
                list[i][0]=strings.get(s);
                s=scanner.next();
                if (!strings.containsKey(s)){
                    strings.put(s,count++);
                }
                list[i][1]=strings.get(s);
            }
            int[] parent=new int[count];
            int[] rank=new int[count];
            int[] cost=new int[count];
            for (int i = 0; i < count; i++) {
                cost[i]=1;
                parent[i]=i;
            }
            for (int[] x:list){
              /*  if (unionSets(x[0],x[1],rank,parent)){
                    cost[x[0]]+=cost[x[1]];
                    cost[x[1]]=cost[x[0]];
                }
                assert cost[x[0]]==cost[x[1]];*/
                System.out.println(unionSets(x[0],x[1],rank,parent,cost));
            }
        }
    }
    static int getSet(int i,int[] parent){
        if (parent[i]==i){
            return i;
        }
        return parent[i]=getSet(parent[i],parent);
    }
    static int unionSets(int i,int j,int[] ranks,int[] parent,int[] cost){

        int ii=getSet(i,parent);
        int jj=getSet(j,parent);
        if (ii!=jj) {
            if (ranks[ii]>ranks[jj]){
                parent[jj]=ii;
                cost[ii]+=cost[jj];
            }else if (ranks[jj]>ranks[ii]){
                parent[ii]=jj;
                cost[jj]+=cost[ii];
            }else {
                parent[ii]=jj;
                cost[jj]+=cost[ii];
                ranks[jj]++;
            }
        }
        return Math.max(cost[ii],cost[jj]);
    }
}
