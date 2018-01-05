public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (last == null) {
                    head = cur.next;
                }else {
                    last.next = cur.next;
                }
            }else {
                last = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = {6, 2, 6, 3, 4, 5, 6};
        int[] arr = {1, 6, 6, 5, 6, 6, 6};
        ListNode head = ListNode.genNodes(arr);
        int val = 6;
        RemoveElements203 re = new RemoveElements203();
        ListNode nHead = re.removeElements(head, val);
        ListNode.printNods(nHead);
    }
}
