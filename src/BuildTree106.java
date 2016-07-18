import java.util.List;
import java.util.Stack;

/**
 * Created by Amysue on 2016/7/16.
 */
public class BuildTree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode       root     = null;
        Stack<TreeNode> midNodes = new Stack<>();
        int            j        = 0;
        int            i        = 0;
        TreeNode       curNode;
        while (i < inorder.length) {
            if (inorder[i] == postorder[j]) {
                curNode = new TreeNode(inorder[i]);
                if (root == null) {
                    root = curNode;
                } else {
                    if (midNodes.isEmpty()) {
                        curNode.left = root;
                        root = curNode;
                    } else {
                        curNode.left = midNodes.peek().right;
                        midNodes.peek().right = curNode;
                    }
                }
                i++;
                j++;
            } else {
                if (midNodes.isEmpty() || midNodes.peek().val != postorder[j]) {
                    curNode = new TreeNode(inorder[i]);
                    if (root == null) {
                        root = curNode;
                    } else {
                        if (midNodes.isEmpty()) {
                            curNode.left = root;
                            root = curNode;
                        } else {
                            curNode.left = midNodes.peek().right;
                            midNodes.peek().right = curNode;
                        }
                    }
                    midNodes.push(curNode);
                    i++;
                } else {
                    midNodes.pop();
                    j++;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BuildTree106 buildTree106 = new BuildTree106();
        int[] inorders1   = {2,3,4,5,7,8,9,10,12,13,14,15,17,19,18};
        int[] postorders1 = {2,4,3,7,9,8,5,12,14,13,17,18,19,15,10};
        int[]         inorders2   = {15, 17, 18, 19};
        int[]         postorders2 = {19, 18, 17, 15};
        int[]         inorders3   = {15, 17, 18, 19};
        int[]         postorders3 = {15, 17, 18, 19};
         int[]         inorders4   = {12,15,14};
        int[]         postorders4 = {12,14,15};
        int[] inorders5   = {2,3,4,5,7,8,9,10,12,13,14,15,17,19,18,20};
        int[] postorders5 = {2,3,4,5,7,8,9,10,12,14,13,17,18,19,15,20};
        int[] inorders6   = {1,3,2};
        int[] postorders6 = {3,2,1};
        int[] inorders7   = {1,2,3,4};
        int[] postorders7 = {3,2,4,1};
        TreeNode      root       = buildTree106.buildTree(inorders7, postorders7);
        BinaryTree    bt         = new BinaryTree(root);
        List<Integer> list       = bt.inorder();
        System.out.println(list);
    }


}
