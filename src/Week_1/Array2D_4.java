package Week_1;

public class Array2D_4 {
    public static void main(String[] args){
        int arr[][]={
            {1,2,4,0},
            {2,5,7,-1},
            {4,2,6,9}
        };

        int largest =Integer.MIN_VALUE;
        for(int ar[]:arr){
            for(int a:ar){
                if(a>largest){
                    largest=a;
                }
            }
        }
        System.out.println(largest);
    }
}
