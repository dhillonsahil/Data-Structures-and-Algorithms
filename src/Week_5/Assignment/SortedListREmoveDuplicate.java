package Week_5.Assignment;

public class SortedListREmoveDuplicate {
    public static void main(String[] args) {
        SortedListREmoveDuplicate sl = new SortedListREmoveDuplicate();
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(1);
        sl.append(2);
        // sl.append(15);
        sl.displayLL();
        sl.removeDuplicates();
        sl.displayLL();
    }
    
    Node head;
    class Node
    {
        int val;
        Node next;
        Node(int data){
            val=data;
            next=null;
        }
        Node(int data, Node nxt){
            this(data);
            next=nxt;
        }
    }

    // insert at end
    void append(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=newNode;
        return;
    }

    void removeDuplicates(){
        Node temp=head;
        // if no element or only 1 element is present S
        if(temp==null || temp.next==null){
            return;
        }

        // if value of current node is equal to next node , direcly link current node to next to next node
        while(temp.next!=null){
            while(temp.val==temp.next.val){
                    temp.next=temp.next.next;
                
            }
            temp=temp.next;
        }
    }

     // display
     public void displayLL(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.val + " ");
            cur=cur.next;
        }
        System.out.println();
        return;
    }
}
