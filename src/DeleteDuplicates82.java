/**
 * Created by Amysue on 2016/7/28.
 */
public class DeleteDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p, q, h, t;
        p = head;
        q = head.next;
        h = null;
        t = null;
        while (p != null) {
            int count = 1;
            while (q != null && p.val == q.val) {
                q = q.next;
                count++;
            }
            if (count == 1) {
                if (h == null) {
                    h = p;
                    t = h;
                } else {
                    t.next = p;
                    t = t.next;
                }
            }
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        if (h != null) {
            t.next = null;
        }
        return h;
    }

    public static void main(String[] args) {
        DeleteDuplicates82 dd = new DeleteDuplicates82();
//        int[]              nums = {2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 9, 10};
//        int[]              nums = {2, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8};
        int[]              nums = {2, 2, 2, 2, 2};
//        int[]    nums = {5, 5};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        head = dd.deleteDuplicates(head);
        if (head == null) {
            System.out.println("NULL");
        } else {
            ListNode.printNods(head);
        }
    }
}
