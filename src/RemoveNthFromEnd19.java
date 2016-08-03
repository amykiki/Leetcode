/**
 * Created by Amysue on 2016/8/3.
 */
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        if (head == null || head.next == null) {
            return null;
        }
        ListNode h,p,q;
        h = new ListNode(0);
        h.next = head;
        p = h;
        q = h;
        int i = 0;
        while (i < n) {
            q = q.next;
            i++;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return h.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd19 rn = new RemoveNthFromEnd19();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        head = rn.removeNthFromEnd(head, 1);
        ListNode.printNods(head);
    }
}
