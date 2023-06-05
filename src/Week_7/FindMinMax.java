package Week_7;
public class FindMinMax{
    static class Pair{
        int min;
        int max;
    }
    public static void main(String[] args) {
        int arr[]={5,7,6,2,1,65,88,21,74,95};
        Pair minmax = getMinMax(arr, 0, arr.length-1);
        System.out.println(minmax.min + " "+minmax.max);
    }
    public static Pair getMinMax(int arr[],int i,int j){
        Pair minmax = new Pair();
        Pair minmaxleft = new Pair();
        Pair minmaxright = new Pair();
        if(i==j){
            minmax.min=arr[i];
            minmax.max=arr[i];
            return minmax;
        }else if(i==j-1){
            if(arr[i]<arr[j]){
                minmax.min=arr[i];
                minmax.max=arr[j];
            }else{
                minmax.max=arr[i];
                minmax.min = arr[j];
            }
            return minmax;
        }else{
            int mid = i+ (j-i)/2;
            minmaxleft = getMinMax(arr, i, mid);
            minmaxright = getMinMax(arr, mid+1, j);

            // compare
            if(minmaxleft.min<minmaxright.min){
                minmax.min=minmaxleft.min;
            }else if(minmaxleft.min>minmaxright.min){
                minmax.min=minmaxright.min;
            }
        // max
            if(minmaxleft.max<minmaxright.max){
                minmax.max=minmaxright.max;
            }else if(minmaxleft.max>minmaxright.max){
                minmax.max=minmaxleft.max;
            }

            
        }
        return minmax;
    }
}

// time complexity O(N) because only comparing no sorting
// space complexity O(log) for 8 elements it used only 3 stack