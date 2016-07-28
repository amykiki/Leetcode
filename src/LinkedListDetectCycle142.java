/**
 * Created by Amysue on 2016/7/28.
 */
public class LinkedListDetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if ((fast != null && fast.next == slow) || fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return null;
        }
        ListNode p = fast.next;
        int count = 1;
        while (p != fast) {
            p = p.next;
            count++;
        }
        p = head;
        ListNode q = head;
        int i = 1;
        while (i < count) {
            q = q.next;
            i++;
        }

        while (q.next != p) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        LinkedListDetectCycle142 ldc = new LinkedListDetectCycle142();
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {0,1};
//        int[] nums = {0, 1};
        ListNode head = ListNode.genNodes(nums);
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        ListNode startnode = head;
        int i = 0;
        int count = 9;
        while (i < count) {
            startnode = startnode.next;
            i++;
        }
        tail.next = startnode;
        System.out.println(startnode.val);
        ListNode node = ldc.detectCycle(head);
        System.out.println(node.val);
    }
}
