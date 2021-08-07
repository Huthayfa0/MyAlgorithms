package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVA784 {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        char[] xx;
        while (t-->0){
            ArrayList<char[]> list=new ArrayList<>();
            while (true) {
                xx = s.nextLine().toCharArray();
                if (xx[0] == '_')
                    break;
                list.add(xx);
            }
            int i=-1,j=-1;
            m:
            for (i = 0; i <list.size() ; i++) {
                char[]ss= list.get(i);
                for (j = 0; j < ss.length; j++) {
                    if (ss[j]=='*')
                        break m;
                }
            }
            dfs(i,j,list);
            for (char[] ss : list) {
                for (char c : ss) {
                    System.out.print(c);
                }
                System.out.println();
            }
            for (char c : xx) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    static void dfs(int i,int j,ArrayList<char[]> list){
        try {
            if (list.get(i)[j]!=' '&&list.get(i)[j]!='*')
                return;
        }catch (Exception e){
            return;
        }
        if (list.get(i)[j]=='#')
            return;
        list.get(i)[j]='#';
        dfs(i+1,j,list);
        dfs(i-1,j,list);
        dfs(i,j+1,list);
        dfs(i,j-1,list);
    }
}
