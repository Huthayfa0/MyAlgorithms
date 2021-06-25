package A;

import java.util.Scanner;

public class UVA460 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while (t-->0) {
            int [][]rect=new int[2][4];//xll yll xur yur
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    rect[i][j]=scanner.nextInt();
                }
            }
            if (Math.max(rect[0][0],rect[1][0]) >= Math.min(rect[0][2],rect[1][2]) || Math.max(rect[0][1],rect[1][1])  >= Math.min(rect[0][3],rect[1][3])){
                System.out.println("No Overlap");
            }else {
                System.out.printf("%d %d %d %d\n",Math.max(rect[0][0],rect[1][0]),Math.max(rect[0][1],rect[1][1]),Math.min(rect[0][2],rect[1][2]),Math.min(rect[0][3],rect[1][3]));
            }
            if (t!=0)System.out.println();
        }
    }
}
