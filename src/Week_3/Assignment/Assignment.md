# Question 1: Given an integer, find out the sum of its digits using recursion
Answer : 
```java
package Week_3;

public class SumOfDigits{
    public static  void main(String args[]){
        int n = 1234;
        int result = sumOfDigits(n);
        System.out.println(result);
    }
    public static int sumOfDigits(int n){
        if(n<=0){
            return 0;
        }
        
        return n%10 + sumOfDigits(n/10);
    }
}
```

# Questiion 2 :  Given a number n. Find the sum of natural numbers till n but with alternate signs. That means if n = 5 then you have to return 1-2+3-4+5 = 3 as your answer.Constraints : 0<=n<=1e6

Answer : 
```java
package Week_3;

public class Question2 {
    public static void main(String[] args) {
        int n=10;
        int result=sumAlternateSign(n);
        System.out.println(result);
    }
    public static int sumAlternateSign(int n){
        if(n<=0 || n>1000000){
            return 0;
        }else {
            if(n%2==0){
                return  -n + sumAlternateSign(--n) ;
            }else{
                return n + sumAlternateSign(--n) ; 
            }
        }
    }
}

```

# Question 3 : Print the max value of the array [ 13, 1, -3, 22, 5]
Answer : 
```java
package Week_3;
public class Max {
    public static void main(String[] args) {
        int arr[] = {13,1,-3,22,5};
        int result = findMax(arr);
        System.out.println(result);
    }
    public static int findMax(int arr[]){
        return checkMax(arr, 0);
    }
    public static int checkMax(int arr[],int i){
        if(i==arr.length-1){
            return arr[i];
        }
        int Max=checkMax(arr,i+1);
        return arr[i]>Max?arr[i]:Max;
    }
}
```
# Question 4 :  Find the sum of the values of the array [92, 23, 15, -20, 10]
Answer : 
```java
package Week_3;

public class SumArray {
    public static void main(String[] args){
        int []arr={1,2,3,4};
        int result= sumOfArray(arr,0);
        System.out.println(result);
    }
    public static int sumOfArray(int arr[],int a){
        if(a==arr.length-1){
            return arr[a];
        }
        return arr[a]+sumOfArray(arr, ++a);
    }
}
```

# Question 5 : Given a number n. Print if it is an armstrong number or not. An armstrong number is a number if the sum of every digit in that number raised to the power of total digits in that number is equal to the number.Example : 153 = 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153 hence 153 is an armstrong number.

Answer : 
```java
package Week_3;
import java.util.*;;
public class ArmStrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=sc.nextInt();
        int result=armStrong(n);
        if(result==n){
            System.out.println("The number is arm Strong");
        }else{
            System.out.println("The number is not arm strong");
        }
        sc.close();
    }
    public static int armStrong(int n){
        if(n<=0){
            return 0;
        }
        return (int)Math.pow(n%10, 3) + armStrong(n/10);
    }
}

```