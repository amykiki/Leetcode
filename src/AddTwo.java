
public class AddTwo {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode p = sum;
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        int tenNum = 0;
        int num = 0;
        while (l1 != null && l2 != null) {
            int p1 = l1.val;
            int p2 = l2.val;
            int value = p1 + p2 + tenNum;
            num = value % 10;
            tenNum = value / 10;
            p.next = new ListNode(num);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = tenNum + l1.val;
            num = value % 10;
            tenNum = value / 10;
            p.next = new ListNode(num);
            p = p.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int value = tenNum + l2.val;
            num = value % 10;
            tenNum = value / 10;
            p.next = new ListNode(num);
            p = p.next;
            l2 = l2.next;
        }
        if (tenNum > 0) {
            p.next = new ListNode(tenNum);
            p = p.next;
        }
        p.next = null;
        sum = sum.next;
        return sum;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {9, 9};
        int[] b = {5, 6, 9};
        ListNode la = ListNode.genNodes(a);
        ListNode lb = ListNode.genNodes(b);
        ListNode.printNods(la);
        ListNode.printNods(lb);
        AddTwo at = new AddTwo();
        ListNode sum = at.addTwoNumbers(la, lb);
        ListNode.printNods(sum);
    }

}
