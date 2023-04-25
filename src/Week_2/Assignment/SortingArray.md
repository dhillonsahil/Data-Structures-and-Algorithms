# Question 1 : Write a program to sort an array in descending order using bubble sort .
Answer : 
```java
package Week_2.Assignment;

import java.util.*;
public class BubbleSort_Desc {
    public static void main(String[] args) {
        int[] arr={3,5,1,6,0};
        bubbleSort(arr);
        System.out.println("Descending order Of Array is : "+Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

```

# Question 2 :  WAP to sort an array in descending order using selection sort
Answer :- 
```java
package Week_2.Assignment;
import java.util.*;
public class SelectionSort_Desc {
    public static void main(String[] args) {
        int arr[]={3,5,1,6,0};
        selectionSort(arr);
        System.out.println("Descending Order is : " + Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int mid_idx=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[mid_idx]<arr[j]){
                    mid_idx=j;
                }
            }
            if(mid_idx!=i){
                int temp= arr[mid_idx];
                arr[mid_idx]=arr[i];
                arr[i]=temp;
            }
        }
    }
}

```

# Question 3 : WAP to sort an array in decreasing order using insertion sort
Answer :
```java
package Week_2.Assignment;

import java.util.*;
public class InsertionSort_Desc {
    public static void main(String[] args) {
        int arr[] = {3,5,1,6,0};
        insertionSort(arr);
        System.out.println("Descending order of Arrat is"+Arrays.toString(arr));
    }
    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length-1;i++){
           int j=i;
           while(j>0 && arr[j]>arr[j-1]){
            int temp= arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            j--;
           }
        }
        
    }
}

```