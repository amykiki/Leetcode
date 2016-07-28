/**
 * Created by Amysue on 2016/7/28.
 */
public class MergeKLists23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        if (high == low + 1) {
            return mergeTwoLists(lists[low], lists[high]);
        }
        int middle = low + (high - low)/2;
        ListNode l1 = mergeLists(lists, low, middle);
        ListNode l2 = mergeLists(lists, middle + 1, high);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode t = null;
        ListNode p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p = l1;
                l1 = l1.next;
            } else {
                p = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = p;
                t = head;
            } else {
                t.next = p;
                t = t.next;
            }
        }
        while (l1 != null) {
            t.next = l1;
            l1 = l1.next;
            t = t.next;
        }
        while (l2 != null) {
            t.next = l2;
            l2 = l2.next;
            t = t.next;
        }
        return head;
    }
}
