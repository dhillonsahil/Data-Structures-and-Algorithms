package Week_1;
public class MatrixRotation{
    public static void main(String[] args){

        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
        int m=arr.length;
        int n=arr[0].length;
        // transpose 
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int tem = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=tem;
            }
        }

        // swap
        for(int i=0;i<m;i++){
            int li=0;
            int ri=n-1;
            while(li<ri){
                int temp=arr[i][li];
                arr[i][li]=arr[i][ri];
                arr[i][ri]=temp;

                li++;
                ri--;
            }
        }

        //print
        for(int ar[]:arr){
            for(int a:ar){
                System.out.print(a);
            }
            System.out.println();
        }

    }
}

// time complexity = O(m*n)
// space complexity = O(1)