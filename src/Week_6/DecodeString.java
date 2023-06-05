package Week_6;
import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter String to decode");
        String a= scan.nextLine();
        scan.close();
        String decoded = decodeString(a);
        System.out.println("Decoded String is "+decoded);
    }
    public static String decodeString(String s){
        Stack<Character> stack= new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch!=']'){
                stack.push(ch);
            }else{
                StringBuilder str= new StringBuilder();
                while(stack.peek()!='['){
                    str.append(stack.pop());
                }
                // remove [ from stack
                stack.pop();
                int base =1;
                int k=0;
                // get the int value from stack
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k = (stack.pop()- '0') * base + k;
                }

                // until k=0 add in stack
                while(k-->0){
                    for(int i=str.length()-1;i>=0;i--){
                        stack.push(str.charAt(i));
                    }
                }
            }

        }
        // now in stack we have elements 
        char result[]= new char[stack.size()];
        for(int i=stack.size()-1;i>=0;i--){
            result[i]=stack.pop();
        }
        return new String(result);
    }
}
