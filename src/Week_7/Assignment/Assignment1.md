# Q1. Given an array where all its elements are sorted in increasing order except two swapped elements, sort it in linear time. Assume there are no duplicates in the array.
Answer
```java
package Week_7.Assignment;

import java.util.Arrays;

public class Question1{
    public static void main(String[] args) {
        int arr[]={3,8,6,7,5,9,10};
        // int arr[]={3,6,5,7,8,9,10};
        mergeSort(arr,0,arr.length-1);
        System.out.println("Array now is "+Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int arr[],int l,int h){
        if(l<h){
            int m = l+(h-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, h);

            // merge Procesdure
            mergeProcedure(arr, l, m, h);

        }
    }
    public static void mergeProcedure(int arr[],int l , int m, int h){
        int lsubarr[]=Arrays.copyOfRange(arr, l, m+1);
        int rsubarr[]=Arrays.copyOfRange(arr,m+1,h+1);

        int i=0,j=0,k=l;

        while(i<lsubarr.length && j<rsubarr.length){
            if(lsubarr[i]<=rsubarr[j]){
                arr[k++]=lsubarr[i++];
            }else{
                arr[k++]=rsubarr[j++];
            }
        }
        while(i<lsubarr.length){
            arr[k++]=lsubarr[i++];
        }

        while(j<rsubarr.length){
            arr[k++]=rsubarr[j++];
        }
    }

}
```

# Q2. Given an array of positive and negative integers, segregate them in linear time and constant space. The output should print all negative numbers, followed by all positive numbers.
```java
package Week_7.Assignment;

import java.util.Arrays;

public class Question2{
    public static void main(String[] args) {
        int arr[]={19,-20,7,-4,-13,11,-5,3};
        segrate(arr, 0, 0);
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int arr[], int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void segrate(int arr[],int i,int j){
        if(j<arr.length ){
            if(arr[j]<0){
                swap(arr, i, j);
                segrate(arr, i+1, j+1);
            }else{
                segrate(arr, i, j+1);
            }
        }
    }
}

```

# Q3 : Given an array of positive and negative integers, segregate them in linear time and constant space. The output should print all negative numbers, followed by all positive numbers. The relative order of elements must remain the same.
Answer :
```java
package Week_7.Assignment;

import java.util.Arrays;

public class Question3 {
    public static void main(String[] args) {
        int arr[] = {19,-20,7,-4,-13,11,-5,3};
        int[] temp=new int[arr.length];
        segerateRelative(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void segerateRelative(int arr[],int temp[],int start,int end){
        if(end<=start)return;
        // else
        int mid=start+(end-start)/2;
        segerateRelative(arr,temp,start, mid);
        segerateRelative(arr,temp, mid+1, end);

        // merge
        merge(arr, temp, start, mid, end);
    }
   public static void  merge(int[] arr,int[] temp ,int start,int mid,int end){
    int k = start;

    // negative of left
    for(int i=start;i<=mid;i++){
        if(arr[i]<0){
            temp[k++]=arr[i];
        }
    }
    // negATive of right

    for(int i=mid+1;i<=end;i++){
        if(arr[i]<0){
            temp[k++]=arr[i];
        }
    }

     // positive of left
    for(int i=start;i<=mid;i++){
        if(arr[i]>0){
            temp[k++]=arr[i];
        }
    }
    /// right positive
    for(int i=mid+1;i<=end;i++){
        if(arr[i]>=0){
            temp[k++]=arr[i];
        }
    }

    // copy to original
    for(int i=start;i<=end;i++){
        arr[i]=temp[i];
    }

    }
}

```

# Q4. Given two arrays of equal size n and an integer k. The task is to permute both arrays such that the sum of their corresponding element is greater than or equal to k i.e a[i] + b[i] >= k. The task is to print “Yes” if any such permutation exists, otherwise print “No”.

Answer :
```java
package Week_7.Assignment;
public class Question4 {
    public static void main(String[] args) {
            int a[]={2,1,3};
            int b[]={7,8,9};
            int k=10;
            checkPerms(a, b, 0, k);
      
    }
    public static void checkPerms(int a[], int b[], int i, int k){
        if(i<a.length){
            if(a[i]+b[i]>=k){
                System.out.println("Yes");
                System.exit(0);
            }else{
                checkPerms(a, b, i+1, k);
            }
        }else{
            System.out.println("No");
        }
    }
}

```

# Q5.Anintervalisrepresentedasacombinationofstarttimeandendtime.Givenasetofintervals, checkifanytwointervalsintersect.
Answer : 
```java
package Week_7.Assignment;

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        int arr[][] = {
            {1,3},{5,7},{2,4},{6,8}
        };

        if (checkIntersect(arr, 0, arr.length - 1)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean checkIntersect(int[][] arr, int start, int end) {
        if (start == end) {
            return false; // Only one interval, no intersection
        }

        int mid = start + (end - start) / 2;
        boolean left = checkIntersect(arr, start, mid); // Check intersection in the left half
        boolean right = checkIntersect(arr, mid + 1, end); // Check intersection in the right half

        // Merge the results from the left and right halves
        if (left || right) {
            return true; // If intersection is found in either half, return true
        } else {
            return hasIntersection(arr[mid], arr[mid + 1]); // Check intersection between middle intervals
        }
    }

    public static boolean hasIntersection(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0]; // Check if the end of the first interval is greater than or equal to the start of the second interval
    }
}


```