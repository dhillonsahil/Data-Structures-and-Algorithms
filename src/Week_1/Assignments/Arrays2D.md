# Question : Q1: Take m and n input from the user and m * n integer inputs from user and print the following:
## number of positive numbers , negative numbers , number of zeros , even number , odd number
**Answer** : 
```java
import java.util.*;
public class Que1 {
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
```
# Question 2 : write a program to print the elements above the secondary diagonal in a user inputted square matrix.
**Answer** :- 
```java
import java.util.Scanner;

public class Que2 {
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

```

# Question 3 : write a program to print the elements of both the diagonals in a user inputted square matrix in any order.	
Answer
```java
import java.util.Scanner;

public class Que3 {
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
```


# Question 4 : Write a program to find the largest element of a given 2D array of integers.
**Answer** : 
```java
public class Que4{
    public static void main(String[] args){
        int arr[][]={
            {1,2,4,0},
            {2,5,7,-1},
            {4,2,6,9}
        };

        int largest =Integer.MIN_VALUE;
        for(int ar[]:arr){
            for(int a:ar){
                if(a>largest){
                    largest=a;
                }
            }
        }
        System.out.println(largest);
    }
}
```

# Question 5 : Write a function which accepts a 2D array of integers and its size as arguments and  displays the elements of middle row and the elements of middle column. Printing can be done in any order. [Assuming the 2D Array to be a square matrix with odd dimensions i.e. 3x3, 5x5, 7x7 etc...]
**Answer** :
```java
public class Que5 {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5},{3,4,5,6,7},{7,6,5,4,3},{8,7,6,5,4},{1,2,37,8,0} };
        int r=arr.length;
        int c=arr[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((i==r/2 || j==c/2) && i!=j){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
```