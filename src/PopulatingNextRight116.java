/**
 * Created by Amysue on 2016/7/25.
 */
public class PopulatingNextRight116 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        connectRight(null, root);
    }

    private void connectRight(TreeLinkNode last, TreeLinkNode node) {
        if (node.next == null) {
            if (last != null && last.next != null) {
                node.next = last.next.left;
            }
        }
        if (node.left != null) {
            node.left.next = node.right;
            connectRight(node,node.left);
            connectRight(node,node.right);
        }
    }

    public static void main(String[] args) {
        PopulatingNextRight116 pn = new PopulatingNextRight116();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left11 = new TreeLinkNode(2);
        TreeLinkNode right11 = new TreeLinkNode(3);
        TreeLinkNode left21 = new TreeLinkNode(4);
        TreeLinkNode right21 = new TreeLinkNode(5);
        TreeLinkNode left22 = new TreeLinkNode(6);
        TreeLinkNode right22 = new TreeLinkNode(7);
        root.left = left11;
        root.right = right11;
        left11.left = left21;
        left11.right = right21;
        right11.left = left22;
        right11.right = right22;
        pn.connect(root);
        System.out.println(1);
    }

}
