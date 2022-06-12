package treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;

import treesandgraphs.structure.TreeNode;

public class ListOfDepths {

  private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<Integer>> lists, int level) {
    if (root == null) return;

    LinkedList<Integer> list = null;
    if (lists.size() == level) {
      list = new LinkedList<Integer>();
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(root.val);
    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
  }

  private ArrayList<LinkedList<Integer>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
    createLevelLinkedList(root, lists, 0);
    return lists;
  }

  private TreeNode buildBinaryTree(int[] arr) {
    return buildBinaryTree(arr, 0, arr.length - 1);
  }

  private TreeNode buildBinaryTree(int[] arr, int start, int end) {
    if (end < start) return null;

    int mid = (start + end) / 2;
    TreeNode node = new TreeNode(arr[mid]);
    node.left = buildBinaryTree(arr, start, mid - 1);
    node.right = buildBinaryTree(arr, mid + 1, end);
    return node;
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    TreeNode root = new ListOfDepths().buildBinaryTree(arr);
    ArrayList<LinkedList<Integer>> lists = new ListOfDepths().createLevelLinkedList(root);
    System.out.println(lists);
  }

  private ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
    LinkedList<TreeNode> current = new LinkedList<>();
    if (root != null) {
      current.add(root);
    }

    while (current.size() > 0) {
      result.add(current);
      LinkedList<TreeNode> parents = current;
      current = new LinkedList<>();
      for (TreeNode parent : parents) {
        if (parent.left != null) {
          current.add(parent.left);
        }
        if(parent.right != null) {
          current.add(parent.right);
        }
      }
    }
    return result;
  }
}
