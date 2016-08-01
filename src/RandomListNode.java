/**
 * Created by Amysue on 2016/8/1.
 */
public class RandomListNode{
    int label;
    RandomListNode next, random;
    RandomListNode(int x) {
        this.label = x;
    }

    public static RandomListNode genNodes(int[] a, int[] randoms) {
        RandomListNode[] rl = new RandomListNode[a.length];
        RandomListNode head = new RandomListNode(0);
        RandomListNode p = head;
        for(int i = 0; i < a.length; i++) {
            rl[i] = new RandomListNode(a[i]);
            p.next = rl[i];
            p = p.next;
        }
        for(int i = 0; i < a.length; i++) {
            if (randoms[i] != -1) {
                rl[i].random = rl[randoms[i]];
            }
        }
        p.next = null;
        head = head.next;
        return head;
    }

    public static void printNods(RandomListNode l) {
        while (l.next != null) {
            System.out.print(l.label + "->");
            l = l.next;
        }
        System.out.println(l.label);
    }
}
