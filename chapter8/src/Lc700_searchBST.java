public class Lc700_searchBST {

    //BST中的搜索
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        TreeNode node = new TreeNode(0);
        if (root.val > val) {
            node =  searchBST(root.left,val);
        } else if (root.val < val) {
            node = searchBST(root.right,val);
        }
        return node;
    }
}
