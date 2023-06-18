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
        // Node temp=l3.head;
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
