# Question 1 : Given a LinkedList and a Key X , the task is to check if X is present in the Linked List or Not
**Answer**
```java
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
```
# Question 2 : Insert a node at the given position in a linked list. We are given a pointer to a node, and the new node is inserted after the given node.
**Answer**
```java
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
```

# Question 3 : Q3. Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
**Answer**
```java
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

```

# Question 4 : Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
**Answer**
```java
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

```

# Question : 
**Answer**
```java
package Week_5.Assignment;

/* Check Linked List is Palindrome or Note */
public class LL_5 {
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


    void displayLL(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
    
    LL_5 add(LL_5 l1, LL_5 l2){
        LL_5 l3= new LL_5();
        int num1=toInt(l1);
        int num2=toInt(l2);
        int num3=num1+num2;
        int digits =(int)Math.log10(num3)+1;
        int count=0;
        Node temp=l3.head;
        String s=""+num3;
        String[] a= s.split("");
        // here is the issue
        while(digits!=0){
            l3.append(Integer.parseInt(a[count]));
            digits--;
            count++;

        }
        return l3;
    }

    public int toInt(LL_5 l1){
        int num=0;
        // digits 
        Node temp=l1.head;
        int count=-1;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        // reverse
        temp=l1.head;
        while(temp != null){
            num+= temp.val*(int)Math.pow(10, count);
            count--;
            temp=temp.next;
        }
        System.out.println("returned "+num);
        return num;
    }
    public static void main(String[] args) {
        
        LL_5 l1= new LL_5();
        l1.append(5);
        l1.append(6);
        l1.append(3) ;

        LL_5 l2= new LL_5();
        l2.append(8);
        l2.append(4);
        l2.append(2);

        LL_5 l3 = l1.add(l1, l2);
        l3.displayLL();
    }
}
```