# Question 1 : given a number, print its binary representation.
Answer : 
```java
package Week_2;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int x= scan.nextInt();
        int binaryNum = 0;
        int pow = 1;
        while(x>0){
            int remainder = x%2;
            binaryNum+=remainder*pow;
            pow*=10;
            x/=2;
        }
        System.out.println(binaryNum);
        scan.close();
    }
}
```

# Question 2 : given a number ‘n’, predict whether it is a power of two or not.
Answer : 
```java
import java.util.*;
public class Question11{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = scan.nextInt(); 
        boolean flag =checkPower(num);
        if(flag){
            System.out.println("This is power of 2");
        }else {
            System.out.println("this is not power of 2 ");
        }
    }
    public static boolean checkPower(int n){
        int count = 0;
        if(n<=0){
            return false;
        }else {
        while(n!=0){
            count+=n & 1;
            n>>=1;
        }}
        return count==1;
    }
}
```

# Question 3 : Given a number. Using bit manipulation, check whether it is odd or even.
Answer : 
```java
package Week_2.Assignment;

import java.util.*;

public class CheckOddEven {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = scan.nextInt();
        int binaryNum = 0;
        int pow = 1;
        while (x > 0) {
            int remainder = x % 2;
            binaryNum += remainder * pow;
            pow *= 10;
            x /= 2;
        }
        if((binaryNum & 1) == 0){
            System.out.println("Even number");
        }else{
            System.out.println("Odd number");
        }
        scan.close();
    }
}
```
# Question 4 : Given a number, count the number of set bits in that number without using an extra space.
Answer : 
```java
import java.util.*;

class CountBits {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = scan.nextInt();
        int count = 0;
        while(x!=0){
             count+=x & 1;
             x>>=1;
        }
        System.out.println("number of bits present in this number is "+count);
        scan.close();
    }
}
```

# Question 5 : Given an integer array, duplicates are present in it in a way that all duplicates appear an even number of times except one which appears an odd number of times. Find that odd appearing element in linear time and without using any extra memory.
Answer : 
```java
class OddOccuring {
    public static void main(String[] args) {
        int arr[] = {4,3,6,2,6,4,2,3,4,3,3};
        int value=0;
        for(int i=0;i<arr.length;i++){
            value=value^arr[i];
        }
        System.out.println(value);
    }
}
```