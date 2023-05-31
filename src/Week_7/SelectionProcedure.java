package Week_7;

public class SelectionProcedure {
    public static void main(String[] args) {
        int arr[]={50,30,70,90,10,34,89,98,13};
        int k = 6;
        int num = selectionProcedure(arr, 0 ,arr.length-1,k);
        System.out.println(num);
    }
    public static int selectionProcedure(int arr[],int l, int r,int k){
        int m =partion(arr, l , r);
        if(m==k-1){
            return arr[m];
        }else if(m<k-1){
            return selectionProcedure(arr, m+1, r, k);
        }else{
            return selectionProcedure(arr, l, m-1, k);
        }
    }
    public static int partion(int arr[], int l , int r){
        int pivot=arr[l];
        int i=l;
        for(int j=l+1;j<=r;j++){
            if(arr[j]<=pivot){
                i+=1;
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            }
        }

        int temp= arr[l];
        arr[l]=arr[i];
        arr[i]=temp;
        return i;
    }
}
