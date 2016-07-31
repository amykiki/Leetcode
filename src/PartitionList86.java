/**
 * Created by Amysue on 2016/7/31.
 */
public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode h = new ListNode(0);
        ListNode p = h;
        ListNode q = head;
        while (q != null) {
            if (q.val >= x) {
                p.next = q;
                break;
            } else {
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        ListNode pre = null;
        while (q != null) {
            if (q.val >= x) {
                pre = q;
            } else {
                pre.next = q.next;
                q.next = p.next;
                p.next = q;
                p = p.next;
            }
            q = pre.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 4, 3, 2, 5, 2};
        int[] nums = {6, 4, 3, 2, 5, 0};
//        int[] nums = {4, 1};
//        int[] nums = {8, 4, 3, 2, 5, 2};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        PartitionList86 pa = new PartitionList86();
        head = pa.partition(head, 1);
        ListNode.printNods(head);
    }
}
