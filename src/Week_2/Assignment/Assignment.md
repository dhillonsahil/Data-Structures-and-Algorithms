# Question 1 : Given an array. FInd the number X in the array. If the element is present, return the index of the element, else print “Element not found in array”. Input the size of array, array from user and the element X from user. Use Linear Search to find the element.
Answer :- 
```java
package Week_2.Assignment;
import java.util.*;

public class Solution_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements you want to add : ");
        int size= scan.nextInt();
        int arr[]= new int [size];
        System.out.println("Enter the elements of the Array");
        for(int i=0;i<size;i++){
            arr[i]=scan.nextInt();
        }
        System.out.print("Enter the element to be Searched in the Array : ");
        int target = scan.nextInt();
        boolean flag= false;
        for(int i=0;i<size;i++){
            if(arr[i] ==target){
                System.out.println("Element Found At index : "+i);
                flag=true;
                break;
            }
        }
        if(!flag){
            System.out.println("Element not Found");
        }
        scan.close();
    }
}
```

# Question 2 :Given an array and an integer “target”, return the last occurrence of “target” in the array. If the target is not present return -1.
Answer : 
```java
package Week_2.Assignment;

import java.util.*;
public class FindLastOccurence {
    public static void main(String[] args) {
        int arr[ ] = {1,1,1,2,3,4,4,5,6,6,6,6};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number to find last occurence : ");
        int target = scan.nextInt();
        int result=lastOccurence(arr , target);
        System.out.println(result);
        scan.close();

    }
    public static int lastOccurence(int arr[] , int target){
        int low= 0,high=arr.length-1;int result=-1;
        while(low<=high){
            int mid_idx = low + (high-low)/2;
            if(arr[mid_idx]==target){
                result=mid_idx;
                low=mid_idx+1;
            }else if(arr[mid_idx]<target){
                low = mid_idx+1;
            }else if(arr[mid_idx]>target){
                high=mid_idx-1;
            }
        }
        return result;
    }
}

```

# Question 3 : Given a sorted binary array, efficiently count the total number of 1’s in it.
Answer :
```java

package Week_2.Assignment;

public class Count {
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,1,1,1,1,1,1};
        int count = check(arr);
        System.out.println("Number of 1 present are " +count);
    }
    public static int check(int arr[]){
        int count = 0; int idx=-1;
        for(int i=0;i<arr.length;i++){
            int low=0 , high = arr.length-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(arr[mid]==1){
                   idx=mid;
                   high=mid-1; 
                }else if( arr[mid]<1){
                    low=mid+1;
                }else if(arr[mid]> 1){
                    high=mid-1;
                }
            }
        }
        count=arr.length-idx;
        return count;
    }
}

```

# Question 4 : Given a sorted integer array containing duplicates, count occurrences of a given number. If the element is not found in the array, report that as well.
Answer : 
```java
package Week_2.Assignment;
import java.util.*;;

public class CountDuplicate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[] = {2,5,5,5,6,6,8,9,9,9};
        int target = scan.nextInt();
        int result=count(arr, target);
        System.out.println(result!=0?"Target "+ target+ " Occured " + result + " times":"Not Found");
    }
    public static int binarySearch(int arr[], int target){
        int low=0;int high = arr.length-1;
        for(int i=0;i<arr.length;i++){
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                return mid;
            }else if( arr[mid]<target){
                low=mid+1;
            }else if(arr[mid]> target){
                high=mid-1;
            }
        }

        return -1;
    }
    public static int count(int arr[], int target){
        int first_occurence =binarySearch(arr, target);
        if(first_occurence==-1){
            return 0;
        }

        int count=1;
        int left= first_occurence-1;
        while(left>=0 && arr[left]==target){
            count++;
            left--;
        }
        int right=first_occurence + 1;
        while(right<arr.length-1 && arr[right]==target){
            count++;
            right++;
        }
        return count;
    }
}

```

# Question 5 : Given a positive integer num, return true if num is a perfect square or false otherwise. A perfect square is an integer that is the square of an integer.
Answer :
```java
package Week_2.Assignment;

import java.util.Scanner;

public class SquareCheck {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        boolean result = checkSquare(num);
        System.out.println(result);
        scan.close();
    }
    public static boolean checkSquare(int num){
        boolean flag = false;
        int low = 0 , high = num;
        while(low<=high){
            int mid = (low + high)/2;
            int sq =mid*mid;
            if(sq==num){
                return true;
            }else if(sq<num){
                low=mid+1;
            }else if(sq>num){
                high=mid-1;
            }
        }
        return flag;
    }
}
```