package Week_9;

import java.util.LinkedList;
import java.util.Queue;

import javax.management.Query;

public class Mirror_Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);
        System.out.println("Before ");
        Bfs_Traversal(root);
        root=mirror(root);
        System.out.println("After ");
        Bfs_Traversal(root);
    }
    public static TreeNode mirror(TreeNode root){
        if(root==null)return root;
        
        TreeNode temp= mirror(root.right);
        TreeNode newRight = mirror(root.left);
        root.left=temp;
        root.right=newRight;
        return root;
    }
    public static void Bfs_Traversal(TreeNode root){
        if(root==null)return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            System.out.print(temp.data + " ");
        }
    }
}
