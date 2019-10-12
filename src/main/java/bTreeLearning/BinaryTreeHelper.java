package bTreeLearning;

import java.util.LinkedList;

/**
 * Created by Alina on 2019/3/11.
 */
public class BinaryTreeHelper {

  public static Node createBTree() {
    Node I = new Node("I", null, null);
    Node H = new Node("H", null, null);
    Node D = new Node("D", H, I);
    Node E = new Node("E", null, null);
    Node F = new Node("F", null, null);
    Node G = new Node("G", null, null);
    Node B = new Node("B", D, E);
    Node C = new Node("C", F, G);
    Node A = new Node("A", B, C);

    return A;
  }

  public static void preorderTraversal(Node root) {
    System.out.print(root.getData());

    if (root.getLeftChild() != null) {
      preorderTraversal(root.getLeftChild());
    }
    if (root.getRightChild() != null) {
      preorderTraversal(root.getRightChild());
    }
  }

  public static void inorderTraversal(Node root) {
    if (root.getLeftChild() != null) {
      inorderTraversal(root.getLeftChild());
    }

    System.out.print(root.getData());

    if (root.getRightChild() != null) {
      inorderTraversal(root.getRightChild());
    }
  }

  public static void postorderTraversal(Node root) {
    if (root.getLeftChild() != null) {
      postorderTraversal(root.getLeftChild());
    }
    if (root.getRightChild() != null) {
      postorderTraversal(root.getRightChild());
    }

    System.out.print(root.getData());
  }

  public static void levelTraversal(Node root) {
    if (root == null) {
      return;
    }
    LinkedList<Node>  nodeList = new LinkedList<>();
    nodeList.add(root);
    while (nodeList.size() > 0) {
      Node currentNode = nodeList.poll();
      System.out.print(currentNode.getData());
      if (currentNode.getLeftChild() != null) {
        nodeList.add(currentNode.getLeftChild());
      }
      if (currentNode.getRightChild() != null) {
        nodeList.add(currentNode.getRightChild());
      }
    }
  }

  public static void main(String[] args) {
    Node root = BinaryTreeHelper.createBTree();
//    levelTraversal(root);
//    preorderTraversal(root);
//    inorderTraversal(root);
    postorderTraversal(root);
  }

}
