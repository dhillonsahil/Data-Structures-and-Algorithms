package Week_8;
public class median{
    public static void main(String[] args) {
        int arr1[]={1,4,7,10,12};
        int arr2[] = {2,3,6,15};
        System.out.printf("%.2f",med(arr1,arr2,arr1.length,arr2.length));
    }
    public static double med(int arr1[],int arr2[],int m , int n){
        if(m>n)return med(arr2, arr1,n,m);

        int low = 0,high=m,medianPosition=((m+n)+1)/2; // where our median will be

        while(low<high){
            int cut1= (low+high)/2;
            int cut2 = medianPosition -cut1;

            int l1= (cut1==0)?Integer.MIN_VALUE:arr1[cut1-1]; // to get element before cut
            int l2= (cut2==0)?Integer.MIN_VALUE:arr1[cut2-1];
            int r1= (cut1==m)?Integer.MAX_VALUE:arr1[cut1];
            int r2= (cut2==n)?Integer.MAX_VALUE:arr1[cut2];

            if(l1<=r2 && l2<=r1){
                if((m+n)%2!=0){ // odd length
                    return Math.max(l1,l2); 
                }else{
                    return (Math.max(l1,l2) +Math.min(r1, r2))/2.0;
                }
            }else if(l1>r2)high = cut1-1;
            else low=cut1+1;
        }
        return 0.0;
    }
}