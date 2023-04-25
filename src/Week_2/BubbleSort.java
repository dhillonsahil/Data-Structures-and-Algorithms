package Week_2;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={20,50,10,40,100,90};

        for(int i=0;i<arr.length;i++){
            // for every iteration we get the biggest number at the end
            boolean swapped=false;
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(!swapped){
                break;
            }
        }
        

        System.out.println("Sorted : ");
         for(int a:arr){
            System.out.println(a);
         }
    }
}

// time : O(n^2)
// space : O(1)