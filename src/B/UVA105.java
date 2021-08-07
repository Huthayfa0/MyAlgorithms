package B;

import java.util.*;

public class UVA105 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<int[]> list=new ArrayList<>();
        while (true){
            try {
                list.add(new int[]{
                        scanner.nextInt(),
                        scanner.nextInt(),
                        scanner.nextInt()
                });
            }catch (Exception e){
                break;
            }
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparing(e->-e[1]));
        int current=list.get(0)[0];
        System.out.print(current);
        int prev=0;
        Iterator<int[]> iterator=list.iterator();
        queue.add(iterator.next());
        while (iterator.hasNext()) {
            int[] n= iterator.next();
            while (!queue.isEmpty()){
                int[] x=queue.peek();
                if (x[0]==n[0])
                    break;
                if (x[2]<n[0]){
                    queue.poll();

                        System.out.print(" "+x[1]+" "+x[2]);
                    current=x[2];
                    while (!queue.isEmpty()&&current>=queue.peek()[2])
                        queue.poll();
                }else {
                    if (x[1]<n[1]){

                        System.out.print(" "+x[1]+" "+n[0]);
                    }
                    break;
                }
            }
            if (queue.isEmpty()){
                System.out.print(" 0 "+n[0]);

            }
            queue.add(n);
        }
        while (!queue.isEmpty()&&current>=queue.peek()[2])
            queue.poll();
        while (!queue.isEmpty()){
            int[] x=queue.poll();

                System.out.print(" "+x[1]+" "+x[2]);
            current=x[2];
            while (!queue.isEmpty()&&current>=queue.peek()[2])
                queue.poll();
        }
        System.out.println(" 0");
    }
}
