/**
 * Created by Amysue on 2016/7/31.
 */
public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        //旋转后半部分
        ListNode p = l2.next;
        ListNode q;
        ListNode pre = l2;
        pre.next = null;
        while (p != null) {
            q = p.next;
            p.next = pre;
            pre = p;
            p = q;
        }
        p = head;
        while (pre != null) {
            q = pre.next;
            pre.next = p.next;
            p.next = pre;
            pre = q;
            p = p.next.next;
        }
    }

    public static void main(String[] args) {
                int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {1};
//        int[] nums = {9,8,7,6,5,4,3,2,1};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        ReorderList143 rl = new ReorderList143();
        rl.reorderList(head);
        ListNode.printNods(head);
    }
}
