package Week_1;

import java.util.*;
public class Array2D_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter rows/coulmns number of a squared matrix : ");
        int r=scan.nextInt();
        int arr[][] = new int[r][r];
        System.out.println("Enter matrix elements : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                arr[i][j]=scan.nextInt();
            }
        }
        // int r=arr.length;
        System.out.println("Output : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<r;j++){
                if(i==j || i+j==r-1){
                    System.out.println(arr[i][j]);
                }
            }
        }
        scan.close();
    }
}
