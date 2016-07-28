/**
 * Created by Amysue on 2016/7/28.
 */
public class MergeTwoLists21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
//        int[] num1 = {2, 10,11,12,13,14};
//        int[] num2 = {1, 3, 4, 5, 7, 8, 12,12,12};
//        int[] num2 = {1, 2, 4, 8, 10};
        int[] num1 = {};
        int[] num2 = {0};
        ListNode l1 = ListNode.genNodes(num1);
        ListNode l2 = ListNode.genNodes(num2);
        MergeTwoLists21 mtl = new MergeTwoLists21();
        ListNode head = mtl.mergeTwoLists(l1, l2);
        ListNode.printNods(head);
    }
}
