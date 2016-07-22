import java.util.*;

/**
 * Created by Amysue on 2016/7/18.
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public BinaryTree(Integer[] nodes) {
        if (nodes.length > 0) {
            root = new TreeNode(nodes[0]);
            HashMap<Integer, TreeNode> map = new HashMap<>();
            map.put(0, root);
            int i = 1;
            while (i < nodes.length) {
                int      index = (i - 1) / 2;
                TreeNode node;
                if (nodes[i] != null) {
                    node = new TreeNode(nodes[i]);
                    map.get(index).left = node;
                    map.put(i, node);
                }
                if ((i+1) < nodes.length && nodes[i + 1] != null) {
                    node = new TreeNode(nodes[i + 1]);
                    map.get(index).right = node;
                    map.put(i + 1, node);
                }
                i += 2;
            }
        }
    }

    public List<Integer> getArray() {
        List<Integer>   nodes = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        boolean notNull = true;
        int     level   = 0;
        while (notNull) {
            int count = (int) Math.pow(2, level);
            int i     = 0;
            notNull = false;
            while (i < count) {
                TreeNode node = stack.pop();
                if (node != null) {
                    nodes.add(node.val);
                    if (node.left != null) {
                        stack.add(node.left);
                        notNull = true;
                    } else {
                        stack.add(null);
                    }
                    if (node.right != null) {
                        stack.add(node.right);
                        notNull = true;
                    } else {
                        stack.add(null);
                    }
                } else {
                    nodes.add(null);
                    stack.add(null);
                    stack.add(null);
                }
                i++;
            }
            level++;
        }
//        addNode(nodes, root, 0);
        return nodes;
    }

    public void printTree() {
        List<Integer> nodes = getArray();
        System.out.println(nodes);
    }

    private void addNode(List<Integer> nodes, TreeNode node, int index) {
        System.out.println("index = " + index);
        if (node == null) {
            nodes.add(index, null);
            return;
        }
        nodes.add(index, node.val);
        if (node.left != null) {
            addNode(nodes, node.left, index * 2 + 1);
        } else {
            addNode(nodes, null, index * 2 + 1);
        }
        if (node.right != null) {
            addNode(nodes, node.right, index * 2 + 2);
        } else {
            addNode(nodes, null, index * 2 + 2);
        }
        return;
    }

    public List<Integer> inorder() {
        List<Integer> list = new ArrayList<>();
        inorderTree(root, list);
        return list;
    }


    public TreeNode getRoot() {
        return root;
    }

    private void inorderTree(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inorderTree(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            inorderTree(node.right, list);
        }
    }
}
