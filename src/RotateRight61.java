/**
 * Created by Amysue on 2016/7/31.
 */
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        ListNode q = head;
        int i = 0;
        while (i < k) {
            if (q.next == null) {
                int n = i + 1;
                k = k % n;
                q = head;
                i = 0;
            } else {
                q = q.next;
                i++;
            }
        }
        if (q == head) {
            return head;
        }

        ListNode p = head;
        while (q!= null && q.next != null) {
            q= q.next;
            p = p.next;
        }
        q.next = head;
        ListNode t = p.next;
        p.next = null;
        return t;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {1, 2, 3, 4};
//        int[] nums = {9,8,7,6,5,4,3,2,1};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        RotateRight61 rr = new RotateRight61();
        int k = 3001;
        head = rr.rotateRight(head, k);
        ListNode.printNods(head);
    }
}
