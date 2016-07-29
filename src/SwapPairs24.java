/**
 * Created by Amysue on 2016/7/29.
 */
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p, q, t,pre,h;
        p = head;
        q = head.next;
        h = head.next;
        t = null;
        pre = null;
        while (q != null) {
            if (pre != null) {
                pre.next = q;
            }
            t = q.next;
            q.next = p;
            pre = p;
            p = t;
            if (t == null) {
                pre.next = null;
                break;
            }
            q = t.next;
        }
        if (t != null) {
            pre.next = t;
        }
        return h;
    }

    public static void main(String[] args) {
        SwapPairs24 sp   = new SwapPairs24();
//        int[]       nums = {1, 2, 3, 4, 5, 6, 7, 8,9};
        int[] nums = {1,2,3};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        head = sp.swapPairs(head);
        ListNode.printNods(head);
    }
}
