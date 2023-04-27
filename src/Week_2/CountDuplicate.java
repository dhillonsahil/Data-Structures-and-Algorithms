package Week_2;
import java.util.*;;

public class CountDuplicate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr[] = {2,5,5,5,6,6,8,9,9,9};
        int target = scan.nextInt();
        int result=count(arr, target);
        System.out.println(result!=0?"Target "+ target+ " Occured " + result + " times":"Not Found");
        scan.close();
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
