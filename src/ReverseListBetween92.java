/**
 * Created by Amysue on 2016/7/28.
 */
public class ReverseListBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode pre, h, p,q,t;
        int i = 1;
        q = head;
        p = null;
        t = null;
        pre = null;
        h = null;
        while (i <= n) {
            if (i >= m) {
                if (i == m) {
                    pre = p;
                    h = q;
                } else {
                    t = q.next;
                    q.next = p;
                }
            }
            p = q;
            if (i <= m) {
                q = q.next;
            } else {
                q = t;
            }
            i++;
        }
        h.next = q;
        if (pre != null) {
            pre.next = p;
            pre = head;
        } else {
            pre = p;
        }
        return pre;
    }

    public static void main(String[] args) {
        ReverseListBetween92 rs = new ReverseListBetween92();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        head = rs.reverseBetween(head, 2, 5);
        ListNode.printNods(head);
    }
}
