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
        ListNode slow = head;
        ListNode fast = head.next;
        int count = 1;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        int sum = 0;
        if (fast == null) {
            sum = 2*count -1;
        } else {
            sum = 2*count;
        }
        int k = sum - n;
        if (k == 0) {
            return head.next;
        }
        ListNode p, q;
        if (k >= count) {
            k = k - count;
            p = slow;
        } else {
            p = new ListNode(0);
            p.next = head;
        }
        int i = 0;
        while (i < k) {
            p = p.next;
            i++;
        }
        p.next = p.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd19 rn = new RemoveNthFromEnd19();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        int n = 3;
        head = rn.removeNthFromEnd(head, 4);
        ListNode.printNods(head);
    }
}
