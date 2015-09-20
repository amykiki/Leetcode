
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
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        ListNode left = sort(slow.next);
        slow.next = null;
        ListNode right = sort(head);
        head = merge(left, right);
        return head;
    }
    
    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0);
        ListNode last = head;
        while (left != null && right != null) {
            if (left.val > right.val) {
            	last.next = right;
                right = right.next;
            }
            else {
                last.next = left;
                left = left.next;
            }
            last = last.next;
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
        return head.next;
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


