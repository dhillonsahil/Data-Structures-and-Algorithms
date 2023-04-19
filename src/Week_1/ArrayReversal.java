package Week_1;

class ArrayReversal {
    public static void main(String[] args) {
        int[] arr={7,0,5,6,2,4};
        int n=arr.length;
        for(int i=0;i<n/2;i++){
            int temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        for(int a:arr){
            System.out.print(a);
        }
    }
}


/* time complexity = O(n) and Space Complexity = O(1) */