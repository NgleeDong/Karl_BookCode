public class Lc108_sortedArrayToBST {

    //将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        return process(nums,0, nums.length - 1);
    }

    public TreeNode process(int[] nums, int L, int R) {
        if (L > R) return null;
        int mid = L + ((R - L) / 2);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums, L, mid - 1);
        node.right = process(nums, mid + 1, R);
        return node;
    }
}
