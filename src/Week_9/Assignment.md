# Q1 :
Answer :
```java
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

            if(Cl.isEmpty()){
                Stack<TreeNode> temp= Cl;
                Cl=Nl;
                Nl=temp;
                flag=!flag;
            }

        }
        
    }
}


class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
        left=null;
        right=null;
    }
}
```

# Q2 
Answer :
```java
package Week_9;

import java.util.*;
 
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class Cbt_Check
{
    public static boolean isComplete(Node root)
    {
        if (root == null) {
            return true;
        }
 
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        Node front;
 
        boolean flag = false;
 
        while (!queue.isEmpty())
        {
            front = queue.poll();
 
           if (flag && (front.left != null || front.right != null)) {
                return false;
            }
 
            if (front.left == null && front.right != null) {
                return false;
            }
 
             if (front.left != null) {
                queue.add(front.left);
            }
            else {
                flag = true;
            }
 
            if (front.right != null) {
                queue.add(front.right);
            }
            else {
                flag = true;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left= new Node(8);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
 
        if (isComplete(root)) {
            System.out.println("Complete binary tree");
        }
        else {
            System.out.println("Not a complete binary tree");
        }
    }
}

```

# Q3 :
```java
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

```

# Q4 :
Answer : 
```java
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
```

# Q5 :
```java
package Week_9;

import java.util.LinkedList;
import java.util.Queue;


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

```