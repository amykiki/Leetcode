public class RemDupList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pHead = head;
        ListNode pNext = head.next;
        while (pNext != null) {
        	if (pNext.val == pHead.val) {
        		while (pNext != null && pNext.val == pHead.val) {
        			pNext = pNext.next;
        		}
        		pHead.next = pNext;
        		if (pNext == null) break;
        	}
        	pHead = pNext;
        	pNext = pNext.next;
        }
        return head;
    }
}
