package Week_5.Assignment;

public class LL_Insertion2 {
    public static void main(String[] args) {
        LL_Insertion2 al = new LL_Insertion2();
        al.insertAtEnd(1);
        al.insertAtEnd(2);
        al.insertAtEnd(4);
        al.insertAtEnd(5);
        al.insertAtEnd(6);
        // insert at mid
        al.insertMid(2, 3);
        al.displayLL();
    }
    Node head;
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }

     // insertion between
     public void insertMid(int index,int num){
        Node newNode = new Node(num);
        if(index==0){
            insertAtBeg(num);
            return ;
        }
        int i=0;
        Node temp = head;
        while(i!=index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return;
        
    }
    // insertion in start
    public void insertAtBeg(int newData){
        Node newNode = new Node(newData);
        if(head==null){
            head=new Node(newData);
            return;
        }
        newNode.next=head;
        head=newNode;
        return;
    }

    // inset at end
    public void insertAtEnd(int d){
        Node newNode = new Node(d);
        if(head==null){
            head=newNode;
            return;
        }
        Node cur =head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=newNode;
        return;
    }

    // display
    public void displayLL(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.data + " ");
            cur=cur.next;
        }
        System.out.println();
        return;
    }
}
