package Week_4.Assignment;

import java.util.*;
public class BackTracking_2{
    public static void main(String[] args) {
        int arr[]={1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        permutations(arr,new ArrayList<>(),res);
        System.out.println(res);
    }
    public static void permutations(int arr[],List<Integer> temp,List<List<Integer>> result){
        if(temp.size()==arr.length){
            result.add(new ArrayList<>(temp));
        }
        for(int i=0;i<arr.length;i++){
            if(temp.contains(arr[i]))continue;
            temp.add(arr[i]);
            permutations(arr, temp, result);
            temp.remove(temp.size()-1);
        }
    }
}