package Week_10;

import java.util.*;

public class Maxheap {
    static class Heap{
        // implementing min HEAP
        ArrayList<Integer>  arr= new ArrayList<>();
        public void insert(int i){
            arr.add(i);

            int child=arr.size()-1;
            int parent=(child-1)/2;
            while(arr.get(child) > arr.get(parent)){
                int temp= arr.get(parent);
                arr.set(parent,arr.get(child));
                arr.set(child,temp);

                child=parent;
                parent=(child-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
        private void heapify(int i){
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int minIdx = i;
    
    if (left < arr.size() && arr.get(minIdx) < arr.get(left)) {
        minIdx = left;
    }
    
    if (right < arr.size() && arr.get(minIdx) < arr.get(right)) {
        minIdx = right;
    }
    
    if (minIdx != i) {
        int temp = arr.get(minIdx);
        arr.set(minIdx, arr.get(i));
        arr.set(i, temp);
        heapify(minIdx);
    }
}

        public int remove(){

            int data=arr.get(0);

            // SWAP ROOT WITH LAST
            int temp=arr.get(arr.size()-1);
            arr.set(arr.size()-1 , arr.get(0));
            arr.set(0, temp);

            // remove left
            arr.remove(arr.size()-1);

            // 
            heapify(0);
            return data;
        }
        public boolean isEmpty(){
            return arr.size()==0;
        }
    }

    public static void main(String[] args) {
        Heap hp= new Heap();
        hp.insert(5);
        hp.insert(9);
        hp.insert(10);
        hp.insert(4);
        hp.insert(1);
        hp.insert(8);
        hp.insert(0);
        while(!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
