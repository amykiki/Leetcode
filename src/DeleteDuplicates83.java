/**
 * Created by Amysue on 2016/7/28.
 */
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p,q;
        p = head;
        q = head.next;
        while (q != null) {
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
            if (q != null) {
                q = q.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates83 dd   = new DeleteDuplicates83();
        int[]              nums = {1, 2, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 8, 8, 9, 10,10,10,10};
//        int[]              nums = {5,5};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        head = dd.deleteDuplicates(head);
        ListNode.printNods(head);

    }
}
