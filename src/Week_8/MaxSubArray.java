package Week_8;

public class MaxSubArray {
    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int n = arr.length;
        int maxSum = maxsubArraySum(arr, 0, n - 1);
        System.out.println(maxSum);
    }

    public static int maxsubArraySum(int arr[],int low,int high){
        if(low>high){
            return Integer.MIN_VALUE;
        }
        if(low==high)return arr[low];
        
        int m=(low+high)/2;
        return Math.max( Math.max(maxsubArraySum(arr, low, m-1), maxsubArraySum(arr, m+1, high)),maxCrossingSum(arr, low, m, high));
    }
    public static int maxCrossingSum(int arr[], int l, int m, int h) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        // right
        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m; i <= h; i++) {
            sum += arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }
        return Math.max(left_sum + right_sum - arr[m], Math.max(left_sum, right_sum));
    }
}
