public class SortListMerg {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    public ListNode sortList(ListNode head) {
        head = sort(head);
        return head;
    }
    
    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode p1 = first;
        ListNode second = head.next;
        ListNode p2 = second;
        ListNode p = head.next.next;
        while (p != null && p.next != null) {
            p1.next = p;
            p1 = p1.next;
            p2.next = p.next;
            p2 = p2.next;
            p = p.next.next;
        }
        p1.next = p;
        p2.next = null;
        ListNode left = sort(first);
        ListNode right = sort(second);
        head = merge(left, right);
        return head;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode last = null;
        while (left != null && right != null) {
            ListNode item;
            if (left.val > right.val) {
                item = right;
                right = right.next;
            }
            else {
                item = left;
                left = left.next;
            }
            if (head == null) {
                head = item;
                last = item;
            }
            else {
                last.next = item;
                last = last.next;
            }
        }
        while (left != null) {
            last.next = left;
            last = last.next;
            left = left.next;
        }
        while (right != null) {
            last.next = right;
            last = last.next;
            right = right.next;
        }
        return head;
    }
    public ListNode creatList(int[] arr) {
        ListNode head;
        head = new ListNode(arr[0]);
        head.next = null;
        ListNode last = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode item = new ListNode(arr[i]);
            item.next = null;
            last.next = item;
            last = item;
        }
        return head;
    }
    
    public void printList(ListNode head) {
        ListNode item = head;
        if (item != null) {
            System.out.print(item.val);
            item = item.next;
        }
        while (item != null) {
            System.out.print("->" + item.val);
            item = item.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        SortListMerg sl = new SortListMerg();
        int[] arr = {3, 9, 1, 8, 6, 7};
        sl.creatList(arr);
        SortListMerg.ListNode head;
        head = sl.creatList(arr);
        head = sl.sortList(head);
        sl.printList(head);
    }
}


