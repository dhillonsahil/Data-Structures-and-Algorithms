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
