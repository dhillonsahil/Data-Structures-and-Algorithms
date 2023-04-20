# Question 1 : Write a program to print sum of all elements present on even indicies in the given array ?
Answer :
```java
public class Que1{
    public static void main(String[] args){
        int arr[] = {3,20,4,6,9};
        int sum=0;
        for(int i=0;i<arr.length;i+=2){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
```
# Question 2: Write a program to traverse over the elements of the array using for each loop and print all even elements.
Answer :
```java
public class PrintEven{
    public static void main(String[] args){
        int arr[]= {34,21,54,65,43};
        for(var a:arr){
            if(a%2==0){
                System.out.println(a);
            }
        }
    }
}
```

# Question 3: Write a program to calculate the maximum element in the array.
Answer :- 
```java
public class Maximum{
    public static void main(String[] args){
        int arr[]={34,21,54,65,43};
        int max=0;
        for(int a:arr){
            if(a>max){
                max=a;
            }
        }
        System.out.println(max);
    }
}
```
# Question 4 : Write a program to find the second largest element in array;
Answer :- 
```java
public class SecondLargest{
    public static void main(String[] args){
        int arr[] = { 34, 21, 54, 65, 43 };
        int largest = Integer.MIN_VALUE;
        int SecondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                SecondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > SecondLargest && arr[i] != largest) {
                SecondLargest = arr[i];
            }
        }
        System.out.println(SecondLargest);
    }
}
```

# Question 5 : Given an array. Find the first peak element in the array. A peak element is an element that is greater than its just left and just right neighbor.
Answer :- 
```java
public class PeakElement{
    public static void main(String[] args){
        int arr[] ={1,4,7,3,2,6,5};
        
        for(int i=0;i<arr.length-2;i++){
            if(arr[i+1]<arr[i] && arr[i-1]<arr[i]){
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
```