package Week_9;

import java.util.*;

public class Left_View {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right= new TreeNode(5);
        root.right.left= new TreeNode(7);

        leftView(root);
    }
    public static void leftView(TreeNode root){
        Map<Integer,Integer> map = new HashMap<>();
        leftView(map , 1, root);


        for(int i=1;i<=map.size();i++){
            System.out.print(map.get(i) + " ");
        }
    }
    public static void leftView(Map<Integer,Integer> map, int level,TreeNode root){
        
        if(root==null)return;

        map.putIfAbsent(level, root.data);

        leftView(map, level+1, root.left);
        leftView(map, level+1, root.right);
    }
}