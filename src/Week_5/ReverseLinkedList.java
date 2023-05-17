package Week_5;
import Week_5.*;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList l1= new LinkedList();
        l1.insertAtBeg(5);
        l1.insertAtEnd(10);
        l1.insertAtEnd(15);
        l1.insertAtEnd(20);
        l1.insertAtEnd(25);
        l1.insertAtBeg(1);
        // l1.displayLL();
        
        l1.reverseRec(null, l1.head);
        l1.displayLL();
        
    }
    public static void reverseList(LinkedList l1,LinkedList.Node cur, LinkedList.Node next, LinkedList.Node prev){{
        if(cur==null){
            l1.head=prev;
            return;
        }
        next =cur.next;
        cur.next=prev;
        prev=cur;
        cur=next;
    }
    reverseList(l1, cur, next, prev);
    }

}
