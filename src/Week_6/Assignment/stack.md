# Q1 : Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and
return its area.
Ans : 
```java
import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length == 0)  return 0;
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] arr = new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[j] = matrix[i][j] == 1 ? arr[j] + 1 : 0;
            }
            //treating arr[j] as histogram, solving max area problem there and updating the max area
            maxArea = Math.max(maxArea, findMaxAreaInHistogram(arr));
        }
        return maxArea;
    }
    public static int findMaxAreaInHistogram(int[] arr){
        int len = arr.length;
        int maxArea = 0;
        int[] left = new int[len];
        int[] right = new int[len];
        Stack<Integer> stack = new Stack<>();
        //traversing left to right, finding left limit
        for(int i=0;i<len;i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i] = 0;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                left[i] = stack.isEmpty() ? 0 : stack.peek()+1;
                stack.push(i);
            }
        }
        //doing empty to stack
        while(!stack.isEmpty())
            stack.pop();
        
        //traversing right to left, find right limit
        for(int i=len-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(len-1);
                right[i] = len - 1;
            }else{
                while(!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                    stack.pop();
                right[i] = stack.isEmpty() ? len-1 : stack.peek()-1;
                stack.push(i);
            }
        }
        //traversing the array , caculating area
        int[] area = new int[len];
        for(int i=0;i<len;i++){
            area[i] = (right[i] - left[i] + 1) * arr[i];
            maxArea = Math.max(maxArea, area[i]);
        }
        return maxArea;
    }
    
	public static void main(String[] args){
        int[][] arr = {{0,1,1,0},{0,1,0,0},{0,0,0,1}};
	    System.out.println("The maximum area is : " + maximalRectangle(arr));
	}
}
```

# Q2 : Q2. Given an encoded string, return its decoded string. The encoding rule is: k  [encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer. You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
Ans
```java
import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ']'){
                stack.push(ch);
            }else{
                //get the sub string
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '['){
                    sb.append(stack.pop());
                }
                //remove the '[' character
                stack.pop();
                //get the number
                int k = 0;
                int base = 1;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = (stack.pop() - '0') * base + k;
                    base *= 10;
                }
                //put back the substring in stack k times
                while(k-- > 0){
                    for(int i=sb.length()-1; i>=0; i--){
                        stack.push(sb.charAt(i));
                    }
                }
            }
        }
        char[] result = new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
            result[i] = stack.pop();
        return new String(result);
    }
	public static void main(String[] args){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream  
        System.out.print("Enter a string: ");  
        String str= sc.nextLine(); 
        System.out.println("The decoded string is : " + decodeString(str));
	}
}
```

# Q3 : You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record. 
# You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
# An integer x.
# Record a new score of x.
# '+'.
# Record a new score that is the sum of the previous two scores.
# 'D'.
# Record a new score that is the double of the previous score.
# 'C'.
# Invalidate the previous score, removing it from the record.
# Return the sum of all the scores on the record after applying all the operations.

Ans 
```java
import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
   public static int calPoints(String[] ops) {
    int sum = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0; i < ops.length; i++)
    {
        if(ops[i].equals("+"))
        {
            int temp1 = stack.pop();
            int temp2 = stack.pop();
            int temp_sum = temp1 + temp2;
            sum += temp_sum;
            stack.push(temp2);
            stack.push(temp1);
            stack.push(temp_sum);
        }
        else if(ops[i].equals("D"))
        {
            int temp = stack.pop();
            int temp_d = 2 * temp;
            sum += temp_d;
            stack.push(temp);
            stack.push(temp_d);
        }
        else if(ops[i].equals("C"))
        {
            int cancel = stack.pop();
            sum -= cancel;
        }
        else
        {
            int temp = Integer.parseInt(ops[i]);
            sum += temp;
            stack.push(temp);   
        }
        }
        return sum;
    }
	public static void main(String[] args){
        String []str = {"5" , "2" , "C" , "D" , "+"};
        System.out.println("The score is : " + calPoints(str));
	}
}
```

# Q4.:We are given an array of asteroids of integers representing asteroids in a row.For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed. Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
Ans : 
```java
import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
    public static int[] asteroidCollision(int[] a) {
        List<Integer> list = new ArrayList<>();
        list.add(a[0]);
        for(int i=1; i<a.length; i++){
            list.add(a[i]);
            int j=list.size()-1;

            // This is the condition for collision
            while(j>0 && (list.get(j)<0 && list.get(j-1)>=0)){
                int first = list.remove(list.size()-1);
                int second = list.remove(list.size()-1);
                int third;
                if(Math.abs(first)==Math.abs(second)){
                    //If both have same value then both will destory
                    j=j-2;
                    continue;
                }else if(Math.abs(first)>Math.abs(second)){
                    //If first have greater value then 2nd will destory
                    j--;
                    list.add(first);
                }else{
                    //If 2nd have greater value then 1st will destory
                    j--;
                    list.add(second);
                }
            }
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
        
    }
	public static void main(String[] args){
        int []a = {5,10,-5};
        System.out.println("The desired output is : ");
        
        int []arr = asteroidCollision(a);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
	}
}
```

# Q5 : Q5. Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Ans 
```java
import java.io.*;
import java.util.*;
import java.util.Stack; 

class Main {
   public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int []nge = new int [n]; 
        for(int i=0;i<n;i++)nge[i] = 0;

        Stack<Integer>st = new Stack();
        
		// move from right to left
        for(int i = n-1; i>=0; --i){
            // pop until we find next greater element to the right
			// since we came from right stack will have element from right only
			// s.top() is the index of elements so we put that index inside temperatures vector to check
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
				
            // if stack not empty, then we have some next greater element, 
			// so we take distance between next greater and current temperature
			// as we are storing indexes in the stack
            if(!st.empty())
                nge[i] = st.peek()-i; // distance between next greater and current
            
			// push the index of current temperature in the stack,
			// same as pushing current temperature in stack
            st.push(i);
        }
        return nge;
    }
	public static void main(String[] args){
        int []a = {60 , 45 , 34 , 65 , 38 , 79 , 80};
        System.out.println("The desired output is : ");
        
        int []arr = dailyTemperatures(a);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
	}
}
```