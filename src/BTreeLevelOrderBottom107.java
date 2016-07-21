import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/21.
 */
public class BTreeLevelOrderBottom107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> levels = new LinkedList<>();
        if (root == null) {
            return levels;
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = nodes.size();
            int i = 0;
            while (i < count) {
                TreeNode node = nodes.pop();
                list.add(node.val);
                i++;
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            levels.push(list);

        }
        return levels;
    }

    public static void main(String[] args) {
        BTreeLevelOrderBottom107 btOrder = new BTreeLevelOrderBottom107();
        BuildTree105  buildTree105 = new BuildTree105();
        int[]         inorder1     = {2, 3, 4, 5, 7, 8, 9, 10, 12, 13, 14, 15, 17, 18, 19};
        int[]         preorder1    = {10, 5, 3, 2, 4, 8, 7, 9, 15, 13, 12, 14, 18, 17, 19};
        int[]         inorder2     = {2};
        int[]         preorder2    = {2};
        int[]         inorder3     = {2,4,6,5,3,1};
        int[]         preorder3    = {1,2,3,4,5,6};
        int[]         inorder4     = {3,2,1,5,4,6};
        int[]         preorder4    = {1,2,3,4,5,6};
        TreeNode root = buildTree105.buildTree(preorder3, inorder3);
        List<List<Integer>> levels = btOrder.levelOrderBottom(root);
        System.out.println("levels = " + levels);
    }

}
