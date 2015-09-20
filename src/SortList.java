public class SortList {
    class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
        }
    }
    public ListNode sortList(ListNode head) {
        head = sortList(head, null);
        return head;
    }
    
    private ListNode sortList(ListNode head, ListNode last) {
        if (head == null || head.next == null || head.next == last) {
            return head;
        }
        ListNode flag = head;
        ListNode flagLast = flag;
        int flagVal = flag.val;
        ListNode p1 = head.next;
        ListNode ltFlag = null;
        ListNode ltFlagLast = null;
        ListNode gtFlag = null;
        ListNode gtFlagLast = null;
        while (p1 != last) {
            if (p1.val < flagVal) {
                if (ltFlag == null) {
                    ltFlag = p1;
                    ltFlagLast = p1;
                }
                else {
                    ltFlagLast.next = p1;
                    ltFlagLast = ltFlagLast.next;
                }
                p1 = p1.next;
                ltFlagLast.next = flag;
            }
            else if (p1.val == flagVal) {
                flagLast.next = p1;
                flagLast = flagLast.next;
                p1 = p1.next;
            }
            else {
                if (gtFlag == null) {
                    gtFlag = p1;
                    gtFlagLast = p1;
                }
                else {
                    gtFlagLast.next = p1;
                    gtFlagLast = gtFlagLast.next;
                }
                p1 = p1.next;
                gtFlagLast.next = last;
            }
        }
        if (gtFlag != null) {
            flagLast.next = sortList(gtFlag, last);
        }
        else {
            flagLast.next = last;
        }
        if (ltFlag != null) {
            head = sortList(ltFlag, flag);
        }
        else {
            head = flag;
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
    }
    public static void main(String[] args) {
        SortList sl = new SortList();
        int[] arr = {3, 2, 1};
        sl.creatList(arr);
        SortList.ListNode head;
        head = sl.creatList(arr);
        head = sl.sortList(head);
        sl.printList(head);
    }
}


