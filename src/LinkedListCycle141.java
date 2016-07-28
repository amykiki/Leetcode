/**
 * Created by Amysue on 2016/7/28.
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if ((fast != null && fast.next == slow) || fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {0, 1};
        ListNode head = ListNode.genNodes(nums);
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        ListNode p = head;
        int i = 0;
        int count = 5;
        while (i < count) {
            p = p.next;
            i++;
        }
        tail.next = p;
        LinkedListCycle141 lcy = new LinkedListCycle141();
        System.out.println(lcy.hasCycle(head));
    }
}
