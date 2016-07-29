/**
 * Created by Amysue on 2016/7/28.
 */
public class ReverseKGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode p,q, t;
        p = head;
        q = head.next;
        int i = 1;
        while (q != null) {
            t = q.next;
            q.next = p;
            p = q;
            q = t;
            i++;
            if (k != -1 && i == k) {
                break;
            }
        }
        if (i == k) {
            head.next = reverseKGroup(q, k);
        } else if (i < k) {
            head.next = null;
            p = reverseKGroup(p, -1);
        } else {
            head.next = null;
        }
        return p;
    }

    public static void main(String[] args) {
        ReverseKGroup25 rg = new ReverseKGroup25();
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {1};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        int k = 10;
        head = rg.reverseKGroup(head, k);
        ListNode.printNods(head);
    }
}
