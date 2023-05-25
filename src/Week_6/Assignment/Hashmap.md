# Q1. Implement a Map in java which takes the input and print the list in sorted order based on key.
Answer
```java
import java.util.*;
public class HashMap_1{
    public static void main(String[] args){
        Map<Integer,String> map = new TreeMap<>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements to insert : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.print("enter the " + i +" key : ");
            int key=sc.nextInt();
            System.out.print("Enter the  Value for key : ");
            String val=sc.next();
            map.put(key, val);
        }
        System.out.println(map);
        sc.close();
    }
}
```

# Q2. Implement a Map in java which takes the input and print the list in sorted order based on value
Answer
```java
import java.util.*;
public class HashMap_2 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map =new TreeMap<>();
        TreeMap<String,Integer> mp=new TreeMap<>();
        map.put(5,"Rahul");
        map.put(7,"Lakhsman");
        map.put(1, "Ram");
        map.put(4,"Krish");
        map.put(2, "aman");
        map.put(8, "Ajay");
        while(!map.isEmpty()){
           Map.Entry av= map.lastEntry();
           map.remove(av.getKey());
           mp.put((String)av.getValue(), (Integer)av.getKey());
        }
        System.out.println(mp);
    }
}

```

# Q3.Detect if an Array contains a duplicate element. At Most 1 duplicate would be there.
Answer:
```java
import java.util.*;
public class HashMap_3{
    public static void main(String[] args){
        HashMap<Integer,Integer> map = new HashMap<>();
        // int arr
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of elements to insert : ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("ENter values : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        // insert in HashMap
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
                System.out.println("Duplicate Element is "+arr[i]);
                System.exit(0);
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println("NO duplicate element is Present");
        sc.close();
    }
}
```

# Q4. Given an array nums of size n, return the majority element.
Answer :
```java
import java.util.*;
public class HashMap_4 {
    public static void main(String[] args) {
        // majority element is which is present more than n/2 times where n is the size of the array
        int arr[]={4,2,7,1,9};
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int nn=map.get(arr[i])+1;
                if(nn>=arr.length/2){
                    System.out.println("The Majority element is : "+arr[i]);
                    System.exit(0);
                }
                map.put(arr[i],map.get(arr[i]));
            }else{
                map.put(arr[i],1);
            }
        }

        // if not present than max
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Majority element is "+max);
    }
}

```

# Q5. Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise. Each letter in magazine can only be used once in ransomNote.
Answer 
```java
import java.util.*;
public class HashMap_5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // HashMap<Character,Integer> ransomeNote = new HashMap<>();
        HashMap<Character,Integer> magazine = new HashMap<>();

        // get values
        System.out.println("Enter key for ransomeNote : ");
        String a=sc.next();
        System.out.println("Enter key for magazine : ");
        String b=sc.next();

        // check
        for(int i=0;i<b.length();i++){
            if(magazine.containsKey(b.charAt(i))){
                magazine.put(b.charAt(i), magazine.get(b.charAt(i))+1);
            }else{
                magazine.put(b.charAt(i), 1);
            }
        }
        
        for(int i=0;i<a.length();i++){
            if(magazine.containsKey(a.charAt(i))){
                if(magazine.get(a.charAt(i))<=0){
                    System.out.println("false");
                    System.exit(0);
                }else{
                    magazine.put(a.charAt(i),magazine.get(a.charAt(i))-1);
                }
            }else{
                System.out.println("false");
                System.exit(0);
            }
        }
        System.out.println("true");
    }
}

```