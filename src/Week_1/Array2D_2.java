package Week_1;

import java.util.Scanner;

public class Array2D_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows/coulmns for square matrix : ");
        int r=scan.nextInt();
        int[][] arr =new int[r][r];
        System.out.println("Enter Matrix elements : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
               arr[i][j]=scan.nextInt();
            }
        }

        System.out.println("Output : ");
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < r - 1; j++) {
                if(i+j<=r/2){
                    System.out.println(arr[i][j]);
                }                
            }
        }
        scan.close();
    }
}