import java.util.ArrayList;
import java.util.List;
public class BTreeInorder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    private int height = 3;
//  Code for Leetcode #94 Binary Tree Inorder Traversal begin
    private List<Integer> bTreeList = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return bTreeList;
        }
        inorder(root, 0, "root");
        return bTreeList;
    }
    private int inorder(TreeNode node, int index, String direction) {
        if (direction.equals("root")) {
            bTreeList.add(node.val);
        }
        else {
            bTreeList.add(index, node.val);
        }
        int sum = 0;
        if (node.left != null) {
            sum += inorder(node.left, index, "left");
        }
        if (node.right != null) {
            sum += inorder(node.right, sum + index + 1, "right");
        }
        return sum + 1;
    }
//  Code for Leetcode #94 Binary Tree Inorder Traversal end  
    public TreeNode createTree() {
        TreeNode head = new TreeNode(1);
        TreeNode n11  = new TreeNode(2);
        TreeNode n12  = new TreeNode(3);
        TreeNode n21  = new TreeNode(4);
        TreeNode n22  = new TreeNode(5);
        TreeNode n31  = new TreeNode(6);
        TreeNode n32  = new TreeNode(7);
        head.left     = n11;
        head.right    = n12;
        n11.left      = n21;
        n11.right     = n22;
        n21.right     = n31;
        n22.left      = n32;
        return head;
    }
    public void printTree(TreeNode root) {
        int level = 0;
        int space = (int) Math.pow(2, height - level) - 1;
        printTree(root, level, space);
    }
    
    private void printTree(TreeNode node, int level, int space) {
        String spaces = new String(new char[space]).replace("\0", "  ");
        System.out.println(spaces + node.val);
        level++;
        int nextLength = (int) Math.pow(2, height - level);
        int leftSpace = space - nextLength;
        System.out.println();
        spaces = new String(new char[leftSpace]).replace("\0", "  ");
        System.out.print(spaces + node.left.val);
        spaces = new String(new char[nextLength*2]).replace("\0", "  ");
        System.out.print(spaces + node.right.val);
        System.out.println();
    }
    
    public static void main (String[] args) {
        BTreeInorder tree = new BTreeInorder();
        BTreeInorder.TreeNode root = tree.createTree();
        tree.printTree(root);
    }
}
