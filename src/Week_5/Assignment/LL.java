package Week_5.Assignment;

public class LL {
    public static void main(String[] args) {
        LL al = new LL();
        al.insertAtEnd(15);
        al.insertAtEnd(5);
        al.insertAtEnd(61);
        al.insertAtEnd(69);
        al.displayLL();
        al.checkKey(61, al);
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

    public void checkKey(int X, LL l1){
        Node cur = l1.head;
        boolean flag=false;
        while(cur.next!=null){
            if(cur.data==X){
               flag=true;
               break;
            }
            cur=cur.next;
        }
        if(flag){
            System.out.println("Present");
        }else {
            System.out.println("Not present");
        }
    }

    public void insertAtEnd(int newData) {
        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = null;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
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
