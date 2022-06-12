package treesandgraphs;

public class GreaterTree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  TreeNode buildTree() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1);
    root.right = new TreeNode(6);
    return null;
  }
}
