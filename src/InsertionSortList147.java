/**
 * Created by Amysue on 2016/7/29.
 */
public class InsertionSortList147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        ListNode p = head.next;
        h.next = head;
        head.next = null;
        ListNode q;
        ListNode n;
        while (p != null) {
            q = h;
            n = p.next;
            p.next = null;
            while (q.next != null) {
                if (q.next.val <= p.val) {
                    q = q.next;
                } else {
                    p.next = q.next;
                    q.next = p;
                    break;
                }
            }
            if (q.next == null) {
                q.next = p;
            }
            p = n;
        }
        return h.next;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {9,8,7,6,5,4,3,2,1};
        int[] nums = {9};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        InsertionSortList147 is = new InsertionSortList147();
        head = is.insertionSortList(head);
        ListNode.printNods(head);
    }
}
