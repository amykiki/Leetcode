/**
 * Created by Amysue on 2016/7/29.
 */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        head = divide(head);
        return head;
    }

    private ListNode divide(ListNode low) {
        if (low == null || low.next == null) {
            return low;
        }

        ListNode slow = low;
        ListNode fast = low.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        ListNode l1 = divide(low);
        ListNode l2 = divide(p);
        ListNode head = sort(l1, l2);
        return head;
    }

    private ListNode sort(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
       if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] nums = {9,8,7,6,5,4,3,2,1};
        ListNode head = ListNode.genNodes(nums);
        ListNode.printNods(head);
        SortList148 sl = new SortList148();
        head = sl.sortList(head);
        ListNode.printNods(head);
    }
}
