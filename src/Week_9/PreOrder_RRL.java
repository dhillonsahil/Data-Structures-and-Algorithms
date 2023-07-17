package Week_9;
import java.util.*;

public class PreOrder_RRL {
    static Queue<TreeNode>  queue= new LinkedList<>();
    static List<Integer> list= new LinkedList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.left=new TreeNode(7);
        traverseTree(root);
        System.out.println(list);

    }

    public static void traverseTree(TreeNode root){
        if(root==null)return;
        Stack<TreeNode> Cl= new Stack<>();
        Stack<TreeNode> Nl= new Stack<>();

        Cl.add(root);
        boolean flag=false;
        while(!Cl.isEmpty()){
            TreeNode tl = Cl.pop();
            list.add(tl.data);
            // if true lef to right
            if(!flag){
                if(tl.right!=null){
                    Nl.add(tl.right);
                }
                if(tl.left!=null){
                    Nl.add(tl.left);
                }
            }else{
                if(tl.left!=null){
                    Nl.add(tl.left);
                }
                 if(tl.right!=null){
                    Nl.add(tl.right);
                }
            }

            // if cl is now empty
            if(Cl.isEmpty()){
                Stack<TreeNode> temp= Cl;
                Cl=Nl;
                Nl=temp;
                flag=!flag;
                // System.out.println();
            }

        }
        
    }
}

