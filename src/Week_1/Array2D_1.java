package Week_1;
import java.util.*;
public class Array2D_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of rows : ");
        int r=scan.nextInt();

        System.out.println("Enter number of columns");
        int c=scan.nextInt();

        int arr[][]=new int[r][c];

        System.out.println("Enter elements or matrix : ");
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[i][j]=scan.nextInt();
            }
        }

        int positiveNum=0;
        int negativeNum = 0;
        int oddNum=0;
        int evenNum=0;
        int zero = 0;

        for(int ar[]:arr){
            for(int a:ar){
                if(a>0){
                    positiveNum++;
                }else if(a<0){
                    negativeNum++;
                }else if(a==0){
                    zero++;
                }

                if(a%2==0){
                    evenNum++;
                }else{
                    oddNum++;
                }
            }
        }
        
        System.out.println("Positive numbers : "+positiveNum);
        System.out.println("Negative numbers : "+negativeNum);
        System.out.println("number of zeros : "+zero);
        System.out.println("Even Numbers :"+evenNum);
        System.out.println("Odd Number : "+oddNum);
        scan.close();
    }
}