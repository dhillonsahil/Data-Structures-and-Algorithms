package Week_9;

import java.util.*;

public class Reverse_LevelOrder {
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.left.left= new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.left.right=new TreeNode(8);
        
        reverseTraversal(root);
        System.out.println(al);
    }
    public static void reverseTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> st= new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode nr = queue.poll();
            st.add(nr.data);
            if(nr.right!=null){
                queue.add(nr.right);
            }
            if(nr.left!=null){
                queue.add(nr.left);
            }

        }
        while(!st.isEmpty()){
            int a=st.pop();
            al.add(a);
        }
    }
}

