/**
 * Created by Amysue on 2016/7/25.
 */
public class PopulatingNextRight11702 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode first = null;
        TreeLinkNode p = root;
        TreeLinkNode q = null;
        while (p != null) {
            if (first == null) {
                if (p.left != null) {
                    first = p.left;
                    q = p.left;
                } else if (p.right != null) {
                    first = p.right;
                    q = p.right;
                }
            }
            if (q != null) {
                if (q == p.left) {
                    if (p.right != null) {
                        q.next = p.right;
                        q = q.next;
                    }
                } else {
                    if (p.left != null) {
                        q.next = p.left;
                        q = q.next;
                        continue;
                    } else if (p.right != null && q != p.right) {
                        q.next = p.right;
                        q = q.next;
                    }
                }
            }
            p = p.next;
            if (p == null && first != null) {
                p = first;
                first = null;
                q = null;
            }

        }
    }

    public static void main(String[] args) {
        PopulatingNextRight11702 pn = new PopulatingNextRight11702();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode level1 = new TreeLinkNode(2);
        root.right = level1;
//        TreeLinkNode left11 = new TreeLinkNode(2);
//        TreeLinkNode right11 = new TreeLinkNode(3);
//        TreeLinkNode left21 = new TreeLinkNode(4);
//        TreeLinkNode right21 = new TreeLinkNode(5);
//        TreeLinkNode left22 = new TreeLinkNode(6);
//        TreeLinkNode right22 = new TreeLinkNode(7);
//        root.left = left11;
//        root.right = right11;
//        left11.left = left21;
//        left11.right = right21;
//        right11.left = left22;
//        right11.right = right22;
        pn.connect(root);
        System.out.println(1);
    }
}
