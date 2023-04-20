package Week_1;

public class Array_3 {
    public static void main(String[] args){
        int arr[]={34,21,54,65,43};
        int max=0;
        for(int a:arr){
            if(a>max){
                max=a;
            }
        }
        System.out.println(max);
    }
}
