package Week_1;
import java.util.*;

public class PrefixSumOptimized{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of rows : ");
        int m=scan.nextInt();
        System.out.print("Enter number of Columns : ");
        int n= scan.nextInt();
        int arr[][] = new int[m][n];

        System.out.println("Enter the matrix elements");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = scan.nextInt();
            }
        }

        // take cordinates
        System.out.print("Enter the value of r1 : ");
        int r1=scan.nextInt();
        System.out.print("Enter the value of c1 : ");
        int c1=scan.nextInt();
        System.out.print("Enter the value of r2 : ");
        int r2=scan.nextInt();
        System.out.print("Enter the value of c2 : ");
        int c2=scan.nextInt();


        prefixMatrix(arr);
        int result = sum(arr, r1, c1, r2, c2);
        System.out.print("Sum is : " + result);
        scan.close();
    }
    public static void prefixMatrix(int arr[][]){
        int rows=arr.length;
        int col = arr[0].length;

        // row wise prefix sum
        for(int i=0;i<rows;i++){
            for(int j=1;j<col;j++){
                arr[i][j]+=arr[i][j-1];
            }
        }

        // column wise prefix sum
        for(int i=1;i<rows;i++){
            for(int j=0;j<col;j++){
                arr[i][j]+=arr[i-1][j];
            }
        }

    }
    public static int sum(int arr[][] , int r1, int c1 , int r2, int c2){
        int total=0,left=0,repeated=0,up=0;
        total=arr[r2][c2];
        
        if(r1==0 && c1!=0){
            left=arr[r2][c1-1];
            up=0;
            repeated=0;
        }else if(r1== 0 && c1==0){
            left=0;
            up=0;
            repeated=0;
        }
        else if(c1==0 ){ // correct tested
            left =0;
            repeated=0;
            up=arr[r1-1][c2];
        }
        else{
            left=arr[r2][c1-1];
            up=arr[r1-1][c2];
           repeated=arr[r1-1][c1-1];
        }
        
        return total-left-up+repeated; 
    }
}