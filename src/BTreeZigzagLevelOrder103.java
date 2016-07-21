import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/21.
 */
public class BTreeZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        boolean left = true;
        while (!nodes.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int count = nodes.size();
            int i = 0;
            while (i < count) {
                TreeNode node = nodes.pop();
                if (left) {
                    list.add(node.val);
                } else {
                    list.push(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                i++;
            }
            levels.add(list);
            left = !left;
        }
        return levels;
    }

    public static void main(String[] args) {
        BTreeZigzagLevelOrder103 btOrder = new BTreeZigzagLevelOrder103();
        BuildTree105  buildTree105 = new BuildTree105();
        int[]         inorder1     = {2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18, 19};
        int[]         preorder1    = {10, 5, 3, 2, 4, 8, 7, 9, 15, 13, 12, 14, 18, 17, 19};
        int[]         inorder2     = {2};
        int[]         preorder2    = {2};
        int[]         inorder3     = {2,4,6,5,3,1};
        int[]         preorder3    = {1,2,3,4,5,6};
        int[]         inorder4     = {3,2,1,5,4,6};
        int[]         preorder4    = {1,2,3,4,5,6};
        TreeNode root = buildTree105.buildTree(preorder4, inorder4);
        List<List<Integer>> levels = btOrder.zigzagLevelOrder(root);
        System.out.println("levels = " + levels);
    }

}
