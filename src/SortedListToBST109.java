/**
 * Created by Amysue on 2016/7/26.
 */
public class SortedListToBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = findMiddle(head, null);
        return root;
    }

    private TreeNode findMiddle(ListNode low, ListNode high) {
        if (low == null || low == high) {
            return null;
        }
        ListNode slow = low;
        ListNode fast = low;
        while (fast != high && fast.next != high) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode head = new TreeNode(slow.val);
        TreeNode leftNode = findMiddle(low, slow);
        TreeNode rightNode = findMiddle(slow.next, high);
        head.left = leftNode;
        head.right = rightNode;
        return head;
    }

    public static void main(String[] args) {
        SortedListToBST109 st = new SortedListToBST109();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        ListNode head = ListNode.genNodes(nums);
        TreeNode root = st.sortedListToBST(head);
        System.out.println(1);
    }
}
