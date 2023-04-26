package Week_2.Assignment;

public class IterationsNum{
    public static void main(String[] args){
        int arr[] = {3,5,1,6,0};
        int length = arr.length;
        int count = 0;
        for(int i=0;i<length;i++){
            int largest=i;
            for(int j=i+1;j<length;j++){
                if(arr[j]>arr[largest]){
                    largest=j;
                }
                count++;
            }
            if(largest!=i){
                int temp = arr[largest];
                arr[largest]=arr[i];
                arr[i]= temp;
            }
        }
        System.out.println(count);
    }
}
