package Week_5.Assignment;

/* Check Linked List is Palindrome or Note */
public class LL2 {
    Node head;
    class Node
    {
        Node next;
        int val;
        Node(int data){
            val=data;
            next=null;
        }
    }

    void append(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return;
    }

    void checkPalindrome(){
        boolean flag = true;
        LL2 l2 = new LL2();
        Node current=head;
        Node prev=null;
        Node next=null;

        // reverse current list
        while(current!=null){
            l2.append(current.val);
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
        LL2 t=new LL2();
        t.head=head;
        head=l2.head;
        l2.head=t.head;
        Node temp=head;
        Node rev=l2.head;
        // check plaindrome
        while(temp!=null && rev!=null){
            if(rev.val!=temp.val){
                flag=false;
                break;
            }
            temp=temp.next;
            rev=rev.next;
        }

        if(flag){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }


    void displayLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LL2 l1= new LL2();
        l1.append(1);
        l1.append(2);
        l1.append(1);
        l1.displayLL();
        l1.checkPalindrome();
        l1.displayLL();
    }
}
