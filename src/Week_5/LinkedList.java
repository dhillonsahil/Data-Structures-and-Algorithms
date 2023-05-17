package Week_5;
public class LinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // insertion at end implementation
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
    // reverse linkedList
    public void reverseList(){
        Node current =head;
        Node prev=null;
        Node next = null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        return;
    }
    // display (print) LinkedList
    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // reverse Using Recurion
    void reverseRec(Node prev,Node cur){
        // if(prev==null){
        //     cur=head;
        // }
        if(cur==null){
            head=prev;
            return;
        }
        Node next = cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
        reverseRec(prev, cur);
    }
    void delete(int index){
        // empty linked list
        if(head==null){
            return;
        }
        Node temp=head;
        // if at beginning
        if(index==0){
            head=temp.next;
            return;
        }
        // if not at start
        for(int i=0;temp!=null & i<index-1;i++){
            temp=temp.next;
        }
        if(temp==null && temp.next==null){
            return;
        }else{
            temp.next=temp.next.next;
        }
    }

    
    public static void main(String []args){
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(5);
        ll.insertAtEnd(10);
        // ll.displayLL();
        ll.insertAtBeg(50);
        ll.insertAtBeg(550);
        // ll.displayLL();
        ll.insertAtEnd(500);
        ll.displayLL();
        System.out.println();
        
        ll.insertMid(0,11);
        ll.displayLL();
        System.out.println();
        System.out.println("After deleting at index 0");
        ll.delete(0);
        ll.displayLL();
        System.out.println();
        ll.delete(2);
        System.out.println("After deleting at index 2");
        ll.displayLL();
        System.out.println();

        ll.reverseList();
        ll.displayLL();
    }
}