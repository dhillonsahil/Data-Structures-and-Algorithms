// time complexity O(n)
// space complexity O(1)

public class PlaindromeArray {
    public static void main(String[] args) {
    int[] arr = {1,2,3,2,1};
    int n = arr.length-1;
    boolean flag=true;
    for(int i=0;i<arr.length/2;i++){
        if(arr[i]==arr[n-i]){
            continue;
        }else{
            flag=false;
            break;
        }
    }
    if(flag==true){
        System.out.println("Plaindrome ");
    }else{
        System.out.println("Not Palindrome");
    }
    }
    
}
