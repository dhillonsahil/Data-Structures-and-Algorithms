# Q1. Given an integer array arr and an integer k, return true if it is possible to divide the vector into k non-empty subsets with equal sum.
Answer
```java
public class BackTracking_1{
    
   public static boolean helper(int []arr , int []vis , int si , int curr_sum , int target , int k)
    {
        if(k==1)return true;
        if(curr_sum>target) return false;
        if(curr_sum==target)return helper(arr,vis,0,0,target,k-1);

        for(int i=si;i<arr.length;i++){
            if(vis[i]==-1){
                vis[i]=1;
                if(helper(arr,vis,i+1,curr_sum+arr[i],target,k) == true)return true;
                vis[i]=-1;
            }
        }
        return false;
    }
    public static boolean canPartition(int []arr, int k) {
        int n=arr.length;
        int []vis = new int[n];
        for(int i=0;i<n;i++)vis[i] = -1;
        int sum=0;
        for(int i=0;i<n;i++)sum+=arr[i];
       
        if(sum%k!=0)return false;
        return helper(arr,vis,0,0,sum/k,k);
    }
    public static void main(String[] args){
        int []arr = {1 , 2 , 2 , 3};
        int k = 2;
        
        if(canPartition(arr , k) == true){
            System.out.println("Possible");
        }
        else System.out.println("Not Possible");
    }
}
```

# Q2. Given an integer array arr, print all the possible permutations of the given array.
Answer :
```java
package Week_4.Assignment;

import java.util.*;
public class BackTracking_2{
    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        permutations(arr,new ArrayList<>(),res);
        System.out.println(res);
    }
    public static void permutations(int arr[],List<Integer> temp,List<List<Integer>> result){
        if(temp.size()==arr.length){
            result.add(new ArrayList<>(temp));
        }
        for(int i=0;i<arr.length;i++){
            if(temp.contains(arr[i]))continue;
            temp.add(arr[i]);
            permutations(arr, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}
```

# 
Answer :
```java
import java.util.*;

public class BackTracking_3 {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2 };
        List<List<Integer>> res = new ArrayList<>();
        permutations(arr, new ArrayList<>(), res);
        System.out.println(res);
    }

    public static void permutations(int arr[], List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == arr.length) {
            List<Integer> re=new ArrayList<>(temp);
           if(result.contains(re)){
            return;
           }
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int te=arr[i];
            if(arr[i]==Integer.MIN_VALUE)continue;
            temp.add(arr[i]);
            arr[i]=Integer.MIN_VALUE;
            permutations(arr, temp, result);
            arr[i]=te;
            temp.remove(temp.size() - 1);
        }
    }
}
```

# Q4. Check if the product of some subset of an array is equal to thetarget value.
Answer:
```java
public class BackTracking_4 {
    static boolean flag=false;
    public static void main(String[] args) {
        int arr[]={2,3,2,5,4};
        int target =16;
        checkSubset(arr, target, 0);
        System.out.println(flag);
    }
    public static void checkSubset(int arr[],int target, int start){
        if(target==0){
            flag=true;
            return;
        }else if(target <0){
            return;
        }
        // check
        for(int i=start;i<arr.length;i++){
            int temp=arr[i];
            if(temp==target){
                flag=true;
            }
            if(target%arr[i]==0){
                checkSubset(arr, target/arr[i], start+1);
            }
        }
    }
}

```

# Q5. The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Answer 
```java
public class CountNQueen{
    static int count=0;
    public static void main(String[] args) {
        int n = 5;
        char board[][]= new char[n][n];

        // initlialzie
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='X';
            }
        }

        nQueen(board, 0);
        System.out.println(count);
    }

    public static boolean isSafe(char board[][], int row,int col){
        // check row
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q')return false;
        }

        // check up left 
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }

        // check right left
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q')return false;
        }

        return true;
    }

    public static void nQueen(char board[][],int row){
        // base call
        if(row==board.length){
            count++;
            return;
        }
        

        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row , j)){
                board[row][j]='Q';
                nQueen(board, row+1);
                board[row][j] = 'X'; // Backtraking step
            }
        }
    }
}
```