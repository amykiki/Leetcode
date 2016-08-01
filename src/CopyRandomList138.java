import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Amysue on 2016/8/1.
 */
public class CopyRandomList138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        List<RandomListNode> lnodes = new ArrayList<>();
        Map<RandomListNode, Integer> map = new HashMap<>();
        RandomListNode p = head;
        int i = 0;
        RandomListNode h = new RandomListNode(0);
        RandomListNode t = h;
        while (p != null) {
            map.put(p, i);
            lnodes.add(new RandomListNode(p.label));
            t.next = lnodes.get(i);
            t = t.next;
            p = p.next;
            i++;
        }
        p = head;
        i = 0;
        while (p != null) {
            if (p.random != null) {
                int index = map.get(p.random);
                lnodes.get(i).random = lnodes.get(index);
            }
            i++;
            p = p.next;
        }
        return h.next;
    }

    public static void main(String[] args) {
//        int[] nums    = {0,  1, 2, 3, 4, 5, 6};
//        int[] randoms = {4, -1, 1, 1, 6, 2, 3};
        int[] nums    = {2};
        int[] randoms = {-1};
        RandomListNode head = RandomListNode.genNodes(nums, randoms);
        RandomListNode.printNods(head);

        CopyRandomList138 cr = new CopyRandomList138();
        RandomListNode h2 = cr.copyRandomList(head);
        RandomListNode.printNods(h2);
    }
}
