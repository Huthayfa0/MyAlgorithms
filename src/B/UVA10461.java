package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVA10461 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count=0;
        while (true){
            count++;
            int v=scanner.nextInt();
            int e=scanner.nextInt();
            if (e==0&&v==0)
                break;
            int[] arr=new int[v];
            for (int i = 0; i < v; i++) {
                arr[i]=scanner.nextInt();
            }
            ArrayList<Integer>[] adjacencyList1=new ArrayList[v];
            ArrayList<Integer>[] adjacencyList2=new ArrayList[v];
            for (int i = 0; i < v; i++) {
                adjacencyList1[i]=new ArrayList<>();
                adjacencyList2[i]=new ArrayList<>();
            }
            while (e-->0){
                int x=scanner.nextInt()-1;
                int y=scanner.nextInt()-1;
                adjacencyList1[x].add(y);
                adjacencyList2[y].add(x);
            }
            int t=scanner.nextInt();
            int sum= Arrays.stream(arr).sum();
            System.out.println("Case #"+count+":");
            while (t-->0){
                int val=scanner.nextInt()-1;
                boolean[] vis1=new boolean[v];
                boolean[] vis2=new boolean[v];
                int sum1=dfs(val,adjacencyList1,vis1,arr)-arr[val];
                int sum2=sum-dfs(val,adjacencyList2,vis2,arr);
                System.out.println(Math.abs(sum1-sum2));
            }
            System.out.println();
        }
    }
    static int dfs(int i,ArrayList<Integer>[] list,boolean[] vis,int[] cost){
        int sum=cost[i];
        vis[i]=true;
        sum += list[i].stream().filter(e -> !vis[e]).mapToInt(e -> dfs(e, list, vis, cost)).sum();
        /*
        list[i].forEach(e->{
            if (!vis[e]){
                sum+=dfs(e,list,vis,cost);
            }
        });
         */
        return sum;
    }
}
