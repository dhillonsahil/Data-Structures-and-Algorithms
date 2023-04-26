package Week_2.Assignment;

public class PassesNo {
    public static void main(String[] args){
        int passes = 0;
        int arr[] = {3,5,1,6,0};
        boolean flag =false;
        for(int i=0;i<arr.length;i++){
            for(int j=0 ;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                    passes++;
                }
            }
            if(!flag){
                break;
            }
        }

        System.out.println("Number of passes "+passes);
    }

}
