
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val = x;
    }
    public static ListNode genNodes(int[] a) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for (int i = 0; i < a.length; i++) {
            p.next = new ListNode(a[i]);
            p = p.next;
        }
        p.next = null;
        head = head.next;
        return head;
    }
    
    public static void printNods(ListNode l) {
        while (l.next != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println(l.val);
    }
}
