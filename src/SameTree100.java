import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Amysue on 2016/7/22.
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> t1 = new LinkedList<>();
        Queue<TreeNode> t2 = new LinkedList<>();
        t1.add(p);
        t2.add(q);
        while (!t1.isEmpty() && !t2.isEmpty()) {
            TreeNode n1 = t1.poll();
            TreeNode n2 = t2.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if (n1 == null || n2 == null) {
                return false;
            }
            if (n1.val != n2.val) {
                return false;
            }
            t1.add(n1.left);
            t1.add(n1.right);
            t2.add(n2.left);
            t2.add(n2.right);
        }
        return true;
    }

    public static void main(String[] args) {
        SameTree100 st = new SameTree100();
//        Integer[] a1 = {1,2,2,null,3,null,3};
//        Integer[] a2 = {1,2,2,null,3,null,3};
        /*Integer[] a1 = {1,2,3,4,5,null,null,6,null,null,null,null,null,null,null};
        Integer[] a2 = {1,2,3,4,5,null,null};*/
        Integer[] a1 = {1,2,null,null,3,null,null};
        Integer[] a2 = {1,null,2,null,null,3,null};
        BinaryTree bt1 = new BinaryTree(a1);
        BinaryTree bt2 = new BinaryTree(a2);
        TreeNode p = bt1.getRoot();
        TreeNode q = bt2.getRoot();
        System.out.println(st.isSameTree(p, q));
    }
}
