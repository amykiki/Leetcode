import java.util.*;

/**
 * Created by Amysue on 2016/7/24.
 */
public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        findPath(root, 0, sum, path, results);
        return results;
    }

    private void findPath(TreeNode node, int lastSum, int target, LinkedList<Integer> path, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }
        lastSum += node.val;
        if (node.left == null && node.right == null) {
            if (lastSum == target) {
                List<Integer> result = new ArrayList<>(path);
                result.add(node.val);
                paths.add(result);
            }
        } else {
            path.add(node.val);
            findPath(node.left, lastSum, target, path, paths);
            findPath(node.right, lastSum, target, path, paths);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        PathSum113 ps113 = new PathSum113();
        Integer[] nodes = {5,4,8,11,null,13,4,7,2,null,null,null,-4,5,1};
        BinaryTree bt = new BinaryTree(nodes);
        TreeNode root = bt.getRoot();
        int sum = 22;
        List<List<Integer>> results = ps113.pathSum(root, sum);
        System.out.println(results);
    }
}
