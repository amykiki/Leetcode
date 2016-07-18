import java.util.List;

/**
 * Created by Amysue on 2016/7/18.
 */
public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        return root;
    }

    public static void main(String[] args) {
        BuildTree105  buildTree105 = new BuildTree105();
        int[]         inorder1     = {2, 3,4,5,7,8,9,10,12,13,14,15,17,19,18};
        int[]         preorder1    = {10,5,3,2,4,8,7,9, 15,13,12,14,18,17,19};
        TreeNode      root         = buildTree105.buildTree(inorder1, preorder1);
        BinaryTree    bt           = new BinaryTree(root);
        List<Integer> list         = bt.inorder();
        System.out.println(list);
    }
}
