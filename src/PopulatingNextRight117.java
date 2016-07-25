import java.util.LinkedList;

/**
 * Created by Amysue on 2016/7/25.
 */
public class PopulatingNextRight117 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            TreeLinkNode startnode = nodes.pop();
            int i = 1;
            if (startnode.left != null) {
                nodes.add(startnode.left);
            }
            if (startnode.right != null) {
                nodes.add(startnode.right);
            }
            while (i < size) {
                TreeLinkNode node = nodes.pop();
                startnode.next = node;
                startnode = node;
                i++;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }
    }

    private void connectRight(TreeLinkNode last, TreeLinkNode node) {
        TreeLinkNode p        = last;
        TreeLinkNode q        = node;
        TreeLinkNode nextNode = null;
        TreeLinkNode nextRoot = null;
        while (node != null) {
            if (node.left != null && node.right != null) {
                node.left.next = node.right;
                if (nextNode == null) {
                    nextNode = node.left;
                    nextRoot = node;
                }
            } else {
                if (node.left != null) {
                    if (nextNode == null) {
                        nextNode = node.left;
                        nextRoot = node;
                    }
                }
                if (node.right != null) {
                    if (nextNode == null) {
                        nextNode = node.right;
                        nextRoot = node;
                    }
                }
            }
            while (node.next != null) {
                node = node.next;
            }
            while (last != null && last.left != node && last.right != node) {
                last = last.next;
            }
            if (last == null || last.next == null) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        PopulatingNextRight117 pn = new PopulatingNextRight117();
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left11 = new TreeLinkNode(2);
        TreeLinkNode right11 = new TreeLinkNode(3);
        TreeLinkNode left21 = new TreeLinkNode(4);
        TreeLinkNode right21 = new TreeLinkNode(5);
//        TreeLinkNode left22 = new TreeLinkNode(6);
        TreeLinkNode right22 = new TreeLinkNode(7);
        root.left = left11;
        root.right = right11;
        left11.left = left21;
        left11.right = right21;
//        right11.left = left22;
        right11.right = right22;
        pn.connect(root);
        System.out.println(1);
    }
}
