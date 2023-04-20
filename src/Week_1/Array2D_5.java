package Week_1;

public class Array2D_5 {
    public static void main(String[] args) {
        int arr[][] = {{1,2,3,4,5},{3,4,5,6,7},{7,6,5,4,3},{8,7,6,5,4},{1,2,37,8,0} };
        int r=arr.length;
        int c=arr[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if((i==r/2 || j==c/2) && i!=j){
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
