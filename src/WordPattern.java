
public class WordPattern {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pHead = head;
        ListNode pNext = head.next;
        while (pNext != null) {
            if (pNext.val != pHead.val) {
                pHead.next = pNext;
                pHead = pNext;
            }
            pNext = pNext.next;
        }
        pHead.next = null;
        return head;
    }
}
