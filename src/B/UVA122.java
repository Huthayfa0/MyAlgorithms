package B;

import java.util.*;

public class UVA122 {
    private static class Pair implements Comparable<Pair>{
        public Pair(int x, String s) {
            this.x = x;
            this.s = s;
        }

        final int x;
        final String s;

        @Override
        public int compareTo(Pair o) {
            int x=Integer.compare(s.length(),o.s.length());
            if (x!=0)
                return x;
            else
                return s.compareTo(o.s);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            try {

                ArrayList<Pair> list=new ArrayList<>();
               while (true){
                   String s=scanner.next();
                   s=s.substring(1,s.length()-1);
                   if (s.trim().length()==0)
                       break;
                   String[] ss=s.split(",");
                   if (ss.length==2)
                    list.add(new Pair(Integer.parseInt(ss[0]),ss[1]));
                   else
                       list.add(new Pair(Integer.parseInt(ss[0]),""));
               }
               Collections.sort(list);
               boolean bad=false;
                HashSet<Integer> set=new HashSet<>();
                for (Pair x:list) {
                   char[]xx= x.s.toCharArray();
                   int v=1;
                    for (char c : xx) {
                        v *= 2;
                        if (c == 'R') v++;
                    }
                    if (v==1) {
                        if (!set.add(1)) {
                            bad = true;
                            break;
                        }
                    }
                    else {
                        if (!set.contains(v/2)||!set.add(v)){
                            bad=true;
                            break;
                        }
                        //set.add(v);
                    }
                }
                if (bad){
                    System.out.println("not complete");
                }
                else{
                    System.out.print(list.get(0).x);
                    for (int i = 1; i < list.size(); i++) {
                        System.out.print(" "+list.get(i).x);
                    }
                    System.out.println();
                }
            }catch (Exception ignored){
                break;
            }
        }
    }
}
