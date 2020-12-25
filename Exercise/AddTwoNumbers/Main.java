public class Main
{
    private  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode();
        ListNode currNode = tempHead; 
        int carry = 0;
        ListNode p = l1, q = l2;
        while (p != null || q != null){
            int sum = 0;
            int x = (p==null ?0:p.val);
            int y = (q==null ?0:q.val);
            sum = x+y +carry;
            carry = sum /10;
            currNode.next = new ListNode(sum%10);
            currNode = currNode.next;
            if (p!=null){
                p = p.next;
            }
            if (q!=null){
                q = q.next;
            }
        }
        if (carry > 0){
            currNode.next = new ListNode (carry);
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
    
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(7);
        l1.next.next.next.next = new ListNode(9);
    
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(8);
    
        ListNode result = addTwoNumbers(l1, l2);
        while(result != null) {
          System.out.print(result.val + " ");
          result = result.next;
        }
        System.out.println();
      }
}
