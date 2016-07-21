import java.util.List;
import java.util.Stack;

/**
 * Created by Amysue on 2016/7/18.
 */
public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode        root     = new TreeNode(preorder[0]);
        Stack<TreeNode> midNodes = new Stack<>();
        midNodes.push(root);
        TreeNode lastNode = null;
        TreeNode curNode;
        int      in        = 0;
        int      pre        = 1;
        while (pre < preorder.length) {
            if (!midNodes.isEmpty() && inorder[in] == midNodes.peek().val) {
                lastNode = midNodes.pop();
                in++;
            } else {
                curNode = new TreeNode(preorder[pre]);
                if (lastNode != null) {
                    lastNode.right = curNode;
                    lastNode = null;
                } else {
                    midNodes.peek().left = curNode;
                }
                if (inorder[in] == preorder[pre]) {
                    lastNode = curNode;
                    in++;
                } else {
                    midNodes.push(curNode);
                }
                pre++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        BuildTree105  buildTree105 = new BuildTree105();
        int[]         inorder1     = {2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18, 19};
        int[]         preorder1    = {10, 5, 3, 2, 4, 8, 7, 9, 15, 13, 12, 14, 18, 17, 19};
//        int[]         inorder2     = {3,2,1,5,4,6};
//        int[]         preorder2    = {1,2,3,4,5,6};
//        int[]         inorder3     = {6,5,4,3,2,1};
//        int[]         preorder3    = {1,2,3,4,5,6};
        /*int[]         inorder4     = {4,2,5,3,6,1};
        int[]         preorder4    = {1,2,4,3,5,6};*/
        int[]         inorder5     = {2,4,6,5,3,1};
        int[]         preorder5    = {1,2,3,4,5,6,};
        TreeNode      root         = buildTree105.buildTree(preorder1, inorder1);
        BinaryTree    bt           = new BinaryTree(root);
        List<Integer> list         = bt.inorder();
        System.out.println(list);
    }
}
