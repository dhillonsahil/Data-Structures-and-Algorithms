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
