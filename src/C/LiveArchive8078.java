package C;

import java.util.Scanner;

public class LiveArchive8078 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=Integer.parseInt(s.nextLine());
        for (int tt = 1; tt <= t; tt++) {
            System.out.println("Case "+tt+":");
            char[] arr=s.nextLine().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                int[]as=new int[4];
                int count=0;
                for (int j = i; j < arr.length; j++) {
                    switch (arr[j]){
                        case '(':
                            as[0]++;
                            break;
                        case '{':
                            as[1]++;
                            break;
                        case '<':
                            as[2]++;
                            break;
                        case '[':
                            as[3]++;
                            break;
                        case ')':
                            as[0]--;
                            break;
                        case '}':
                            as[1]--;
                            break;
                        case '>':
                            as[2]--;
                            break;
                        case ']':
                            as[3]--;
                            break;
                    }
                    if (as[1]<0||as[2]<0||as[0]<0||as[3]<0)
                        break;
                    count++;
                }
                if (as[1]>0||as[2]>0||as[0]>0||as[3]>0)
                    System.out.println(0);
                else
                    System.out.println(count);
            }
        }
    }
}
