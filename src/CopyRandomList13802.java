/**
 * Created by Amysue on 2016/8/1.
 */
public class CopyRandomList13802 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode n = new RandomListNode(p.label);
            n.next = p.next;
            p.next = n;
            p = n.next;
        }
        p = head;
        RandomListNode q = null;
        while (p != null && p.next != null) {
            q = p.random;
            if (q != null) {
                p.next.random = q.next;
            }
            p = p.next.next;
        }
        RandomListNode h2 = new RandomListNode(0);
        RandomListNode h = h2;
        p = head;
        while (p != null && p.next != null) {
            h.next = p.next;
            p.next = p.next.next;
            p = p.next;
            h = h.next;
        }
        return h2.next;
    }

    public static void main(String[] args) {
//        int[] nums    = {0, 1, 2, 3, 4, 5, 6};
//        int[] randoms = {4, -1, 1, 1, 6, 2, 3};
        int[] nums    = {2};
        int[] randoms = {0};
        RandomListNode head = RandomListNode.genNodes(nums, randoms);
        RandomListNode.printNods(head);

        CopyRandomList13802 cr = new CopyRandomList13802();
        RandomListNode      h2 = cr.copyRandomList(head);
        RandomListNode.printNods(h2);
    }
}
