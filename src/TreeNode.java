import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amysue on 2016/7/16.
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
